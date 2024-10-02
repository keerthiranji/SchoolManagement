
package com.keerthi.tamilSchool.service;

import com.keerthi.tamilSchool.exception.EmployeeNotFoundException;
import com.keerthi.tamilSchool.model.Employee;
import com.keerthi.tamilSchool.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepo;

    public Employee addData(Employee emp) {
        return employeeRepo.save(emp);
    }

    public List<Employee> getAllData() {
        return employeeRepo.findAll();
    }

    public Employee getData(Long id) {
        Optional<Employee> emp = employeeRepo.findById(id);
        if (emp.isPresent()) {
            return emp.get();
        } else {
            throw new EmployeeNotFoundException("Employee not found for the id " + id);
        }
    }

    public Employee updateData(Employee emp) {
        return employeeRepo.save(emp);
    }

    public String deleteData(Long id) {
        if (employeeRepo.existsById(id)) {
            employeeRepo.deleteById(id);
            return "Deleted Successufully for the id " + id;
        } else {
            throw new RuntimeException("Employee not found for the id" + id);
        }
    }
}