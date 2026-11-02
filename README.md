
# Task Manager REST API

A RESTful Task Management API developed using Java, Spring Boot and MySQL.

## Technologies Used

- Java 25
- Spring Boot 4
- Spring Data JPA
- MySQL
- Maven
- Swagger UI
- Postman

## Features

- Create a new task
- Retrieve all tasks
- Retrieve a task by ID
- Update task details
- Delete tasks
- Search tasks by title
- Filter tasks by status
- Update task status
- Input validation
- Global exception handling
- API documentation using Swagger UI

## Task Properties

- ID
- Title
- Description
- Status
- Priority
- Due Date

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | /api/tasks | Create task |
| GET | /api/tasks | Get all tasks |
| GET | /api/tasks/{id} | Get task by ID |
| PUT | /api/tasks/{id} | Update task |
| DELETE | /api/tasks/{id} | Delete task |
| GET | /api/tasks/search?title=Java | Search tasks |
| GET | /api/tasks/filter?status=PENDING | Filter tasks |
| PATCH | /api/tasks/{id}/status?status=COMPLETED | Update status |

## Database

MySQL database: task_manager

## Run the Project

1. Install Java and MySQL.
2. Create a MySQL database named `task_manager`.
3. Configure database connection in application.properties.
4. Open the project in IntelliJ IDEA.
5. Run TaskmanagerApplication.java.

## API Documentation

After starting the application, open:

http://localhost:8080/swagger-ui.html

## Developer

M.I.F. Rushdha

B.Tech in Software Technology
