package com.oracle.hackathon.control;

import com.oracle.hackathon.entities.Stocks;
import com.oracle.hackathon.service.StocksService;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
@Path("/stocks")
public class StocksControl {
    private StocksService stockService = new StocksService();

    @GET
    @Produces("application/json")
    public Response getData() {

        List<Stocks> stockList;
        try {
            stockList = stockService.findAll();
            GenericEntity<List<Stocks>> entity = new GenericEntity<List<Stocks>>(stockList){};
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    @POST
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response addData(Stocks stock) {

        try {
            stockService.addStock(stock);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response updateData(Stocks stock) {

        try {
            stockService.updateStock(stock);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response deleteData(List<Stocks> stocks) {

        try {
            stockService.deleteStock(stocks);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    @Path("/getDataByField")
    @GET
    @Produces("application/json")
    public Response getDataByField() {

        List<Stocks> stockList;
        String type="";
        String supplier="";
        double flooerPrice=-1;
        double ceilingPrice=-1;

        try {
            stockList = stockService.findByFields(type,supplier,flooerPrice,ceilingPrice);
            GenericEntity<List<Stocks>> entity = new GenericEntity<List<Stocks>>(stockList){};
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
