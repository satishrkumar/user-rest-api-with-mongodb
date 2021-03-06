# user-rest-api-with-mongodb
test project where we have full CRUD operation with API test
[![Build Status][travis-badge]][travis-badge-url]


`

#### Swagger UI Static Resources
1. Download the Swagger UI static resources from [here](https://github.com/swagger-api/swagger-ui)
1. Copy the downloaded resources to `/target/classes/static` folder.
1. Rename the `index.html` in `/target/classes/static` to `swagger-ui.html`.
1. Replace the `http://petstore.swagger.io/v2/swagger.json` string in
`swagger-ui.html` to `swagger.json`.

In this example, all these changes are executed dynamically during the 
build process by the plugins specified in `pom.xml`.

By default, Spring Boot configures the Jersey servlet container as a [servlet](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-jersey).

```
You also need the following dependency to view `swagger-ui.html`, 

```

### Build
To build the JAR, execute the following command from the parent directory:

```
mvn clean install
```

### Run
To run the application fromm command line,

```
java -jar target/com.ssaa.mongo.demo-1.0-SNAPSHOT.jar

Open JDK (openjdk version "12.0.1" 2019-04-16)

java -Djdk.tls.client.protocols=TLSv1.2 -jar target/com.ssaa.mongo.demo-1.0-SNAPSHOT.jar

```

### Access Swagger Endpoints

##### Swagger UI
You can view the Swagger UI at `http://localhost:9081/swagger-ui.html`.

![](./img/swagger-ui.png)


[travis-badge]: https://travis-ci.org/indrabasak/spring-jersey-swagger-example.svg?branch=master
[travis-badge-url]: https://travis-ci.org/indrabasak/spring-jersey-swagger-example/
