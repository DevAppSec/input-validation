FROM gradle:6.3-jdk13 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build --no-daemon

FROM openjdk:13-jdk-alpine
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/input-validation.jar
ENTRYPOINT ["java", "-jar", "/app/input-validation.jar"]