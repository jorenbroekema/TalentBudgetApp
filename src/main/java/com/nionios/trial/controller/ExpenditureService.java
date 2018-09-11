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

    public void approve(Long id){
        // changing the state to 'Approved'
        expenditureRepository.findById(id).get().setState(1);
    }

    public void inprogress(Long id){
        expenditureRepository.findById(id).get().setState(2);
    }

    public void declined(Long id){
        expenditureRepository.findById(id).get().setState(3);
    }

    public void closed(Long id){
        expenditureRepository.findById(id).get().setState(4);
    }

    public Expenditure displayExpenditure(Long id){
        return expenditureRepository.findById(id).get();
    }





}
