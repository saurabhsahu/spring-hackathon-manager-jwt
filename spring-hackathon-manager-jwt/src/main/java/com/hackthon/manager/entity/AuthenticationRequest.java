package com.hackthon.manager.entity;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {


    private String employeeId;
    private String password;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //need default constructor for JSON Parsing
    public AuthenticationRequest()
    {

    }
    public AuthenticationRequest(String employeeId, String password) {
        this.employeeId = employeeId;
        this.password = password;
    }
}
