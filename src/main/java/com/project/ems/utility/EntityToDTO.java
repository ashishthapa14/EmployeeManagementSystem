package com.project.ems.utility;

import com.project.ems.dto.*;
import com.project.ems.entity.*;

public class EntityToDTO {

    public static AddressDTO convertToAddressDto(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .employeeDTO(convertToEmployeeDto(address.getEmployee()))
                .addressLine1(address.getAddressLine1())
                .addressLine2(address.getAddressLine2())
                .city(address.getCity())
                .state(address.getState())
                .postalCode(address.getPostalCode())
                .country(address.getCountry())
                .build();
    }

    public static AttendanceDTO convertToAttendanceDto(Attendance attendance) {
        return AttendanceDTO.builder()
                .id(attendance.getId())
                .employeeDTO(convertToEmployeeDto(attendance.getEmployee()))
                .date(attendance.getDate())
                .checkIn(attendance.getCheckIn())
                .checkOut(attendance.getCheckOut())
                .build();
    }

    public static DepartmentDTO convertToDepartmentDto(Department department) {
        DepartmentDTO departmentDto = new DepartmentDTO();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        departmentDto.setDescription(department.getDescription());
        return departmentDto;
    }

    //Recursive Error Because Manager is Also an Employee
    public static EmployeeDTO convertToEmployeeDto(Employee employee) {
        return EmployeeDTO.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .phone(employee.getPhone())
                .hireDate(employee.getHireDate())
                .departmentDTO(convertToDepartmentDto(employee.getDepartment()))
                .jobTitleIdDTO(convertToJobTitleDto(employee.getJobTitle()))
                .currentSalary(employee.getCurrentSalary())
                .employeeStatus(employee.getEmployeeStatus())
                .build();
    }

    public static JobTitleDTO convertToJobTitleDto(JobTitle jobTitle) {
        JobTitleDTO jobTitleDto = new JobTitleDTO();
        jobTitleDto.setId(jobTitle.getId());
        jobTitleDto.setTitle(jobTitle.getTitle());
        jobTitleDto.setDescription(jobTitle.getDescription());
        return jobTitleDto;
    }

    public static LeaveRequestDTO convertToLeaveRequestDto(LeaveRequest leaveRequest) {
        return LeaveRequestDTO.builder()
                .id(leaveRequest.getId())
                .employeeDTO(convertToEmployeeDto(leaveRequest.getEmployee()))
                .startDate(leaveRequest.getStartDate())
                .endDate(leaveRequest.getEndDate())
                .reason(leaveRequest.getReason())
                .status(leaveRequest.getStatus())
                .build();
    }
}