USE student_management_db;

CREATE TABLE IF NOT EXISTS students (

    id INT AUTO_INCREMENT PRIMARY KEY,

    name VARCHAR(100) NOT NULL,

    age INT NOT NULL,

    branch VARCHAR(50) NOT NULL,

    email VARCHAR(100) UNIQUE,

    phone VARCHAR(15) UNIQUE,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);