package com.project.ems.repository;

import com.project.ems.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressDAO extends JpaRepository<Address,Long> {
}
