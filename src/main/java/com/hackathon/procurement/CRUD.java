package com.hackathon.procurement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by alex on 17/3/27.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/crud")
public class CRUD {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public String getData() {
        // Return some cliched textual content
        return "Hello World";
    }

}