/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class Classes {
    private int id;
    private String name;
    private String startdate;
    private String endate;
    private int teacherId;
    private int courseId;
    private String teacherName;
    private String courseName;
    
    
    
     
    
   
}
