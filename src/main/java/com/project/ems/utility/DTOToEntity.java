package com.project.ems.utility;

import com.project.ems.dto.*;
import com.project.ems.entity.*;

public class DTOToEntity {

    public static Address convertToAddress(AddressDTO addressDto) {
        return Address.builder()
                .id(addressDto.getId())
                .addressLine1(addressDto.getAddressLine1())
                .addressLine2(addressDto.getAddressLine2())
                .city(addressDto.getCity())
                .state(addressDto.getState())
                .postalCode(addressDto.getPostalCode())
                .country(addressDto.getCountry())
                .employee(convertToEmployee(addressDto.getEmployeeDTO()))
                .build();
    }

    public static Attendance convertToAttendance(AttendanceDTO attendanceDto) {
        return Attendance.builder()
                .id(attendanceDto.getId())
                .date(attendanceDto.getDate())
                .checkIn(attendanceDto.getCheckIn())
                .checkOut(attendanceDto.getCheckOut())
                .employee(convertToEmployee(attendanceDto.getEmployeeDTO()))
                .build();
    }

    public static Department convertToDepartment(DepartmentDTO departmentDto) {
        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        department.setDescription(departmentDto.getDescription());
        return department;
    }

    public static Employee convertToEmployee(EmployeeDTO employeeDto) {
        return Employee.builder()
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .phone(employeeDto.getPhone())
                .hireDate(employeeDto.getHireDate())
                .currentSalary(employeeDto.getCurrentSalary())
                .employeeStatus(employeeDto.getEmployeeStatus())
                .jobTitle(convertToJobTitle(employeeDto.getJobTitleIdDTO()))
                .department(convertToDepartment(employeeDto.getDepartmentDTO()))
                .build();
    }

    public static JobTitle convertToJobTitle(JobTitleDTO jobTitleDto) {
        JobTitle jobTitle = new JobTitle();
        jobTitle.setId(jobTitleDto.getId());
        jobTitle.setTitle(jobTitleDto.getTitle());
        jobTitle.setDescription(jobTitleDto.getDescription());
        return jobTitle;
    }

    public static LeaveRequest convertToLeaveRequest(LeaveRequestDTO leaveRequestDto) {
        return LeaveRequest.builder()
                .id(leaveRequestDto.getId())
                .startDate(leaveRequestDto.getStartDate())
                .endDate(leaveRequestDto.getEndDate())
                .reason(leaveRequestDto.getReason())
                .status(leaveRequestDto.getStatus())
                .employee(convertToEmployee(leaveRequestDto.getEmployeeDTO()))
                .build();
    }
}