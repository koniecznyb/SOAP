package src.main;



import org.codehaus.jackson.map.ObjectMapper;

import javax.imageio.ImageIO;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by redi on 6/1/15.
 */
public class ConsumerMain {
    public static void main(String ... args) throws IOException {
        Client client = ClientBuilder.newClient();

        client.property("TestProperty", "TestValue");

        Response res = client.target("http://localhost:8080/soa-web/test/hello").request("application/json").get();
        String message = res.readEntity(String.class);

        ObjectMapper objectMa2pper = new ObjectMapper();
        Student student = objectMapper.readValue(message, Student.class);

        System.out.println(student.getFirstName() + ": " + student.getLastName());

        System.out.println("/test/hello: " + message);

        res = client.target("http://localhost:8080/soa-web/test/hello?id=5").request("application/json").get();
        message = res.readEntity(String.class);

        System.out.println("/test/hello?id=5: " + message);

        res = client.target("http://localhost:8080/soa-web/test/lista").request("application/json").get();
        message = res.readEntity(String.class);

        System.out.println("/test/lista: " + message);

        res = client.target("http://localhost:8080/soa-web/test/img").request("image/png").get();
        byte[] imageData = res.readEntity(byte[].class);
        InputStream in = new ByteArrayInputStream(imageData);
        BufferedImage image = ImageIO.read(in);
        ImageIO.write(image, "png", new File("downloadedImage.png"));


        Form form = new Form();
        form.param("id", "wartoscid");

        res = client.target("http://localhost:8080/soa-web/test/post").request("application/json").post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        message = res.readEntity(String.class);

        System.out.println("/test/post: " + message);


        res = client.target("http://localhost:8080/soa-web/test/pdf").request("document/pdf").get();

        final Path destination = Paths.get("downloadedPDF.pdf");

        try {
            final InputStream inputStream = res.readEntity(InputStream.class);
            Files.copy(inputStream, destination);
            inputStream.close();
        }catch (Exception e){
            System.out.println("file exists");
        }


        form = new Form();
        form.param("username", "admin");
        form.param("password", "haslo");
        res = client.target("http://localhost:8080/soa-web/test/validate").request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
        System.out.println("Validation: " + res);




        res = client.target("http://localhost:8080/soa-web/test/helloSecured").request("application/json").get();
        message = res.readEntity(String.class);

//        System.out.println("/test/helloSecured: " + message);
    }
}
