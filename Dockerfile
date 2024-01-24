
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTest

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/vida-1.0.0.jar ./
EXPOSE 9090
RUN addgroup -S appgroup && adduser -S appuser -G appgroup \
    && chown -R appuser:appgroup /app
USER appuser
CMD ["java", "-jar", "vida-1.0.0.jar"]