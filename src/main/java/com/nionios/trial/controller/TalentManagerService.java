package com.nionios.trial.controller;

import com.nionios.trial.domain.Talent;
import com.nionios.trial.domain.TalentManager;
import com.nionios.trial.domain.TalentTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    public Talent addTalent(Talent talent){ return talentRepository.save(talent); }
    
   /* public Talent changeTalent(Talent talent, Long newId) {
    	talentRepository.
    }*/

    public void removeTalent(long number){
        Optional<Talent> t = talentRepository.findById(number);
        System.out.println(t);
        if (t.isPresent())
        	talentRepository.delete(t.get());
    }


    public TalentTeam addTalentTeam(TalentTeam tt){
        return talentTeamRepository.save(tt);
    }

    public void approveExpenditure(Long id){
        expenditureRepository.findById(id).get().setState(1);
    }

    public void disapproveExpenditure(Long id){
        expenditureRepository.findById(id).get().setState(3);
    }


    public TalentManager displayTalentManager(Long id){
        return talentManagerRepository.findById(id).get();
    }
    public TalentManager addTalentManager(TalentManager manager) { 
    	return talentManagerRepository.save(manager); 
    }
    public void removeTalentManager(long id) {
    	Optional<TalentManager> m = talentManagerRepository.findById(id);
    	System.out.println(m);
    	if (m.isPresent())
    		talentManagerRepository.delete(m.get());
    }
}
