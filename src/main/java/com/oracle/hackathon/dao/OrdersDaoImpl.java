package com.oracle.hackathon.dao;

import com.oracle.hackathon.entities.Orders;

import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
public class OrdersDaoImpl extends AbstractDao {

    public OrdersDaoImpl(Class clazz) {

        super(clazz);
    }

    public Orders findById(int id) {
        return (Orders)super.find((Integer)id);
    }

    public List<Orders> findAll() {

        return (List<Orders>) super.findAll();
    }

    public void addById(int id) {
        em.getTransaction().begin();
        Orders order = findById(id);
        em.persist(order);
        em.getTransaction().commit();
    }

    public void add(List<Orders> orders) {

        em.getTransaction().begin();
        for (Orders order : orders) {
            em.persist(order);
        }
        em.getTransaction().commit();
    }

    public void delete(List<Orders> orders) {
        em.getTransaction().begin();
        for (Orders order : orders) {
            em.remove(em.contains(order) ? order : em.merge(order));
        }
        em.getTransaction().commit();
    }

    public void update(Orders order) {
        em.getTransaction().begin();
        em.merge(order);
        em.getTransaction().commit();
    }
}
