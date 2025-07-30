package com.project.ems.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "leave_request")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

    private LocalDate startDate;
    private LocalDate endDate;
    @Column(columnDefinition = "Text")
    private String reason;

    @Enumerated(EnumType.STRING)
    private EmployeeLeaveStatus status = EmployeeLeaveStatus.PENDING;
}
