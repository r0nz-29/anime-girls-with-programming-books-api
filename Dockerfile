FROM amazoncorretto:11-alpine-jdk
MAINTAINER raunit
COPY target/anime-girls-0.0.1-SNAPSHOT.jar anime-girls-0.0.1.jar
ENTRYPOINT ["java","-jar","/anime-girls-0.0.1.jar"]