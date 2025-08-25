# Employee Management System

This is a simple Employee Management System built with Spring Boot. It allows for basic CRUD operations on employees.

## Features

*   List all employees
*   Add a new employee
*   Update an existing employee
*   Delete an employee

## Technologies Used

*   Java 17
*   Spring Boot
*   Spring Data JPA
*   Thymeleaf
*   MySQL
*   Maven
*   Lombok

## Setup and Installation

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/EmployeeManagementSystem.git
    ```
2.  **Navigate to the project directory:**
    ```bash
    cd EmployeeManagementSystem
    ```
3.  **Update the database configuration:**
    Open `src/main/resources/application.properties` and update the following properties with your MySQL database credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/your-database-name
    spring.datasource.username=your-username
    spring.datasource.password=your-password
    ```
4.  **Run the application:**
    ```bash
    ./mvnw spring-boot:run
    ```
    The application will be available at `http://localhost:8080`.

## API Endpoints

The application provides the following RESTful endpoints:

### Web (Thymeleaf)

*   `GET /api/list`: Displays a list of all employees.
*   `GET /api/showFormForAdd`: Displays a form to add a new employee.
*   `POST /api/save`: Saves a new or updated employee.
*   `GET /api/showFormForUpdate?employeeId={id}`: Displays a form to update an existing employee.
*   `GET /api/delete?employeeId={id}`: Deletes an employee.

### REST API

*   `GET /api/employees`: Returns a list of all employees.
*   `GET /api/employees/{id}`: Returns a specific employee by their ID.
*   `POST /api/employees`: Adds a new employee.
*   `DELETE /api/employees/{id}`: Deletes an employee by their ID.

## Usage

You can use the web interface to manage employees by navigating to `http://localhost:8080/api/list`.

Alternatively, you can use a tool like Postman or curl to interact with the REST API.
