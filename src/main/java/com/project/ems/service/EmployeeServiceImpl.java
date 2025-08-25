package com.project.ems.service;

import com.project.ems.dto.EmployeeDTO;
import com.project.ems.entity.Employee;
import com.project.ems.exception.EmployeeException;
import com.project.ems.repository.EmployeeDAO;
import com.project.ems.utility.DTOToEntity;
import com.project.ems.utility.EntityToDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service(value = "employeeService")
@PropertySource("classpath:message.properties")
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;
    private Environment environment;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO, Environment environment) {
        this.employeeDAO = employeeDAO;
        this.environment = environment;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getAllEmployees() throws EmployeeException {
        log.info("Fetching all employees");
        List<Employee> employeeList = employeeDAO.findAll();
        List<EmployeeDTO> employeeDTOList = employeeList.stream()
                .filter(Objects::nonNull)
                .map(EntityToDTO::convertToEmployeeDto)
                .toList();
        if(employeeDTOList.isEmpty()) {
            log.warn("No employees found");
            throw new EmployeeException("List is not found");
        }
        log.info("Returning {} employees", employeeDTOList.size());
        return employeeDTOList;
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) throws EmployeeException {
        log.info("Fetching employee with id: {}", employeeId);
        Optional<Employee> employeeOptional = employeeDAO.findById(employeeId);
        Employee employee = employeeOptional.orElseThrow(() -> {
            log.error("Employee not found with id: {}", employeeId);
            return new EmployeeException(environment.getProperty("employee.not.found"));
        });
        log.info("Returning employee with id: {}", employeeId);
        return EntityToDTO.convertToEmployeeDto(employee);

    }

    @Override
    @Transactional(rollbackFor = EmployeeException.class)
    public Long addEmployee(EmployeeDTO employeeDTO) throws EmployeeException {
        log.info("Adding new employee");
        Employee employee = DTOToEntity.convertToEmployee(employeeDTO);
        Long employeeId = employeeDAO.save(employee).getId();
        log.info("Employee added with id: {}", employeeId);
        return employeeId;
    }

    //TODO: Update method is not implemented.
    @Override
    public Long updateEmployee(EmployeeDTO employeeDTO) throws EmployeeException {
        return 0L;
    }

    @Override
    @Transactional(rollbackFor = EmployeeException.class)
    public Long deleteEmployee(Long employeeId) throws EmployeeException {
        log.info("Deleting employee with id: {}", employeeId);
        Optional<Employee> employeeOptional = employeeDAO.findById(employeeId);
        Employee employee = employeeOptional.orElseThrow(() -> {
            log.error("Employee not found with id: {}", employeeId);
            return new EmployeeException(environment.getProperty("employee.not.found"));
        });
        employeeDAO.delete(employee);
        log.info("Employee with id: {} deleted successfully", employeeId);
        return employeeId;
    }
}
