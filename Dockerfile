FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/certifact_boletas_service_sp-0.0.1.jar
COPY ${JAR_FILE} boletas_service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "boletas_service.jar"]