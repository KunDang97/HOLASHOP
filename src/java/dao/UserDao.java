/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Connect.DBConnect;
import model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Nguyen Van Long
 */
public class UserDao {

    Connection conn = null;

    DBConnect dbConn = null;

    public UserDao(DBConnect dbconn) {
        conn = dbconn.con;
        this.dbConn = dbconn;
    }
   
    public User showUserProfile(String account) {
        try {
            String sql = "select * from [User] where UserAccount=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8));
                return u;
            }
        } catch (Exception e) {

        }
        return null;
    }
    public boolean changePass(String account, String password) {
        try {
            String sql = "  UPDATE [HappyProgramming].[dbo].[user]\n"
                    + "SET [password] = ? WHERE [account] =?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, account);
            ps.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
