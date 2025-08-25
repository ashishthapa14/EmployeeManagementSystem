package com.project.ems.utility;

import com.project.ems.dto.*;
import com.project.ems.entity.*;

public class EntityToDTO {

    //Recursive Error Because Manager is Also an Employee
    public static EmployeeDTO convertToEmployeeDto(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .hireDate(employee.getHireDate())
                .departmentDTO(employee.getDepartment())
                .jobTitleIdDTO(employee.getJobTitle())
                .currentSalary(employee.getCurrentSalary())
                .build();
    }
}