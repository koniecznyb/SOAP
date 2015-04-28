package java.com.soa;

import javax.ejb.Stateless;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.xml.ws.Response;

/**
 * Created by redi on 28.04.15.
 */
@Stateless
@Path("test")
public class TestResource {
    public Response hello(@QueryParam("id") String id){
        
    }
}
