# Getting Started

## Project
Implementation of construsalesman microservice for the Construsales application. The notification will be created for the following event:

* Salesman Register

The following scripts are provided for the MongoDB database/collections creation:

* construsalesmandb_creation.js

The instructions to execute manually this microservice are:
1.	Clone the git repo to your local repo.
2.	Copy the folder to your Eclipse workspace.
3.	Open Eclipse IDE and import project.
4.	Update Maven project.
5.	Open a Mongo client and execute the script resources/db/mongo/construsalesmandb_creation.js
6.	Run As Maven Build … , put spring-boot: run in Goals. Then go to Environment tab and configure the following variables:
MONGO_AUTHDB
MONGO_DB
MONGO_HOSTNAME
MONGO_PORT
MONGO_PWD
MONGO_USER
TOMCART_PORT
7.	Open a REST client software, introduce the URL http://localhost:8080/api/vendedores from localhost or http://k8s.nuup.ninja/api/vendedores from Web  . Choose POST method and introduce the following JSON in the body:
{
    "nombre":"Miguel Alejandro",
    "paterno": "Vieyra",
    "materno": "Rivera",
    "sucursal": "Mexico",
    "claveagente": "MIVI",
    "objetivo": 1000000,
    "venta": 999000
}
8.	When you press SEND button, response will retrieve 201 code and the inserted JSON object.
9.	You can also see the inserted document in the Mongo client with the following queries:
use construsalesmandb;
db.vendedor.find();

For more details, please refer to Instructions_for_execution.docx file.

For the API documentation, please refer to api.yaml file.


## Deploy

This image is based on docker.io/aleviemk/construsalesman-app-user18

The complete specification of the image that contains the application is in ./Dockerfile

* Docker Hub image: docker pull aleviemk/construsalesman-app-user18:v11
* Kubernetes deployment file: construsalesman-deployment.yaml
* Kubernetes service file: construsalesman-service.yaml
* Kubernetes ingress file: construsalesman-ingress.yaml
* Apply Kubernetes resources:
    * kubectl apply -f construsalesman-deployment.yaml
    * kubectl apply -f construsalesman-service.yaml
    * kubectl apply -f construsalesman-ingress.yaml
* Verify deployment:
    * kubectl get pods | grep construsalesman
    * kubectl get services | grep construsalesman
    * kubectl get ingress | gre construsalesman

With final CI/CD project all of these deployment tasks now run automatically when pushing to this repository from your local one a Tekton event listener is triggered by GitHub Webhook request.
Such trigger executes tasks like clone, compile, create image, push this image and deploy to OpenShift.

For more info read the file: Demostracion_de_Proyecto_Final_Vieyra_Rivera_Miguel_Alejandro.pdf

## Test within pod
To enter to pod execute the folllowing command:
kubectl exec -it <podname> -- /bin/bash

## Test
Execute the next `curl` command to validate the deploy of the service from localhost.
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
Execute the next `curl` command to validate the deploy of the service from Web.
```
curl -X 'POST' \
  'http://k8s.nuup.ninja/api/vendedores' \
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
 

> cafaray: Project revision
