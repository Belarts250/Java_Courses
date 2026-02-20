package DAO;

import model.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.Util;

import java.util.List;

public class StudentDAO {

    // CREATE
    public void saveStudent(Student student) {

        Session session = Util.getSessionFactory().openSession();
        // Open connection

        Transaction tx = session.beginTransaction();
        // Start transaction

        session.persist(student);
        // Save object to database

        tx.commit();
        // Commit changes

        session.close();
        // Close connection
    }

    // READ ALL
    public List<Student> getAllStudents() {

        Session session = Util.getSessionFactory().openSession();

        List<Student> students = session
                .createQuery("from Student", Student.class)
                .list();
        // HQL query (similar to SQL)

        session.close();

        return students;
    }

    // READ BY ID
    public Student getStudentById(int id) {

        Session session = Util.getSessionFactory().openSession();

        Student student = session.get(Student.class, id);
        // Fetch student by primary key

        session.close();

        return student;
    }

    // UPDATE
    public void updateStudent(Student student) {

        Session session = Util.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        session.merge(student);
        // Update existing record

        tx.commit();

        session.close();
    }

    // DELETE
    public void deleteStudent(int id) {

        Session session = Util.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);

        if (student != null) {
            session.remove(student);
        }

        tx.commit();

        session.close();
    }
}
