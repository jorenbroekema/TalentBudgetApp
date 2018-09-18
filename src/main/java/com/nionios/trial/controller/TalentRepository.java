package com.nionios.trial.controller;

import com.nionios.trial.domain.Talent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TalentRepository extends CrudRepository<Talent, Long> {
    @Query("SELECT t FROM Talent t where t.talentTeam.id = :id")
    List<Talent> findAllByTeamId(@Param("id") Long id);
}
