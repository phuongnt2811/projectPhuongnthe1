/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.adminDAO;
import DAO.loginDAO;
import DAO.studentDAO;
import Model.Account;
import Model.Admin;
import Model.Student;
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
public class updateProfile extends HttpServlet {

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
        loginDAO LoginDAO = new loginDAO();
        adminDAO dao = new adminDAO();
        Cookie[] cookies = request.getCookies();
        String uname = null;
        String pword = null;
        if (cookies != null) {
            for (Cookie cooky : cookies) {
                if (cooky.getName().equals("username")) {
                    uname = cooky.getValue();
                    request.setAttribute("username", cooky.getValue());
                }
                if (cooky.getName().equals("password")) {
                    pword = cooky.getValue();
                    request.setAttribute("password", cooky.getValue());
                }
            }
        }
        Account account = LoginDAO.checkLogin(uname, pword);
        Admin ad = dao.getById(account.getId());
        request.setAttribute("ad", ad);
        request.setAttribute("account", account);
        request.getRequestDispatcher("Profile.jsp").forward(request, response);
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
        request.setCharacterEncoding("UTF-8");
       int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String temp = request.getParameter("gender");
        boolean gender = temp.equals("Nam");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");

        Admin ad = Admin.builder().id(id).name(name).code(code).gender(gender).phone(phone).email(email).address(address).birthday(birthday).build();

        new adminDAO().update(ad);
   
        response.sendRedirect("update-profile");
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
