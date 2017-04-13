package com.oracle.hackathon.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */


@Entity
@XmlRootElement
public class Orders implements Serializable {


    @Id
    private int id;
    private String name;
    private int count;
    private double price;
    private Date time;
    private String address;
    private int orderid;

    public Orders() {
    }

    public Orders(int id, String name, int count, double price, Date time, String address, int orderid) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.time = time;
        this.address = address;
        this.orderid = orderid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
}
