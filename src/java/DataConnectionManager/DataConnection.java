/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**
 *
 * @author DELL
 */
public class DataConnection {
    public Connection con = null;
    private PreparedStatement pre;
    public PreparedStatement getPre() {
        return pre;
    }

    public void setPre(PreparedStatement pre) {
        this.pre = pre;
    }
    public void getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Properties connectionProps = new Properties();
            connectionProps.put("user", "root");
            connectionProps.put("password", "");
            String ConnectionString  = "jdbc:mysql://localhost/web_bandienthoai";
                   
            this.con = DriverManager.getConnection(ConnectionString,
                    connectionProps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public ResultSet getDataTable(String strQuery){
        ResultSet rs = null;
        try{
           if (this.con!=null){
               Statement st = this.con.createStatement();
               rs=st.executeQuery(strQuery);
           }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }
    public int Update(){
        int result = 0;
        try {
            if (this.con != null) {
                result = this.getPre().executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
