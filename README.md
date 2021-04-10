# spring-hackathon-manager-jwt
This project is to manage Hackathon Challenge in Organisation

This is Spring boot application made using Spring Security with JWT, in memory DB as H2.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them
```
You will need Java 8 installed to run the application.
if you want to copy project and run then below tools will be needed
  1. Maven 
  2. Any IDE (e.g. Intellij, Eclipse, STS)
```

### Installing

A step by step series of examples that tell you how to get a development env running

```
need to put examples here
```

## Deployment

## Loggin to H2 database console when applcation is running
```
1. Hit URL http://localhost:9192/h2-console  on browser, you will see H2 DB console to fill details
2. in Driver class put : org.hr.Driver
3. JDBC URL : jdbc:h2:mem:hackathon
4. User name : sa
5. password should be blank
```

