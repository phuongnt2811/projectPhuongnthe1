/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Context.DBContext;
import Model.Weekday;
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
public class weekdayDAO {

    public List<Weekday> getAll() {
        List<Weekday> list = new ArrayList<>();
             String sql = "SELECT  * FROM [WeekdayHE151412]";   
        try {
            Connection conn = new DBContext().getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Weekday weekday = Weekday.builder().id(rs.getInt(1)).name(rs.getString(2)).build();
                list.add(weekday);
            }
        } catch (Exception ex) {
            Logger.getLogger(weekdayDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
