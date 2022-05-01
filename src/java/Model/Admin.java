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
public class Admin {
    private int id;
    private String name;
    private String code;
    private boolean gender;
    private String phone;
    private String email;
    private String address;
    private String birthday;
 private int loginId;
   
    
}
