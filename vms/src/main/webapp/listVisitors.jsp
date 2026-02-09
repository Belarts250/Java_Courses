<%@ page import="com.example.model.*, java.util.List" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>All Visitors</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #F9F7EC 0%, #F0EDE0 100%);
            min-height: 100vh; padding: 40px 20px;
        }
        .container { max-width: 900px; margin: 0 auto; }
        h2 { color: #470B18; font-size: 2.8em; text-align: center; margin-bottom: 40px; }

        .visitor-card {
            background: white; border: 2px solid #E0D9C6;
            margin: 20px 0; padding: 30px; border-radius: 20px;
            box-shadow: 0 10px 40px rgba(71,11,24,0.1);
            font-family: 'Courier New', monospace;
        }
        .visitor-card:hover {
            border-color: #470B18; transform: translateY(-5px);
            box-shadow: 0 20px 50px rgba(71,11,24,0.2);
            transition: all 0.3s ease;
        }
        .visitor-header {
            color: #470B18; font-size: 1.4em; font-weight: 700; margin-bottom: 15px;
            padding-bottom: 10px; border-bottom: 3px solid #470B18;
        }
        .visitor-info { line-height: 1.8; color: #333; }

        .empty-state {
            text-align: center; color: #666; font-size: 1.3em;
            margin: 60px 0; padding: 40px;
            background: rgba(255,255,255,0.7); border-radius: 20px;
        }

        .stats {
            background: linear-gradient(145deg, #470B18, #5A0D20);
            color: white; padding: 20px; border-radius: 15px;
            margin-bottom: 40px; text-align: center;
        }
        .back-btn {
            display: inline-block; margin-top: 30px; padding: 15px 35px;
            background: #470B18; color: white; text-decoration: none;
            border-radius: 30px; font-weight: 700; font-size: 1.1em;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>📋 All Registered Visitors</h2>

        <div class="stats">
            Total Visitors: <%= ((List<Visitor>)request.getAttribute("visitors")).size() %>
        </div>

        <%
            List<Visitor> visitors = (List<Visitor>) request.getAttribute("visitors");
            if (visitors != null && !visitors.isEmpty()) {
                for (Visitor v : visitors) {
                    out.print("<div class='visitor-card'>");
                    out.print("<div class='visitor-header'>");
                    out.print("👤 " + v.getName() + " (ID: " + v.getId() + ")");
                    out.print("</div>");
                    out.print("<div class='visitor-info'>");
                    out.print(v.displayInfo().replace("\n", "<br>"));
                    out.print("</div>");
                    out.print("</div>");
                }
            } else {
        %>
            <div class="empty-state">
                <h3>📭 No visitors registered yet</h3>
                <p>Add your first visitor using the <strong>Add Visitor</strong> button on home page!</p>
            </div>
        <% } %>

        <a href="/" class="back-btn">🏠 Back to Home</a>
    </div>
</body>
</html>
