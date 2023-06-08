# Build stage
FROM maven AS build
WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests

# Final image stage
FROM openjdk:17
COPY --from=build /app/target/backend-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
