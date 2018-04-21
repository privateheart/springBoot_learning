package com.example.cache.controller;

import com.example.cache.domain.Person;
import com.example.cache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CacheController {

    @Autowired
    DemoService demoService;

    @RequestMapping("/put")
    public Person put(Person person){
        return demoService.save(person);
    }

    @RequestMapping("/able")
    public Person cacheable(Person person){
        return demoService.findOne(person);
    }

    @RequestMapping("/evit")
    public String evit(Long id){
        demoService.remove(id);
        return "ok";
    }

    @RequestMapping("/persons")
    public Page<Person> persons(){
        return demoService.findPeople(new PageRequest(1,4));
    }
}
