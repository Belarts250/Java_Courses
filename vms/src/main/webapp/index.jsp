<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Visitor Management System</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #F9F7EC 0%, #F0EDE0 100%);
            min-height: 100vh;
            padding: 40px 20px;
        }
        .container {
            max-width: 800px; margin: 0 auto; text-align: center;
        }
        h1 {
            color: #470B18; font-size: 3em; font-weight: 700;
            text-shadow: 2px 2px 4px rgba(71,11,24,0.3);
            margin-bottom: 40px;
        }
        .btn {
            display: inline-block; padding: 15px 30px;
            margin: 15px; font-size: 1.2em; font-weight: 600;
            color: white; background: linear-gradient(145deg, #470B18, #5A0D20);
            border: none; border-radius: 50px; cursor: pointer;
            text-decoration: none; transition: all 0.3s ease;
            box-shadow: 0 8px 25px rgba(71,11,24,0.3);
        }
        .btn:hover {
            transform: translateY(-3px); box-shadow: 0 12px 35px rgba(71,11,24,0.4);
            background: linear-gradient(145deg, #5A0D20, #470B18);
        }
        .header-line {
            width: 200px; height: 4px; background: linear-gradient(90deg, #470B18, transparent);
            margin: 20px auto;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🏛️ Visitor Management System</h1>
        <div class="header-line"></div>
        <a href="add" class="btn">➕ Add Visitor & Issue Ticket</a>
        <a href="list" class="btn">📋 View All Visitors</a>
        <div class="header-line"></div>
        <p style="color: #666; margin-top: 30px; font-size: 1.1em;">Powered by JSP • Servlets • Java Threads</p>
    </div>
</body>
</html>
