package com.nionios.trial.api;

import com.nionios.trial.controller.*;
import com.nionios.trial.domain.Expenditure;
import com.nionios.trial.domain.Talent;
import com.nionios.trial.domain.TalentManager;
import com.nionios.trial.domain.TalentTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("talentteam")
@Component
public class TalentTeamEndpoint {

    @Autowired
    private TalentTeamService talentTeamService;

    @Autowired
    private TalentService talentService;

    @Autowired
    private TalentManagerService talentManagerService;

    @Autowired
    private ExpenditureService expenditureService;

    @Autowired
    private TalentUserService talentUserService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listGroep(){
        Expenditure bookJava = new Expenditure();
        bookJava.setName("Java Book");
        bookJava.setDescription("This is a book for learning Java");
        talentUserService.addExpenditure(bookJava);

        Expenditure course2 = new Expenditure();
        course2.setName("Java course");
        course2.setDescription("This is a course to learn Java");
        talentUserService.addExpenditure(course2);

        ArrayList<Expenditure> expenditures = new ArrayList<>();
        expenditures.add(bookJava);
        expenditures.add(course2);

      //  TalentTeam tt = new TalentTeam();
      //  tt.setTeamname("TEP12");

        Talent talent = new Talent();
        talent.setName("Frits");
        talent.setBudget(1500);
        //talent.setTalentTeam(tt);
        talent.setExpenditures(expenditures);

        talentManagerService.addTalent(talent);


        return Response.ok("talentTeams").build();
    }
}
