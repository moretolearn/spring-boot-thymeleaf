package com.moretolearn.curd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moretolearn.curd.models.*;

@Repository
public interface EmployeeReposiotory extends JpaRepository<Employee, EmployeePK> {

}
