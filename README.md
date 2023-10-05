# Getting Started

## Project
Implementation of construsalesman microservice for the Construsales application. The notification will be created for the following event:

* Salesman Register

The following scripts are provided for the MongoDB database/collections creation:

* construsalesmandb_creation.js
  
## Deploy

// TODO

## Test
Execute the next `curl` command to validate the deploy of the service.
```
curl -X 'POST' \
  'http://localhost:8083/api/vendedores' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
    "nombre": "Miguel Alejandro",
    "paterno": "Vieyra",
    "materno": "Rivera",
    "sucursal": "Mexico",
    "claveagente": "MIVI",
    "objetivo": 1000000,
    "venta": 999000
}'
```
The expected result should looks like:
```
{
    "id": "651e2892a76c343fff4e55b6",
    "nombre": "Miguel Alejandro",
    "paterno": "Vieyra",
    "materno": "Rivera",
    "sucursal": "Mexico",
    "claveagente": "MIVI",
    "objetivo": 1000000.0,
    "venta": 999000.0
}
```
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.15/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#web)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.7.15/reference/htmlsingle/index.html#data.nosql.mongodb)
* [Mongo Docker Official Image](https://hub.docker.com/_/mongo)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)https://spring.io/guides/tutorials/rest/
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)https://spring.io/guides/gs/accessing-data-mongodb/
