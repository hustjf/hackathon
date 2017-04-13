package com.oracle.hackathon.control;

import com.oracle.hackathon.entities.Stocks;
import com.oracle.hackathon.service.StocksService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        return "/productData.json";
    }



    public String listToJson(List<Stocks> stocks) {

        List<Stocks> list = stocksService.findAll();
        net.sf.json.JSONArray json = net.sf.json.JSONArray.fromObject(list);
        return json.toString();
    }

    @GET
    @Produces("text/plain")
    public Response writeFile() {
        try {
            String filepath = getFilePath();
            File directory = new File("");
            String p = directory.getAbsolutePath();
            String string = listToJson(stocksService.findAll());
            File file=new File(filepath);
            byte bt[] = new byte[1024];
            bt = string.getBytes();
            FileOutputStream in = new FileOutputStream(file);
            in.write(bt, 0, bt.length);
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            return Response.status(Response.Status.OK).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }


    }

}
