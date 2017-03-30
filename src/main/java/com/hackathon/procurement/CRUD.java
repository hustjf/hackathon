package com.hackathon.procurement;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by alex on 17/3/27.
 */
// The Java class will be hosted at the URI path "/crud"
@Path("/crud")
public class CRUD {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "application/json"
    @Produces("application/json")
    public Response getData() {
        List<Item> itemList;
        try {
            itemList = DBHelper.getData();
            GenericEntity<List<Item>> entity = new GenericEntity<List<Item>>(itemList){};
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response addData(Item item) {
        boolean isSuccess = false;
        try {
            isSuccess = DBHelper.addData(item);
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
        if (isSuccess) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("insert data failed").build();
        }
    }

}
