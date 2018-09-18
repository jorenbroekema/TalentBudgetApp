package com.nionios.trial.api;
import com.nionios.trial.controller.*;
import com.nionios.trial.domain.Talent;
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

    @Autowired
    private TalentService talentService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTeam(TalentTeam team) {
        TalentTeam result = talentManagerService.addTalentTeam(team);
        return Response.accepted(result).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeTeam(@PathParam("id") Long id){
        talentManagerService.removeTalentTeam(id);
        return Response.ok("Succesfully deleted").build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTeam(@PathParam("id") Long id){
        Iterable<Talent> result = talentService.displayAllTeamMembers(id);
        return Response.ok(result).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllTeams(){
        Iterable<TalentTeam> teams = talentTeamService.displayAllTeams();
        return Response.ok(teams).build();

    }
}
