package com.nionios.trial.controller;

import com.nionios.trial.domain.Talent;
import com.nionios.trial.domain.TalentTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TalentTeamService {
    @Autowired
    private TalentRepository talentRepository;
    @Autowired
    private TalentTeamRepository talentTeamRepository;

    public Iterable<TalentTeam> displayAllTeams(){
        return talentTeamRepository.findAll();
    }

    public Iterable<Talent> displayAllTalents(){
        return talentRepository.findAll();
    }
}
