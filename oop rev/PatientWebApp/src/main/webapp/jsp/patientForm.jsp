<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Patient Registration</title>
</head>
<body>
<h2>Register a Patient</h2>
<form action="PatientServlet" method="post">
    First Name: <input type="text" name="firstName" required><br><br>
    Last Name: <input type="text" name="lastName" required><br><br>
    Age: <input type="number" name="age"><br><br>
    Email: <input type="email" name="email"><br><br>
    <input type="submit" value="Register">
</form>
</body>
</html>
