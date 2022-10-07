FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/users-mysql.jar users-mysql.jar 
ENTRYPOINT ["java","-jar","/users-mysql.jar"]