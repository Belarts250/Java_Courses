package models;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PatientServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get form data
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        int age = 0;
        String ageParam = request.getParameter("age");
        if (ageParam != null && !ageParam.isEmpty()) {
            age = Integer.parseInt(ageParam);
        }
        String email = request.getParameter("email");

        // Create Patient object
        Patient patient = new Patient(firstName, lastName, age, email);

        // Save using Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(patient);
        tx.commit();
        session.close();

        // Send response
        response.setContentType("text/html");
        response.getWriter().println("<h3>Patient registered successfully!</h3>");
        response.getWriter().println("<a href='jsp/patientForm.jsp'>Register another patient</a>");
    }
}
