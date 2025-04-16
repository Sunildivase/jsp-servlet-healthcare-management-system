<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="style.css">
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Form</title>
</head>
<body>
<div class="form-container">
  <h1>Doctor Information Form</h1>

  <form action="/jsp-servlet-healthcare-management-system/doctor-controller" method="POST">

   <label for="doctorId">doctorId:</label>
   <input type="text" id="doctorId" name="doctorId" placeholder="doctorId" required><br>

     <label for="firstName">FirstName:</label>
     <input type="text" id="firstName" name="firstName" placeholder="firstName" required><br>

     <label for="lastName">LastName:</label>
     <input type="text" id="lastName" name="lastName" placeholder="lastName" required> <br>

     <label for="age">Age:</label>
     <input type="number" id="age" name="age" placeholder="age" required> <br>

     <label for="gender">Gender:</label>
      <input type="text" id="gender" name="gender" placeholder="gender" required><br>

     <label for="contactNo">ContactNo:</label>
     <input type="number" name="contactNo" id="contactNo" placeholder="contactNo" required> <br>

     <label for="speciality">Speciality:</label>
     <input type="text" name="speciality" id="speciality" placeholder="speciality" required> <br>

     <label for="experience">Experience:</label>
     <input type="number" name="experience" id="experience" placeholder="experience" required> <br>


      <button type="submit">Submit</button>
      <br>
      <button type="reset">Reset</button>
</form>

</div>
</body>
</html>