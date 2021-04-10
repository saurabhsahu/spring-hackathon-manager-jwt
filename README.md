# spring-hackathon-manager-jwt
This project is to manage Hackathon Challenge in Organisation

This is Spring boot application made using Spring Security with JWT, in memory DB as H2.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them
```
You will need Java 8 and postman installed to run the application.
  
```
### Installing

A step by step series of examples that tell you how to get a development env running

```
need to put examples here
```
### Detail of Execution

Below are the steps to execute the application
```
If you are using generated jar 
  1. Double click on the executable jar spring-hackathon-manager-jwt-0.0.1-SNAPSHOT.jar
     Application will be started on http://localhost:9192/
  2. Use postman tool to authenticate the employee and using other REST End points
  
  http://localhost:9192/authenticate
  http://localhost:9192/addChallenge
  http://localhost:9192/getChallenges
  http://localhost:9192/challenges/6/castVote
  
if you want to copy project and run then below tools will be needed
  1. Maven 
  2. Any IDE (e.g. Intellij, Eclipse, STS)
  3. Import the project
  4. Run the project as spring boot application
  5. Application will be started on http://localhost:9192/
```

## Deployment

## Loggin to H2 database console when applcation is running
```
1. Hit URL http://localhost:9192/h2-console on browser, you will see H2 DB console to fill details
2. In Driver class put - org.h2.Driver
3. JDBC URL : jdbc:h2:mem:hackathon
4. User name : sa
5. Password should be blank
```

