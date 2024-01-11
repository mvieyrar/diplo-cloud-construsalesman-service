# Usa la imagen oficial de Maven como imagen base
FROM docker.io/maven:3.8.4-openjdk-17-slim AS build
MAINTAINER Miguel Vieyra <aleviemk@gmail.com>

# Copia los archivos de configuración y el código fuente
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

# Establece el directorio de trabajo
WORKDIR /usr/src/app

# Variables de entorno
ENV MONGO_HOSTNAME mongodb+srv://mvieyrar:eXtend2016@cluster0.s2gkz05.mongodb.net/unam
ENV MONGO_DB unam
ENV MONGO_USER mvieyrar
ENV MONGO_PWD eXtend2016
ENV TOMCAT_PORT 8080

# Compila la aplicación
RUN mvn clean install

# Cambia a una imagen más ligera de Java para la ejecución
# FROM docker.io/openjdk:17-jre-slim

# Copia el archivo JAR generado en la etapa anterior
#COPY /usr/src/app/target/construsalesman-service-0.0.1-SNAPSHOT.jar /app/construsalesman.jar

# Expone el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación al iniciar el contenedor.
CMD ["java", "-jar", "/usr/src/app/target/construsalesman-service-0.0.1-SNAPSHOT.jar"]
