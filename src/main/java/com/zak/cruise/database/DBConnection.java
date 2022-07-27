package com.zak.cruise.database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
//    public static void main(String[] args) {
//        DBConnection connection = new DBConnection();
//        connection.createConnection();
//    }
    public DBConnection dbConnection(){
        DBConnection connection = new DBConnection();
        connection.createConnection();
        return connection;
    }

    void createConnection(){
        try {
            //connect to database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Cruise", "root", "matiwariacik"
            );
            System.out.println("connected!:)");
        }catch (ClassNotFoundException e){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null,e);
        }
        catch(SQLException e){
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null,e);
            e.printStackTrace();
        }
    }
}
