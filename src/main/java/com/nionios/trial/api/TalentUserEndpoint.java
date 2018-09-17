package com.nionios.trial.api;

import com.nionios.trial.controller.ExpenditureService;
import com.nionios.trial.controller.TalentManagerService;
import com.nionios.trial.controller.TalentService;
import com.nionios.trial.controller.TalentUserService;
import com.nionios.trial.domain.Expenditure;
import com.nionios.trial.domain.Talent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("user")
@Component
public class TalentUserEndpoint {

    @Autowired
    private TalentUserService talentUserService;

    @Autowired
    private ExpenditureService expenditureService;

    @Autowired
    private TalentManagerService talentManagerService;

    @Autowired
    private TalentService talentService;

    @POST
    @Path("/{id}/expenditure")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addExpenditure(Expenditure expenditure, @PathParam("id") Long id) {
        Talent talent = talentService.displayTalent(id);
        Expenditure result = talentUserService.saveExpenditure(expenditure);
        List<Expenditure> talentExpenditures = talent.getExpenditures();
        talentExpenditures.add(result);
        talent.setExpenditures(talentExpenditures);
        talentManagerService.addTalent(talent);
        return Response.accepted(result.getId()).build();
    }

    @DELETE
    @Path("/{id}/expenditure/{expenditure_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteExpenditure(@PathParam("id") Long id, @PathParam("expenditure_id") Long ex_id) {
        Talent talent = talentService.displayTalent(id);
        Expenditure expenditure = expenditureService.findExpenditure(ex_id);
        List<Expenditure> talentExpenditures = talent.getExpenditures();

        // Finding the right expenditure in the list to delete
        Expenditure target = new Expenditure();
        for (Expenditure e : talentExpenditures) {
            if (e.getId() == ex_id){
                target = e;
                break;
            }
            target = null;
        }
        try{talentExpenditures.remove(target);} catch (Exception e){
            System.out.println(e);
        }

        talent.setExpenditures(talentExpenditures);
        talentManagerService.addTalent(talent);
        talentUserService.deleteExpenditure(expenditure);
        return Response.noContent().build();
    }
}