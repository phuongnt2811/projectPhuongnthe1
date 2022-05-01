/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import DAO.accountDAO;
import DAO.loginDAO;
import Model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PHUONG
 */
public class loginControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // kiem tra cookie
         Cookie[] cookies = request.getCookies();
                String uname = null;
                String pword = null;
                for (Cookie cooky : cookies) {
                    if(cooky.getName().equals("username")){
                        uname = cooky.getValue();
                    }
                    if(cooky.getName().equals("password")){
                        pword = cooky.getValue();
                    }
                    if(uname != null && pword != null){
                        break;
                    }
                    
                }
                if(uname != null && pword != null){
                    Account account = new accountDAO().checkLogin(uname, pword);
                    if(account != null){
                        request.getSession().setAttribute("account", account);
                        if(account.getRole().equals("ADMIN")){
                            response.sendRedirect("adminHome");
                        }
                         if(account.getRole().equals("TEACHER")){
                            response.sendRedirect("teacherHome");
                        }      
                        if(account.getRole().equals("STUDENT")){
                            response.sendRedirect("studentHome");
                        }     
                    }
                    
                 }
        
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
           // boolean remember = Boolean.parseBoolean(request.getParameter("remember"));
            Account account = new accountDAO().checkLogin(username, password);
        if (account != null) {
            // check username and password
         //   if (remember) {
                Cookie usernameCookie = new Cookie("username", username);
                usernameCookie.setMaxAge(60 * 60 * 24 * 2);
                Cookie passwordCookie = new Cookie("password", password);
                passwordCookie.setMaxAge(60 * 60 * 24 * 2);
                response.addCookie(usernameCookie);
                response.addCookie(passwordCookie);

          //  }
            request.getSession().setAttribute("account", account);
            if(account.getRole().equals("ADMIN")){
                            response.sendRedirect("adminHome");
                        }
                          if(account.getRole().equals("TEACHER")){
                            response.sendRedirect("teacherHome");
                        }      
                        if(account.getRole().equals("STUDENT")){
                            response.sendRedirect("studentHome");
                        }     
            // invalid, save in session 

        } else {
            // illegal- return error
            request.setAttribute("error", "username or password incorrect");
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
