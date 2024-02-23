package com.Kaan.demoKaan.service;

import com.Kaan.demoKaan.model.Employee;
import com.Kaan.demoKaan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    public Employee updateEmployeeName(Long employeeId, String newFirstName, String newLastName) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(employeeId);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setFirstName(newFirstName);
            employee.setLastName(newLastName);
            return employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found with id: " + employeeId);
        }
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + employeeId));
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void updateEmployee(Long id, Employee employee) {
    }
}
