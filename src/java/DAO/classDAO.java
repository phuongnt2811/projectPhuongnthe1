/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Model.Classes;
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
public class classDAO {

    public List<Classes> getAllClass() {
        List<Classes> list = new ArrayList<>();
        String sql = "select * \n"
                + "from classHE151412 inner join CourseHE151412 on classHE151412.course_id = CourseHE151412.id\n"
                + "inner join TeacherHE151412\n"
                + " on classHE151412.teacher_id = TeacherHE151412.id";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classes cla = Classes.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .startdate(rs.getString(3))
                        .endate(rs.getString(4))
                        .teacherId(rs.getInt(5))
                        .courseId(rs.getInt(6))
                        .teacherName(rs.getString(13))
                        .courseName(rs.getString(9))
                        .build();
                list.add(cla);
            }

        } catch (Exception ex) {
            Logger.getLogger(classDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(Classes classes) {
        String sql = "INSERT INTO [dbo].[classHE151412]\n"
                + "           ([name]\n"
                + "           ,[startDate]\n"
                + "           ,[endDate]\n"
                + "           ,[teacher_id]\n"
                + "           ,[course_id])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?)";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, classes.getName());
            ps.setString(2, classes.getStartdate());
            ps.setString(3, classes.getEndate());
            ps.setInt(4, classes.getTeacherId());
            ps.setInt(5, classes.getCourseId());
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(classDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Classes getById(int id) {
        String sql = "select * \n"
                + "from classHE151412 inner join CourseHE151412 on classHE151412.course_id = CourseHE151412.id\n"
                + "inner join TeacherHE151412\n"
                + " on classHE151412.teacher_id = TeacherHE151412.id where classHE151412.id = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Classes cla = Classes.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .startdate(rs.getString(3))
                        .endate(rs.getString(4))
                        .teacherId(rs.getInt(5))
                        .courseId(rs.getInt(6))
                        .teacherName(rs.getString(13))
                        .courseName(rs.getString(8))
                        .build();
                return cla;
            }

        } catch (Exception ex) {
            Logger.getLogger(classDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void update(Classes classes) {
        String sql = "UPDATE [dbo].[classHE151412]\n"
                + "   SET [name] = ?\n"
                + "      ,[startDate] = ?\n"
                + "      ,[endDate] = ?\n"
                + "      ,[teacher_id] = ?\n"
                + "      ,[course_id] = ?\n"
                + " WHERE id = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, classes.getName());
            ps.setString(2, classes.getStartdate());
            ps.setString(3, classes.getEndate());
            ps.setInt(4, classes.getTeacherId());
            ps.setInt(5, classes.getCourseId());
             ps.setInt(6, classes.getId());
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(classDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM classHE151412\n"
                + "      WHERE id = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(LevelCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public int getTotalClass() {
        String sql = "SELECT count(*) from [classHE151412]";
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

//    public static void main(String[] args) {
//        classDAO st = new classDAO();
//        int count = st.getTotalClass();
//        System.out.println(count);
//    }
   
}
