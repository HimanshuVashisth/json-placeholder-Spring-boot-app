# json-placeholder-Spring-boot-app
This Spring boot application publishes RESTful API endpoints between the data source (https://jsonplaceholder.typicode.com/) and the front-end.

In the project directory, you can run:
### `mvn clean install`
### `java -jar target/json-placeholder-Spring-boot-app.jar`

Application should be up & running. 

To confirm open browser & go to : http://localhost:8080/swagger-ui.html#

Docker steps:

## `docker build -t spring-boot-app .`

## `docker images`

## `docker tag spring-boot-app hvashistha54/spring-boot-app`

## `docker push hvashistha54/spring-boot-app`

clear local docker images using ## `docker rmi <image-name>`
  
## `docker run -p 8080:8080 hvashistha54/spring-boot-app`

Application should be up & running. 

To confirm open browser & go to : http://localhost:8080/swagger-ui.html#
