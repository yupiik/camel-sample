package io.yupiik.camel.example.gateway.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class SimpleApi {

    @Path("/foo")
    @GET
    public String foo() {
        // stub
        return null;
    }

}
