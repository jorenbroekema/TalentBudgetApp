package com.nionios.trial.controller;

import com.nionios.trial.domain.Expenditure;
import com.nionios.trial.domain.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TalentService {

    @Autowired
    private TalentRepository talentRepository;

    public Talent displayTalent(Long id){
        return talentRepository.findById(id).get();
    }

    public Iterable<Expenditure> displayExpeditures(Long id){
        return talentRepository.findById(id).get().getExpenditures();
    }

}
