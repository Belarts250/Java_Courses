<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>

<%
    List<Student> students = (List<Student>) request.getAttribute("studentList");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Management</title>
    <style>
        body {
            font-family: Arial;
            background: linear-gradient(to right, #141E30, #243B55);
            padding: 20px;
            color: white;
        }

        .container {
            width: 90%;
            margin: auto;
        }

        h1 {
            text-align: center;
        }

        .btn {
            padding: 8px 15px;
            background: #00c6ff;
            border: none;
            color: white;
            border-radius: 5px;
            text-decoration: none;
        }

        .btn-danger {
            background: #ff4b5c;
        }

        table {
            width: 100%;
            margin-top: 20px;
            border-collapse: collapse;
            background: white;
            color: black;
            border-radius: 10px;
        }

        th, td {
            padding: 12px;
            text-align: center;
        }

        th {
            background: #243B55;
            color: white;
        }

        tr:nth-child(even) {
            background: #f2f2f2;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Student Management System</h1>

    <a href="student?action=new" class="btn">+ Add Student</a>

    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Actions</th>
        </tr>

        <% if (students != null) {
            for (Student s : students) { %>

        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getFirstName() %></td>
            <td><%= s.getLastName() %></td>
            <td><%= s.getEmail() %></td>
            <td>
                <a href="student?action=edit&id=<%= s.getId() %>" class="btn">Edit</a>
                <a href="student?action=delete&id=<%= s.getId() %>"
                   class="btn btn-danger"
                   onclick="return confirm('Delete this student?')">
                   Delete
                </a>
            </td>
        </tr>

        <% } } %>
    </table>

</div>

</body>
</html>
