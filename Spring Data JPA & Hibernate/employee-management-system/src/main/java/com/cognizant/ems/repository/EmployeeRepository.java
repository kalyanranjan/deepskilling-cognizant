package com.cognizant.ems.repository;

import com.cognizant.ems.entity.Employee;
import com.cognizant.ems.projection.EmployeeDto;
import com.cognizant.ems.projection.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartmentId(Long departmentId);

    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
    List<Employee> searchByName(@Param("name") String name);

    Employee findByEmailNamed(String email);

    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    List<Employee> findByNameContaining(String name, Sort sort);

    List<EmployeeProjection> findProjectedByDepartmentId(Long departmentId);

    @Query("SELECT new com.cognizant.ems.projection.EmployeeDto(e.name, e.email) FROM Employee e WHERE e.department.id = :departmentId")
    List<EmployeeDto> findDtoByDepartmentId(@Param("departmentId") Long departmentId);
}
