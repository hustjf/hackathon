package com.oracle.hackathon.dao;

import com.oracle.hackathon.entities.Stock;

import java.util.List;

/**
 * Created by xinyuan.zhang on 3/30/17.
 */
public interface StockDao {

    public Stock findById(int id);
    public List<Stock> findAll();
    public void add(Stock stock);
    public void delete(List<Stock> stocks);
    public void update(Stock stock);




}
