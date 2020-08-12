package com.JPAMVCH2.JPAH2demoApp.dao;

import com.JPAMVCH2.JPAH2demoApp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepo extends JpaRepository<Person, Integer> {

    /*List<Person> findByage(int age);
    List<Person> findByageGreaterThan(int age);
    @Query("from Person where age = ?1 order by name")
    List<Person> findByageSorted(int age);*/
}