/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author chien
 */
public class SQLServerProvider {
    private Connection connection;
    
    public void open() {
        String strServer = "LAPTOP-JC36CK9N\\CHIENPHUNG";
        String strDatabase = "mydatabase"; 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); String connectionURL = "jdbc:sqlserver://" + strServer
            + ":1433; databaseName=" + strDatabase
            + "; user = sa; password = 1234abcd" + ";encrypt=false"; //+ ";integratedSecurity = true";
            connection = DriverManager.getConnection (connectionURL);
//            System.out.println("TT");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void close() {
        try{
            this.connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ResultSet executeQuery (String sql) { 
        ResultSet rs = null;
        try{
            Statement sm = connection.createStatement(); 
            rs = sm.executeQuery (sql);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return rs;
    }
    
    public int executeUpdate (String sql) {
        int n = -1;
        try{
            Statement sm = connection.createStatement (); 
            n = sm.executeUpdate (sql);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return n;
    }


}
