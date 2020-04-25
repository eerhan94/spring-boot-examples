package com.example.redis.repository;

import com.example.redis.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmployeeRepository {
    private static final AtomicLong idGenerator = new AtomicLong();
    private static final Map<Long, Employee> EMPLOYEE_MAP = new HashMap<>();

    public List<Employee> getEmployees() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new ArrayList<>(EMPLOYEE_MAP.values());
    }

    public void save(Employee employee) {
        employee.setId(idGenerator.incrementAndGet());
        EMPLOYEE_MAP.put(employee.getId(), employee);
    }
}