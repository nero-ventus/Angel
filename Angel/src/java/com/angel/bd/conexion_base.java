package com.angel.bd;
import java.sql.Connection;
import java.sql.DriverManager;
public class conexion_base {
    private Connection conex;
    public conexion_base() {
        String server = "localhost";
        String base= "angel";
        String user= "root";
        String pswd = "n0m3l0";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conex=DriverManager.getConnection("jdbc:mysql://"+server+"/"+base+"?useSSL=false",user,pswd);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection getConex() {
        return conex;
    }
    
}