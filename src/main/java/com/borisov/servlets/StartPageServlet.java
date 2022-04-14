package com.borisov.servlets;

import com.borisov.DAO.StudentDAO;
import com.borisov.DAO.StudentDAOImpl;
import com.borisov.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StartPageServlet extends HttpServlet {
    StudentDAO studentDAO;


    @Override
    public void init() throws ServletException {
        studentDAO = new StudentDAOImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Student> studentList = studentDAO.getAllStudents();
        request.setAttribute("students", studentList);
        String index = "/WEB-INF/view/start-page.jsp";
        getServletContext().getRequestDispatcher(index).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
