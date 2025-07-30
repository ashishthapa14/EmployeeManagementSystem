package com.project.ems.repository;

import com.project.ems.entity.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRequestDAO extends JpaRepository<LeaveRequest,Long> {
}
