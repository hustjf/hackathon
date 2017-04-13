package com.oracle.hackathon.service;

import com.oracle.hackathon.dao.CartDaoImpl;
import com.oracle.hackathon.entities.Cart;

import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
public class CartService {
    private CartDaoImpl cartDao = new CartDaoImpl(Cart.class);;

    public List<Cart> findAll() {
        return cartDao.findAll();
    }

    public Cart findById(int id) {
        return cartDao.findById(id);
    }

    public void addCart(Cart cart) {
        cartDao.add(cart);
    }

    public void updateCart(Cart cart) {
        cartDao.update(cart);
    }

    public void deleteCart(List<Cart> carts) {
        cartDao.delete(carts);
    }

}
