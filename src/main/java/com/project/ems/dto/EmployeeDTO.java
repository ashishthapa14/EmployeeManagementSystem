
package com.project.ems.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.ems.entity.EmployeeStatus;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {
    private Long id;
    @NotBlank(message = "First name is required")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "Phone number is required")
    private String phone;
    @NotNull(message = "Hire date is required")
    private LocalDate hireDate;
    @NotNull(message = "Department is required")
    @JsonProperty("department")
    private DepartmentDTO departmentDTO;
    @NotNull(message = "Job title is required")
    @JsonProperty("jobTitle")
    private JobTitleDTO jobTitleIdDTO;
    @NotNull(message = "Current salary is required")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")
    private BigDecimal currentSalary;
    @NotNull(message = "Employee status is required")
    @JsonProperty("status")
    private EmployeeStatus employeeStatus;
}
