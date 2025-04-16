<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Doctor List</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
    <h2>List of Doctor</h2>
    <table border="1">
        <thead>
            <tr>
                <th>DoctorId</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Age</th>
                <th>Gender</th>
                <th>ContactNo</th>
                <th>Speciality</th>
                <th>Experience</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="doctor" items="${doctorList}">
                <tr>
                    <td>${doctor.PersonId}</td>
                    <td>${doctor.FirstName}</td>
                    <td>${doctor.LastName}</td>
                    <td>${doctor.Age}</td>
                    <td>${doctor.Gender}</td>
                    <td>${doctor.ContactNo}</td>
                    <td>${doctor.Speciality}</td>
                    <td>${doctor.Experience}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>