package com.oracle.hackathon.service;

import com.oracle.hackathon.dao.StocksDaoImpl;
import com.oracle.hackathon.entities.Stocks;

import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
public class StocksService {

    private StocksDaoImpl stockDao = new StocksDaoImpl(Stocks.class);;

    public List<Stocks> findAll() {
        return stockDao.findAll();
    }

    public Stocks findById(int id) {
        return stockDao.findById(id);
    }

    public List<Stocks> findByFields(String type, String supplier, double floorPrice, double ceilingPrice) {
        return stockDao.findByField(type,supplier,floorPrice,ceilingPrice);
    }

    public void addStock(Stocks stock) {
        stockDao.add(stock);
    }

    public void updateStock(Stocks stock) {
        stockDao.update(stock);
    }

    public void deleteStock(List<Stocks> stocks) {
        stockDao.delete(stocks);
    }

}
