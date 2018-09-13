package com.nionios.trial.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class TalentManager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;


    @OneToMany
    private List<TalentTeam> talentTeams = new ArrayList<>();


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

    public List<TalentTeam> getTalentTeams() {
        return talentTeams;
    }

    public void setTalentTeams(List<TalentTeam> talentTeams) {
        this.talentTeams = talentTeams;
    }
}
