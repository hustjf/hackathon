package com.hackathon.procurement;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by alex on 17/3/28.
 */
public class DBHelper {

    private static String driverName;
    private static String url;
    private static String user;
    private static String password;

    private static Connection getConnection() {

        try {
            InputStream in = DBHelper.class.getClassLoader().getResourceAsStream("dbinfo.properties");
            Properties properties = new Properties();
            properties.load(in);
            driverName = properties.getProperty("driverName");
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            Class.forName(driverName);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        //Todo when final deploy on the server, url should change to localhost
        // String url="jdbc:mysql://alexjiang.net:3306/hackathon";
        //String url="jdbc:mysql://localhost:3306/hackathon";
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public static List<Item> getData() throws SQLException {
        List<Item> itemList = new ArrayList<Item>();
        Connection connection = getConnection();
        String sql = "select * from items";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            String SKU = rs.getString(1);
            double price = rs.getDouble(2);
            String Catalog = rs.getString(3);
            int Unit = rs.getInt(4);
            String Supplier = rs.getString(5);
            Item item = new Item(SKU, price, Catalog, Unit, Supplier);
            itemList.add(item);
        }
        return itemList;
    }

    public static boolean addData(Item item) throws SQLException {
        Connection connection = getConnection();
        String sql = "insert into items(SKU, Price, Catalog, Unit, Supplier) values(?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, item.getSku());
        ps.setDouble(2, item.getPrice());
        ps.setString(3, item.getCatalog());
        ps.setInt(4, item.getUnit());
        ps.setString(5, item.getSupplier());
        int result = ps.executeUpdate();
        return result > 0;
    }

    public static void main(String[] args) throws SQLException {
        Connection connection = getConnection();
        String sql = "select * from items";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.print(rs.getString(1) + "\t");
            System.out.print(rs.getDouble(2) + "\t");
            System.out.print(rs.getString(3) + "\t");
            System.out.print(rs.getInt(4) + "\t");
            System.out.print(rs.getString(5) + "\t");
            System.out.println();
        }
        rs.close();
        stmt.close();
        connection.close();
    }
}
