package com.project.ems.repository;

import com.project.ems.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceDAO extends JpaRepository<Attendance,Long> {
}
