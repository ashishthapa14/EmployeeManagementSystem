package com.project.ems;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ems.controller.EmployeeController;
import com.project.ems.dto.EmployeeDTO;
import com.project.ems.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateEmployee_whenValidEmployee_returns201() throws Exception {
        EmployeeDTO employeeDTO = EmployeeDTO.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .phone("1234567890")
                .hireDate(java.time.LocalDate.now())
                .departmentDTO(new com.project.ems.dto.DepartmentDTO(1L, "IT", "Information Technology"))
                .jobTitleIdDTO(new com.project.ems.dto.JobTitleDTO(1L, "Software Engineer", "Develops software"))
                .currentSalary(new java.math.BigDecimal("50000.00"))
                .employeeStatus(com.project.ems.entity.EmployeeStatus.ACTIVE)
                .build();

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employeeDTO)))
                .andExpect(status().isCreated());
    }

    @Test
    public void testCreateEmployee_whenInvalidEmployee_returns400() throws Exception {
        EmployeeDTO employeeDTO = EmployeeDTO.builder().build(); // Invalid DTO

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employeeDTO)))
                .andExpect(status().isBadRequest());
    }
}
