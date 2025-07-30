
package com.project.ems.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.ems.entity.EmployeeStatus;
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
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private LocalDate hireDate;
    @JsonProperty("department")
    private DepartmentDTO departmentDTO;
    @JsonProperty("jobTitle")
    private JobTitleDTO jobTitleIdDTO;
    private BigDecimal currentSalary;
    @JsonProperty("status")
    private EmployeeStatus employeeStatus;
}
