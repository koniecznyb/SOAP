package com.soa;

import javax.ejb.Stateless;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by redi on 28.04.15.
 */
@Stateless
@Path("test")
public class TestResource {
    @GET
    @Produces("application/json")
    @Path("hello")
    public Response hello(@QueryParam("id") String id){

        Student s = new Student("Jan", "Nowak", id);
        return Response.ok(s, MediaType.APPLICATION_JSON).build();
    }
}
