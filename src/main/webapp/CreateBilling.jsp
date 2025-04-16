<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="style.css">
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Title</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
<div class="form-container">
  <h1>Billing Information Form</h1>

  <form action="/jsp-servlet-healthcare-management-system/billing-controller" method="POST">

    <label for="billId">BillId:</label>
    <input type="number" id="billId" name="billId" placeholder="billId" required><br>

    <label for="bill">Bill:</label>
    <input type="number" id="bill" name="bill" placeholder="bill" required><br>

    <label for="totalBill">TotalBill:</label>
    <input type="number" id="totalBill" name="totalBill" placeholder="totalBill" required> <br>

    <label for="personId">PersonId:</label>
    <input type="number" id="personId" name="personId" placeholder="personId" required> <br>


    <button type="submit">Submit</button>
    <br>
    <button type="reset">Reset</button>
  </form>
</div>
</body>
</html>