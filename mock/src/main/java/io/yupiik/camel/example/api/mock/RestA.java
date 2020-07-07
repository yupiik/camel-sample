package io.yupiik.camel.example.api.mock;

import org.osgi.service.component.annotations.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/resta")
@Component(property = { "osgi.jaxrs.resource=true" })
public class RestA {

    @Path("/")
    @Produces("application/json")
    @GET
    public String get() {
        return "hello world";
    }

}
