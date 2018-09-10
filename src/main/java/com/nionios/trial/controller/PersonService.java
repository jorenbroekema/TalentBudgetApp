package com.nionios.trial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nionios.trial.domain.Person;
import com.nionios.trial.domain.Team;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private TeamRepository teamRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }
    public Team save(Team team) { return teamRepository.save(team); }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Person update(Person person) {
        return personRepository.save(person);
    }
    public Team update(Team team) { return teamRepository.save(team); }

    public Person findById(Long id) {
        return personRepository.findById(id).get();
    }

    public Iterable<Person> findAllPersons() {
        Iterable<Person> result = personRepository.findAll();
        return result;
    }

    public Iterable<Team> findAllTeams() {
        Iterable<Team> result = teamRepository.findAll();
        return result;
    }

}
