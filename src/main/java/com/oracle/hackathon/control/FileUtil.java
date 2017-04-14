package com.oracle.hackathon.control;

import com.oracle.hackathon.entities.Stocks;

import java.util.List;

/**
 * Created by xinyuan.zhang on 4/14/17.
 */
public class FileUtil {

    public String getFilePath() {
        String t=Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String[] strs=t.split("/");
        StringBuilder path=new StringBuilder("");
        for(String s:strs) {
            if(s.equals("WEB-INF")) {
                break;
            }
            path.append(s);
            path.append("/");
        }
        return path.toString()+"productData.json";
    }


    public String stockListToJson(List<Stocks> stocks) {

        net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(stocks);
        return json.toString();
    }
}
