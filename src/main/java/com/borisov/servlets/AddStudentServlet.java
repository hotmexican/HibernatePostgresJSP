package com.borisov.servlets;

import com.borisov.DAO.StudentDAO;
import com.borisov.DAO.StudentDAOImpl;
import com.borisov.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {

    StudentDAO studentDAO;
    Student student;

    @Override
    public void init() {
        studentDAO = new StudentDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/insert-student-page.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println(name);
        String surname = request.getParameter("surname");
        System.out.println(surname);
        student = new Student(name, surname);
        System.out.println(student);
        studentDAO.save(student);
        response.sendRedirect("StartPageServlet");
    }
}
