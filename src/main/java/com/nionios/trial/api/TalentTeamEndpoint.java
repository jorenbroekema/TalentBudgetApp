package com.nionios.trial.api;

import com.nionios.trial.controller.*;
import com.nionios.trial.domain.TalentTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("talentteam")
@Component
public class TalentTeamEndpoint {

    @Autowired
    private TalentManagerService talentManagerService;

    @Autowired
    private TalentTeamService talentTeamService;


    //// Team http requests
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTeam(TalentTeam team) {
        TalentTeam result = talentManagerService.addTalentTeam(team);
        return Response.accepted(result).build();
    }

    @DELETE
    @Path(value = "/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeTeam(@PathParam("id") Long id){
        talentManagerService.removeTalentTeam(id);
        return Response.noContent().build();
    }

    @GET
    @Path(value = "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTeam(@PathParam("id") Long id){
        TalentTeam result = talentTeamService.displayTeam(id);
        return Response.ok(result).build();
    }

    @GET
    @Path(value = "/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllTeams(){
        Iterable<TalentTeam> teams = talentTeamService.displayAllTeams();
        return Response.ok(teams).build();

    }
}
