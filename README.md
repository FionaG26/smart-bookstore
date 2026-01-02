Smart Bookstore Project Report
1. Project Overview

The Smart Bookstore is a full-stack Java-based application designed to manage books in a digital bookstore. It demonstrates a microservices-inspired architecture, combining a backend REST API with a Vaadin-based admin user interface. The system uses Spring Boot, Spring Data JPA, and H2 in-memory database, making it lightweight, fast, and suitable for demonstration or testing purposes.

Key Features:

CRUD operations for books (Create, Read, Update, Delete)

RESTful API for backend operations

Preloaded sample data for immediate testing

Admin UI built with Vaadin for interactive book management

H2 in-memory database with console access

2. Project Structure

The project follows a modular Maven structure with three main modules:

smart-bookstore/
├─ bookstore-backend/           # REST API and JPA backend
├─ bookstore-admin/             # Vaadin admin UI
├─ bookstore-microservice/      # Example microservice module
└─ pom.xml                      # Root pom for multi-module management

2.1 bookstore-backend

Implements the backend REST API and database logic.

Key packages:

com.bookstore.model → Contains Book.java entity class

com.bookstore.repository → Contains BookRepository.java (extends JpaRepository)

com.bookstore.service → Contains BookService.java (business logic)

com.bookstore.controller → Contains BookController.java (REST endpoints)

Database: H2 in-memory database with data.sql for preloaded sample books.

Sample REST Endpoints:

GET /api/books → List all books

POST /api/books → Add a new book

DELETE /api/books/{id} → Delete a book by ID

2.2 bookstore-admin

Vaadin-based web UI module for managing books.

Connects to backend API to fetch and display data.

Provides interactive UI components for:

Viewing all books

Adding new books

Editing book details

Deleting books

2.3 bookstore-microservice

Optional microservice module to demonstrate independent service architecture.

Includes its own simple REST endpoints and data model.

Can be extended to simulate microservice communication with the backend.

3. Technologies Used
Technology	Purpose
Java 11	Project programming language
Spring Boot 2.7.18	Rapid backend development, embedded server
Spring Data JPA	ORM for database interaction
H2 Database	In-memory database for testing and demo
Vaadin	Admin UI front-end framework
Maven	Build and dependency management
Maven Compiler Plugin	Compiles Java source code for Java 11
Spring Boot Maven Plugin	Runs the application from Maven
4. Sample Data

The backend comes with a data.sql file containing sample books:

ID	Title	Author	Price
1	The Great Gatsby	F. Scott Fitzgerald	10.99
2	To Kill a Mockingbird	Harper Lee	12.50
3	1984	George Orwell	9.99
4	Pride and Prejudice	Jane Austen	11.25

This ensures the admin UI and API return data immediately after startup.

5. How to Run the Project
5.1 Backend

Navigate to backend folder:

cd smart-bookstore/bookstore-backend


Build and run using Maven:

mvn clean spring-boot:run


The API will be available at http://localhost:8080/api/books.

5.2 Admin UI

Navigate to admin folder:

cd smart-bookstore/bookstore-admin


Run with Maven:

mvn spring-boot:run


Access the Vaadin UI at http://localhost:8081 (or configured port).

5.3 H2 Database Console

URL: http://localhost:8080/h2-console

JDBC URL: jdbc:h2:mem:testdb

User: sa

Password: leave empty

6. Key Implementation Details
6.1 Backend

Entity: Book.java
Annotated with @Entity, @Id, @GeneratedValue, uses javax.persistence.

Repository: BookRepository.java
Extends JpaRepository<Book, Long> for CRUD operations.

Service: BookService.java
Contains business logic for managing books (findAll, save, delete).

Controller: BookController.java
REST endpoints annotated with @RestController, @RequestMapping, @GetMapping, @PostMapping, @DeleteMapping.

6.2 Admin UI

Connects to backend via REST API.

Uses Vaadin Grid to display books dynamically.

Provides buttons for adding, editing, and deleting entries.

Fetches and updates data in real time.

7. Lessons Learned

Java Version Compatibility

Spring Boot 3.x requires Java 17+ and Jakarta Persistence.

For Java 11, Spring Boot 2.7.x + javax persistence is required.

Maven Dependency Management

Correct version alignment is critical.

Using mvn spring-boot:run avoids repeated downloads after initial cache.

Modular Project Structure

Separating backend, UI, and microservices improves maintainability.

Multi-module Maven setup allows easier expansion.

Rapid Prototyping

H2 database + data.sql enables immediate testing without external DB setup.

Vaadin allows fast UI without complex frontend tooling.

8. Future Improvements

Connect to a persistent database (MySQL, PostgreSQL)

Add authentication and authorization (Spring Security)

Implement microservice communication (REST + Feign client)

Add unit and integration tests for backend

Expand Vaadin UI with search, filters, and pagination

9. Conclusion

The Smart Bookstore project is a fully functional, Java 11 compatible application demonstrating:

Backend REST API with Spring Boot & JPA

Preloaded sample data

Admin UI with Vaadin

Modular project structure for easy expansion

This project provides a strong foundation for portfolio work, learning modern Java backend development, and building full-stack applications.
