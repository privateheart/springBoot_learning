package com.example.cache.service.impl;

import com.example.cache.dao.PersonRepository;
import com.example.cache.domain.Person;
import com.example.cache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    PersonRepository personRepository;

    @Override
    @CachePut(value = "people",key = "#person.id")
    public Person save(Person person) {// @CachePut 缓存新增的或更新的数据到缓存，其中缓存名称为people,数据的key是person的id
        Person p = personRepository.save(person);
        System.out.println("为id、key为："+p.getId()+"数据库做了缓存");
        return p;
    }

    @Override
    @CacheEvict(value = "people")//2 @CacheEvict 从缓存people中删除key为id的数据
    public void remove(Long id) {
        System.out.println("删除了id、key为"+id+"的数据缓存");
        personRepository.delete(id);
    }

    @Override
    @Cacheable(value = "people",key = "#person.id")//3 @Cacheable 缓存key 为person的id数据到缓存people中   特别说明，如果没有指定Key,则方法参数作为key保存到缓存中
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("为id、key为："+p.getId()+"数据做了缓存");
        return p;
    }

    @Override
    @Cacheable(value = "people")
    public Page<Person> findPeople(PageRequest personPage) {
        Page<Person> all = personRepository.findAll(personPage);
        return all;
    }
}
