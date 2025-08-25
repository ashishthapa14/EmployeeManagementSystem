package com.project.ems.controller;

import com.project.ems.dto.EmployeeDTO;
import com.project.ems.exception.EmployeeException;
import com.project.ems.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
@Slf4j
@Validated
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/list")
    public String listEmployees(Model model) throws EmployeeException{
        log.info("Received request to get all employees");
        List<EmployeeDTO> employeeDTOList = employeeService.getAllEmployees();
        log.info("Returning {} employees",employeeDTOList.size());
        model.addAttribute("employeeDTO",employeeDTOList);
        return "list-emps";
    }

    @GetMapping(value = "/showFormForAdd")
    public String showFormForAdd(Model model){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        model.addAttribute("employeeDTO",employeeDTO);
        return "employee-form";
    }

    @PostMapping(value = "/save")
    public String saveEmployee(@ModelAttribute("employeeDTO") @Valid @RequestBody EmployeeDTO employeeDTO) throws EmployeeException {
        log.info("Received request to add new employee");
        Long employeeId = employeeService.addEmployee(employeeDTO);
        String responseMessage = employeeId + " successfully added";
        log.info("Employee with id: {} added successfully", employeeId);
        return "redirect:/api/list";
    }

    @GetMapping(value = "/showFormForUpdate")
    public String showFormUpdate(@RequestParam("employeeId") Long theId, Model model) throws EmployeeException{
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(theId);
        model.addAttribute("employeeDTO",employeeDTO);
        return "employee-form";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") Long theId) throws EmployeeException {
        log.info("Received request to delete employee with id: {}", theId);
        employeeService.deleteEmployee(theId);
        log.info("Employee with id: {} deleted successfully", theId);
        return "redirect:/api/list";
    }
}
