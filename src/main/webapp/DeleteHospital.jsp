<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="style.css">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Person</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
<div class="form-container">
    <h1>Delete Doctor</h1>
    <form action="/servlet-healthcare-management-system/DeleteHospital.jsp" method="DELETE">
        <div class="form-group">
            <label for="hospitalId">HospitalId:</label>
            <input type="number" id="hospitalId" name="hospitalId" placeholder="hospitalId" required>
        </div>

        <button type="submit">Submit</button>
        <br>
        <button type="reset">Reset</button>

    </form>
</div>
</body>
</html>