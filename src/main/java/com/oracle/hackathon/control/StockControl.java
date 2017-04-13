package com.oracle.hackathon.control;

import com.oracle.hackathon.entities.Stock;
import com.oracle.hackathon.service.StockService;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Created by xinyuan.zhang on 3/31/17.
 */

@Path("/stock")
public class StockControl {


    private StockService stockService = new StockService();

        @GET
        @Produces("application/json")
        public Response getData() {

            List<Stock> stockList;

            if(stockService==null) {
                stockService = new StockService();
            }

            try {
                stockList = stockService.findAll();
                GenericEntity<List<Stock>> entity = new GenericEntity<List<Stock>>(stockList){};
                return Response.status(Response.Status.OK).entity(entity).build();
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
            }
        }


        @POST
        // The Java method will produce content identified by the MIME Media type "text/plain"
        @Consumes("application/json")
        @Produces("text/plain")
        public Response addData(Stock stock) {
            if(stockService==null) {
                stockService = new StockService();
            }

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
        public Response updateData(Stock stock) {
            if(stockService==null) {
                stockService = new StockService();
            }

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
        public Response deleteData(List<Stock> stocks) {
            if(stockService==null) {
                stockService = new StockService();
            }

            try {
                stockService.deleteStock(stocks);
                return Response.status(Response.Status.OK).build();
            } catch (Exception e) {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
            }
    }
}
