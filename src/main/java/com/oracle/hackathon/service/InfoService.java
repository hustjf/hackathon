package com.oracle.hackathon.service;

import com.oracle.hackathon.dao.InfoDaoImpl;
import com.oracle.hackathon.entities.Info;

import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
public class InfoService {

    private InfoDaoImpl infoDao = new InfoDaoImpl(Info.class);;

    public List<Info> findAll() {
        return infoDao.findAll();
    }

    public Info findById(int id) {
        return infoDao.findById(id);
    }

    public void addInfo(Info info) {
        infoDao.add(info);
    }

    public void updateInfo(Info info) {
        infoDao.update(info);
    }

    public void deleteInfo(List<Info> infos) {
        infoDao.delete(infos);
    }

    public Info getById(int id) {
        return infoDao.findById(id);
    }
}
