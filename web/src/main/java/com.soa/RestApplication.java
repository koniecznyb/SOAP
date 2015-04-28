package java.com.soa;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Created by redi on 28.04.15.
 */
@ApplicationPath("/")
public class RestApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(TestResource.class);
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> singletons = new HashSet<Object>();
        singletons.add(new JacksonJsonProvider());
        return singletons;
    }
}
