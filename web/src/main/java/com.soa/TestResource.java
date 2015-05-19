package com.soa;

import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    @GET
    @Produces("application/json")
    @Path("lista")
    public Response lista(){
        List<Student> list = new ArrayList<Student>();
        for(int i=0; i<5; i++){
            list.add(new Student("Jan", "nowak", "" + i));
        }
        return Response.ok(list, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Produces("image/png")
    @Path("img")
    public Response img() throws IOException {
        BufferedImage image = ImageIO.read(new File("C:\\Users\\redi\\soap\\web\\image.gif"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageData = baos.toByteArray();
        return Response.ok(imageData).build();
    }

    @GET
    @Produces("document/pdf")
    @Path("pdf")
    public Response pdf(){
        File file = new File("C:\\Users\\redi\\soap\\web\\a.pdf");
        Response.ResponseBuilder responseBuilder = Response.ok(file);
        responseBuilder.header("Content-Disposition",
                "attachment; filename=a.pdf");
        return responseBuilder.build();

    }

    @POST
    @Path("post")
    public Response post(@QueryParam("id") String id){

        Student s = new Student("Jan", "Nowak", id);
        return Response.ok(s, MediaType.APPLICATION_JSON).build();
    }

}