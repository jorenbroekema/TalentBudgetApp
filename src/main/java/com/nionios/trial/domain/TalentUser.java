package com.nionios.trial.domain;

import javax.persistence.*;

@Entity
public class TalentUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private Talent talent;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Talent getTalent() {
        return talent;
    }

    public void setTalent(Talent talent) {
        this.talent = talent;
    }
}
