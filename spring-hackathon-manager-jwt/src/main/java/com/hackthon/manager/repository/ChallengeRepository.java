package com.hackthon.manager.repository;

import com.hackthon.manager.entity.Challenge;
import com.hackthon.manager.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<Challenge, Integer> {
    List<Challenge> findAllByOrderByCreationDateDesc();
    List<Challenge> findAllByOrderByVoteDesc();
    List<Challenge> findAllByOrderByCreationDateAsc();
    List<Challenge> findAllByOrderByVoteAsc();
}
