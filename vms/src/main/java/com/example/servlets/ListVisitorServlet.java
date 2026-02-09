package com.example.servlets;

import com.example.model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListVisitorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Visitor> all = VisitorModel.getInstance().getAll();
        req.setAttribute("visitors", all);
        req.getRequestDispatcher("/listVisitors.jsp").forward(req, resp);
    }
}
