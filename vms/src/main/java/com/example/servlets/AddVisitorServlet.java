package com.example.servlets;  // Adjust package if needed

import com.example.dao.VisitorDao;
import com.example.model.Visitor;
import com.example.model.VisitorPurpose;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddVisitorServlet extends HttpServlet {
    private VisitorDao dao = new VisitorDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String name = req.getParameter("name");
            int visitorId = Integer.parseInt(req.getParameter("visitorId"));
            int purposeValue = Integer.parseInt(req.getParameter("purpose"));
            VisitorPurpose purpose = VisitorPurpose.fromValue(purposeValue);

            Visitor visitor = new Visitor(0, name, visitorId, purpose);  // id=0, auto-generated
            dao.addVisitor(visitor);

            // Success message using displayInfo()
            String ticket = visitor.displayInfo();

            req.setAttribute("message", "Visitor ticket issued successfully! ID: " + visitor.getId());
            req.setAttribute("ticket", ticket);

        } catch (IllegalArgumentException e) {
            req.setAttribute("error", " Invalid input: " + e.getMessage());
        } catch (Exception e) {
            req.setAttribute("error", " Database error: " + e.getMessage());
        }

        req.getRequestDispatcher("/addVisitor.jsp").forward(req, resp);
    }
}
