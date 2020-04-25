package com.example.redis.service;

import com.example.redis.model.Employee;
import com.example.redis.repository.EmployeeRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Cacheable("employeeCache")
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployees();
    }

    @CacheEvict(value = "employeeCache", allEntries = true)
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}