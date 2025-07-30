package com.project.ems.repository;

import com.project.ems.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentDAO extends JpaRepository<Department,Long> {

}
