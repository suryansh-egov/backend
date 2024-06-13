package org.egov.backassign.service;


import org.egov.backassign.entity.Employee;
import org.egov.backassign.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {

//        List<Employee> employees = employeeRepository.findAll();
//        for (Employee employee : employees) {
//            System.out.println("ID: " + employee.getId());
//            System.out.println("First Name: " + employee.getFirstName());
//            System.out.println("Last Name: " + employee.getLastName());
//            System.out.println("Email: " + employee.getEmail());
//            System.out.println("Department: " + employee.getDepartment());
//            System.out.println("Salary: " + employee.getSalary());
//            System.out.println();
//        }
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id).orElse(null);
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id).orElse(null);
        if (existingEmployee != null) {
            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            existingEmployee.setEmail(employee.getEmail());
            existingEmployee.setDepartment(employee.getDepartment());
            existingEmployee.setSalary(employee.getSalary());
            return employeeRepository.save(existingEmployee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}