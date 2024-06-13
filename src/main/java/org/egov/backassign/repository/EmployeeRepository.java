package org.egov.backassign.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.egov.backassign.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
