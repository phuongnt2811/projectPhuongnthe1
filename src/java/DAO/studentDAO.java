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
public class studentDAO {

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM StudentHE151412";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = Student.builder()
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

                list.add(student);
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public void insert(Student student) {
        String sql = "INSERT INTO [dbo].[StudentHE151412]\n"
                + "           ([Fullname]\n"
                + "           ,[code]\n"
                + "           ,[Gender]\n"
                + "           ,[Phone]\n"
                + "           ,[Email]\n"
                + "           ,[State_City]\n"
                + "           ,[Birthday]\n"
                + "           ,[loginId])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ? ,?,?)";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getCode());
            ps.setBoolean(3, student.isGender());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getAddress());
            ps.setString(7, student.getBirthday());
            ps.setInt(8, student.getLoginId());
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM StudentHE151412\n"
                + "      WHERE id = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student getById(int id) {
        String sql = "SELECT * FROM StudentHE151412 where id = ?";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                Student student = Student.builder()
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
                return student;
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(Student student) {
        String sql = "UPDATE [dbo].[StudentHE151412]\n"
                + "   SET [Fullname] = ?\n"
                + "      ,[code] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[State_City] = ?\n"
                + "      ,[Birthday] = ?\n"
                + "      ,[loginId] = ?\n"
                + " WHERE ID = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getCode());
            ps.setBoolean(3, student.isGender());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getEmail());
            ps.setString(6, student.getAddress());
            ps.setString(7, student.getBirthday());
            ps.setInt(8, student.getLoginId());
            ps.setInt(9, student.getId());
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTotalStudent() {
        String sql = "SELECT count(*) from [StudentHE151412]";
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

    public List<Student> searchByName(String txtsearch) {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT *\n"
                + "  FROM [StudentHE151412]  where Fullname like '%?%'";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + txtsearch + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = Student.builder()
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
                list.add(student);
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public static void main(String[] args) {
//        studentDAO st = new studentDAO();
//        int count = st.getTotalStudent();
//        System.out.println(count);
//        studentDAO st = new studentDAO();
//        List<Student> a = st.Search("ph");
//        System.out.println(a);
        studentDAO st = new studentDAO();
        List<Student> a = st.getAllStudents();
        System.out.println(a);
    }

    public List<Student> Search(String search) {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM [StudentHE151412]  where Fullname like ? or code like ?  or [Phone]  like ?  or [Email] like ?  or [State_City] like ?  or [Birthday] like ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");
            ps.setString(2, "%" + search + "%");
            ps.setString(3, "%" + search + "%");
            ps.setString(4, "%" + search + "%");
            ps.setString(5, "%" + search + "%");
            ps.setString(6, "%" + search + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = Student.builder()
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
                list.add(student);
            }

        } catch (Exception e) {
        }
        return list;
    }

    public List<Student> getpage(int index) {
        List<Student> list = new ArrayList<>();
        String sql = "select * from ( select  ROW_NUMBER() OVER(ORDER BY id) as [rownumber] ,* from StudentHE151412 )as TBL\n"
                + " where [rownumber] between ? and ?\n"
                + "  order by ID";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 5 + 1);
            ps.setInt(2, index * 5);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = Student.builder()
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
                list.add(student);

            }

        } catch (Exception e) {
        }
        return list;
    }

    public Student getByIdA(int id) {
        String sql = "SELECT * FROM StudentHE151412 as st inner join AccountHE151412 as  a on a.id = st.loginId where st.loginId =? ";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Student student = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                Student student = Student.builder()
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
                return student;
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
