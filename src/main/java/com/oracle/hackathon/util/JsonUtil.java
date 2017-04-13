package com.oracle.hackathon.util;

import com.oracle.hackathon.entities.Cart;
import com.oracle.hackathon.entities.Stocks;
import com.oracle.hackathon.service.StocksService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;
import java.io.*;
import java.util.List;

/**
 * Created by xinyuan.zhang on 4/13/17.
 */
@Path("/jsonutil")
public class JsonUtil {

    private static StocksService stocksService = new StocksService();


    public static void main(String[] args) {

        JsonUtil jsonUtil = new JsonUtil();
        //jsonUtil.deleteFile(jsonUtil.getFilePath());
        //jsonUtil.createFile(jsonUtil.getFilePath());
        //jsonUtil.listToJson(stocksService.findAll());
        //jsonUtil.writeFile();
    }

    public String getFilePath() {
        return "productData.json";
    }



    public String listToJson(List<Stocks> stocks) {

        List<Stocks> list = stocksService.findAll();
        net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(list);
        return json.toString();
    }

    @GET
    @Produces("text/plain")
    public Response writeFile() {

        String filepath = getFilePath();
        String string = listToJson(stocksService.findAll());
        File file=new File(filepath);
        byte bt[] = new byte[1024];
        bt = string.getBytes();
        try {
            FileOutputStream in = new FileOutputStream(file);
            in.write(bt, 0, bt.length);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            GenericEntity<List<Stocks>> entity = new GenericEntity<List<Stocks>>(null){};
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }


    }

}
