<%-- 
    Document   : passwordvalid
    Created on : 18-Jul-2023, 3:01:29 pm
    Author     : Nivedha.S
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>User Registration Form</title>
  <style>
    .error {
      color: red;
    }
  </style>
  <script>
    function validateForm() {
      var name = document.forms["registrationForm"]["name"].value;
      var email = document.forms["registrationForm"]["email"].value;
      var phone = document.forms["registrationForm"]["phone"].value;
      var address = document.forms["registrationForm"]["address"].value;
      var password = document.forms["registrationForm"]["password"].value;
      var confirmPassword = document.forms["registrationForm"]["confirmPassword"].value;

      if (name == "") {
        document.getElementById("nameError").innerHTML = "Name is required";
        return false;
      }

      if (email == "") {
        document.getElementById("emailError").innerHTML = "Email is required";
        return false;
      }

      if (phone == "") {
        document.getElementById("phoneError").innerHTML = "Phone is required";
        return false;
      }

      if (address == "") {
        document.getElementById("addressError").innerHTML = "Address is required";
        return false;
      }

      if (password == "") {
        document.getElementById("passwordError").innerHTML = "Password is required";
        return false;
      }

      if (password != confirmPassword) {
        document.getElementById("confirmPasswordError").innerHTML = "Passwords do not match";
        return false;
      }
    }
  </script>
</head>
<body>
  <h2>User Registration Form</h2>
  <form name="registrationForm" onsubmit="return validateForm()" method="post">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name"><br>
    <span id="nameError" class="error"></span><br>

    <label for="email">Email:</label><br>
    <input type="email" id="email" autocomplete="on" name="email"><br>
    <span id="emailError" class="error"></span><br>

    <label for="phone">Phone:</label><br>
    <input type="tel" id="phone" name="phone"><br>
    <span id="phoneError" class="error"></span><br>

    <label for="address">Address:</label><br>
    <textarea id="address" name="address"></textarea><br>
    <span id="addressError" class="error"></span><br>

    <label for="password">Password:</label><br>
    <input type="password" id="password" name="password"><br>
    <span id="passwordError" class="error"></span><br>

    <label for="confirmPassword">Confirm Password:</label><br>
    <input type="password" id="confirmPassword" name="confirmPassword"><br>
    <span id="confirmPasswordError" class="error"></span><br>

    <input type="submit" value="Register">
  </form>
</body>
</html>
