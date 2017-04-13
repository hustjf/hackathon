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
public class Cart implements Serializable {


    @Id
    private int id;
    private String name;
    private int count;
    private String type;
    private double price;


    public Cart() {
    }

    public Cart(int id, String name, int count, String type, double price) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.type = type;
        this.price = price;
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

}
