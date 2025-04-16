<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Person List</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
    <h2>List of Person</h2>
    <table border="1">
        <thead>
            <tr>
                <th>PersonId</th>
                <th>Type</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Age</th>
                <th>Gender</th>
                <th>ContactNo</th>
                <th>AlternateMobile</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
            <p:forEach var="person" items="${personList}">
                <tr>
                    <td>${person.PersonId}</td>
                    <td>${person.Type}</td>
                    <td>${person.FirstName}</td>
                    <td>${person.LastName}</td>
                    <td>${person.Age}</td>
                    <td>${person.Gender}</td>
                    <td>${person.ContactNo}</td>
                    <td>${person.AlternateMobile}</td>
                    <td>${person.Address}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>