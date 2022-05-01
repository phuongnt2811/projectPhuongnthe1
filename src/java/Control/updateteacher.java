/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.accountDAO;
import DAO.teacherDAO;
import Model.Account;
import Model.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author PHUONG
 */
public class updateteacher extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Teacher teacher = new teacherDAO().getById(id);
        request.setAttribute("teacher", teacher);
        List<Account> acc = new accountDAO().getAllAccount();
        request.setAttribute("acc", acc);
        request.getRequestDispatcher("updateTeacher.jsp").forward(request, response);
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
        int loginid = Integer.parseInt(request.getParameter("loginId"));
        Teacher teacher = Teacher.builder().id(id).name(name).code(code).gender(gender).phone(phone)
                .email(email).address(address).birthday(birthday).loginId(loginid).build();

        new teacherDAO().update(teacher);
        //   new teacherDAO().update(name, code, gender, phone, email, address, birthday, id);
        response.sendRedirect("list-teacher");
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
