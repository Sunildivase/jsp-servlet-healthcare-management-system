package com.healthcareApp.controller;


import com.healthcareApp.model.Prescription;
import com.healthcareApp.service.PrescriptionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class PrescriptionController extends HttpServlet {

    PrescriptionService prescriptionService = new PrescriptionService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the doGet() method==========");

        try {
            List<Prescription> prescriptionList = prescriptionService.displayPrescription();

            System.out.println("---------set the attribute-------");
            System.out.println("--------redirecting servlet request to dispatcher-----");
            request.setAttribute("prescriptionList",prescriptionList);

            // forward method
            request.getRequestDispatcher("DisplayPrescription.jsp").forward(request,response);

            // redirect method
//            request.getSession().setAttribute("prescriptionList",prescriptionList);
//            response.sendRedirect("DisplayPrescription.jsp");



        } catch (SQLException | ServletException e) {

            throw new RuntimeException(e);
        }

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the doPost() method==========");

        int  prescriptionId = Integer.parseInt(request.getParameter("prescriptionId"));
        String prescriptionDetails = request.getParameter("prescriptionDetails");
        int personId = Integer.parseInt(request.getParameter("personId"));


        Prescription prescription = new Prescription(prescriptionId,prescriptionDetails,personId);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            if (prescriptionService.insertPrescription(prescription)) {
                out.println("<h2>prescription inserted successfully!</h2>");
            } else {
                out.println("<h2>Failed to insert prescription.</h2>");
            }
        } catch (SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the service() method==========");
        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else if (request.getMethod().equals("DELETE")) {
            this.destroy(request,response);
        } else {
            this.doGet(request, response);
        }
    }

    public void destroy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the destroy() method==========");

        String idStr = request.getParameter("PrescriptionId");  // This must not be null

        if (idStr == null || idStr.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "personId is required.");
            return;
        }

        int prescriptionId = Integer.parseInt(idStr);  // This line throws error if idStr is null

        boolean deleted = false; // Assuming service accepts id
        try {
            deleted = prescriptionService.deletePrescription(prescriptionId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (deleted) {
            out.println("<h1>prescription deleted successfully</h1>");
        } else {
            out.println("<h1>prescription not found</h1>");
        }
        out.println("</body></html>");
    }

}
