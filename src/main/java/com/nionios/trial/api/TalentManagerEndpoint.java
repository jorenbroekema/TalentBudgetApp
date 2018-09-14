
package com.nionios.trial.api;

import com.nionios.trial.controller.*;
import com.nionios.trial.domain.Expenditure;
import com.nionios.trial.domain.Talent;
import com.nionios.trial.domain.TalentManager;
import com.nionios.trial.domain.TalentTeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("talentmanager")
@Component
public class TalentManagerEndpoint {
    @Autowired
    private TalentManagerService talentManagerService;

    @Autowired
    private TalentService talentService;

    @Autowired
    private TalentUserService talentUserService;

    @Autowired
    private TalentTeamService talentTeamService;

    @Autowired
    private ExpenditureService expenditureService;


    //// Talent manager CR(U)D http requests:
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTalentManager(TalentManager talentManager){
        TalentManager result = talentManagerService.addTalentManager(talentManager);
        return Response.accepted(result).build();
    }

    @DELETE
    @Path(value = "/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeTalentManager(@PathParam("id") Long id){
        talentManagerService.removeTalentManager(id);
        return Response.noContent().build();
    }

    @GET
    @Path(value = "/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTalentManager(@PathParam("id") Long id){
        TalentManager result = talentManagerService.displayTalentManager(id);
        return Response.ok(result).build();
    }

    @GET
    @Path(value = "/talentmanager/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response displayAllTalentManagers(){
        Iterable<TalentManager> talentmanagers = talentManagerService.displayAllTalentManagers();
        return Response.ok(talentmanagers).build();

    }

    //// Talent http requests
    @POST
    @Path(value = "/talent")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTalent(Talent talent){
        Talent result = talentManagerService.addTalent(talent);
        return Response.accepted(result).build();
    }

    @DELETE
    @Path(value = "/talent/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeTalent(@PathParam("id") Long id){
        talentManagerService.removeTalent(id);
        return Response.noContent().build();
    }

    @GET
    @Path(value = "/talent/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTalent(@PathParam("id") Long id){
        Talent result = talentService.displayTalent(id);
        return Response.ok(result).build();
    }

    @GET
    @Path(value = "/talent/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response displayAllTalents(){
        Iterable<Talent> talents = talentService.displayAllTalents();
        return Response.ok(talents).build();

    }

    //// Team http requests
    @POST
    @Path(value = "/team")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTeam(TalentTeam team) {
        TalentTeam result = talentManagerService.addTalentTeam(team);
        return Response.accepted(result).build();
    }

    @DELETE
    @Path(value = "/team/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeTeam(@PathParam("id") Long id){
        talentManagerService.removeTalentTeam(id);
        return Response.noContent().build();
    }

    @GET
    @Path(value = "/team/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTeam(@PathParam("id") Long id){
        TalentTeam result = talentTeamService.displayTeam(id);
        return Response.ok(result).build();
    }

    @GET
    @Path(value = "/team/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllTeams(){
        Iterable<TalentTeam> teams = talentTeamService.displayAllTeams();
        return Response.ok(teams).build();

    }

    // change state

    @PATCH
    @Path("/changestate/{id}/state/{state}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateState(@PathParam("id") Long id, @PathParam("state") int state) {
        expenditureService.changeState(id, state);
        return Response.ok(" state updated").build();
    }



}