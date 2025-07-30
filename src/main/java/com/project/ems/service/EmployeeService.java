package com.project.ems.service;

import com.project.ems.dto.EmployeeDTO;
import com.project.ems.exception.EmployeeException;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees() throws EmployeeException;
    EmployeeDTO getEmployeeById(Long employeeId) throws EmployeeException;
    Long addEmployee(EmployeeDTO employeeDTO) throws EmployeeException;
    Long updateEmployee(EmployeeDTO employeeDTO) throws EmployeeException;
    Long deleteEmployee(Long employeeId) throws EmployeeException;

}
