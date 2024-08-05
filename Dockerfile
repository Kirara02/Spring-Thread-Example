# Use the official Maven image to build the project
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Use the official OpenJDK 21 image to run the application
FROM openjdk:21-slim
WORKDIR /app
COPY --from=build /app/target/docker_test-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
