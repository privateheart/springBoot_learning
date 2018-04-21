package com.example.transaction.service.impl;

import com.example.transaction.dao.PersonRepository;
import com.example.transaction.domain.Person;
import com.example.transaction.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    PersonRepository personRepository;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        List<Person> lists = personRepository.findByName(person.getName());
        if (lists.size() > 1) {
            throw new IllegalArgumentException(person.getName() + "已存在，数据将回滚！");
        }
        return p;
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        List<Person> lists = personRepository.findByName(person.getName());
        if (lists.size() > 1) {
            throw new IllegalArgumentException(person.getName() + "已存在，数据将不会回滚！");
        }
        return p;
    }
}
