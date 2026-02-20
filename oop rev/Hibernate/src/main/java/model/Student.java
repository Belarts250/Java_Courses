package model;

import jakarta.persistence.*;   // Import JPA annotations

@Entity                     // Marks this class as a database table
@Table(name = "students")   // Table name in database
public class Student {

    @Id                                         // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Auto increment ID (PostgreSQL SERIAL behavior)
    private int id;

    @Column(name = "first_name")  // Column name in database
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    // Empty constructor (required by Hibernate)
    public Student() {}

    // Constructor without id (used when creating new student)
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters and Setters (Hibernate uses them to access fields)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
