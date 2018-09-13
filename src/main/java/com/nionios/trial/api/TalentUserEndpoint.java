package com.nionios.trial.api;

import com.nionios.trial.controller.ExpenditureService;
import com.nionios.trial.controller.TalentUserService;
import com.nionios.trial.domain.Expenditure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
@Component
public class TalentUserEndpoint {

    @Autowired
    private TalentUserService talentUserService;

    @Autowired
    private ExpenditureService expenditureService;

    @POST
    @Path("/add-expenditure")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response addExpenditure(Expenditure expenditure) {
        talentUserService.addExpenditure(expenditure);
        return Response.accepted().build();
    }

    @DELETE
    @Path("/delete/expenditure/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteExpenditure(@PathParam("id") Long id) {
        Expenditure expenditure = expenditureService.findExpenditure(id);
        talentUserService.deleteExpenditure(expenditure);
        return Response.noContent().build();
    }
/*
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(Person person) {
        Person result = personService.update(person);
        return Response.noContent().build();
    }*/
}
