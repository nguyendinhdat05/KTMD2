package com.example.ktmd2.controller;

import com.example.ktmd2.model.Student;
import com.example.ktmd2.service.StudentServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "student", value = "/student")


public class StudentServlet extends HttpServlet {
    StudentServiceImpl studentService = new StudentServiceImpl();

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "creat":
                createPost(req, resp);
                break;
            case "edit":
                editPost(req,resp);
                break;
        }
    }

    private void editPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String msv = req.getParameter("msv");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        String address = req.getParameter("address");
        double mediumScore = Double.parseDouble(req.getParameter("mediumScore"));
        studentService.edit(msv,new Student(msv,name,age,sex,address,mediumScore));
        resp.sendRedirect("/student");
    }

    private void createPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String msv = req.getParameter("msv");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String sex = req.getParameter("sex");
        String address = req.getParameter("address");
        double mediumScore = Double.parseDouble(req.getParameter("mediumScore"));
        studentService.add(new Student(msv, name, age, sex, address, mediumScore));
        resp.sendRedirect("/student");
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "creat":
                showCreat(req, resp);
                break;
            case "delete":
                showDelete(req, resp);
                break;
            case "edit":
                showEdit(req,resp);
                break;
            default:
                showListStudent(req, resp);
        }
    }


    private void showEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Student/edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        studentService.delete(req.getParameter("msv"));
        resp.sendRedirect("/student");
    }

    private void showCreat(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Student/creat.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showListStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Student/list.jsp");
        req.setAttribute("student", studentService.findAll());
        requestDispatcher.forward(req, resp);
    }

}

