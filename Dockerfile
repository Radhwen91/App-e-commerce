FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/users-mysql-1.0.jar users-mysql-1.0.jar 
ENTRYPOINT ["java","-jar","/users-mysql-1.0.jar"]