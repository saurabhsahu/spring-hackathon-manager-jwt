package com.hackthon.manager.service;

import com.hackthon.manager.entity.Challenge;
import com.hackthon.manager.repository.ChallengeRepository;
import com.hackthon.manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeService {

    @Autowired
    private ChallengeRepository repository;

    public void addChallenge(Challenge challenge){
        repository.save(challenge);
    }
    public List<Challenge> getChallenges(){
        return repository.findAll();
    }
}
