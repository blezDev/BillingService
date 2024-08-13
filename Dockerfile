FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY target/billing-service-0.0.1-SNAPSHOT.jar /app/billing-service.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "billing-service.jar"]
