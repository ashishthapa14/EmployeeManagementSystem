
package com.project.ems.dto;

import com.project.ems.entity.EmployeeLeaveStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeaveRequestDTO {
    private Long id;
    private EmployeeDTO employeeDTO;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private EmployeeLeaveStatus status;
}
