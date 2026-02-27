package controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class addSub extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)throws IOException {
        int num1 = Integer.parseInt(req.getParameter("numa"));
        int num2 = Integer.parseInt(req.getParameter("numb"));


    }
}
