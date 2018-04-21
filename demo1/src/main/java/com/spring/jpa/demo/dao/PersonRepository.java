package com.spring.jpa.demo.dao;

import com.spring.jpa.demo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    /**
     * 1
     *
     * @param name
     * @return
     */
    List<Person> findByAddress(String name);

    /**
     * 2
     *
     * @param name
     * @param address
     * @return
     */
    Person findByNameAndAddress(String name, String address);

    /**
     * 3
     *
     * @param name
     * @param address
     * @return
     */
    @Query("select p from Person p where p.name= :name and p.address= :address")
    Person withNameAndAddressQuery(@Param("name") String name, @Param("address") String address);

    /**
     * 4
     *
     * @param name
     * @param address
     * @return
     */
    Person withNameAndAddressNamedQuery(String name, String address);
}
