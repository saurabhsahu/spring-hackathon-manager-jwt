package com.hackthon.manager.repository;

import com.hackthon.manager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByUserName(String username);
   // Optional<Employee> findById(Integer id);


}