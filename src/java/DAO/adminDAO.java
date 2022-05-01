/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Model.Admin;
import Model.Student;
import Model.Teacher;
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
public class adminDAO {

    public Admin getById(int id) {
        String sql = "SELECT *\n"
                + "  FROM [dbo].[AdministratorHE151412] as ad inner join AccountHE151412 as  a\n"
                + "  on a.id = ad.loginId where ad.loginId = ?";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                Admin admin = Admin.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .code(rs.getString(3))
                        .gender(rs.getBoolean(4))
                        .phone(rs.getString(5))
                        .email(rs.getString(6))
                        .address(rs.getString(7))
                        .birthday(rs.getString(8))
                        .loginId(rs.getInt(9))
                        .build();
                return admin;
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        adminDAO dao = new adminDAO();
        Admin a = dao.getById(16);
        System.out.println(a);
    }

    public void update(Admin ad) {
        String sql = "UPDATE [AdministratorHE151412]\n"
                + "   SET [Fullname] = ?\n"
                + "      ,[code] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[State_City] = ?\n"
                + "      ,[Birthday] = ?"
                + " WHERE id = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, ad.getName());
            ps.setString(2, ad.getCode());
            ps.setBoolean(3, ad.isGender());
            ps.setString(4, ad.getPhone());
            ps.setString(5, ad.getEmail());
            ps.setString(6, ad.getAddress());
            ps.setString(7, ad.getBirthday());
            ps.setInt(8, ad.getId());
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Admin> getAllAdmin() {
        List<Admin> list = new ArrayList<>();
        String sql = "SELECT *\n"
                + "  FROM [AdministratorHE151412]";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                Admin admin = Admin.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .code(rs.getString(3))
                        .gender(rs.getBoolean(4))
                        .phone(rs.getString(5))
                        .email(rs.getString(6))
                        .address(rs.getString(7))
                        .birthday(rs.getString(8))
                        .loginId(rs.getInt(9))
                        .build();
                list.add(admin);
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
