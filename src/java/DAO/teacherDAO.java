/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
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
public class teacherDAO {

    public List<Teacher> getAllTeacher() {
        List<Teacher> list = new ArrayList<>();
        String sql = "SELECT * FROM TeacherHE151412";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Teacher teacher = Teacher.builder()
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
                list.add(teacher);
            }
        } catch (Exception ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(Teacher teacher) {

        String sql = "INSERT INTO [dbo].[TeacherHE151412]\n"
                + "           ([Fullname]\n"
                + "           ,[code]\n"
                + "           ,[Gender]\n"
                + "           ,[Phone]\n"
                + "           ,[Email]\n"
                + "           ,[Adress]\n"
                + "           ,[Birthday]\n"
                + "           ,[loginId])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";

        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getCode());
            ps.setBoolean(3, teacher.isGender());
            ps.setString(4, teacher.getPhone());
            ps.setString(5, teacher.getEmail());
            ps.setString(6, teacher.getAddress());
            ps.setString(7, teacher.getBirthday());
            ps.setInt(8, teacher.getLoginId());

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM TeacherHE151412\n"
                + "      WHERE id =?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Teacher getById(int id) {
        String sql = "SELECT * FROM TeacherHE151412 where id  = ?";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Teacher teacher = Teacher.builder()
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
                return teacher;
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Teacher teacher) {
        try {
            String sql = "UPDATE [dbo].[TeacherHE151412]\n"
                    + "   SET [Fullname] = ?\n"
                    + "      ,[code] = ?\n"
                    + "      ,[Gender] = ?\n"
                    + "      ,[Phone] = ?\n"
                    + "      ,[Email] = ?\n"
                    + "      ,[Adress] = ?\n"
                    + "      ,[Birthday] = ?\n"
                    + "      ,[loginId] = ?\n"
                    + " WHERE id = ?";
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getCode());
            ps.setBoolean(3, teacher.isGender());
            ps.setString(4, teacher.getPhone());
            ps.setString(5, teacher.getEmail());
            ps.setString(6, teacher.getAddress());
            ps.setString(7, teacher.getBirthday());
            ps.setInt(8, teacher.getLoginId());
            ps.setInt(9, teacher.getId());
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(teacherDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTotalTeacher() {
        String sql = "SELECT count(*) from [TeacherHE151412]";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);

            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        teacherDAO teacherdao = new teacherDAO();
        int count = teacherdao.getTotalTeacher();
        System.out.println(count);
    }

    public Teacher getByIdT(int id) {
        String sql = "SELECT * FROM TeacherHE151412 as tea inner join AccountHE151412 as  a on a.id = tea.loginId where tea.loginId = ?";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                Teacher teacher = Teacher.builder()
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
                return teacher;
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
