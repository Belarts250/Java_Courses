package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Student st1 = new Student("Melissa", "Shami");
        Student st2 = new Student("Sandrine", "Utuje");
        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);

        req.setAttribute("students", students);
        req.getRequestDispatcher("display.jsp").forward(req, res);
    }
}
