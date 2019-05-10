# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy WAR into image
COPY spring-boot-app-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 10000

# rum application with this command line
CMD ["usr/bin/java", "-jar", "/app.jar"]
