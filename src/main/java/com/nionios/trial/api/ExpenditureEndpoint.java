package com.nionios.trial.api;

import javax.print.attribute.standard.Media;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nionios.trial.domain.Expenditure;
import com.nionios.trial.controller.ExpenditureService;

@Path("expenditure")
@Component
public class ExpenditureEndpoint {

    @Autowired
    private ExpenditureService expenditureService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listExpenditures() {
        Iterable<Expenditure> expenditures = expenditureService.findAllExpenditures();
        //return "Hello world";
        //return Response.ok("expenditures").build();
        return Response.ok(expenditures).build();
    }

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postPerson(Person person) {
        Person result = personService.save(person);
        return Response.accepted(result.getId()).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePerson(Person person, @PathParam("id") Long id) {
        personService.deletePerson(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(Person person) {
        Person result = personService.update(person);
        return Response.noContent().build();
    }*/

}
