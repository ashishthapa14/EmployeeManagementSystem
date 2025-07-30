package com.project.ems.controller;

import com.project.ems.dto.EmployeeDTO;
import com.project.ems.exception.EmployeeException;
import com.project.ems.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/employees")
    public ResponseEntity<List<EmployeeDTO>> getEmployee() throws EmployeeException {
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeeDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId) throws EmployeeException {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }

    @PostMapping(value = "/employees")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeDTO employeeDTO) throws EmployeeException {
        Long employeeId = employeeService.addEmployee(employeeDTO);
        String responseMessage = employeeId + " successfully added";
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId) throws EmployeeException {
        employeeService.deleteEmployee(employeeId);
        String responseMessage = employeeId + " successfully deleted";
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

}
