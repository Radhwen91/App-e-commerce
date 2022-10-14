FROM openjdk:8-jdk-alpine
EXPOSE 8089
RUN cp -r public/dist/* www/
ADD target/tpAchatProject-1.0.jar tpAchatProject-1.0.jar 
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0.jar"]