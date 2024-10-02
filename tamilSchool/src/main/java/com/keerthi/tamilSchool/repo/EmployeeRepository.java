package com.keerthi.tamilSchool.repo;

import com.keerthi.tamilSchool.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
