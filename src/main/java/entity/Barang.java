/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.SQLException;

/**
 *
 * @author ai
 */
public class Barang {
    private String kode,nm,satuan;
    private float stok;
    private long hrg;
    private boolean deleted;

    public Barang(String kode,util.Db d) throws SQLException {
        this.kode = kode;
        java.sql.PreparedStatement ps=d.getPS("select*from barang where kode=?");
        ps.setString(1, kode);
        java.sql.ResultSet rs=ps.executeQuery();
        if(rs.next()){
            nm=rs.getString("nm");
            satuan=rs.getString("satuan");
            stok=rs.getFloat("stok");
            hrg=rs.getLong("hrg");
            deleted=rs.getBoolean("deleted");
        }rs.close();
        ps.close();
    }

    public Barang(String kode, String nm, String satuan, float stok, long hrg) {
        this.kode = kode;
        this.nm = nm;
        this.satuan = satuan;
        this.stok = stok;
        this.hrg = hrg;
        deleted=false;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNm() {
        return nm;
    }

    public void setNm(String nm) {
        this.nm = nm;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public float getStok() {
        return stok;
    }

    public void setStok(float stok) {
        this.stok = stok;
    }

    public long getHrg() {
        return hrg;
    }

    public void setHrg(long hrg) {
        this.hrg = hrg;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}