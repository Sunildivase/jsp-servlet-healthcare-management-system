<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Department List</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
    <h2>List of Department</h2>
    <table border="1">
        <thead>
            <tr>
                <th>deptId</th>
                <th>deptName</th>
                <th>doctorId</th>
                <th>hospitalId</th>
            </tr>
        </thead>
        <tbody>
            <p:forEach var="department" items="${departmentList}">
                <tr>
                    <td>${department.deptId}</td>
                    <td>${department.deptName}</td>
                    <td>${department.doctorId}</td>
                    <td>${department.hospitalId}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>