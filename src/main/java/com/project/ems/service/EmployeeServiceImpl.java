package com.project.ems.service;

import com.project.ems.dto.EmployeeDTO;
import com.project.ems.entity.Employee;
import com.project.ems.exception.EmployeeException;
import com.project.ems.repository.EmployeeDAO;
import com.project.ems.utility.DTOToEntity;
import com.project.ems.utility.EntityToDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service(value = "employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() throws EmployeeException {
        List<Employee> employeeList = employeeDAO.findAll();
        List<EmployeeDTO> employeeDTOList = employeeList.stream()
                .filter(Objects::nonNull)
                .map(EntityToDTO::convertToEmployeeDto)
                .toList();
        if(employeeDTOList.isEmpty()) throw new EmployeeException("{employee.not.found}");
        return employeeDTOList;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) throws EmployeeException {
        Optional<Employee> employeeOptional = employeeDAO.findById(employeeId);
        Employee employee = employeeOptional.orElseThrow(() -> new EmployeeException("List is not found"));
        return EntityToDTO.convertToEmployeeDto(employee);

    }

    @Override
    @Transactional
    public Long addEmployee(EmployeeDTO employeeDTO) throws EmployeeException {
        Optional<Employee> employeeOptional = employeeDAO.findById(employeeDTO.getId());
        if(employeeOptional.isPresent()) throw new EmployeeException("{employee.already.exists}");
        Employee employee = DTOToEntity.convertToEmployee(employeeDTO);
        return employeeDAO.save(employee).getId();
    }

    @Override
    public Long updateEmployee(EmployeeDTO employeeDTO) throws EmployeeException {
        return 0L;
    }

    @Override
    @Transactional
    public Long deleteEmployee(Long employeeId) throws EmployeeException {
        Optional<Employee> employeeOptional = employeeDAO.findById(employeeId);
        Employee employee = employeeOptional.orElseThrow(() -> new EmployeeException("{employee.not.found}"));
        employeeDAO.delete(employee);
        return employeeId;
    }
}
