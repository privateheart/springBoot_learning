package com.example.cache.service;

import com.example.cache.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DemoService {
    public Person save(Person person);

    public void remove(Long id);

    public Person findOne(Person person);

    public Page<Person> findPeople(PageRequest personPage);
}
