/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.list;

import DAO.accountDAO;
import DAO.adminDAO;
import DAO.loginDAO;
import DAO.studentDAO;
import Model.Account;
import Model.Admin;
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
public class listStudentsControl extends HttpServlet {

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
            studentDAO stdao = new studentDAO();
//            String indexpage = request.getParameter("index");
//            if (indexpage == null) {
//                indexpage = "1";
//            }
//            int index = Integer.parseInt(indexpage);
//            int count = stdao.getTotalStudent();
//            int endpage = count / 5;
//            if (count % 5 != 0) {
//                endpage++;
//            }
//            List<Student> list = stdao.getpage(index);
//            request.setAttribute("endPage", endpage);
//            request.setAttribute("tag", index);
//            request.setAttribute("List", list);
//
//            Account account = LoginDAO.checkLogin(uname, pword);
//            Admin ad = dao.getById(account.getId());
//            request.setAttribute("ad", ad);
//            request.setAttribute("account", account);
//            List<Account> loginaccount = new accountDAO().getAllAccount();
//            List<Student> listStudents = new studentDAO().getAllStudents();
//            studentDAO studentdao = new studentDAO();
//            
            //  request.setAttribute("listStudents", listStudents);
            Account account = LoginDAO.checkLogin(uname, pword);
            Admin ad = dao.getById(account.getId());
            request.setAttribute("ad", ad);
            request.setAttribute("account", account);
            List<Student> listStudents = new studentDAO().getAllStudents();
            request.setAttribute("listStudents", listStudents);
            request.getRequestDispatcher("listStudents.jsp").forward(request, response);
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
