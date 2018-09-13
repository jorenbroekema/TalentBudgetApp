package com.nionios.trial.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.nionios.trial.controller.ExpenditureService;
import com.nionios.trial.domain.Expenditure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nionios.trial.domain.Talent;
import com.nionios.trial.controller.TalentService;

@Path("talent")
@Component
public class TalentEndpoint {

    @Autowired
    private TalentService talentService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response displayTalent(@PathParam("id") Long id) {
        Talent talent = talentService.displayTalent(id);
        return Response.ok(talent).build();
    }

    @GET
    @Path("/{id}/expenditures")
    @Produces(MediaType.APPLICATION_JSON)
    public Response displayAllExpenditures(@PathParam("id") Long id) {
        Iterable<Expenditure> expenditures = talentService.displayAllExpenditures(id);
        return Response.ok(expenditures).build();
    }



}
