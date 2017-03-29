package com.hackathon.procurement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by alex on 17/3/27.
 */
// The Java class will be hosted at the URI path "/crud"
@Path("/crud")
public class CRUD {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/plain")
    public Response getData() {
        // Return some cliched textual content
        try {
            List<Item> itemList = DBHelper.getData();
            return Response.status(Response.Status.OK).entity(itemList).build();
        } catch (SQLException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e).build();
        }

    }

}
