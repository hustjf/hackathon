package com.oracle.hackathon.service;

import com.oracle.hackathon.dao.StockDaoImpl;
import com.oracle.hackathon.entities.Stock;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.util.List;

import com.oracle.hackathon.dao.StockDao;

/**
 * Created by xinyuan.zhang on 3/30/17.
 */


public class StockService {

    private StockDao stockDao;


    protected EntityManager em;


    public StockService(EntityManager em) {
        this.em = em;
        stockDao = new StockDaoImpl(Stock.class,em);
    }

    public List<Stock> findAll() {
        return stockDao.findAll();
    }



    public Stock findById(int id) {
        Stock s = stockDao.findById(id);
        return s;
    }


    /*public static void main(String[] args) {
        StockService s = new StockService(emf.createEntityManager());
        System.out.println(s.findAll().size());
    }*/





    /*public Stock createStock(int materialsid, String matname, int currentstock, int totalstock, String type, int save) {

        Stock stock = new Stock(materialsid);
        stock.setMatname(matname);
        stock.setCurrentstock(currentstock);
        stock.setTotalstock(totalstock);
        stock.setType(type);
        stock.setSave(save);
        em.persist(stock);
        return stock;
    }

    public Collection<Stock> findAllStocks() {
        Query query = em.createQuery("SELECT s FROM Stock s");
        return (Collection<Stock>) query.getResultList();
    }*/


}
