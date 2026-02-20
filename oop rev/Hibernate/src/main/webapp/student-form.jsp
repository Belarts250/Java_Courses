<%@ page import="model.Student" %>

<%
    Student student = (Student) request.getAttribute("student");
    boolean isEdit = (student != null);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Student Form</title>
    <style>
        body {
            font-family: Arial;
            background: linear-gradient(to right, #141E30, #243B55);
            padding: 20px;
            color: white;
        }

        .container {
            width: 40%;
            margin: auto;
            background: white;
            padding: 30px;
            border-radius: 10px;
            color: black;
        }

        input {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
        }

        .btn {
            padding: 10px;
            background: #00f6ff;
            border: none;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }

        .back {
            display: block;
            margin-top: 15px;
            text-decoration: none;
        }
    </style>
</head>
<body>

<div class="container">
    <h2><%= isEdit ? "Edit Student" : "Add New Student" %></h2>

    <form action="student" method="post">

        <% if (isEdit) { %>
            <input type="hidden" name="id" value="<%= student.getId() %>"/>
            <input type="hidden" name="action" value="update"/>
        <% } else { %>
            <input type="hidden" name="action" value="create"/>
        <% } %>

        <input type="text" name="firstName"
               placeholder="First Name"
               value="<%= isEdit ? student.getFirstName() : "" %>" required/>

        <input type="text" name="lastName"
               placeholder="Last Name"
               value="<%= isEdit ? student.getLastName() : "" %>" required/>

        <input type="email" name="email"
               placeholder="Email"
               value="<%= isEdit ? student.getEmail() : "" %>" required/>

        <button type="submit" class="btn">
            <%= isEdit ? "Update" : "Save" %>
        </button>

    </form>

    <a href="student" class="back"> Back to List</a>
</div>

</body>
</html>
