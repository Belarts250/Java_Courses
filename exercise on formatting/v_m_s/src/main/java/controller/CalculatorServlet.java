package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int number1 = Integer.parseInt(request.getParameter("number1"));
        int number2 = Integer.parseInt(request.getParameter("number2"));

        String operation = request.getParameter("operation");

        int result  = 0;

        switch (operation){
            case "add":
                result = number1 + number2;
                break;
            case "sub" :
                result = number1 - number2;
                break;
            case "mul" :
                result = number1 * number2;
                break;
            case "div" :
                result = number1 / number2;
        }
        request.setAttribute("result", result);

        RequestDispatcher rd = request.getRequestDispatcher("ResultServlet");
        rd.forward(request, response);
    }

}
