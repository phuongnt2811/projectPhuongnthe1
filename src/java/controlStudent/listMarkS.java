/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlStudent;

import DAO.loginDAO;
import DAO.markDAO;
import DAO.studentDAO;
import Model.Account;
import Model.Admin;
import Model.Mark;
import Model.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PHUONG
 */
public class listMarkS extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       loginDAO LoginDAO = new loginDAO();
        Cookie[] cookies = request.getCookies(); 
        String user = "";        
        String pass = "";        
        if (cookies != null) {
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("username")) {
                    user = cooky.getValue();
                    request.setAttribute("username", cooky.getValue());
                }
                if (cooky.getName().equals("password")) {
                    pass = cooky.getValue();
                    request.setAttribute("password", cooky.getValue());
                }
            }
        }
         
        
       studentDAO dao = new studentDAO();
        Account a = LoginDAO.checkLogin(user, pass);
        Student st = dao.getById(a.getId());
        request.setAttribute("st", st);
        request.setAttribute("account", a);
        
        markDAO markdao = new markDAO();
      
        request.getRequestDispatcher("markOfStudent.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
