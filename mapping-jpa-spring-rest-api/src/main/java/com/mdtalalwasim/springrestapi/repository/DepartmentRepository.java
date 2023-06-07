package com.mdtalalwasim.springrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mdtalalwasim.springrestapi.entity.Department;

@Repository 
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
