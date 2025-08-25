package com.project.ems.controller;

import com.project.ems.dto.EmployeeDTO;
import com.project.ems.exception.EmployeeException;
import com.project.ems.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployee() throws EmployeeException {
        log.info("Received request to get all employees");
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
        log.info("Returning all employees");
        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeException {
        log.info("Received request to get employee with id: {}", employeeId);
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        log.info("Returning employee with id: {}", employeeId);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<String> addEmployee(@Valid @RequestBody EmployeeDTO employeeDTO) throws EmployeeException {
        log.info("Received request to add new employee");
        Long employeeId = employeeService.addEmployee(employeeDTO);
        String responseMessage = employeeId + " successfully added";
        log.info("Employee with id: {} added successfully", employeeId);
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) throws EmployeeException {
        log.info("Received request to delete employee with id: {}", employeeId);
        employeeService.deleteEmployee(employeeId);
        String responseMessage = employeeId + " successfully deleted";
        log.info("Employee with id: {} deleted successfully", employeeId);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}
