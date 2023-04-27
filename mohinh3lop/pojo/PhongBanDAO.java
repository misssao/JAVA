/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojo;

import java.sql.ResultSet;

import java.util.ArrayList;

/**
 *
 * @author chien
 */
public class PhongBanDAO {
    public static ArrayList<PhongBan> layDanhSachPhongBan () { 
        ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
        try{
            String sql = "SELECT * FROM PhongBan";
            SQLServerProvider provider = new SQLServerProvider(); 
            provider.open();
            ResultSet rs = provider.executeQuery (sql);
            while (rs.next()) {
                PhongBan pb = new PhongBan ();
                pb.setMaPHG (rs.getInt("MaPHG"));
                pb.setTenPHG (rs.getString("TenPHG")); 
                dsPB.add (pb);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsPB;
    }
    
    public static ArrayList<PhongBan> timKiemPhongBanTheoTen (String tenPB) { 
        ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
        try{
            String sql = "SELECT * FROM PhongBan WHERE TenPHG LIKE '%" + tenPB + "%'"; 
            SQLServerProvider provider = new SQLServerProvider();
            ResultSet rs = provider.executeQuery(sql);
            while (rs.next()) {
                PhongBan pb = new PhongBan ();
                pb.setMaPHG (rs.getInt("MaPHG"));
                pb.setTenPHG (rs.getString ("TenPHG")); 
                dsPB.add (pb);
            }
            provider.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsPB;
    }
    
    public static boolean themPhongBan (PhongBan pb) {
        boolean kq = false;
        String sql = String.format("INSERT INTO PhongBan (TenPHG) VALUES ('%s');", pb.getTenPHG()); 
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate(sql);
        if (n==1) {
            kq = true;
        }
        provider.close();
        return kq;
    }
    
    public static boolean xoaPhongBan (int maPB) {
        boolean kq = false;
        String sql = String.format("DELETE FROM PhongBan WHERE MaPHG=%d", maPB); 
        SQLServerProvider provider = new SQLServerProvider();
        provider.open();
        int n = provider.executeUpdate (sql);
        if (n == 1) {
            kq = true;
        }
        provider.close();
        return kq;
    }
    
    public static boolean capNhatPhongBan (PhongBan pb) { 
        boolean kq = false;
        String sql = String.format("UPDATE PHONGBAN SET TENPHG = '%s'" + "WHERE MaPHG = %d", pb.getTenPHG(), pb.getMaPHG()); 
        SQLServerProvider provider = new SQLServerProvider (); 
        provider.open();
        int n = provider.executeUpdate (sql);
        if (n == 1) {
            kq = true;
        }
        provider.close();
        return kq;
    }

}
