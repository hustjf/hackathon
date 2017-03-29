package com.hackathon.procurement;

import java.sql.*;

/**
 * Created by alex on 17/3/28.
 */
public class DBHelper {
    private Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection connection = null;
        String url="jdbc:mysql://alexjiang.net:3306/hackathon";
        try {
            connection = DriverManager.getConnection(url,"hackathon","hackathon");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }


    public static void main(String[] args) throws SQLException {
        DBHelper dbHelper = new DBHelper();
        Connection connection = dbHelper.getConnection();
        String sql = "select * from hackathon";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()){
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
