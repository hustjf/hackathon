package com.oracle.hackathon.control;

import com.oracle.hackathon.entities.Cart;
import com.oracle.hackathon.entities.Orders;
import com.oracle.hackathon.service.OrdersService;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */

@Path("/orders")
public class OrdersControl {

    private OrdersService ordersService = new OrdersService();

    @GET
    @Produces("application/json")
    public Response getData() {

        List<Orders> ordersList;

        try {
            ordersList = ordersService.findAll();
            GenericEntity<List<Orders>> entity = new GenericEntity<List<Orders>>(ordersList){};
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }


    @POST
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response addData(List<Cart> carts) {

        List<Orders> orders = new ArrayList<Orders>();
        for(int i=0;i<carts.size();i++) {
            Cart cart = carts.get(i);
            Orders order = new Orders();
            order.setCount(cart.getCount());
            order.setId(cart.getId());
            order.setName(cart.getName());
            order.setOrderid(cart.getOrderid());
            order.setTime(new Date());
            order.setPrice(cart.getPrice());
            orders.add(order);

        }
        try {
            ordersService.addOrder(orders);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response updateData(Orders order) {
        try {
            ordersService.updateOrder(order);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response deleteData(List<Orders> orders) {
        try {
            ordersService.deleteOrder(orders);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
