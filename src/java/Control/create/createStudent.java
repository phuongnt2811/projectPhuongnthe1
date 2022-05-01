/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control.create;

import DAO.accountDAO;
import DAO.studentDAO;
import Model.Account;
import Model.Student;
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
public class createStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Account> acc = new accountDAO().getAllAccount();
        request.setAttribute("acc", acc);
        request.getRequestDispatcher("createStudent.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String code = request.getParameter("code");
        String temp = request.getParameter("gender");
        boolean gender = temp.equals("Nam");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        String address = request.getParameter("address");
        String birthday = request.getParameter("birthday");
        int loginid = Integer.parseInt(request.getParameter("loginId"));

        //Student student = new Student(-1, name, code, gender, phone, email, address, birthday);
        Student student = Student.builder().id(-1).name(name).code(code).gender(gender).phone(phone).email(email).address(address).birthday(birthday).loginId(loginid).build();
        studentDAO studentDAO = new studentDAO();
//        accountDAO accountdao = new accountDAO();
//        Account loginname = accountdao.getAcc(loginId);
        studentDAO.insert(student);
        response.sendRedirect("listStudentsControl");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
