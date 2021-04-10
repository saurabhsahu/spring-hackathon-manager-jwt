package com.hackthon.manager.controlller;

import com.hackthon.manager.entity.AuthenticationRequest;
import com.hackthon.manager.entity.Challenge;
import com.hackthon.manager.service.ChallengeService;
import com.hackthon.manager.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public String addChallenge(@RequestBody Challenge challengeRequest) throws Exception {
        challengeService.addChallenge(challengeRequest);
        return "Challenge Added";
    }

    @GetMapping("/getChallenges")
    public List<Challenge> getAllChallenge() throws Exception {
        return challengeService.getChallenges();
    }

}
