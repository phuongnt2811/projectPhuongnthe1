/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Other;

import DAO.adminDAO;
import DAO.classDAO;
import DAO.courseDAO;
import DAO.loginDAO;
import DAO.studentDAO;
import DAO.teacherDAO;
import Model.Account;
import Model.Admin;
import Model.Student;
import Model.Teacher;
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
public class teacherHome extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
             adminDAO dao = new adminDAO();
            studentDAO daost = new studentDAO();
            teacherDAO daotea = new teacherDAO();
            loginDAO LoginDAO = new loginDAO();
            Cookie[] cookies = request.getCookies();
            String uname = null;
            String pword = null;
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("username")) {
                    uname = cooky.getValue();
                }
                if (cooky.getName().equals("password")) {
                    pword = cooky.getValue();
                }
                if (uname != null && pword != null) {
                    break;
                }

            }
            Account account = LoginDAO.checkLogin(uname, pword);
            Admin ad = dao.getById(account.getId());
            Student st = daost.getByIdA(account.getId());
            Teacher tea = daotea.getByIdT(account.getId());
            request.setAttribute("ad", ad);
            request.setAttribute("st", st);
            request.setAttribute("tea", tea);
                    
                    
        request.setAttribute("account", account);
        studentDAO studentdao = new studentDAO();
        teacherDAO teacherdao = new teacherDAO();
        classDAO clas = new classDAO();
        courseDAO coursedao = new courseDAO();

        int count2 = teacherdao.getTotalTeacher();
        int count = studentdao.getTotalStudent();
        int count3 = clas.getTotalClass();
        int count4 = coursedao.getTotalCourse();
        

        
       

        
        

        request.setAttribute("count", count);
        request.setAttribute("count2", count2);
        request.setAttribute("count3", count3);
             request.getRequestDispatcher("Teacher.jsp").forward(request, response);
        }
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
        processRequest(request, response);
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
