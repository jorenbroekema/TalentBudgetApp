package com.nionios.trial.api;
import javax.ws.rs.*;
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
        return Response.ok(expenditures).build();
    }

    @GET
    @Path("/inprogress")
    @Produces(MediaType.APPLICATION_JSON)
    public Response expendituresInProgress() {
        Iterable<Expenditure> expenditures = expenditureService.findInProgress(2);
        return Response.ok(expenditures).build();
    }

    @PATCH
    @Path("/{id}/state/{state}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateState(@PathParam("id") Long id, @PathParam("state") int state) {
        expenditureService.changeState(id, state);
        return Response.ok(" Succesfully updated").build();
    }

}
