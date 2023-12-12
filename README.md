# Todo Management

This backend project is designed for managing Todo items using Spring Boot with Spring Web, Spring Data JPA, MySQL Driver, and Lombok. The application follows a structured architecture, employing the DTO -> Controller -> Service -> Repository model to facilitate CRUD operations through RESTful APIs.

## Technologies Used

- **Spring Boot:** Framework for building the backend application.
- **Spring Web:** Facilitates the creation of RESTful APIs.
- **Spring Data JPA:** Simplifies database operations using JPA.
- **MySQL Driver:** Connector for MySQL database.
- **Lombok:** Reduces boilerplate code, enhancing code readability.

## Project Structure

The project adheres to the following structure:

- **dto:** Contains Data Transfer Objects for mapping entities to client requests using the Model Mapper dependency.
- **controller:** Handles incoming HTTP requests, interacting with the service layer.
- **service:** Implements business logic, communicates with the repository, and includes exception handling.
- **repository:** Manages database operations using Spring Data JPA.

## Exception Handling

- **ResourceNotFoundException:** Custom exception for handling resource not found situations.
- **GlobalExceptionHandler:** Handles global exceptions, providing consistent error responses.

## CRUD Operations

The application supports CRUD operations through the following RESTful APIs:

- **Create Todo:**
  - `POST /api/todos`

- **Get All Todos:**
  - `GET /api/todos`

- **Get Todo by ID:**
  - `GET /api/todos/{id}`

- **Update Todo:**
  - `PUT /api/todos/{id}`

- **Delete Todo:**
  - `DELETE /api/todos/{id}`

## Build and Run

To build and run the project, use the following commands:

```bash
./mvnw clean install
./mvnw spring-boot:run
```

The application will be accessible at `http://localhost:8080`.

## Usage

Utilize the provided API endpoints for creating, retrieving, updating, and deleting Todo items. Exception handling ensures smooth error responses.

## Contributing

Feel free to contribute to the project by opening issues or submitting pull requests.