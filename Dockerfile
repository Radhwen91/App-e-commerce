FROM openjdk:8-jdk-alpine
EXPOSE 8089
ADD target/tpAchatProject-1.0-SNAPSHOTS.jar tpAchatProject-1.0-SNAPSHOTS.jar 
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0-SNAPSHOTS.jar"]
