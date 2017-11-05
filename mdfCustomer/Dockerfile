FROM openjdk:8
COPY build/libs/mdfCustomer-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar", "--eureka.instance.hostname=192.168.99.100", "--eureka.client.serviceUrl.defaultZone=http://192.168.99.100:8761/eureka/"]