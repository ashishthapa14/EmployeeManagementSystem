
package com.project.ems.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AttendanceDTO {
    private Long id;
    private EmployeeDTO employeeDTO;
    private LocalDate date;
    private LocalTime checkIn;
    private LocalTime checkOut;
}
