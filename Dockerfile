#FROM openjdk:17-jdk-alpine
FROM openjdk:17-oracle
MAINTAINER Miguel Vieyra <aleviemk@gmail.com>
# a default value
ENV MONGO_HOSTNAME mongodb+srv://mvieyrar:eXtend2016@cluster0.s2gkz05.mongodb.net/unam
ENV MONGO_DB unam
ENV MONGO_USER mvieyrar
ENV MONGO_PWD eXtend2016
ENV TOMCAT_PORT 8080
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
CMD ["java","-jar","/app.jar"]
