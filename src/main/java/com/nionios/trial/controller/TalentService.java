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

    public Talent displayTalent(Long id){ return talentRepository.findById(id).get(); }

    public Iterable<Talent> displayAllTalents (){Iterable<Talent> result = talentRepository.findAll(); return result;}

    public Iterable<Expenditure> displayAllExpenditures(Long id){ return talentRepository.findById(id).get().getExpenditures(); }

}
