/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Model.Classes;
import Model.Mark;
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
public class markDAO {

    public List<Mark> getAllMark() {
        List<Mark> list = new ArrayList<>();
        String sql = "SELECT * FROM [markHE151412] inner join classHE151412 on markHE151412.class_id = classHE151412.id \n"
                + "inner join TeacherHE151412 on markHE151412.Teacher_id = TeacherHE151412.Id \n"
                + "inner join StudentHE151412 on StudentHE151412.ID = markHE151412.Student_id";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Mark mark = Mark.builder()
                        .id(rs.getInt(1))
                        .classId(rs.getInt(4))
                        .className(rs.getString(10))
                        .teacherId(rs.getInt(2))
                        .teacherName(rs.getString(16))
                        .studentId(rs.getInt(3))
                        .studentName(rs.getString(25))
                        .listening(rs.getFloat(5))
                        .writting(rs.getFloat(6))
                        .reading(rs.getFloat(7))
                        .speaking(rs.getFloat(8))
                        .build();
                list.add(mark);
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public float getreading(int id) {
        String sql = "select Teacher_id, Student_id, class_id, listening from markHE151412\n"
                + "where id = ?";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getFloat(4);
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public static void main(String[] args) {
        markDAO st = new markDAO();
        float count = st.getreading(1);
        System.out.println(count);
    }

    public List<Mark> getAllMark(int classId) {
        List<Mark> list = new ArrayList<>();
        String sql = "SELECT * FROM [markHE151412] inner join classHE151412 on markHE151412.class_id = classHE151412.id\n"
                + "inner join TeacherHE151412 on markHE151412.Teacher_id = TeacherHE151412.Id\n"
                + "inner join StudentHE151412 on StudentHE151412.ID = markHE151412.Student_id where class_id = ?";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, classId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Mark mark = Mark.builder()
                        .id(rs.getInt(1))
                        .classId(rs.getInt(4))
                        .className(rs.getString(10))
                        .teacherId(rs.getInt(2))
                        .teacherName(rs.getString(16))
                        .studentId(rs.getInt(3))
                        .studentName(rs.getString(25))
                        .listening(rs.getFloat(5))
                        .writting(rs.getFloat(6))
                        .reading(rs.getFloat(7))
                        .speaking(rs.getFloat(8))
                        .build();
                list.add(mark);
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(Mark mark) {
        List<Mark> list = new ArrayList<>();
        String sql = "INSERT INTO [dbo].[markHE151412]\n"
                + "           ([Teacher_id]\n"
                + "           ,[Student_id]\n"
                + "           ,[class_id]\n"
                + "           ,[listening]\n"
                + "           ,[writting]\n"
                + "           ,[reading]\n"
                + "           ,[speaking])\n"
                + "     VALUES\n"
                + "           (?, ?, ?, ?, ?, ?, ?)";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, mark.getTeacherId());
            ps.setInt(2, mark.getStudentId());
            ps.setInt(3, mark.getClassId());
            ps.setFloat(4, mark.getListening());
            ps.setFloat(5, mark.getWritting());
            ps.setFloat(6, mark.getReading());
            ps.setFloat(7, mark.getSpeaking());
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[markHE151412]\n"
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

    public Mark getbyId(int id) {
        String sql = "SELECT * FROM [markHE151412] inner join classHE151412 on markHE151412.class_id = classHE151412.id \n"
                + "inner join TeacherHE151412 on markHE151412.Teacher_id = TeacherHE151412.Id \n"
                + "				inner join StudentHE151412 on StudentHE151412.ID = markHE151412.Student_id\n"
                + "				where [markHE151412].id = ?";
        try {

            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mark mark = Mark.builder()
                        .id(rs.getInt(1))
                        .classId(rs.getInt(4))
                        .className(rs.getString(10))
                        .teacherId(rs.getInt(2))
                        .teacherName(rs.getString(16))
                        .studentId(rs.getInt(3))
                        .studentName(rs.getString(25))
                        .listening(rs.getFloat(5))
                        .writting(rs.getFloat(6))
                        .reading(rs.getFloat(7))
                        .speaking(rs.getFloat(8))
                        .build();
                return mark;
            }

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public void update(Mark mark) {
        String sql = "UPDATE [dbo].[markHE151412]\n"
                + "   SET [Teacher_id] = ?\n"
                + "      ,[Student_id] = ?\n"
                + "      ,[class_id] = ?\n"
                + "      ,[listening] = ?\n"
                + "      ,[writting] =?\n"
                + "      ,[reading] = ?\n"
                + "      ,[speaking] = ?\n"
                + " WHERE id = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, mark.getTeacherId());
            ps.setInt(2, mark.getStudentId());
            ps.setInt(3, mark.getClassId());
            ps.setFloat(4, mark.getListening());
            ps.setFloat(5, mark.getWritting());
            ps.setFloat(6, mark.getReading());
            ps.setFloat(7, mark.getSpeaking());
            ps.setInt(8, mark.getId());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LevelCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
