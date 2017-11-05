FROM openjdk:8-alpine
COPY build/libs/mdfDiscovery-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "app.jar"]