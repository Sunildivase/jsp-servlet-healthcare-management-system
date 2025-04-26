package com.healthcareApp.controller;


import com.healthcareApp.model.Person;
import com.healthcareApp.service.PersonService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class PersonController extends HttpServlet {
    PersonService personService = new PersonService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("=======inside the doGet() method");


        try {

            List<Person> personList = personService.displayPerson();

            System.out.println("---------set the attribute-------");
            System.out.println("--------redirecting servlet request to dispatcher-----");
            request.setAttribute("personList", personList);

            // forward method
            request.getRequestDispatcher("/DisplayPerson.jsp").forward(request,response);

//             redirect method
//            request.getSession().setAttribute("personList",personList);
//            response.sendRedirect("DisplayPerson.jsp");

        } catch (SQLException | ServletException e) {

            throw new RuntimeException(e);
        }


    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String  personId = request.getParameter("personId");
        String type = request.getParameter("type");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String  age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String  contactNo = request.getParameter("contactNo");
        String  alternateMobile = request.getParameter("alternateMobile");
        String address = request.getParameter("address");

        Person person = new Person(personId,type,firstName,lastName,age,gender,contactNo,alternateMobile,address);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            if (personService.insertPerson(person)) {
                out.println("<h2>person inserted successfully!</h2>");
            } else {
                out.println("<h2>Failed to insert person.</h2>");
            }
        } catch (SQLException e) {
            out.println("<p>Error: " + e.getMessage() + "</p>");
        }
    }

    public void service(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("========inside the service() method=====");

        if (request.getMethod().equals("POST")) {
            this.doPost(request, response);
        } else if (request.getMethod().equals("DELETE")) {
            this.destroy(request,response);
        } else {
            this.doGet(request, response);
        }
    }
    public void destroy(HttpServletRequest request,HttpServletResponse response) throws IOException {
        System.out.println("========inside the destroy() method=====");

        String idStr = request.getParameter("personId");  // This must not be null

        if (idStr == null || idStr.trim().isEmpty()) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "personId is required.");
            return;
        }

        int personId = Integer.parseInt(idStr);  // This line throws error if idStr is null

        boolean deleted = false; // Assuming service accepts id
        try {
            deleted = personService.deletePerson(personId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        if (deleted) {
            out.println("<h1>person deleted successfully</h1>");
        } else {
            out.println("<h1>person not found</h1>");
        }
        out.println("</body></html>");
    }

}
