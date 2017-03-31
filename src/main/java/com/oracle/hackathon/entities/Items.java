package com.oracle.hackathon.entities;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Alex on 2017/3/27.
 */
@XmlRootElement
/*@Entity
@Table(name = "items")*/
public class Items {
    private String sku;
    private double price;
    private String catalog;
    private int unit;
    private String supplier;

    public Items() {}

    public Items(String sku, double price, String catalog, int unit, String supplier) {
        this.sku = sku;
        this.price = price;
        this.catalog = catalog;
        this.unit = unit;
        this.supplier = supplier;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
