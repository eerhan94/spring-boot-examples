package com.example.redis;

import com.example.redis.model.Employee;
import com.example.redis.service.EmployeeService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class SpringBootStarterDataRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStarterDataRedisApplication.class, args);
    }

    @Bean
    ApplicationRunner runner(EmployeeService employeeService) {
        return args -> {
            employeeService.save(new Employee("John"));
            employeeService.save(new Employee("Danny"));
        };
    }

}
