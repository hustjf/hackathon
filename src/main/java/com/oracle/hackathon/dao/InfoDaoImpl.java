package com.oracle.hackathon.dao;

import com.oracle.hackathon.entities.Info;

import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
public class InfoDaoImpl extends AbstractDao {

    public InfoDaoImpl(Class clazz) {

        super(clazz);
    }

    public Info findById(int id) {
        return (Info)super.find((Integer)id);
    }

    public List<Info> findAll() {

        return (List<Info>) super.findAll();
    }

    public void add(Info info) {

        em.getTransaction().begin();
        em.persist(info);
        em.getTransaction().commit();
    }

    public void delete(List<Info> infos) {
        em.getTransaction().begin();
        for (Info info : infos) {
            em.remove(em.contains(info) ? info : em.merge(info));
        }
        em.getTransaction().commit();
    }

    public void update(Info info) {
        em.getTransaction().begin();
        em.merge(info);
        em.getTransaction().commit();
    }
}
