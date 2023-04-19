
FROM amazoncorretto:17-alpine-jdk
MAINTAINER daichiora
COPY target/ap.jar portfolio.jar
ENTRYPOINT ["java", "-jar", "/portfolio.jar"]

