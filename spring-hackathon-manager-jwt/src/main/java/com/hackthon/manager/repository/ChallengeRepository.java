package com.hackthon.manager.repository;

import com.hackthon.manager.entity.Challenge;
import com.hackthon.manager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {

}
