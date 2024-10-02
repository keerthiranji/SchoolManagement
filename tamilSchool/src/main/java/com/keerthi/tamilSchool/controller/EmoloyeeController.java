package com.keerthi.tamilSchool.controller;

import com.keerthi.tamilSchool.model.Employee;
import com.keerthi.tamilSchool.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmoloyeeController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/officeEmp")
    public Employee addValues(@RequestBody Employee emp){
        employeeService.addData(emp);
        return emp;
    }

    @GetMapping("/officeEmployees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllData();
    }

    @GetMapping("/officeEmp/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getData(id);
    }

    @PutMapping("/officeEmp")
    public Employee updateEmployee(@RequestBody Employee emp) {
        return employeeService.updateData(emp);
    }

    @DeleteMapping("/officeEmp/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return employeeService.deleteData(id);
    }
}
