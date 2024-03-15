package com.example.projetgreta2.dao;


import java.sql.*;
public class Connexion {

    private final String url = "jdbc:mysql://localhost:3306/account";
    private final String user = "root";
    private final String pswd = "root";

    public Connection conn;

    public Connexion() throws ClassNotFoundException,SQLException{
        super();
        Class.forName("com.mysql.jdbc.Driver");
        try {
            this.conn = DriverManager.getConnection(url, user,pswd);
        }
        catch ( SQLException e) {
            e.printStackTrace();
            System.out.println("problèmee");
        }
    }


}
