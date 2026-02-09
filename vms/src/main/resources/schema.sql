CREATE TABLE visitors (
    id SERIAL PRIMARY KEY,  -- personId from Person
    name VARCHAR(100) NOT NULL,  -- fullName from Person
    visitor_id INTEGER NOT NULL UNIQUE,
    purpose VARCHAR(20) NOT NULL,  -- Stores enum name like 'BUSINESS'
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Sample data
INSERT INTO visitors (name, visitor_id, purpose) VALUES
('John Doe', 1001, 'BUSINESS'),
('Jane Smith', 1002, 'MEETING');
