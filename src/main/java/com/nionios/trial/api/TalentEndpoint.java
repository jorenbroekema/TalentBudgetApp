package com.nionios.trial.api;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.nionios.trial.controller.TalentManagerService;
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

   @Autowired
   private TalentManagerService talentManagerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTalent(Talent talent){
        Talent result = talentManagerService.addTalent(talent);
        return Response.accepted(result).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeTalent(@PathParam("id") Long id){
        talentManagerService.removeTalent(id);
        return Response.noContent().build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findTalent(@PathParam("id") Long id){
        Talent result = talentService.displayTalent(id);
        return Response.ok(result).build();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response displayAllTalents(){
        Iterable<Talent> talents = talentService.displayAllTalents();
        return Response.ok(talents).build();

    }

    @GET
    @Path("/{id}/expenditures")
    @Produces(MediaType.APPLICATION_JSON)
    public Response displayAllExpenditures(@PathParam("id") Long id) {
        Iterable<Expenditure> expenditures = talentService.displayAllExpenditures(id);
        return Response.ok(expenditures).build();
    }
}
