package com.example.transaction.service;

import com.example.transaction.domain.Person;

public interface DemoService {

    public Person savePersonWithRollBack(Person person);

    public Person savePersonWithoutRollBack(Person person);
}
