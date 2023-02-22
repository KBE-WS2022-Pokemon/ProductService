FROM maven:3-openjdk-17 AS MAVEN_ENV

EXPOSE 8084
WORKDIR /app

COPY target/product-service-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
