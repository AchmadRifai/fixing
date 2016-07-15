/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ai
 */
public class Db {
    private java.sql.Connection c;
    private java.sql.Statement s;

    public Db() throws SQLException{
        try {
            com.mysql.jdbc.Driver.class.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Db.class.getName()).log(Level.SEVERE, null, ex);
        }c=DriverManager.getConnection("jdbc:mysql://localhost/toko", "root", "");
        s=c.createStatement();
    }

    public void close() throws SQLException{
        s.close();
        c.close();
    }

    public void masuk(String sql) throws SQLException{
        s.executeUpdate(sql);
    }

    public java.sql.ResultSet keluar(String sql) throws SQLException{
        return s.executeQuery(sql);
    }

    public java.sql.PreparedStatement getPS(String sql) throws SQLException{
        return c.prepareStatement(sql);
    }
}