package controller;

import DAO.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.util.List;

@WebServlet("/student")   // URL mapping
public class StudentController extends HttpServlet {

    // DAO object to interact with database
    private StudentDAO studentDAO;

    // Initialize DAO when servlet starts
    @Override
    public void init() {
        studentDAO = new StudentDAO();
    }

    // ============================
    // HANDLE GET REQUESTS
    // ============================
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        // If no action provided → default to list
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {

                case "new":
                    showNewForm(request, response);
                    break;

                case "edit":
                    showEditForm(request, response);
                    break;

                case "delete":
                    deleteStudent(request, response);
                    break;

                default:
                    listStudents(request, response);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // ============================
    // HANDLE POST REQUESTS
    // ============================
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        try {
            if ("create".equals(action)) {
                insertStudent(request, response);
            } else if ("update".equals(action)) {
                updateStudent(request, response);
            } else {
                listStudents(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    // ============================
    // LIST ALL STUDENTS
    // ============================
    private void listStudents(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Student> students = studentDAO.getAllStudents();

        // Send student list to JSP
        request.setAttribute("studentList", students);

        request.getRequestDispatcher("index.jsp")
                .forward(request, response);
    }

    // ============================
    // SHOW CREATE FORM
    // ============================
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("student-form.jsp")
                .forward(request, response);
    }

    // ============================
    // SHOW EDIT FORM
    // ============================
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        Student existingStudent = studentDAO.getStudentById(id);

        request.setAttribute("student", existingStudent);

        request.getRequestDispatcher("student-form.jsp")
                .forward(request, response);
    }

    // ============================
    // INSERT NEW STUDENT
    // ============================
    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Student newStudent = new Student(firstName, lastName, email);

        studentDAO.saveStudent(newStudent);

        // Redirect to list page after saving
        response.sendRedirect("student");
    }

    // ============================
    // UPDATE STUDENT
    // ============================
    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        Student student = new Student(firstName, lastName, email);
        student.setId(id);

        studentDAO.updateStudent(student);

        response.sendRedirect("student");
    }

    // ============================
    // DELETE STUDENT
    // ============================
    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        studentDAO.deleteStudent(id);

        response.sendRedirect("student");
    }
}
