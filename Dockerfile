FROM openjdk:8-jdk-alpine
EXPOSE 8089
RUN cp -r target/tpAchatProject-1.0.jar 
ADD target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar 
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]