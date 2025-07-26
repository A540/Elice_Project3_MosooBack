FROM openjdk:17-jdk-slim-buster

COPY build/libs/mosoo-backend-0.0.1-SNAPSHOT.jar app.jar

RUN echo "docker"

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]