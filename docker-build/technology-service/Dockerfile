FROM openjdk:8-jdk-alpine
COPY target/technology-service-0.0.1-SNAPSHOT.war app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom -Djava.net.preferIPv4Stack=true","-jar","/app.jar"]