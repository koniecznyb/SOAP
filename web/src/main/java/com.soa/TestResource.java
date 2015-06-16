package com.soa;

import com.soa.model.Student;
import com.soa.model.Subject;
import org.hibernate.Query;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


    @DELETE
    @Produces("application/json")
    @Path("deleteStudent")
    public Response deleteStudent(@QueryParam("id") Integer id) {
        Session session = Hibernate.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Query query = session.createQuery("delete from Student where ID= :id");
        query.setInteger("id", id);
        int result = query.executeUpdate();
        session.getTransaction().commit();
        if(result == 1) {
            return Response.status(200).entity("DELETED").build();
        } else {
            return Response.status(204).build();
        }
    }

    @GET
    @Produces("application/json")
    @Path("student")
    public Response getStudent(@QueryParam("id") Integer id){
        Session session = Hibernate.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Student where id= :id");
        query.setInteger("id", id);
        Student student = (Student) query.uniqueResult();
        session.getTransaction().commit();
        return Response.ok(student, MediaType.APPLICATION_JSON).build();
    }


    @GET
    @Produces("application/json")
    @Path("getStudents")
    public Response getStudents() {
        Session session = Hibernate.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query query = session.createQuery("from Student");
        List students = query.list();
        session.getTransaction().commit();
        return Response.ok(students, MediaType.APPLICATION_JSON).build();
    }


    @POST
    @Produces("application/json")
    @Path("addStudent")
    public Response getStudent(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
    @FormParam("albumNum") String albumNum, @FormParam("subject1") String subject1,
                               @FormParam("subject2") String subject2){
        Session session = Hibernate.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setIndexNo(albumNum);
        Set<Subject> subjects = new HashSet<Subject>();

        subjects.add(new Subject(subject1));
        subjects.add(new Subject(subject2));

        student.setSubjects(subjects);

        session.save(student);
        Boolean saved = session.contains(student);
        session.getTransaction().commit();
        if(saved == true){
            return Response.status(200).entity(student).build();
        }else {
            return Response.status(422).build();
        }

    }
}
