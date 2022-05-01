/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Model.ClassStudent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class classStudentDAO {

    public List<ClassStudent> getAll() {
        List<ClassStudent> list = new ArrayList<>();
        String sql = " select * from class_studentHE151412 inner join classHE151412 on class_studentHE151412.class_id = classHE151412.id inner join StudentHE151412\n"
                + " on class_studentHE151412.StudenId = StudentHE151412.id";

        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClassStudent classStudent = ClassStudent.builder()
                        .id(rs.getInt(1))
                        .classId(rs.getInt(2))
                        .className(rs.getString(5))
                        .studentId(rs.getInt(3))
                        .studentName(rs.getString(11))
                        .studentCode(rs.getString(12))
                        .build();
                list.add(classStudent);

            }
        } catch (Exception ex) {
            Logger.getLogger(classStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<ClassStudent> getStudentById(int classId) {
        List<ClassStudent> list = new ArrayList<>();
        String sql = " select * from class_studentHE151412 inner join classHE151412 on class_studentHE151412.class_id = classHE151412.id inner join StudentHE151412\n"
                + " on class_studentHE151412.StudenId = StudentHE151412.id where class_studentHE151412.class_id =?";

        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, classId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ClassStudent classStudent = ClassStudent.builder()
                        .id(rs.getInt(1))
                        .classId(rs.getInt(2))
                        .className(rs.getString(5))
                        .studentId(rs.getInt(3))
                        .studentName(rs.getString(11))
                        .studentCode(rs.getString(12))
                        .build();
                list.add(classStudent);

            }
        } catch (Exception ex) {
            Logger.getLogger(classStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void insert(ClassStudent classStudent) {
        String sql = "INSERT INTO [dbo].[class_studentHE151412]\n"
                + "           ([class_id]\n"
                + "           ,[StudenId])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, classStudent.getClassId());
            ps.setInt(2, classStudent.getStudentId());

            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(studentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM [dbo].[class_studentHE151412]\n"
                + "      WHERE id =?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(LevelCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ClassStudent getById(int id) {
        String sql = " select * from class_studentHE151412 inner join classHE151412 on class_studentHE151412.class_id = classHE151412.id inner join StudentHE151412\n"
                + " on class_studentHE151412.StudenId = StudentHE151412.id where class_studentHE151412.id = ? ";

        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ClassStudent classStudent = ClassStudent.builder()
                        .id(rs.getInt(1))
                        .classId(rs.getInt(2))
                        .className(rs.getString(5))
                        .studentId(rs.getInt(3))
                        .studentName(rs.getString(11))
                        .studentCode(rs.getString(12))
                        .build();
                return classStudent;

            }
        } catch (Exception ex) {
            Logger.getLogger(classStudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(ClassStudent classStudent) {
        String sql = "UPDATE [dbo].[class_studentHE151412]\n"
                + "   SET [class_id] = ?\n"
                + "      ,[StudenId] = ?\n"
                + " WHERE id = ?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, classStudent.getClassId());
            ps.setInt(2, classStudent.getStudentId());
            ps.setInt(3, classStudent.getId());
            ps.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(classDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
