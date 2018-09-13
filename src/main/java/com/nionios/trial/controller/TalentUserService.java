package com.nionios.trial.controller;

import com.nionios.trial.domain.Expenditure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class TalentUserService {

    @Autowired
    TalentUserRepository talentUserRepository;

    @Autowired
    ExpenditureRepository expenditureRepository;

    @Autowired
    TalentRepository talentRepository;

    public void addExpenditure(Expenditure expenditure){
        expenditureRepository.save(expenditure);
    }

    public void deleteExpenditure(Expenditure expenditure){
        expenditureRepository.delete(expenditure);
    }

    public void viewBudget(Long id){
        talentRepository.findById(id).get().getBudget();
    }


}
