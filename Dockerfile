
FROM amazoncorretto:17-alpine-jdk
MAINTAINER daichiora
COPY out/artifacts/ap_jar/ap.jar portfolio.jar
ENTRYPOINT ["java", "-jar", "/portfolio.jar"]

