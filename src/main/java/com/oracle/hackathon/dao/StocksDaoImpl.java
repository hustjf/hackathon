package com.oracle.hackathon.dao;

import com.oracle.hackathon.entities.Stocks;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
public class StocksDaoImpl extends AbstractDao  {

    public StocksDaoImpl(Class clazz) {

        super(clazz);
    }

    public Stocks findById(int id) {
        return (Stocks)super.find((Integer)id);
    }

    public List<Stocks> findAll() {

        return (List<Stocks>) super.findAll();
    }

    public void add(Stocks stock) {

        em.getTransaction().begin();
        em.persist(stock);
        em.getTransaction().commit();
    }

    public void delete(List<Stocks> stocks) {
        em.getTransaction().begin();
        for (Stocks stock : stocks) {
            em.remove(em.contains(stock) ? stock : em.merge(stock));
        }
        em.getTransaction().commit();
    }

    public void update(Stocks stock) {
        em.getTransaction().begin();
        em.merge(stock);
        em.getTransaction().commit();
    }

    public List<Stocks> findByField(String type, String supplier, double floorPrice, double ceilingPrice) {
        Query query = null;

        StringBuilder sql = new StringBuilder("select * from  Stocks s where 1=1 ");

        if(type!=null&&""!=type){
            sql.append("and type =:s1 ");
        }
        if(supplier!=null&&""!=supplier){
            sql.append("and supplier =:s2 ");
        }

        if(floorPrice !=-1) {
            sql.append("and price >=:s3 ");
        }

        if(ceilingPrice !=-1) {
            sql.append("and price <=:s4 ");
        }

        query = em.createNativeQuery(sql.toString(),Stocks.class);

        if(type!=null&&""!=type){
            query.setParameter("s1", type);
        }
        if(supplier!=null&&""!=supplier){
            query.setParameter("s2", supplier);
        }

        if(floorPrice !=-1) {
            query.setParameter("s3", floorPrice);
        }

        if(ceilingPrice !=-1) {
            query.setParameter("s4",ceilingPrice);
        }
        System.out.println("查询语句："+sql.toString());
        return query.getResultList();
    }

    public List<Stocks> findByInput(String input) {
        Query query = null;
        List<Stocks> stocks = null;

        StringBuilder sql = new StringBuilder("select * from  Stocks s where ");
        sql.append("type like:s1 ");
        query = em.createNativeQuery(sql.toString(),Stocks.class);
        query.setParameter("s1", "%"+input+"%");
        stocks = query.getResultList();

        if(stocks !=null)
            return stocks;

        sql = new StringBuilder("select * from  Stocks s where ");
        sql.append("supplier like:s1 ");
        query = em.createNativeQuery(sql.toString(),Stocks.class);
        query.setParameter("s1", "%"+input+"%");
        stocks = query.getResultList();

        if(stocks !=null)
            return stocks;


        sql = new StringBuilder("select * from  Stocks s where ");
        sql.append("name like:s1 ");
        query = em.createNativeQuery(sql.toString(),Stocks.class);
        query.setParameter("s1", "%"+input+"%");
        stocks = query.getResultList();

        if(stocks !=null)
            return stocks;


        sql = new StringBuilder("select * from  Stocks s where ");
        sql.append("suk like:s1 ");
        query = em.createNativeQuery(sql.toString(),Stocks.class);
        query.setParameter("s1", "%"+input+"%");
        stocks = query.getResultList();

        if(stocks !=null)
            return stocks;

        return null;


    }

    public static void main(String[] args) {
        StocksDaoImpl s = new StocksDaoImpl(Stocks.class);
       /* List<Stocks> list = s.findByField("Computer","Dell",-1,-1);
        for(Stocks stock:list){
            System.out.println(stock.getName());
        }

        list = s.findByField("","Dell",100,5200);
        for(Stocks stock:list){
            System.out.println(stock.getName());
        }*/

        for(Stocks stock:s.findByInput("computer")){
            System.out.println(stock.getName());
        }

    }

}