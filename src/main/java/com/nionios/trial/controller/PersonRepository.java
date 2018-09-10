package com.nionios.trial.controller;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.nionios.trial.domain.Person;

@Component
public interface PersonRepository extends CrudRepository<Person, Long> {

}
