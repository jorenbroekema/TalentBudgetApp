package com.nionios.trial.controller;

import com.nionios.trial.domain.Expenditure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class ExpenditureService {
    // 1 = APPROVED
    // 2 = INPROGESS
    // 3 = DECLINED
    // 4 = CLOSED
    @Autowired
    private ExpenditureRepository expenditureRepository;
/*
    public void approve(Long id){expenditureRepository.findById(id).get().setState(1); }

    public void inprogress(Long id){
        expenditureRepository.findById(id).get().setState(2);
    }

    public void declined(Long id){
        expenditureRepository.findById(id).get().setState(3);
    }

    public void closed(Long id){
        expenditureRepository.findById(id).get().setState(4);
    }
 */

    public void changeState (Long id, int state) {expenditureRepository.findById(id).get().setState(state);}

    public Expenditure findExpenditure(Long id){
        return expenditureRepository.findById(id).get();
    }

    public Iterable<Expenditure> findAllExpenditures() { Iterable<Expenditure> result = expenditureRepository.findAll(); return result;}

    public Iterable<Expenditure> findInProgress(int state) {return expenditureRepository.findByStateEquals(2);}
}
