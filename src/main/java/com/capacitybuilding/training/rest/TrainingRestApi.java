package com.capacitybuilding.training.rest;

import com.capacitybuilding.training.bean.TrainingBeanI;
import com.capacitybuilding.training.model.Training;
import com.capacitybuilding.util.rest.BaseRestApi;
import com.capacitybuilding.util.rest.ResponseWrapper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/training")
public class TrainingRestApi extends BaseRestApi {

    @EJB
    private TrainingBeanI trainingBean;
    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Training training) {
        try {
            trainingBean.add(training);
            return Response.status(Response.Status.OK).entity(new ResponseWrapper()).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ResponseWrapper(false, ex.getMessage())).build();
        }

    }

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.status(Response.Status.OK).entity(trainingBean.getList()).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTraining(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(trainingBean.getTraining(id)).build();
    }
}
