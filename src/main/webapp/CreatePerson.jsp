<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="style.css">
<!DOCTYPE html>
<html>
<head>
    <title>Person Form</title>
</head>
<body>
<div class="form-container">
<h1>Person Information Form</h1>

<form action="/jsp-servlet-healthcare-management-system/person-controller" method="POST">

   <label for="personId">PersonId:</label>
   <input type="text" id="personId" name="personId" placeholder="personId" required><br>

   <label for="type">Type:</label>
     <input type="text" id="type" name="type" placeholder="type" required><br>

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

     <label for="alternateMobile">AlternateMobile:</label>
     <input type="number" name="alternateMobile" id="alternateMobile" placeholder="alternateMobile" required>
     <br>

     <label for="address">Address:</label><textarea name="address" id="address" cols="30" rows="10"></textarea>
     <br>

      <button type="submit">Submit</button>
      <br>
      <button type="reset">Reset</button>
</form>

</div>
</body>
</html>