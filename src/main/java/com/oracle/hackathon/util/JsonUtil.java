package com.oracle.hackathon.util;

import com.oracle.hackathon.entities.Stocks;
import com.oracle.hackathon.service.StocksService;

import java.io.*;
import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
public class JsonUtil {

    private static StocksService stocksService = new StocksService();


    public static void main(String[] args) {

        JsonUtil jsonUtil = new JsonUtil();
        //jsonUtil.deleteFile(jsonUtil.getFilePath());
        //jsonUtil.createFile(jsonUtil.getFilePath());
        //jsonUtil.listToJson(stocksService.findAll());
        jsonUtil.writeFile();
    }

    public String getFilePath() {
        return "/Users/xinyuan.zhang/workspace/hackathonFinal/hackathon/src/main/webapp/productData.json";
    }


    public void createFile(String filePath) {
        File file = new File(getFilePath());
        try {

            if(!file.exists()) {
                file.createNewFile();
            } else {
                deleteFile(filePath);
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String listToJson(List<Stocks> stocks) {

        List<Stocks> list = stocksService.findAll();
        net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(list);

        System.out.println(json.toString());
        return "";
    }

    public void writeFile() {

        String filepath = getFilePath();
        String string = listToJson(stocksService.findAll());
        File file=new File(filepath);
        createFile(filepath);
        FileOutputStream out= null;
        try {
            out = new FileOutputStream(file,true);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        StringBuffer sb=new StringBuffer();
        sb.append(string);
        try {
            out.write(sb.toString().getBytes("utf-8"));
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteFile(String filePath) {
        File file = new File(filePath);
        if(file.exists()) {
            file.delete();
        }


    }

    public void getDataFromDb() {




    }


}
