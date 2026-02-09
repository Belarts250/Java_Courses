package com.example.dao;

import com.example.model.Visitor;
import com.example.model.VisitorPurpose;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class VisitorDao {
    private Properties props;

    public VisitorDao() {
        props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) throw new RuntimeException("db.properties not found");
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(props.getProperty("db.url"),
                props.getProperty("db.username"), props.getProperty("db.password"));
    }

    public void addVisitor(Visitor visitor) {
        String sql = "INSERT INTO visitors (name, visitor_id, purpose) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, visitor.getName());  // From Person
            pstmt.setInt(2, visitor.getVisitor_id());
            pstmt.setString(3, visitor.getPurpose().name());  // Enum to String
            pstmt.executeUpdate();
            try (ResultSet rs = pstmt.getGeneratedKeys()) {
                if (rs.next()) visitor.setId(rs.getInt(1));  // Set Person id
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Visitor> getAllVisitors() {
        List<Visitor> visitors = new ArrayList<>();
        String sql = "SELECT * FROM visitors ORDER BY created_at DESC";
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                VisitorPurpose purpose = VisitorPurpose.valueOf(rs.getString("purpose"));
                Visitor v = new Visitor(rs.getInt("id"), rs.getString("name"), rs.getInt("visitor_id"), purpose);
                visitors.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return visitors;
    }
}
