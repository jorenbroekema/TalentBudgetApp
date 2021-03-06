package com.nionios.trial.controller;

import com.nionios.trial.domain.Expenditure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface ExpenditureRepository extends CrudRepository<Expenditure, Long> {
    List<Expenditure> findByStateEquals (int State);
}
