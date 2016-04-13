# Spring-REST-Seed

A simple getting started project to help you understand a simple Spring Boot Project. 

| Detail | Version  |
|---------------|----------------|
| Maven    |   3.3.7   |
| JDK    |   1.8   |


## Run the app:

```
docker-compose up
```


### To build

```
docker-compose run --rm web mvn package
```

* war file is at: `target/{{artifactId}}-{{version}}.jar`

### To test

```
docker-compose run --rm web mvn test
```

**Generate a coverage report:**

```
docker-compose run --rm web mvn cobertura:cobertura
```

* Covertura report is at: `target/site/cobertura/index.html `

### To run

```
docker-compose up
```

## Getting started with Spring boot

To see how this application was built. See: [Building a RESTful Service](https://spring.io/guides/gs/rest-service/)

### A quick overview if testing. 

* Code lives in: `src/main/{package}/{file}.java`
* Tests lives in: `src/test/{package}/{file}Test.java`
