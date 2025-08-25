package com.project.ems.utility;

import com.project.ems.dto.*;
import com.project.ems.entity.*;

public class DTOToEntity {

    public static Employee convertToEmployee(EmployeeDTO employeeDto) {
        return Employee.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .phone(employeeDto.getPhone())
                .hireDate(employeeDto.getHireDate())
                .currentSalary(employeeDto.getCurrentSalary())
                .jobTitle(employeeDto.getJobTitleIdDTO())
                .department(employeeDto.getDepartmentDTO())
                .build();
    }
}