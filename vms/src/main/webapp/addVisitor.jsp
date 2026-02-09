<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Visitor - Ticket System</title>
    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #F9F7EC 0%, #F0EDE0 100%);
            min-height: 100vh; padding: 40px 20px;
        }
        .container { max-width: 700px; margin: 0 auto; }
        h2 { color: #470B18; font-size: 2.5em; text-align: center; margin-bottom: 30px; }

        /* Message/Ticket */
        .message {
            background: linear-gradient(145deg, #E8F5E8, #D4EDDA);
            border-left: 6px solid #28A745; padding: 25px; margin: 20px 0;
            border-radius: 10px; box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }
        .error {
            background: linear-gradient(145deg, #F8D7DA, #F5C6CB);
            border-left: 6px solid #DC3545;
        }
        .ticket {
            background: white; border: 3px solid #470B18;
            padding: 30px; margin: 20px 0; border-radius: 15px;
            font-family: 'Courier New', monospace; font-size: 1.1em;
            box-shadow: 0 10px 30px rgba(71,11,24,0.2);
        }

        /* Form */
        .form-group { margin-bottom: 25px; }
        label { display: block; color: #470B18; font-weight: 600; margin-bottom: 8px; font-size: 1.1em; }
        input, select {
            width: 100%; padding: 15px; font-size: 1.1em;
            border: 2px solid #E0D9C6; border-radius: 10px;
            transition: border-color 0.3s;
        }
        input:focus, select:focus { outline: none; border-color: #470B18; box-shadow: 0 0 10px rgba(71,11,24,0.2); }

        .btn {
            width: 100%; padding: 18px; font-size: 1.3em; font-weight: 700;
            background: linear-gradient(145deg, #470B18, #5A0D20); color: white;
            border: none; border-radius: 12px; cursor: pointer;
            transition: all 0.3s; box-shadow: 0 8px 25px rgba(71,11,24,0.3);
        }
        .btn:hover { transform: translateY(-2px); box-shadow: 0 12px 35px rgba(71,11,24,0.4); }

        .back-btn {
            display: inline-block; margin-top: 20px; padding: 12px 25px;
            background: #470B18; color: white; text-decoration: none;
            border-radius: 25px; font-weight: 600;
        }
        .back-btn:hover { background: #5A0D20; }
    </style>
</head>
<body>
    <div class="container">
        <h2>🎫 Issue Visitor Ticket</h2>

        <% if (request.getAttribute("message") != null) { %>
            <div class="message">
                <strong>✅ <%= request.getAttribute("message") %></strong>
                <div class="ticket">
                    <%= ((String) request.getAttribute("ticket")).replace("\n", "<br>") %>
                </div>
            </div>
        <% } %>

        <% if (request.getAttribute("error") != null) { %>
            <div class="message error">
                ❌ <%= request.getAttribute("error") %>
            </div>
        <% } %>

        <form method="get">
            <div class="form-group">
                <label>Full Name:</label>
                <input type="text" name="name" required pattern="[A-Za-z ]+">
            </div>
            <div class="form-group">
                <label>Visitor ID:</label>
                <input type="number" name="visitorId" required min="1">
            </div>
            <div class="form-group">
                <label>Purpose of Visit:</label>
                <select name="purpose" required>
                    <option value="">Select Purpose</option>
                    <option value="1">🏢 BUSINESS</option>
                    <option value="2">✈️ TOURISM</option>
                    <option value="3">📦 DELIVERY</option>
                    <option value="4">🎓 EDUCATION</option>
                    <option value="5">🤝 MEETING</option>
                    <option value="6">❓ OTHER</option>
                </select>
            </div>
            <button type="submit" class="btn">🎟️ Issue Ticket Now</button>
        </form>

        <a href="/" class="back-btn">🏠 Home</a>
    </div>
</body>
</html>
