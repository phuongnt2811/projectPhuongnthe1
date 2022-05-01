/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Model.Account;
import Model.Admin;
import Model.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHUONG
 */
public class loginDAO {

    public Account checkLogin(String username, String password) {

        String sql = "SELECT *\n"
                + "  FROM [AccountHE151412] \n"
                + "  where login_account = ? and password_account = ?";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account account = Account.builder()
                        .id(rs.getInt(1))
                        .loginAccount(rs.getString(2))
                        .passwordAccount(rs.getString(3))
                        .role(rs.getString(4))
                        .build();
                return account;
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public Account checkExist(String uname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
