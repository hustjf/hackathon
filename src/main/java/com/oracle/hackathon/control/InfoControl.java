package com.oracle.hackathon.control;

import com.oracle.hackathon.entities.Info;
import com.oracle.hackathon.service.InfoService;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
@Path("/info")
public class InfoControl {

    private InfoService infoService = new InfoService();

    @Path("/getAll")
    @GET
    @Produces("application/json")
    public Response getData() {

        List<Info> infoList;

        try {
            infoList = infoService.findAll();
            GenericEntity<List<Info>> entity = new GenericEntity<List<Info>>(infoList){};
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Path("/getById")
    @POST
    @Produces("application/json")
    public Response getById(@FormParam("id") String id) {
        try {
            Info info = infoService.getById(Integer.parseInt(id));
            GenericEntity<Info> entity = new GenericEntity<Info>(info){};
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    @POST
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response addData(Info info) {
        try {
            infoService.addInfo(info);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response updateData(Info info) {
        try {
            infoService.updateInfo(info);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response deleteData(List<Info> infos) {
        try {
            infoService.deleteInfo(infos);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
