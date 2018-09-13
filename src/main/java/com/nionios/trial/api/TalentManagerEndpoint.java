
package com.nionios.trial.api;

import com.nionios.trial.controller.TalentManagerService;
import com.nionios.trial.controller.TalentService;
import com.nionios.trial.controller.TalentUserService;
import com.nionios.trial.domain.Expenditure;
import com.nionios.trial.domain.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("talentmanager")
@Component
public class TalentManagerEndpoint {
    @Autowired
    private TalentManagerService talentManagerService;

    @Autowired
    private TalentService talentService;

    @Autowired
    private TalentUserService talentUserService;



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTalent(Talent talent){
        Talent result = talentManagerService.addTalent(talent);
        return Response.accepted(result).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeTalent(Talent talent){
        talentManagerService.removeTalent(talent.getId());
        return Response.noContent().build();
    }

    /*@GET
    @Path(value = "{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTalent(@PathParam("id") long id){
        System.out.println(id);

        Expenditure bookJava = new Expenditure();
        bookJava.setName("Java Book");
        bookJava.setDescription("This is a book for learning Java");
        talentUserService.saveExpenditure(bookJava);

        Expenditure course2 = new Expenditure();
        course2.setName("Java course");
        course2.setDescription("This is a course to learn Java");
        talentUserService.saveExpenditure(course2);

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


        Talent result = talentService.displayTalent(id);
        return Response.ok(result).build();
    }

*/
}