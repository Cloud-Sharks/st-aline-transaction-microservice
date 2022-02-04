FROM openjdk:8-jdk-alpine
COPY ./transaction-microservice/target/transaction-microservice-0.1.0.jar app.jar
ENV APP_PORT 8072
ENTRYPOINT ["java", "-jar", "/app.jar"]