<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>AppointmentList List</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
    <h2>List of Appointment</h2>
    <table border="1">
        <thead>
            <tr>
                <th>AppointmentId</th>
                <th>PersonId</th>
                <th>DoctorId</th>
                <th>HospitalId</th>
                <th>DeptId</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="appointment" items="${appointmentList}">
                <tr>
                    <td>${appointment.AppointmentId}</td>
                    <td>${appointment.PersonId}</td>
                    <td>${appointment.DoctorId}</td>
                    <td>${appointment.HospitalId}</td>
                    <td>${appointment.DeptId}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>