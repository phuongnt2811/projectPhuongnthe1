/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.classDAO;
import DAO.classStudentDAO;
import DAO.studentDAO;
import Model.ClassStudent;
import Model.Classes;
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
public class updateClassStudent extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
        List<Student> listS = new studentDAO().getAllStudents();
        List<Classes> listC = new classDAO().getAllClass();
        
        ClassStudent listCSa = new classStudentDAO().getById(id);

        request.setAttribute("listS", listS);
        request.setAttribute("listC", listC);

        request.setAttribute("listCSa", listCSa);
        request.getRequestDispatcher("updateClassStudent.jsp").forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("id"));
        int classId = Integer.parseInt(request.getParameter("classId"));
        String className = request.getParameter("className");
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        String studentName = request.getParameter("studentName");
        String studentCode = request.getParameter("studentCode");

        ClassStudent classStudent = ClassStudent.builder().id(id).classId(classId).className(className).studentId(studentId).studentName(studentName).studentCode(studentCode).build();

        classStudentDAO classStudentDAO = new classStudentDAO();
        classStudentDAO.update(classStudent);
        response.sendRedirect("list-class-student");
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
