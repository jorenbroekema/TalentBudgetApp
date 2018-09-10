package com.nionios.trial.controller;

import com.nionios.trial.domain.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TeamRepository extends CrudRepository<Team, Long> {

}
