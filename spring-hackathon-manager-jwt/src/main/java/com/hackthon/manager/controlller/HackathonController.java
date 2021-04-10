package com.hackthon.manager.controlller;

import com.hackthon.manager.entity.AuthenticationRequest;
import com.hackthon.manager.entity.Challenge;
import com.hackthon.manager.service.ChallengeService;
import com.hackthon.manager.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class HackathonController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ChallengeService challengeService;

    @GetMapping("/Welcome")
    public String welcome() {
        return "Welcome to Hackathon Manager !!";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getEmployeeId(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw   new Exception("Invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getEmployeeId());
    }

    @PostMapping("/addChallenge")
    public String addChallenge(@RequestBody Challenge challengeRequest) {
        challengeRequest.setCreationDate(new Date());
        challengeRequest.setEmployeeId(Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName()));
        challengeService.addChallenge(challengeRequest);
        return "Challenge added successfully.";
    }

    @GetMapping("/getChallenges")
    public List<Challenge> getAllChallenge() {
        return challengeService.getChallenges();
    }
    @GetMapping("/getChallengesSortAscVote")
    public List<Challenge> getAllChallengeSortAscVote() {
        return challengeService.getChallengesSortByAscOnVote();
    }

    @GetMapping("/getChallengesSortDescVote")
    public List<Challenge> getAllChallengeSortDescVote() {
        return challengeService.getChallengesSortByDescOnVote();
    }

    @GetMapping("/getChallengesSortAscCreationDate")
    public List<Challenge> getAllChallengeSortAscCreationDate() {
        return challengeService.getChallengesSortByAscOnCreationDate();
    }

    @GetMapping("/getChallengesSortDescCreationDate")
    public List<Challenge> getAllChallengeSortDescCreationDate() {
        return challengeService.getChallengesSortByDescOnCreationDate();
    }

    @PostMapping("challenges/{challengeId}/castVote")
    public String castVote(@PathVariable("challengeId") int challengeId) throws Exception {
        Optional<Challenge> challenge=  challengeService.getChallengebyId(challengeId);
        challenge.orElseThrow(() -> new EntityNotFoundException("Not found: " + challengeId));
        int voteCount= challenge.get().getVote();
        int loggedInEmployeeId= Integer.parseInt(SecurityContextHolder.getContext().getAuthentication().getName());
        if(challenge.get().getEmployeeId()!=loggedInEmployeeId){
            Challenge challengeLocal = challenge.get();
            voteCount++;
            challengeLocal.setVote(voteCount);
            challengeService.updateVoteCountForChallenge(challengeLocal);
            return "New Vote is casted for challenge: "+challengeId;
        }
       else{
           return "Challenge author can't vote his/her own challenge.";
        }
    }

}
