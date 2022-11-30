package com.capacitybuilding.enrollment.view;

import com.capacitybuilding.enrollment.bean.EnrollmentBeanI;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@PermitAll
@Path("/enrollment")
public class EnrollmentRestApi {

    @EJB
    private EnrollmentBeanI enrollmentBean;

    @PermitAll
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.status(Response.Status.OK).entity(enrollmentBean.getEnrollments()).build();
    }
}
