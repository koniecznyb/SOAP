package com.soa;

import com.sun.org.apache.xerces.internal.util.Status;
import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by redi on 28.04.15.
 */
@Stateless
@Path("test")
public class TestResource {

    @POST
    @Path("validate")
    public Response validate(@FormParam("username") String username, @FormParam("password") String password,
    @Context HttpServletRequest http){

        HttpSession httpSession = http.getSession();

        if(password.equals("haslo")){
            Student s = new Student("Jan", "Nowak", "10");
            httpSession.setAttribute("username", username);
            return Response.status(Response.Status.ACCEPTED).build();
        }

        return Response.status(Response.Status.FORBIDDEN).build();

    }


    @GET
    @Produces("application/json")
    @Path("helloSecured")
    public Response helloSecured(@QueryParam("username") String username, @FormParam("password") String password,
                                 @Context HttpServletRequest http){

        HttpSession httpSession = http.getSession();

        if(httpSession == null){
            Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

        if(httpSession.getAttribute("username").equals("admin")){
            Student s = new Student("Jan", "Nowak", "10");
            return Response.ok(s, MediaType.APPLICATION_JSON).build();
        }

        return Response.status(Response.Status.FORBIDDEN).build();

    }

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
        BufferedImage image = ImageIO.read(new File("/home/redi/Projects/soap/web/image2.png"));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] imageData = baos.toByteArray();
        return Response.ok(imageData).build();
    }

    @GET
    @Produces("document/pdf")
    @Path("pdf")
    public Response pdf() throws FileNotFoundException {
        Response.ResponseBuilder response = Response.ok(new File("/home/redi/Projects/soap/web/a.pdf"));
        response.header("Content-Disposition",
                "attachment; filename=a.pdf");
        return response.build();

    }

    @POST
    @Produces("application/json")
    @Path("post")
    public Response post(@FormParam("id") String id, @FormParam("param2") String param2){

        Student s = new Student("Jan", "Nowak", id);
        return Response.ok(s, MediaType.APPLICATION_JSON).build();
    }


    @PUT
    @Path("put")
    public Response put(@QueryParam("id") String id){
        Student s = new Student("Nowak", "Jan", id);
        return Response.ok(s, MediaType.APPLICATION_JSON).build();

    }

    @DELETE
    @Path("delete")
    public Response delete(){
        return Response.ok("Something deleted").build();
    }
}
