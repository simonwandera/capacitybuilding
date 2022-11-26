package com.capacitybuilding.auth.rest;


import com.capacitybuilding.user.bean.UserBeanI;
import com.capacitybuilding.user.model.User;
import com.capacitybuilding.util.rest.ResponseWrapper;
import org.apache.commons.codec.digest.DigestUtils;

import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/auth")
public class AuthApi {

    @EJB
    UserBeanI userBean;

    @PermitAll
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(RestLoginWrapper loginWrapper) {

        User user = new User();
        user.setUsername(loginWrapper.getUsername());
        user.setPassword(DigestUtils.md5Hex(loginWrapper.getPassword()));


        try {
            User user1 = userBean.login(user);
            return Response.status(Response.Status.OK)
                .entity(new ResponseWrapper("authorized", user1.getBearerToken())).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new ResponseWrapper(false, ex.getMessage())).build();
        }
    }
}
