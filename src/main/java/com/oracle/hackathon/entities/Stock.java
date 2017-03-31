package com.oracle.hackathon.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by xinyuan.zhang on 3/30/17.
 */
@Entity
@XmlRootElement
public class Stock implements Serializable {

    public Stock() {

    }

    public Stock(int materialsid){
        this.materialsid = materialsid;
    }

    /*public Stock(int materialsid, String matname, int currentstock, int totalstock, String type, int save) {
        this.materialsid = materialsid;
        this.matname = matname;
        this.currentstock = currentstock;
        this.totalstock = totalstock;
        this.type = type;
        this.save = save;
    }*/

    @Id
    private int materialsid;
    private String matname;
    private int currentstock;
    private int totalstock;
    private String type;
    private int save;
    private double price;
    private String suk;
    private String unit;
    private String supplier;

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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public int getMaterialsid() {
        return materialsid;
    }

    public void setMaterialsid(int materialsid) {
        this.materialsid = materialsid;
    }

    public String getMatname() {
        return matname;
    }

    public void setMatname(String matname) {
        this.matname = matname;
    }

    public int getCurrentstock() {
        return currentstock;
    }

    public void setCurrentstock(int currentstock) {
        this.currentstock = currentstock;
    }

    public int getTotalstock() {
        return totalstock;
    }

    public void setTotalstock(int totalstock) {
        this.totalstock = totalstock;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSave() {
        return save;
    }

    public void setSave(int save) {
        this.save = save;
    }




}
