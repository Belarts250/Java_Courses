package controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        int result = (Integer) request.getAttribute("result");

        out.println("<h2>Result: " + result + "</h2>");
        out.println("<a href='calculator.jsp'>Back</a>");
     }
}
