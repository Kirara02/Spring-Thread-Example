package com.kirara.docker_test.controllers;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kirara.docker_test.entities.Employee;
import com.kirara.docker_test.services.EmployeeAsyncService;

// import com.kirara.docker_test.entities.Employee;
// import com.kirara.docker_test.services.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    
    // @Autowired
    // private EmployeeService employeeService;

    // @GetMapping
    // public List<Employee> getAllEmployees() {
    //     return employeeService.getAllEmployees();
    // }

    // @GetMapping("/{id}")
    // public Optional<Employee> getEmployeeById(@PathVariable Long id) {
    //     return employeeService.getEmployeeById(id);
    // }

    // @PostMapping
    // public Employee createEmployee(@RequestBody Employee employee) {
    //     return employeeService.saveEmployee(employee);
    // }

    // @PutMapping("/{id}")
    // public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
    //     employee.setId(id);
    //     return employeeService.saveEmployee(employee);
    // }

    // @DeleteMapping("/{id}")
    // public void deleteEmployee(@PathVariable Long id) {
    //     employeeService.deleteEmployee(id);
    // }
    

    @Autowired
    private EmployeeAsyncService employeeAsyncService;


    @GetMapping
    public CompletableFuture<List<Employee>> getAllEmployees() {
        return employeeAsyncService.getAllEmployeesAsync();
    }

    @GetMapping("/{id}")
    public CompletableFuture<Optional<Employee>> getEmployeeById(@PathVariable Long id) {
        return employeeAsyncService.getEmployeeByIdAsync(id);
    }

    @PostMapping
    public CompletableFuture<Employee> createEmployee(@RequestBody Employee employee) {
        return employeeAsyncService.saveEmployeeAsync(employee);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<Void> deleteEmployee(@PathVariable Long id) {
        return employeeAsyncService.deleteEmployeeAsync(id);
    }

}
