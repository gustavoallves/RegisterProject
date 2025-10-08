package com.example.registerspring.repository;

import com.example.registerspring.entity.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {

}