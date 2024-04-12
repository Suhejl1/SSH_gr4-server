# SSH_gr4-server

# Bookstore Project - Server Side

This project constitutes the server-side component of the Bookstore project, developed using Spring Boot with JPA (Java Persistence API) for managing database operations. The project provides RESTful APIs to interact with the database entities.

## Table of Contents
1. [Controllers](#controllers)
2. [Entities](#entities)
3. [Repositories](#repositories)
4. [Services](#services)
5. [Test](#test)
6. [Resources](#resources)
7. [Application Properties](#application-properties)


## Controllers <a name="controllers"></a>
- **AuthorController:** Manages HTTP requests related to authors. It provides endpoints for retrieving, adding, updating, and deleting authors.
- **BookController:** Handles HTTP requests related to books. It includes endpoints for saving, retrieving, updating, and deleting books.

## Entities <a name="entities"></a>
- **Author:** Represents an author entity with attributes such as name, nationality, and birth date.
- **Book:** Represents a book entity with attributes like title, author ID, ISBN, publisher ID, year, image, description, and inventory ID.

## Repositories <a name="repositories"></a>
- **AuthorRepository:** Provides methods for CRUD (Create, Read, Update, Delete) operations on the Author entity.
- **BookRepository:** Offers CRUD operations for the Book entity.

## Services <a name="services"></a>
- **AuthorService:** Implements business logic related to author operations like adding, deleting, and retrieving authors.
- **BookService:** Contains methods for performing CRUD operations on books and handling business logic.

## Test <a name="test"></a>
- **BookRepositoryTest:** Includes test cases for the BookRepository class to ensure proper CRUD operations.

## Resources <a name="resources"></a>
- **db.migration:** Contains SQL scripts for initializing the database schema using Flyway migration.

## Application Properties <a name="application-properties"></a>
- **application.properties:** Configuration file containing settings for the Spring Boot application, including data source, Hibernate, and Flyway configurations.

## Getting Started
To get started with the project, follow these steps:
1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Configure the project dependencies and database connection settings in the `application.properties` file.
4. Run the project using Maven or your IDE's run command.

## Dependencies
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- MySQL Connector
- Flyway Core
- Lombok
- H2 Database (for testing)
- Spring Boot Starter Test (for testing)
- Spring Security Test (for testing)

## Contributors
- [Reis Stanovci](https://github.com/reis03)
- [Rigon Osmanaj](https://github.com/rigonOs)
- [Rron Sherifi](https://github.com/rronsherifii)
- [Suhejl Vejseli](https://github.com/Suhejli1)
- [Visar Gjema](https://github.com/GjemaVisar)

