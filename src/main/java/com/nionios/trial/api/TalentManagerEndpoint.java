
package com.nionios.trial.api;

import com.nionios.trial.controller.*;
import com.nionios.trial.domain.TalentManager;
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
    @Path(value = "/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response displayAllTalentManagers(){
        Iterable<TalentManager> talentmanagers = talentManagerService.displayAllTalentManagers();
        return Response.ok(talentmanagers).build();

    }


}