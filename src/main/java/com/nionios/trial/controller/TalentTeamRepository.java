package com.nionios.trial.controller;

import com.nionios.trial.domain.TalentTeam;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TalentTeamRepository extends CrudRepository<TalentTeam, Long> {
}
