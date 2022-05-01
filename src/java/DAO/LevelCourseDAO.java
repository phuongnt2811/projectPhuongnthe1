/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Model.LevelCourse;
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
public class LevelCourseDAO {

    public List<LevelCourse> getAlllevels() {
        List<LevelCourse> list = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[levelHE151412]";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LevelCourse level = LevelCourse.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .signCode(rs.getString(3))
                        .build();
                list.add(level);

            }
        } catch (Exception ex) {
            Logger.getLogger(LevelCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public void insert(LevelCourse level) {
        String sql = "INSERT INTO [dbo].[levelHE151412]\n"
                + "           ([name]\n"
                + "           ,[sign_code])\n"
                + "     VALUES\n"
                + "           (?, ?)";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, level.getName());
            ps.setString(2, level.getSignCode());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LevelCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void delete(int id) {
        String sql = "DELETE FROM levelHE151412\n"
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

    public LevelCourse getById(int id) {
        String sql = "SELECT * FROM [dbo].[levelHE151412] where id =?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LevelCourse level = LevelCourse.builder()
                        .id(rs.getInt(1))
                        .name(rs.getString(2))
                        .signCode(rs.getString(3))
                        .build();
                return level;

            }
        } catch (Exception ex) {
            Logger.getLogger(LevelCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(LevelCourse level) {
        String sql = "UPDATE levelHE151412\n"
                + "   SET [name] = ?\n"
                + "      ,[sign_code] =?\n"
                + " WHERE id =?";
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, level.getName());
            ps.setString(2, level.getSignCode());
            ps.setInt(3, level.getId());

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LevelCourseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
