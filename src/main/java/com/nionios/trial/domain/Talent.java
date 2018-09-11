package com.nionios.trial.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Talent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private double budget;


    public List<Expenditure> getExpenditures() {
        return expenditures;
    }

    public void setExpenditures(List<Expenditure> expenditures) {
        this.expenditures = expenditures;
    }

    public TalentTeam getTalentTeam() {
        return talentTeam;
    }

    public void setTalentTeam(TalentTeam talentTeam) {
        this.talentTeam = talentTeam;
    }

    @OneToMany
    private List<Expenditure> expenditures = new ArrayList<>();

    @ManyToOne
    private TalentTeam talentTeam;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }


}
