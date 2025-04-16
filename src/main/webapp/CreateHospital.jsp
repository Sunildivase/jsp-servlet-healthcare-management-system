<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="style.css">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hospital Form</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class="form-container">
    <h1>Hospital Information Form</h1>

    <form action="/jsp-servlet-healthcare-management-system/hospital-controller" method="POST">

        <label for="hospitalId">HospitalId:</label>
        <input type="text" id="hospitalId" name="hospitalId" placeholder="hospitalId"><br>

        <label for="hospitalName">HospitalName:</label>
        <input type="text" id="hospitalName" name="hospitalName" placeholder="hospitalName" required><br>

        <label for="address">Address:</label>
        <input type="text" id="address" name="address" placeholder="address" required><br>

        <label for="emailId">EmailId:</label>
        <input type="text" id="emailId" name="emailId" placeholder="emailId" required><br>

        <label for="contactNo">ContactNo:</label>
        <input type="number" name="contactNo" id="contactNo" placeholder="contactNo" required> <br>

        <button type="submit">Submit</button>
        <br>
        <button type="reset">Reset</button>
    </form>

</div>
</body>
</html>