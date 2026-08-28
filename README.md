# BookVault API

A RESTful **Book Management API** built with **Spring Boot, Spring Data JPA, and MySQL**.

BookVault provides a clean backend architecture for managing books through CRUD operations, request validation, DTO-based data transfer, and centralized exception handling.

## Tech Stack

**Backend**

* Java 21
* Spring Boot 3.5.16
* Spring Web
* Spring Data JPA
* Jakarta Bean Validation

**Database**

* MySQL

**Tools**

* Maven
* Lombok

## Features

* Create, read, update, and delete books
* Request validation using Jakarta Validation
* DTO-based request and response handling
* JPA/Hibernate database persistence
* Automatic book status assignment
* Centralized exception handling
* Layered backend architecture

## API Endpoints

Base URL:

```text
http://localhost:8080/bookvault
```

| Method   | Endpoint             | Description           |
| -------- | -------------------- | --------------------- |
| `GET`    | `/api/v1/books`      | Retrieve all books    |
| `GET`    | `/api/v1/books/{id}` | Retrieve a book by ID |
| `POST`   | `/api/v1/books`      | Add a new book        |
| `PUT`    | `/api/v1/books/{id}` | Update a book         |
| `DELETE` | `/api/v1/books/{id}` | Delete a book         |

### Create Book

**POST** `/bookvault/api/v1/books`

```json
{
  "title": "The Alchemist",
  "author": "Paulo Coelho",
  "isbn": "9780061122415",
  "category": "Fiction",
  "price": 399.0,
  "publishedYear": 1988
}
```

### Response

```json
{
  "title": "The Alchemist",
  "author": "Paulo Coelho",
  "category": "Fiction",
  "price": 399.0,
  "status": "Available"
}
```

## Validation

Incoming book requests are validated before being processed.

* `title`, `author`, `isbn`, and `category` must not be blank
* `price` must be greater than `0`
* `publishedYear` must be `1500` or later

New books are automatically assigned the status:

```text
Available
```

## Architecture

```text
Client
   ↓
Controller
   ↓
Service
   ↓
Repository
   ↓
MySQL
```

The project follows a layered architecture:

```text
controller
    ↓
service
    ↓
repository
    ↓
model
```

DTOs are used to separate API request/response structures from the database entity.

## Project Structure

```text
src/main/java/com/karl/BookVault_API
│
├── controller
│   └── BookController.java
│
├── dto
│   ├── request
│   │   └── BookRequestDTO.java
│   └── response
│       └── BookResponseDTO.java
│
├── exception
│   └── GlobalExceptionHandler.java
│
├── model
│   └── Book.java
│
├── repository
│   └── BookRepository.java
│
├── service
│   └── BookService.java
│
└── BookVaultApiApplication.java
```

## Database Model

The `Book` entity is mapped to the `books` table.

| Field           | Type          |
| --------------- | ------------- |
| `id`            | Integer       |
| `title`         | String        |
| `author`        | String        |
| `isbn`          | String        |
| `category`      | String        |
| `price`         | Double        |
| `publishedYear` | Integer       |
| `status`        | String        |
| `createdAt`     | LocalDateTime |

## Error Handling

The API uses a global exception handler to handle requests for books that do not exist.

Example response:

```text
Book Not Found
```

## Testing

The project includes a Spring Boot application context test using JUnit 5.

```bash
./mvnw test
```
