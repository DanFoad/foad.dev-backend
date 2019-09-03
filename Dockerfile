FROM openjdk:8-jre-slim

ADD foad.dev-backend-app/build/libs/foad.dev-backend-app-all.jar /usr/local/backend-app-all.jar

CMD ["java", "-jar", "/usr/local/backend-app-all.jar"]

EXPOSE 8080