package com.hackthon.manager.service;

import com.hackthon.manager.entity.Employee;
import com.hackthon.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;


@Service
public class EmployeeDetailsService implements UserDetailsService {
    
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String employeeId) throws UsernameNotFoundException {
        Optional<Employee> user = repository.findById(Integer.parseInt(employeeId));
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + employeeId));
        return new org.springframework.security.core.userdetails.User(String.valueOf(user.get().getId()), user.get().getPassword(), new ArrayList<>());
    }
   /* @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Test");
        Optional <Employee> user = repository.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        return new org.springframework.security.core.userdetails.User(user.get().getUserName(), user.get().getPassword(), new ArrayList<>());
    }*/

}