#Creates layer from the openjdk:8-jdk-alpine Docker image
FROM openjdk:8-jdk-alpine

#creates a directory from where tomcat creates it's own working directories
VOLUME /tmp

#set from where to get the variable values (jar in our case)
ARG JAR_FILE='target/*.jar'

#copy the jar file to the container renames as spring-hackathon-manager.jar
COPY ${JAR_FILE} spring-hackathon-manager.jar

#execute that jar in the entry point below
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-hackathon-manager.jar"]