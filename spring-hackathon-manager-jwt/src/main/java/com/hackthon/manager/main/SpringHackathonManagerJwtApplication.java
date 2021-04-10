package com.hackthon.manager.main;

import com.hackthon.manager.entity.Employee;
import com.hackthon.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@EntityScan("com.hackthon.manager.entity")
@ComponentScan(basePackages = "com.hackthon.manager")
public class SpringHackathonManagerJwtApplication {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void initEmployees() {
		List<Employee> users = Stream.of(
				new Employee(1, "saurabh", "password",true),
				new Employee(2, "user1", "pwd1",true),
				new Employee(3, "user2", "pwd2",true),
				new Employee(4, "user3", "pwd3",true)
		).collect(Collectors.toList());
		repository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringHackathonManagerJwtApplication.class, args);
	}

}
