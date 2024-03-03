FROM openjdk:17-jdk-slim
COPY /target/c16-32-m-java-0.0.1-SNAPSHOT.jar chatbeat.jar
ENTRYPOINT ["java", "-jar", "/chatbeat.jar"]