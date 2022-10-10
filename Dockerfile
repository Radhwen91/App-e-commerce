FROM maven:3.8.2-jdk-8

WORKDIR /spring-app
COPY . .

RUN mvn clean install
ADD target/tpAchatProject-0.0.1-SNAPSHOT.jar tpAchatProject-0.0.1-SNAPSHOT.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "tpAchatProject-0.0.1-SNAPSHOT.jar"]
CMD mvn spring-boot:run