package com.healthcareApp.controller;


import com.healthcareApp.model.Hospital;
import com.healthcareApp.service.HospitalService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class HospitalController extends HttpServlet {

    private static final HospitalService hospitalService = new HospitalService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("========inside the doGet()=========");

                try {
            List<Hospital> hospitalList = hospitalService.displayHospital();

            System.out.println("---------set the attribute-------");
            System.out.println("--------redirecting servlet request to dispatcher-----");
            request.setAttribute("hospitalList",hospitalList);

            //forward method
            request.getRequestDispatcher("DisplayHospital.jsp").forward(request,response);

            // redirect method
//            request.getSession().setAttribute("hospitalList",hospitalList);
//            response.sendRedirect("DisplayHospital.jsp");

        } catch (SQLException | ServletException e) {

            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("========inside the doPost()=========");

        int hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
        String hospitalName = request.getParameter("hospitalName");
        String address = request.getParameter("address");
        String emailId = request.getParameter("emailId");
        String contactNo = request.getParameter("contactNo");

        Hospital hospital = new Hospital(hospitalId, hospitalName, address, emailId, contactNo);

        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();

        try {
            if (hospitalService.insertHospital(hospital)) {
                writer.println("<h2> hospital Inserted Successfully !!");
            } else {
                writer.println("<h2> Failed to Insert Hospital");
            }
        } catch (SQLException e) {
            System.err.println("<p> Error: " + e.getMessage() + "</P>");
        }

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("========inside the service()=========");

        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else if (request.getMethod().equals("DELETE")) {
            this.destroy(request,response);
        } else {
            this.doGet(request, response);
        }

    }

    public void destroy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("========inside the destroy() method=====");

        String idStr = request.getParameter("hospitalId");  // This must not be null

        if (idStr == null || idStr.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "personId is required.");
            return;
        }

        int hospitalId = Integer.parseInt(idStr);  // This line throws error if idStr is null

        boolean deleted = false; // Assuming service accepts id
        try {
            deleted = hospitalService.deleteHospital(hospitalId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (deleted) {
            out.println("<h1>Hospital deleted successfully</h1>");
        } else {
            out.println("<h1>Hospital not found</h1>");
        }
        out.println("</body></html>");
    }

}

