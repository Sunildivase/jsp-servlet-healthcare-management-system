<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="style.css">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Prescription Form</title>
</head>
<link rel="stylesheet" href="style.css">
<body>
<div class="form-container">
    <h1>Prescription Information Form</h1>

    <form action="/jsp-servlet-healthcare-management-system/prescription-controller" method="POST">

        <label for="prescriptionId">PrescriptionId:</label>
        <input type="number" id="prescriptionId" name="prescriptionId" placeholder="prescriptionId"><br>

        <label for="prescriptionDetails">PrescriptionDetails:</label>
        <input type="text" id="prescriptionDetails" name="prescriptionDetails" placeholder="prescriptionDetails"><br>

        <label for="personId">PersonId:</label>
        <input type="number" id="personId" name="personId" placeholder="personId" required><br>


        <button type="submit">Submit</button>
        <br>
        <button type="reset">Reset</button>
    </form>

</div>
</body>
</html>