package com.oracle.hackathon.control;

import com.oracle.hackathon.entities.Cart;
import com.oracle.hackathon.service.CartService;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */

@Path("/cart")
public class CartControl {
    private CartService cartService = new CartService();

    @GET
    @Produces("application/json")
    public Response getData() {

        List<Cart> cartList;

        try {
            cartList = cartService.findAll();
            GenericEntity<List<Cart>> entity = new GenericEntity<List<Cart>>(cartList){};
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @Path("/addtoCart")
    @POST
    // The Java method will produce content identified by the MIME Media type "text/plain"
    //@Consumes("application/json")
    @Produces("text/plain")
    public Response addData(String id) {
        try {
            cartService.addById(Integer.parseInt(id));
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @PUT
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response updateData(Cart cart) {
        try {
            int id = cart.getId();
            Cart ori = cartService.findById(id);
            int count = ori.getCount();
            double price = ori.getPrice();
            double single = price / count;
            count = cart.getCount();
            cart.setPrice(single * count);
            cartService.updateCart(cart);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @DELETE
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Consumes("application/json")
    @Produces("text/plain")
    public Response deleteData(List<Cart> carts) {
        try {
            cartService.deleteCart(carts);
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

}
