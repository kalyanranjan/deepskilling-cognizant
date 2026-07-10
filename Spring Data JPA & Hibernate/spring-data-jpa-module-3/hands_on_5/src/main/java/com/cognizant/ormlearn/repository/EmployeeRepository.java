package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
