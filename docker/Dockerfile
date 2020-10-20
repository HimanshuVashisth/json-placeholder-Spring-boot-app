FROM openjdk:8-jdk-alpine
MAINTAINER Himanshu Vashisth
ENV env_name=dev
ARG JAR_FILE=json-placeholder-spring-boot-app.jar
COPY ${JAR_FILE} json-placeholder-spring-boot-app.jar
ENTRYPOINT ["java","-jar", "/json-placeholder-spring-boot-app.jar", "--spring.profiles.active=${env_name}"]
EXPOSE 8080