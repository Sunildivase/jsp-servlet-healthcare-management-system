package com.healthcareApp.controller;


import com.healthcareApp.model.Department;
import com.healthcareApp.service.DepartmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class DepartmentController extends HttpServlet {

    DepartmentService departmentService = new DepartmentService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("========Inside the doGet() method=============");

        try {
            List<Department> departmentList = departmentService.displayDepartment();

            System.out.println("---------set the attribute-------");
            System.out.println("--------redirecting servlet request to dispatcher-----");
            request.setAttribute("departmentList",departmentList);

            request.getRequestDispatcher("DisplayDepartment.jsp").forward(request,response);

            // redirect method
//            request.getSession().setAttribute("departmentList",departmentList);
//            response.sendRedirect("DisplayDoctor.jsp");

        } catch (SQLException | ServletException e) {

            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("========Inside the doPost() method=============");


        int  deptId = Integer.parseInt(request.getParameter("deptId"));
        String deptName = request.getParameter("deptName");
        int  doctorId = Integer.parseInt(request.getParameter("doctorId"));
        int  hospitalId = Integer.parseInt(request.getParameter("hospitalId"));

        Department department = new Department(deptId,deptName,doctorId,hospitalId);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            if (departmentService.insertDepartment(department)) {
                out.println("<h2>department inserted successfully!</h2>");
            } else {
                out.println("<h2>Failed to insert deartment.</h2>");
            }
        } catch (SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("========Inside the service() method=============");

        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else if (request.getMethod().equals("DELETE")) {
            this.destroy(request,response);
        } else {
            this.doGet(request, response);
        }

    }
    public void destroy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("========Inside the destroy() method=============");


        String idStr = request.getParameter("deptId");  // This must not be null

        if (idStr == null || idStr.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "deptId is required.");
            return;
        }

        int deptId = Integer.parseInt(idStr);  // This line throws error if idStr is null

        boolean deleted = false; // Assuming service accepts id
        try {
            deleted = departmentService.deleteDepartment(deptId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (deleted) {
            out.println("<h1>Department deleted successfully</h1>");
        } else {
            out.println("<h1>Department not found</h1>");
        }
        out.println("</body></html>");
    }

}
