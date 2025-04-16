<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Billing List</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
    <h2>List of Billing</h2>
    <table border="1">
        <thead>
            <tr>
                <th>BillId</th>
                <th>Bill</th>
                <th>TotalBill</th>
                <th>PersonId</th>

            </tr>
        </thead>
        <tbody>
            <p:forEach var="billing" items="${billingList}">
                <tr>
                    <td>${billing.BillId}</td>
                    <td>${billing.Bill}</td>
                    <td>${billing.TotalBill}</td>
                    <td>${billing.PersonId}</td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>