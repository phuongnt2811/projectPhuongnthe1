/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.classDAO;
import DAO.courseDAO;
import DAO.teacherDAO;
import Model.Classes;
import Model.Course;
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
public class updateclass extends HttpServlet {

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
        request.setCharacterEncoding("UTF-8");
      int id = Integer.parseInt(request.getParameter("id"));
        Classes classes = new classDAO().getById(id);
        request.setAttribute("classes", classes);
         List<Course> listCourse = new courseDAO().getAllCourse();
        List<Teacher> listTeacher = new teacherDAO().getAllTeacher();
        request.setAttribute("listCourse", listCourse);
        request.setAttribute("listTeacher", listTeacher);
        request.getRequestDispatcher("updateClass.jsp").forward(request, response);
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
        String startdate = request.getParameter("startdate");
        String endate = request.getParameter("endate");
        int teacherId = Integer.parseInt(request.getParameter("teacherId"));
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        String teacherName = request.getParameter("teacherName");
        String courseName = request.getParameter("courseName");
        Classes classes = Classes.builder()
                .id(id).name(name).startdate(startdate).endate(endate).teacherId(teacherId)
                .courseId(courseId).teacherName(teacherName).courseName(courseName).build();
      
        classDAO classDAO = new classDAO();
        classDAO.update(classes);
        response.sendRedirect("list-class");
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
