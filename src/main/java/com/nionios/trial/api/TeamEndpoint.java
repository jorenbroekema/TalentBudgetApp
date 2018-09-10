package com.nionios.trial.api;

import com.nionios.trial.controller.PersonService;
import com.nionios.trial.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("team")
@Component
public class TeamEndpoint {

    @Autowired
    private PersonService personService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listTeams() {
        Iterable<Team> teams = personService.findAllTeams();
        return Response.ok(teams).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response postPerson(Team team) {
        Team result = personService.save(team);
        return Response.accepted(result.getId()).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deletePerson(Team team, @PathParam("id") Long id) {
        personService.deletePerson(id);
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(Team team) {
        Team result = personService.update(team);
        return Response.noContent().build();
    }
}
