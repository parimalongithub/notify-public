FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean spring-boot:run


FROM  openjdk:17.0.1-jdk-slim
COPY --from=build /target/-0.0.1-SNAPSHOT.jar demo.jar


