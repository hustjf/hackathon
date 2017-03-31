package com.oracle.hackathon.control;

import com.oracle.hackathon.entities.Stock;
import com.oracle.hackathon.service.StockService;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;


import static com.oracle.hackathon.control.DepotDBEntityManagerFactory.emf;

/**
 * Created by xinyuan.zhang on 3/31/17.
 */

@Path("/stock")
public class StockControl {

    private EntityManager em = emf.createEntityManager(); ;
    private StockService stockService ;


    @GET
    @Produces("application/json")
    public Response getData() {

        List<Stock> stockList;

        if(stockService==null) {
            stockService = new StockService(em);
        }

        try {
            stockList = stockService.findAll();
            GenericEntity<List<Stock>> entity = new GenericEntity<List<Stock>>(stockList){};
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


}
