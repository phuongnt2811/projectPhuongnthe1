/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
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
public class courseDAO {

    public List<Course> getAllCourse() {
        List<Course> list = new ArrayList<>();
        String sql = "select * from CourseHE151412 inner join levelHE151412\n"
                + "on CourseHE151412.level_id = levelHE151412.id";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course course = Course.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(3))
                        .lesson(rs.getInt(2))
                        .money(rs.getFloat(4))
                        .levelId(rs.getInt(5))
                        .levelName(rs.getString(7))
                        .build();

                list.add(course);
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;

    }

    public static void main(String[] args) {
        courseDAO coursedao = new courseDAO();
        List<Course> list = coursedao.getAllCourse();

        for (Course course : list) {
            System.out.println(list);
        }
    }

    public void insert(Course course) {
        String sql = "INSERT INTO [dbo].[CourseHE151412]\n"
                + "           ([name]\n"
                + "           ,[lessons]\n"
                + "           ,[prize]\n"
                + "           ,[level_id])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, course.getName());
            ps.setInt(2, course.getLesson());
            ps.setFloat(3, course.getMoney());
            ps.setInt(4, course.getLevelId());

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LevelCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Course getById(int id) {
        String sql = "select * from CourseHE151412 inner join levelHE151412 \n"
                + "               on CourseHE151412.level_id = levelHE151412.id \n"
                + "			   where CourseHE151412.id = ?";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Course course = Course.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .lesson(rs.getInt(3))
                        .money(rs.getFloat(4))
                        .levelId(rs.getInt(5))
                        .levelName(rs.getString(7))
                        .build();
                return course;
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void update(Course course) {

        String sql = "UPDATE [dbo].[CourseHE151412]\n"
                + "   SET [name] = ?\n"
                + "      ,[lessons] = ?\n"
                + "      ,[prize] = ?\n"
                + "      ,[level_id] = ?\n"
                + " WHERE id = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, course.getName());
            ps.setInt(2, course.getLesson());
            ps.setFloat(3, course.getMoney());
            ps.setInt(4, course.getLevelId());
            ps.setInt(5, course.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LevelCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[CourseHE151412]\n"
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

    public int getTotalCourse() {
        String sql = "SELECT count(*) from [CourseHE151412]";
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

}
