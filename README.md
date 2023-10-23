# Geekseat Sorcerer Saga

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 17](https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.exe)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.geekseat.sorcerer.saga.GeekseatSorcererSagaApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Test Application

For the front display i use React JS. Spring Boot here functions as a server and service api.
The results can be seen in the browser with the default application configuration which will run at the URL http://localhost:8080
or can be set in [application.properties](src%2Fmain%2Fresources%2Fapplication.properties)
