package com.kirara.docker_test.services;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kirara.docker_test.entities.Employee;
import com.kirara.docker_test.repositories.EmployeeRepository;

@Service
public class EmployeeAsyncService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Executor taskExecutor;

    public CompletableFuture<List<Employee>> getAllEmployeesAsync() {
        return CompletableFuture.supplyAsync(() -> employeeRepository.findAll(), taskExecutor);
    }

    public CompletableFuture<Optional<Employee>> getEmployeeByIdAsync(Long id) {
        return CompletableFuture.supplyAsync(() -> employeeRepository.findById(id), taskExecutor);
    }

    public CompletableFuture<Employee> saveEmployeeAsync(Employee employee) {
        return CompletableFuture.supplyAsync(() -> employeeRepository.save(employee), taskExecutor);
    }

    public CompletableFuture<Void> deleteEmployeeAsync(Long id) {
        return CompletableFuture.runAsync(() -> employeeRepository.deleteById(id), taskExecutor);
    }


}
