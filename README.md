# Task Management System

This is a Task Management System built with Spring Boot, Spring Security, and JPA for managing tasks. Users can register, log in, create, view, update, and delete tasks.

## Features

- User Registration
- User Authentication
- Task Creation
- Task Retrieval
- Task Update
- Task Deletion

## Technologies Used

- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- BCrypt for password encoding

## Prerequisites

- Java 17 or higher
- Maven
- MySQL

## Getting Started

1. **Clone the repository:**
    ```bash
    git clone https://github.com/vivendra-yadav/task_management_system..git
    cd task-management-system
    ```

2. **Configure MySQL:**

    Create a database named `task_management_system` in MySQL.

    Update the `application.properties` file in the `src/main/resources` directory with your MySQL credentials:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/task_management_system
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    ```

3. **Build the project:**
    ```bash
    mvn clean install
    ```

4. **Run the application:**
    ```bash
    mvn spring-boot:run
    ```

## API Endpoints

### User Registration

- **URL:** `/api/register`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "username": "user1",
        "password": "password123"
    }
    ```
- **Response:**
    ```json
    {
        "id": 1,
        "username": "user1"
    }
    ```

### User Login

- **URL:** `/api/login`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "username": "user1",
        "password": "password123"
    }
    ```
- **Response:** 200 OK with a JWT token in the headers

### Create Task

- **URL:** `/api/tasks`
- **Method:** `POST`
- **Request Body:**
    ```json
    {
        "title": "New Task",
        "description": "Task description"
    }
    ```
- **Response:**
    ```json
    {
        "id": 1,
        "title": "New Task",
        "description": "Task description",
        "user": {
            "id": 1,
            "username": "user1"
        }
    }
    ```

### Get Tasks

- **URL:** `/api/tasks`
- **Method:** `GET`
- **Response:**
    ```json
    [
        {
            "id": 1,
            "title": "New Task",
            "description": "Task description",
            "user": {
                "id": 1,
                "username": "user1"
            }
        }
    ]
    ```

### Update Task

- **URL:** `/api/tasks/{taskId}`
- **Method:** `PUT`
- **Request Body:**
    ```json
    {
        "title": "Updated Task",
        "description": "Updated description"
    }
    ```
- **Response:**
    ```json
    {
        "id": 1,
        "title": "Updated Task",
        "description": "Updated description",
        "user": {
            "id": 1,
            "username": "user1"
        }
    }
    ```

### Delete Task

- **URL:** `/api/tasks/{taskId}`
- **Method:** `DELETE`
- **Response:** 200 OK

## Usage

1. **Register a new user:**
    ```bash
    curl -X POST http://localhost:8080/api/register \
    -H "Content-Type: application/json" \
    -d '{"username": "user1", "password": "password123"}'
    ```

2. **Log in to get a JWT token:**
    ```bash
    curl -X POST http://localhost:8080/api/login \
    -H "Content-Type: application/json" \
    -d '{"username": "user1", "password": "password123"}'
    ```

3. **Create a new task:**
    ```bash
    curl -X POST http://localhost:8080/api/tasks \
    -H "Content-Type: application/json" \
    -H "Authorization: Bearer your_jwt_token" \
    -d '{"title": "New Task", "description": "Task description"}'
    ```

4. **Get tasks for the authenticated user:**
    ```bash
    curl -X GET http://localhost:8080/api/tasks \
    -H "Authorization: Bearer your_jwt_token"
    ```

5. **Update a task:**
    ```bash
    curl -X PUT http://localhost:8080/api/tasks/1 \
    -H "Content-Type: application/json" \
    -H "Authorization: Bearer your_jwt_token" \
    -d '{"title": "Updated Task", "description": "Updated description"}'
    ```

6. **Delete a task:**
    ```bash
    curl -X DELETE http://localhost:8080/api/tasks/1 \
    -H "Authorization: Bearer your_jwt_token"
    ```

