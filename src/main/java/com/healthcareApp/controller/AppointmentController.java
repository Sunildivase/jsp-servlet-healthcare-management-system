package com.healthcareApp.controller;


import com.healthcareApp.model.Appointment;
import com.healthcareApp.service.AppointmentService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class AppointmentController extends HttpServlet {

    AppointmentService appointmentService = new AppointmentService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the doGet()===========");


        try {
            List<Appointment> appointmentList = appointmentService.displayAppointment();

            System.out.println("---------set the attribute-------");
            System.out.println("--------redirecting servlet request to dispatcher-----");
            request.setAttribute("appointmentList",appointmentList);

            request.getRequestDispatcher("DisplayAppointment.jsp").forward(request,response);

            // redirect method
//            request.getSession().setAttribute("appointmentList",appointmentList);
//            response.sendRedirect("DisplayAppointment.jsp");

        } catch (SQLException | ServletException e) {

            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the doPost() method=========");
        int  appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
        int  personId = Integer.parseInt(request.getParameter("personId"));
        int  doctorId = Integer.parseInt(request.getParameter("doctorId"));
        int  hospitalId = Integer.parseInt(request.getParameter("hospitalId"));
        int  deptId = Integer.parseInt(request.getParameter("deptId"));


        Appointment appointment = new Appointment(appointmentId,personId,doctorId,hospitalId,deptId);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            if (appointmentService.insertAppointment(appointment)) {
                out.println("<h2>appointment inserted successfully!</h2>");
            } else {
                out.println("<h2>Failed to insert appointment.</h2>");
            }
        } catch (SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("======inside the service() method=======");

        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else if (request.getMethod().equals("DELETE")) {
            this.destroy(request,response);
        } else {
            this.doGet(request, response);
        }
    }
    public void destroy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the destroy method=========");

        String idStr = request.getParameter("personId");  // This must not be null

        if (idStr == null || idStr.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "personId is required.");
            return;
        }

        int appointmentId = Integer.parseInt(idStr);  // This line throws error if idStr is null

        boolean deleted = false; // Assuming service accepts id
        try {
            deleted = AppointmentService.deleteAppointment(appointmentId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (deleted) {
            out.println("<h1>Doctor deleted successfully</h1>");
        } else {
            out.println("<h1>Doctor not found</h1>");
        }
        out.println("</body></html>");
    }

}
