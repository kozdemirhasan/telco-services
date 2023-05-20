FROM maven:3.5.2-jdk-8-alpine AS Build
COPY . /tmp/
WORKDIR /tmp/
RUN mvn clean package -DskipTests=true

FROM openjdk:8-jdk-alpine AS Run
COPY --from=Build /tmp/target/telco-services-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT java -jar /app.jar  