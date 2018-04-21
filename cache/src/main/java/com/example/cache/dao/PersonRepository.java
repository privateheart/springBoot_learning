package com.example.cache.dao;

import com.example.cache.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long>{
}
