package com.oracle.hackathon.dao;

import com.oracle.hackathon.entities.Stock;
import java.util.List;

/**
 * Created by xinyuan.zhang on 3/30/17.
 */
public class StockDaoImpl extends AbstractDao implements StockDao {

    public StockDaoImpl(Class clazz) {

        super(clazz);
    }

    public Stock findById(int id) {
        return (Stock)super.find((Integer)id);
    }

    public List<Stock> findAll() {

        return (List<Stock>) super.findAll();
    }

    public void add(Stock stock) {

        em.getTransaction().begin();
        em.persist(stock);
        em.getTransaction().commit();
    }

    public void delete(Stock stock) {

    }

    public void update(Stock stock) {

    }
}
