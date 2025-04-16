<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Hospital List</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
    <h2>List of Hospital</h2>
    <table border="1">
        <thead>
            <tr>
                <th>HospitalId</th>
                <th>HospitalName</th>
                <th>Address</th>
                <th>EmailId</th>
                <th>ContactNo</th>
            </tr>
        </thead>
        <tbody>
            <p:forEach var="hospital" items="${hospitalList}">
                <tr>
                    <td>${hospital.HospitalId}</td>
                    <td>${hospital.HospitalName}</td>
                    <td>${hospital.Address}</td>
                    <td>${hospital.EmailId}</td>
                    <td>${hospital.ContactNo}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>