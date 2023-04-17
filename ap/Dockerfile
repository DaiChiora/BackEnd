
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template
#COPY . /app
#WORKDIR /app
#RUN ./mvnw package
#EXPOSE 8080
#CMD ["java", "-jar", "target/my-app.jar"]

#COPY target/WG-0.0.1-SNAPSHOT.jar /app.jar
#FROM alpine:latest
#EXPOSE 8080
#CMD ["java", "-jar", "target/my-app.jar"]
#FROM amazoncorretto:11-alpine-jdk

FROM amazoncorretto:8-alpine-jdk
MAINTAINER daichiora
COPY target/ap-0.0.1-SNAPSHOT.jar portfolio.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

