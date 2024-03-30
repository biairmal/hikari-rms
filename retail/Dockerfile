FROM maven:3.9.6-eclipse-temurin-21-alpine as build
ENV MAVEN_CONFIG=~/.m2

RUN mkdir -p /usr/local/content/app
ADD ./ /usr/local/content/app
WORKDIR /usr/local/content/app
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
EXPOSE 8080
COPY --from=build /usr/local/content/app/target/*.jar hikari-rms.jar
ENTRYPOINT ["java","-jar","/hikari-rms.jar"]
