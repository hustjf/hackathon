package com.oracle.hackathon.service;

import com.oracle.hackathon.dao.OrdersDaoImpl;
import com.oracle.hackathon.entities.Orders;

import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
public class OrdersService {

    private OrdersDaoImpl ordersDao = new OrdersDaoImpl(Orders.class);;

    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    public Orders findById(int id) {
        return ordersDao.findById(id);
    }

    public void addStock(Orders order) {
        ordersDao.add(order);
    }

    public void updateStock(Orders order) {
        ordersDao.update(order);
    }

    public void deleteStock(List<Orders> orders) {
        ordersDao.delete(orders);
    }
}