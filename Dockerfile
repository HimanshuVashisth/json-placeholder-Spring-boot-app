FROM openjdk:8-jdk-alpine
MAINTAINER Himanshu Vashisth
ENV env_name=dev
ADD /target/json-placeholder-spring-boot-app.jar spring-boot-app.jar
ENTRYPOINT ["java","-jar", "spring-boot-app.jar", "--spring.profiles.active=${env_name}"]
EXPOSE 8080