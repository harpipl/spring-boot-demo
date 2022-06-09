FROM openjdk:17

EXPOSE 8080

ARG JAR_FILE=*.jar
COPY maven/${JAR_FILE} application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]