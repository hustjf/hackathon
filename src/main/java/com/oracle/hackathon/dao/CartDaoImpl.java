package com.oracle.hackathon.dao;

import com.oracle.hackathon.entities.Cart;

import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
public class CartDaoImpl extends AbstractDao {

    public CartDaoImpl(Class clazz) {

        super(clazz);
    }

    public Cart findById(int id) {
        return (Cart)super.find((Integer)id);
    }

    public List<Cart> findAll() {

        return (List<Cart>) super.findAll();
    }

    public void add(Cart cart) {

        em.getTransaction().begin();
        em.persist(cart);
        em.getTransaction().commit();
    }

    public void addById(int id) {
        Cart cart = findById(id);
        em.getTransaction().begin();
        em.persist(cart);
        em.getTransaction().commit();
    }

    public void delete(List<Cart> carts) {
        em.getTransaction().begin();
        for (Cart cart : carts) {
            em.remove(em.contains(cart) ? cart : em.merge(cart));
        }
        em.getTransaction().commit();
    }

    public void update(Cart cart) {
        em.getTransaction().begin();
        em.merge(cart);
        em.getTransaction().commit();
    }
}
