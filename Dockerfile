FROM eclipse-temurin:21
WORKDIR /app
COPY target/user-registration-app-1.0.0.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
