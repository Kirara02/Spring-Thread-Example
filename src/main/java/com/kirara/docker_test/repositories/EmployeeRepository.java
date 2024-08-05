package com.kirara.docker_test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kirara.docker_test.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    
}
