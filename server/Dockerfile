FROM maven:3-eclipse-temurin-21-alpine AS builder
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn package -DskipTests

FROM openjdk:21-jdk
COPY --from=builder /app/target/server-0.0.1-SNAPSHOT.jar app.jar
CMD ["java","-jar","app.jar"]