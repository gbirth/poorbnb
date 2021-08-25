FROM openjdk:11-jre

ARG JAVA_RESOURCES=target/*.jar
COPY ${JAVA_RESOURCES} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]