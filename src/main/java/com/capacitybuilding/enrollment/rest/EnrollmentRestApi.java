package com.capacitybuilding.enrollment.rest;

import com.capacitybuilding.enrollment.bean.EnrollmentBeanI;
import com.capacitybuilding.enrollment.model.Enrollment;
import com.capacitybuilding.util.rest.BaseRestApi;
import com.capacitybuilding.util.rest.ResponseWrapper;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/enrollment")
public class EnrollmentRestApi extends BaseRestApi {

    @EJB
    private EnrollmentBeanI enrollmentBean;

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Enrollment enrollment) {
        try {
            enrollmentBean.enroll(enrollment);
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
        return Response.status(Response.Status.OK).entity(enrollmentBean.getEnrollments()).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTraining(@PathParam("id") Long id) {
        return Response.status(Response.Status.OK).entity(enrollmentBean.getEnrollment(id)).build();
    }
}
