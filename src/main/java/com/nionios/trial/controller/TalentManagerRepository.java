package com.nionios.trial.controller;

import com.nionios.trial.domain.TalentManager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TalentManagerRepository extends CrudRepository<TalentManager, Long> {
}
