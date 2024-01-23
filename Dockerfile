FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/vida-1.0.0.jar vida-1.0.0.jar
EXPOSE 9090
CMD [ "java","-jar", "vida-1.0.0.jar"]