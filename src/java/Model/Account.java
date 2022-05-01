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
public class Account {
    public  static final String ADMIN = "ADMIN";
    public  static final String TEACHER = "TEACHER";
    public  static final String STUDENT = "STUDENT";
    private int id;
    private String loginAccount;
    private String passwordAccount;
    private String role;
}
