/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dao;

import entity.Barang;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ai
 */
public class DAOBarang implements DAO<Barang>{
    private util.Db d;

    public DAOBarang(util.Db db) {
        d=db;
    }

    @Override
    public void insert(Barang v) throws SQLException {
        PreparedStatement ps=d.getPS("insert into barang values(?,?,?,?,?,?)");
        ps.setString(1, v.getKode());
        ps.setString(2, v.getNm());
        ps.setString(3, v.getSatuan());
        ps.setLong(4, v.getHrg());
        ps.setFloat(5, v.getStok());
        ps.setBoolean(6, v.isDeleted());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Barang w) throws SQLException {
        PreparedStatement ps=d.getPS("update barang set deleted=? where kode=?");
        ps.setBoolean(1, true);
        ps.setString(2, w.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public void update(Barang a, Barang b) throws SQLException {
        PreparedStatement ps=d.getPS("update barang set nm=?,satuan=?,hrg=?,stok=? where kode=?");
        ps.setString(1, b.getNm());
        ps.setString(2, b.getSatuan());
        ps.setLong(3, b.getHrg());
        ps.setFloat(4, b.getStok());
        ps.setString(5, a.getKode());
        ps.execute();
        ps.close();
    }

    @Override
    public ArrayList<Barang> getData() throws SQLException {
        ArrayList<Barang>a=new ArrayList<Barang>();
        java.sql.ResultSet rs=d.keluar("select kode from barang where not deleted");
        while(rs.next())a.add(new entity.Barang(rs.getString("kode"), d));
        rs.close();
        return a;
    }
}