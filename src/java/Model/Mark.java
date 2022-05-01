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
public class Mark {

    private int id;
    private int classId;
    private String className;
    private int teacherId;
    private String teacherName;
    private int studentId;
    private String studentName;
    private float listening;
    private float writting;
    private float reading;
    private float speaking;

}
