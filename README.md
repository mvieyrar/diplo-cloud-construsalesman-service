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

### Guides
