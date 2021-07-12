/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import DataConnectionManager.DataConnection;
import Model.taikhoan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class UserDao {
    public int dangKyUser(taikhoan tk){
        int result = 0;
        DataConnection dc = new DataConnection();
        try
        {
            
            dc.getConnection();
            String strSQL = "INSERT INTO `taikhoan` (`id`, `username`, `password`, `admin`) VALUES (NULL, ?, ?, ?)";
            PreparedStatement pre = (PreparedStatement) dc.con.prepareStatement(strSQL);
            pre.setString(1, tk.getUsername());
            //pre.setDate(3, java.sql.Date.valueOf(sp.getNgaySX()));
            pre.setString(2, tk.getPassword());
            pre.setInt(3, tk.getAdmin());
            
            
            dc.setPre(pre);
            result = dc.Update();
            
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
        return result;
    }
    public int dangNhapUser(taikhoan tk){
        int result = 0;
        DataConnection dc = new DataConnection();
        ResultSet rs = null;
        try
        {
            dc.getConnection();
            String strSQL = "SELECT * FROM `taikhoan` WHERE `username` LIKE '"+tk.getUsername()+"' AND `password` LIKE '"+tk.getPassword()+"'";
            rs = dc.getDataTable(strSQL);
            if(rs.next()==true){
                result=1;
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
        return result;
    }
}
