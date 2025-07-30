package com.project.ems.repository;

import com.project.ems.entity.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleDAO extends JpaRepository<JobTitle,Long> {
}
