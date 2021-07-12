/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DataConnectionManager.DataConnection;
import Model.sanpham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DELL
 */
public class SanPhamDao {
    public List<sanpham> getNewReleasesSanPham() {
        DataConnection dc = new DataConnection();
        ResultSet rs = null;
        List<sanpham> list = new ArrayList<sanpham>();
        try
        {
            dc.getConnection();
            String strSQL = "SELECT * FROM `sanpham` WHERE 1 ORDER BY `sanpham`.`ngayramat` DESC LIMIT 6";
            rs =  dc.getDataTable(strSQL);
            while(rs.next())
            {
                sanpham sp = new sanpham();
                sp.setId(rs.getInt("id"));
                sp.setTensp(rs.getString("tensp"));
                sp.setHang(rs.getString("hang"));
                sp.setGia(rs.getDouble("gia"));
                sp.setNgayramat(rs.getString("ngayramat"));
                sp.setLuotthich(rs.getInt("luotthich"));
                sp.setLinkanh(rs.getString("linkanh"));
                list.add(sp);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            if (dc.con != null) {
                try {
                    rs.close();
                    dc.con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return list;
    }
    public List<sanpham> getMostExpensiveSanPham() {
        DataConnection dc = new DataConnection();
        ResultSet rs = null;
        List<sanpham> list = new ArrayList<sanpham>();
        try
        {
            dc.getConnection();
            String strSQL = "SELECT * FROM `sanpham` WHERE 1 ORDER BY `sanpham`.`gia` DESC LIMIT 6";
            rs =  dc.getDataTable(strSQL);
            while(rs.next())
            {
                sanpham sp = new sanpham();
                sp.setId(rs.getInt("id"));
                sp.setTensp(rs.getString("tensp"));
                sp.setHang(rs.getString("hang"));
                sp.setGia(rs.getDouble("gia"));
                sp.setNgayramat(rs.getString("ngayramat"));
                sp.setLuotthich(rs.getInt("luotthich"));
                sp.setLinkanh(rs.getString("linkanh"));
                list.add(sp);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            if (dc.con != null) {
                try {
                    rs.close();
                    dc.con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return list;
    }
    public List<sanpham> getBestRatedSanPham() {
        DataConnection dc = new DataConnection();
        ResultSet rs = null;
        List<sanpham> list = new ArrayList<sanpham>();
        try
        {
            dc.getConnection();
            String strSQL = "SELECT * FROM `sanpham` WHERE 1 ORDER BY `sanpham`.`luotthich` DESC LIMIT 6";
            rs =  dc.getDataTable(strSQL);
            while(rs.next())
            {
                sanpham sp = new sanpham();
                sp.setId(rs.getInt("id"));
                sp.setTensp(rs.getString("tensp"));
                sp.setHang(rs.getString("hang"));
                sp.setGia(rs.getDouble("gia"));
                sp.setNgayramat(rs.getString("ngayramat"));
                sp.setLuotthich(rs.getInt("luotthich"));
                sp.setLinkanh(rs.getString("linkanh"));
                list.add(sp);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally{
            if (dc.con != null) {
                try {
                    rs.close();
                    dc.con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return list;
    }
    public sanpham getSanPham(int id){
        sanpham sp = null;
        DataConnection dc = new DataConnection();
        ResultSet rs = null;
        try
        {
            dc.getConnection();
            String strSQL = "SELECT * FROM `sanpham` WHERE `id` ="+id;
            rs = dc.getDataTable(strSQL);
            if(rs.next()==true){
                sp = new sanpham();
                sp.setId(rs.getInt("id"));
                sp.setTensp(rs.getString("tensp"));
                sp.setHang(rs.getString("hang"));
                sp.setGia(rs.getDouble("gia"));
                sp.setNgayramat(rs.getString("ngayramat"));
                sp.setLuotthich(rs.getInt("luotthich"));
                sp.setLinkanh(rs.getString("linkanh"));
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if (dc.con != null) {
                try {
                    dc.con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return sp;
    }
}
