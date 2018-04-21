package com.spring.jpa.demo.controller;

import com.spring.jpa.demo.dao.PersonRepository;
import com.spring.jpa.demo.dao.PersonRepositorySpec;
import com.spring.jpa.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 人员控制器
 *
 * @author huyi
 * @create 2018/2/1 19:10
 */
@RestController
public class PersonController {
    /**
     * 1 Spring Data JPA 已自动为你注册bean,所以可以自动注入
     */
    @Autowired
    PersonRepository personRepository;

    @Autowired
    PersonRepositorySpec personRepositorySpec;

    @RequestMapping("/save")
    public Person save(String name, String address, Integer age) {
        Person p = personRepository.save(new Person(name, age, address));
        return p;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address) {
        List<Person> people = personRepository.findByAddress(address);
        return people;
    }

    @RequestMapping("/q2")
    public Person q2(String name, String address) {
        Person people = personRepository.findByNameAndAddress(name, address);
        return people;
    }

    @RequestMapping("/q3")
    public Person q3(String name, String address) {
        Person p = personRepository.withNameAndAddressQuery(name, address);
        return p;
    }

    @RequestMapping("/q4")
    public Person q4(String name, String address) {
        Person p = personRepository.withNameAndAddressNamedQuery(name, address);
        return p;
    }

    @RequestMapping("/sort")
    public List<Person> sort() {
        List<Person> people = personRepository.findAll(new Sort(Sort.Direction.ASC, "age"));
        return people;
    }

    @RequestMapping("/page")
    public Page<Person> page() {
        Page<Person> pagePeople = personRepository.findAll(new PageRequest(1, 2));
        return pagePeople;
    }

    @RequestMapping("/auto")
    public Page<Person> auto(Person person) {
        Page<Person> pagePeople = personRepositorySpec.findByAuto(person, new PageRequest(0, 10));
        return pagePeople;
    }
}
