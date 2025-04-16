<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Prescription List</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
    <h2>List of Prescription</h2>
    <table border="1">
        <thead>
            <tr>
                <th>PrescriptionId</th>
                <th>PrescriptionDetails</th>
                <th>PersonId</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach var="prescription" items="${prescriptionList}">
                <tr>
                    <td>${prescription.PrescriptionId}</td>
                    <td>${prescription.PrescriptionDetails}</td>
                    <td>${prescription.PersonId}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>