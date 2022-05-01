/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Model.Account;
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
public class accountDAO {

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

    public void updatePassword(Account acc) {
        String sql = "UPDATE [dbo].[AccountHE151412]\n"
                + "   SET [password_account] = ?\n"
                + " WHERE [login_account] = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getPasswordAccount());
            ps.setString(2, acc.getLoginAccount());
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Account checkAccount(String account) {
        String sql = "SELECT *\n"
                + "  FROM [AccountHE151412] \n"
                + "  where login_account = ?";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, account);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account acc = Account.builder()
                        .id(rs.getInt(1))
                        .loginAccount(rs.getString(2))
                        .passwordAccount(rs.getString(3))
                        .role(rs.getString(4))
                        .build();
                return acc;
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM [AccountHE151412] ";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account acc = Account.builder()
                        .id(rs.getInt(1))
                        .loginAccount(rs.getString(2))
                        .passwordAccount(rs.getString(3))
                        .role(rs.getString(4))
                        .build();
                list.add(acc);
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        List<Account> listAccount = new accountDAO().getAllAccount();
        System.out.println(listAccount);
    }

    public void insert(Account accou) {
        String sql = "INSERT INTO [dbo].[AccountHE151412]\n"
                + "           ([login_account]\n"
                + "           ,[password_account]\n"
                + "           ,[rolePeople])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accou.getLoginAccount());
            ps.setString(2, accou.getPasswordAccount());
            ps.setString(3, accou.getRole());

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LevelCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[AccountHE151412]\n"
                + "      WHERE ID = ?";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getById(int id) {
        String sql = "SELECT * FROM [AccountHE151412] where ID = ? ";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Account acc = Account.builder()
                        .id(rs.getInt(1))
                        .loginAccount(rs.getString(2))
                        .passwordAccount(rs.getString(3))
                        .role(rs.getString(4))
                        .build();
                return acc;
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Account accou) {
        String sql = "UPDATE [dbo].[AccountHE151412]\n"
                + "   SET [login_account] = ?\n"
                + "      ,[password_account] = ?\n"
                + "      ,[rolePeople] = ?\n"
                + " WHERE id = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, accou.getPasswordAccount());
            ps.setString(2, accou.getRole());
            ps.setInt(3, accou.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LevelCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
