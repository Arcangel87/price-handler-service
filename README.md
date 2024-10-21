# Price Handler Service
## Overview
The Price Handler Service is a Spring Boot microservice designed to manage and query price data for products in an 
e-commerce system. It follows a hexagonal architecture (DDD) to ensure a clean separation of concerns and maintainability. 
Requirement can be found here: [Requirements.md](Requirements.md)

## Features
- **REST API:** Provides endpoints to query price data.
- **Database:** Uses an in-memory H2 database for simplicity and ease of testing.
- **Exception Handling:** Utilizes `@ControllerAdvice` for global exception handling.
- **Dockerized:** Can be easily run in a Docker container.

## Prerequisites
- Java 17+
- Maven 3.6+
- Docker
- Docker Compose

## Getting Started
Clone the Repository </br>
`git clone https://github.com/yourusername/price-handler-service.git` </br>
`cd price-handler-service`

## Build the Project
Use Maven to build the project:</br>
`mvn clean package`

## Run the Application
Run `internal.ecommerce.pricehandlerPriceHandlerRunner.java`

or You can run the application using Docker Compose:</br>

`docker-compose up --build` </br>

This will build the Docker image and start the application on port 8080.

## Accessing the Application
The application exposes a REST endpoint to query prices:

**Endpoint:** /price </br>
**Method:** GET </br>
**Parameters:**
- productId (Long)
- brandId (Long)
- applicationDate (ISO 8601 format)

**Example request:**

`curl "http://localhost:8080/price?productId=35455&brandId=1&applicationDate=2020-06-14T10:00:00"`

## Accessing the H2 Database
The H2 database console can be accessed at:

- **URL:** http://localhost:8080/h2-console
- **JDBC URL:** jdbc:h2:mem:testdb
- **Username:** sa
- **Password:** password

## Accessing Swagger Documentation
Swagger documentation can be accessed at:

- **URL:** http://localhost:8080/swagger-ui.html

To disable it on application.yml change `springdoc.swagger-ui.enabled` to false

## Running Tests
To run the tests, use the following Maven command: </br>

`mvn test`

## Project Structure
```src
src
├── main
│   ├── docker
│   │   └── Dockerfile
│   ├── java
│   │   └── internal
│   │       └── ecommerce
│   │           └── pricehandler
│   │               ├── domain
│   │               │   ├── model
│   │               │   │   ├── Brand.java
│   │               │   │   ├── Price.java
│   │               │   │   └── Product.java
│   │               │   ├── repository
│   │               │   │   ├── BrandRepository.java
│   │               │   │   ├── PriceRepository.java
│   │               │   │   └── ProductRepository.java
│   │               │   └── service
│   │               │       └── PriceService.java
│   │               └── infrastructure
│   │                   ├── controller
│   │                   │   └── PriceController.java
│   │                   └── exception
│   │               │       └── GlobalExceptionHandler.java
│   │               └── PriceHandlerRunner.java
│   └── resources
│       ├── application.yml
│       └── data.sql
└── test
    └── java
        └── internal
            └── ecommerce
                └── pricehandler
                    └── domain
                        └── service
                            └── PriceServiceTest.java
                    └── infrastructure
                        └── controller
                            └── PriceControllerTest.java
                    └── integration
                        └── PriceHandlerServiceIntegration.java
docker-compose.yml

```

## Acknowledgments
- Spring Boot
- H2 Database
- Docker