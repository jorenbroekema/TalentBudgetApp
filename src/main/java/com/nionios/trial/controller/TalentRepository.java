package com.nionios.trial.controller;

import com.nionios.trial.domain.Talent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TalentRepository extends CrudRepository<Talent, Long> {
}
