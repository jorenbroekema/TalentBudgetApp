package com.nionios.trial.controller;

import com.nionios.trial.domain.Talent;
import com.nionios.trial.domain.TalentTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TalentManagerService {

    @Autowired
    TalentManagerRepository talentManagerRepository;

    @Autowired
    TalentTeamRepository talentTeamRepository;

    @Autowired
    TalentRepository talentRepository;

    @Autowired
    ExpenditureRepository expenditureRepository;

    public Iterable<TalentTeam> viewOwnTeams(Long id){
        return talentManagerRepository.findById(id).get().getTalentTeams();
    }

    public void addTalent(Talent talent){
        talentRepository.save(talent);
    }

    public void addTalentTeam(TalentTeam tt){
        talentTeamRepository.save(tt);
    }

    public void approveExpenditure(Long id){
        expenditureRepository.findById(id).get().setState(1);
    }

    public void disapproveExpenditure(Long id){
        expenditureRepository.findById(id).get().setState(3);
    }
}
