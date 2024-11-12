package com.example.hrisproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hrisproject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
