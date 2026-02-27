package controller;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

public class Calculator extends HttpServlet {
    public void service(ServletRequest req, ServletResponse respo) throws IOException {
        int firstNum = Integer.parseInt(req.getParameter("bNum"));
        int lastNum = Integer.parseInt(req.getParameter("iNum"));

        int sum = firstNum + lastNum;

        PrintWriter output = respo.getWriter();

        respo.setContentType("text/html");

        output.println("the answer is" + sum);
        System.out.println("The sum on console is " + sum);
    }
}
