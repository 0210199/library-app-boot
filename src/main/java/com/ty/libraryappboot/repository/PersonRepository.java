package com.ty.libraryappboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.libraryappboot.dto.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
