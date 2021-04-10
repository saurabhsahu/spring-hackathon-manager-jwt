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
Apllication initialised with 4 Employee profile, below is rhe data with
EmployeeId, UserName, Password, ActiveStatus
Employee(1, "saurabh", "password",true),
Employee(2, "user1", "pwd1",true),
Employee(3, "user2", "pwd2",true),
Employee(4, "user3", "pwd3",true)

If you are using generated jar 
  1. Double click on the executable jar spring-hackathon-manager-jwt-0.0.1-SNAPSHOT.jar
     Application will be started on http://localhost:9192/
  2. Use postman tool to authenticate the employee and use generated token to call other REST End points
  
if you want to copy project and run then below tools will be needed
  1. Maven 
  2. Any IDE (e.g. Intellij, Eclipse, STS)
  3. Import the project
  4. Run the project as spring boot application
  5. Application will be started on http://localhost:9192/
  
 1. http://localhost:9192/authenticate
    Usage :
        Header :
        Content-Type:application/json
        Body content :
        {
          "employeeId":"1",
          "password":"password"
        }
    Response :
        eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxIiwiZXhwIjoxNjE4MDg0MTg3LCJpYXQiOjE2MTgwNDgxODd9.G3DMwbhDNsSbLBT63v2cYm0pJMKZ2c4Gf_7dzvZ49cc
  
 2. http://localhost:9192/addChallenge
     Usage :
            Header :
                Content-Type:application/json
                Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIiwiZXhwIjoxNjE4MDgxMDAwLCJpYXQiOjE2MTgwNDUwMDB9.D3l6vUEwLgWmRDBMi0t-bykWy__beCB5IWueBaQqAYM
            Body content :
               {
                "title" : "challemge3",
                "description" : "description 3",
                "tags" : [ "admin", "editor" , "test"]
                }
        Response :
            Challenge added successfully.
  3. http://localhost:9192/getChallenges
        Usage :
            Headers :
                Content-Type:application/json
                Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIiwiZXhwIjoxNjE4MDgxMDAwLCJpYXQiOjE2MTgwNDUwMDB9.D3l6vUEwLgWmRDBMi0t-bykWy__beCB5IWueBaQqAYM
            Body content :
            Response :
                    [
                        {
                            "id": 5,
                            "title": "challemge3",
                            "description": "description 3",
                            "tags": [
                                "admin",
                                "editor",
                                "test"
                            ],
                            "vote": 0,
                            "employeeId": 2,
                            "creation_date": "2021-04-10T09:40:31.593+00:00"
                        },
                        {
                            "id": 6,
                            "title": "challemge2",
                            "description": "description 2",
                            "tags": [
                                "admin",
                                "editor",
                                "role"
                            ],
                            "vote": 0,
                            "employeeId": 1,
                            "creation_date": "2021-04-10T09:51:22.222+00:00"
                        }
                    ]
  4. http://localhost:9192/challenges/6/castVote
           Usage :
                Header :
                    Content-Type:application/json
                    Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIiwiZXhwIjoxNjE4MDgxMDAwLCJpYXQiOjE2MTgwNDUwMDB9.D3l6vUEwLgWmRDBMi0t-bykWy__beCB5IWueBaQqAYM
                Body content :
                     
                Response :
                   New Vote is casted for challenge: 6
                Response 2 :
                    Challenge author can't vote his/her own challenge.
  
  
  5. http://localhost:9192/getChallengesSortAscVote
            Usage :
                Header :
                    Content-Type:application/json
                    Authorization:Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIiwiZXhwIjoxNjE4MDgxMDAwLCJpYXQiOjE2MTgwNDUwMDB9.D3l6vUEwLgWmRDBMi0t-bykWy__beCB5IWueBaQqAYM
                Body content :
                     
                Response :
                   [
                        {
                            "id": 7,
                            "title": "challemge3",
                            "description": "description 3",
                            "tags": [
                                "admin",
                                "editor",
                                "test"
                            ],
                            "vote": 0,
                            "employeeId": 2,
                            "creationDate": "2021-04-10T13:29:20.191+00:00"
                        },
                        {
                            "id": 8,
                            "title": "challemge5",
                            "description": "description 4",
                            "tags": [
                                "admin",
                                "editor"
                            ],
                            "vote": 0,
                            "employeeId": 2,
                            "creationDate": "2021-04-10T13:29:21.400+00:00"
                        },
                        {
                            "id": 6,
                            "title": "challemge8",
                            "description": "description 8",
                            "tags": [
                                "admin",
                                "editor",
                                "test"
                            ],
                            "vote": 1,
                            "employeeId": 2,
                            "creationDate": "2021-04-10T13:29:18.541+00:00"
                        },
                        {
                            "id": 5,
                            "title": "challemge6",
                            "description": "description 6",
                            "tags": [
                                "admin",
                                "editor",
                                "test"
                            ],
                            "vote": 2,
                            "employeeId": 2,
                            "creationDate": "2021-04-10T13:29:16.612+00:00"
                        }
                    ]  
                    
  
   6. http://localhost:9192/getChallengesSortDescVote
   7. http://localhost:9192/getChallengesSortAscCreationDate
   8. http://localhost:9192/getChallengesSortDescCreationDate
```

## Deployment

## Login to H2 database console when application is running
```
1. Hit URL http://localhost:9192/h2-console on browser, you will see H2 DB console to fill details
2. In Driver class put - org.h2.Driver
3. JDBC URL - jdbc:h2:mem:hackathon
4. User name - sa
5. Password should be blank
```

