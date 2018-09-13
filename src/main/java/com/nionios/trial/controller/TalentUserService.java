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

    public Expenditure saveExpenditure(Expenditure expenditure){
        return expenditureRepository.save(expenditure);
    }

    // TODO: Get rid of voids. There is always something to return, which helps with troubleshooting on the frontend :)!
    public void deleteExpenditure(Expenditure expenditure){
        expenditureRepository.delete(expenditure);
    }

    public void viewBudget(Long id){
        talentRepository.findById(id).get().getBudget();
    }


}
