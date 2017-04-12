package com.oracle.hackathon.service;

import com.oracle.hackathon.dao.StockDao;
import com.oracle.hackathon.dao.StockDaoImpl;
import com.oracle.hackathon.entities.Stock;

import java.util.List;

/**
 * Created by xinyuan.zhang on 3/30/17.
 */


public class StockService {

    private StockDao stockDao = new StockDaoImpl(Stock.class);;


    public List<Stock> findAll() {
        return stockDao.findAll();
    }



    public Stock findById(int id) {
        Stock s = stockDao.findById(id);
        return s;
    }


    public void addStock(Stock stock) {
        stockDao.add(stock);
    }

    public void updateStock(Stock stock) {
        stockDao.update(stock);
    }

    public void deleteStock(List<Stock> stocks) {
        stockDao.delete(stocks);
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
