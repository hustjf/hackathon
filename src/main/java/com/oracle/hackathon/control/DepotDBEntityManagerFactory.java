package com.oracle.hackathon.control;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by xinyuan.zhang on 3/31/17.
 */
public class DepotDBEntityManagerFactory {


    protected static EntityManagerFactory emf;

    static {
        emf = Persistence.createEntityManagerFactory("depotdb");
    }


}

