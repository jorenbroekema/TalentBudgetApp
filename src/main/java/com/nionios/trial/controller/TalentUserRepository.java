package com.nionios.trial.controller;

import com.nionios.trial.domain.TalentUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface TalentUserRepository extends CrudRepository<TalentUser, Long> {
}
