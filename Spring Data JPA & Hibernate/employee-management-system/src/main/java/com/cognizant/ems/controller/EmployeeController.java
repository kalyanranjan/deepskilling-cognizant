package com.cognizant.ems.controller;

import com.cognizant.ems.entity.Employee;
import com.cognizant.ems.projection.EmployeeDto;
import com.cognizant.ems.projection.EmployeeProjection;
import com.cognizant.ems.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> getByDepartment(@PathVariable Long departmentId) {
        return employeeRepository.findByDepartmentId(departmentId);
    }

    @GetMapping("/search")
    public List<Employee> search(@RequestParam String name) {
        return employeeRepository.searchByName(name);
    }

    @GetMapping("/email/{email}")
    public Employee getByEmail(@PathVariable String email) {
        return employeeRepository.findByEmailNamed(email);
    }

    @GetMapping("/page")
    public Page<Employee> getPagedByDepartment(@RequestParam Long departmentId, Pageable pageable) {
        return employeeRepository.findByDepartmentId(departmentId, pageable);
    }

    @GetMapping("/sort")
    public List<Employee> getSorted(@RequestParam String name, Sort sort) {
        return employeeRepository.findByNameContaining(name, sort);
    }

    @GetMapping("/projections/interface/{departmentId}")
    public List<EmployeeProjection> getProjectedByDepartment(@PathVariable Long departmentId) {
        return employeeRepository.findProjectedByDepartmentId(departmentId);
    }

    @GetMapping("/projections/dto/{departmentId}")
    public List<EmployeeDto> getDtoByDepartment(@PathVariable Long departmentId) {
        return employeeRepository.findDtoByDepartmentId(departmentId);
    }
}
