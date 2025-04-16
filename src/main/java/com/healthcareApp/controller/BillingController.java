package com.healthcareApp.controller;

import com.healthcareApp.model.Billing;
import com.healthcareApp.service.BillingService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class BillingController extends HttpServlet {

    BillingService billingService = new BillingService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the doGet() method=======");

        try {
            List<Billing> billingList = billingService.displayBilling();

            System.out.println("---------set the attribute-------");
            System.out.println("--------redirecting servlet request to dispatcher-----");
            request.setAttribute("billingList",billingList);

            //forward method
            request.getRequestDispatcher("DisplayBilling.jsp").forward(request,response);

            // redirect method
//            request.getSession().setAttribute("billingList",billingList);
//            response.sendRedirect("DisplayBilling.jsp");

        } catch (SQLException | ServletException e) {

            throw new RuntimeException(e);
        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the doPost() method=======");

        int billingId = Integer.parseInt(request.getParameter("billingId"));
        int bill = Integer.parseInt(request.getParameter("bill"));
        int totalBill = Integer.parseInt(request.getParameter("totalBill"));
        int personId = Integer.parseInt(request.getParameter("personId"));

        Billing billing = new Billing(billingId,bill,totalBill,personId);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            if (billingService.insertBilling(billing)) {
                out.println("<h2>billing inserted successfully!</h2>");
            } else {
                out.println("<h2>Failed to insert billing.</h2>");
            }
        } catch (SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }

    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the service() method=======");

        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else if (request.getMethod().equals("DELETE")) {
            this.destroy(request,response);
        } else {
            this.doGet(request, response);
        }

    }

    public void destroy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the destroy() method=======");

        String idStr = request.getParameter("billId");  // This must not be null

        if (idStr == null || idStr.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "billId is required.");
            return;
        }

        int billId = Integer.parseInt(idStr);  // This line throws error if idStr is null

        boolean deleted = false; // Assuming service accepts id
        try {
            deleted = billingService.deleteBilling(billId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (deleted) {
            out.println("<h1>billing deleted successfully</h1>");
        } else {
            out.println("<h1>billing not found</h1>");
        }
        out.println("</body></html>");
    }

}
