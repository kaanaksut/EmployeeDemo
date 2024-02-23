package com.Kaan.demoKaan.repository;

import com.Kaan.demoKaan.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    // sorgu eklemek istersek buraya yazabiliriz.....
}
