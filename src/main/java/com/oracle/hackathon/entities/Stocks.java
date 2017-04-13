package com.oracle.hackathon.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
@Entity
@XmlRootElement
public class Stocks implements Serializable {


    @Id
    private int id;
    private String name;
    private int count;
    private String type;
    private double price;
    private String suk;
    private String supplier;

    public Stocks() {
    }

    public Stocks(int id, String name, int count, String type, double price, String suk, String supplier) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.type = type;
        this.price = price;
        this.suk = suk;
        this.supplier = supplier;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSuk() {
        return suk;
    }

    public void setSuk(String suk) {
        this.suk = suk;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
