FROM openjdk:21-jdk-slim

WORKDIR /app

COPY mvnw .
COPY mvnw.cmd .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x ./mvnw

RUN ./mvnw dependency:go-offline -B

COPY src ./src

RUN ./mvnw clean package -DskipTests

EXPOSE 8100

CMD ["java", "-jar", "target/fruit-total-price-service-0.0.1-SNAPSHOT.jar"]
