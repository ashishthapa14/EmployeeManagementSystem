CREATE TABLE employee (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          first_name VARCHAR(50) NOT NULL,
                          last_name VARCHAR(50) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          phone VARCHAR(20),
                          hire_date DATE NOT NULL,
                          department VARCHAR(100),
                          job_titled VARCHAR(100) NOT NULL,
                          current_salary DECIMAL(10,2)
);
