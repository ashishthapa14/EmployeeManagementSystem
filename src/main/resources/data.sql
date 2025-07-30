-- Create Department Table
CREATE TABLE department (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            name VARCHAR(100) NOT NULL,
                            description TEXT
);

-- Create Job Title Table
CREATE TABLE job_title (
                           id INT PRIMARY KEY AUTO_INCREMENT,
                           title VARCHAR(100) NOT NULL,
                           description TEXT
);

-- Create Employee Table
CREATE TABLE employee (
                          id INT PRIMARY KEY AUTO_INCREMENT,
                          first_name VARCHAR(50) NOT NULL,
                          last_name VARCHAR(50) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          phone VARCHAR(20),
                          hire_date DATE NOT NULL,
                          department_id INT,
                          job_title_id INT,
                          manager_id INT,
                          current_salary DECIMAL(10,2),
                          status ENUM('ACTIVE', 'INACTIVE', 'ON_LEAVE') DEFAULT 'ACTIVE',
                          FOREIGN KEY (department_id) REFERENCES department(id),
                          FOREIGN KEY (job_title_id) REFERENCES job_title(id),
                          FOREIGN KEY (manager_id) REFERENCES employee(id)
);

-- Create Address Table
CREATE TABLE address (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         employee_id INT,
                         address_line1 VARCHAR(255),
                         address_line2 VARCHAR(255),
                         city VARCHAR(100),
                         state VARCHAR(100),
                         postal_code VARCHAR(20),
                         country VARCHAR(100),
                         FOREIGN KEY (employee_id) REFERENCES employee(id)
);

-- Create Salary History Table
CREATE TABLE salary_history (
                                id INT PRIMARY KEY AUTO_INCREMENT,
                                employee_id INT,
                                salary DECIMAL(10,2),
                                start_date DATE,
                                end_date DATE,
                                FOREIGN KEY (employee_id) REFERENCES employee(id)
);

-- Create Attendance Table
CREATE TABLE attendance (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            employee_id INT,
                            date DATE,
                            check_in TIME,
                            check_out TIME,
                            FOREIGN KEY (employee_id) REFERENCES employee(id)
);

-- Create Leave Request Table
CREATE TABLE leave_request (
                               id INT PRIMARY KEY AUTO_INCREMENT,
                               employee_id INT,
                               start_date DATE,
                               end_date DATE,
                               reason TEXT,
                               status ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING',
                               FOREIGN KEY (employee_id) REFERENCES employee(id)
);
