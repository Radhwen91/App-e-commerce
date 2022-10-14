FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/tpAchatProject-1.0-SNAPSHOT.jar tpAchatProject-1.0-SNAPSHOT.jar 
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0-SNAPSHOT.jar"]