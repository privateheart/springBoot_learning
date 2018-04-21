package com.example.restdata.dao;

import com.example.restdata.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


public interface PersonRepository extends JpaRepository<Person, Long> {
    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Person findByNameStartsWith(@Param("name") String name);
}
