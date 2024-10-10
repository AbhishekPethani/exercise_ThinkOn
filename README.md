# exercise_ThinkOn: User Management REST API

This project is a RESTful API built using **Java 17** and the **Spring Framework**. The API allows users to create, view, update, and delete user records, persisting them in a database (file-based H2). The API consumes and produces JSON data.

### Features
- **Create a new user** (`POST /users`)
- **Retrieve a list of all available users** (`GET /users`)
- **Retrieve a single user by ID** (`GET /users/{id}`)
- **Update an existing user** (`PUT /users/{id}`)
- **Delete a user by ID** (`DELETE /users/{id}`)

### Technologies & Dependencies
The project is built using the following key dependencies:

#### Spring Web
- **Purpose:** To build the RESTful API.
- **Usage:** This provides the framework to expose the API endpoints and handle HTTP requests such as `GET`, `POST`, `PUT`, and `DELETE`.

#### Spring Data JPA
- **Purpose:** Simplifies database interactions by abstracting away much of the boilerplate code related to database access.
- **Usage:** The **UserRepository** is a JPA repository that handles CRUD operations for the `User` entity with minimal configuration.

#### H2 Database
- **Purpose:** A file-based database used to persist user data through restarts.
- **Usage:** User data is stored in the H2 database during API calls and persists across service restarts.

#### Lombok
- **Purpose:** Reduces boilerplate code for getter, setter, constructors, etc.
- **Usage:** Annotations like `@Data`, `@NoArgsConstructor`, and `@AllArgsConstructor` are used in the `User` model to automatically generate getters, setters, constructors, and other utility methods.

---

## 1. POST /users - Create a New User

This endpoint is responsible for creating a new user in the system.

### Request
- **Method:** `POST`
- **URL:** `/users`
- **Content-Type:** `application/json`
- **Request Body:**
  ```json
  {
    "username": "explorer",
    "firstName": "Abhishek",
    "lastName": "Pethani",
    "email": "abhishekpethani@gmail.com",
    "phoneNumber": "1234567890"
  }
  ```

### Response
- **Status Code:** `200 OK`
- **Response Body:**
  ```json
  {
    "id": 1,
    "username": "explorer",
    "firstName": "Abhishek",
    "lastName": "Pethani",
    "email": "abhishekpethani@gmail.com",
    "phoneNumber": "1234567890"
  }
  ```
---

## 2. GET /users - Retrieve a list of all available users

This endpoint returns a list of all users currently stored in the system.

### Request
- **Method:** `GET`
- **URL:** `/users`
- **Response Type:** `application/json`

### Response
- **Status Code:** `200 OK`
- **Response Body Example:**
  ```json
  {
    "users": [
        {
            "id": 1,
            "username": "explorer",
            "firstName": "Abhishek",
            "lastName": "Pethani",
            "email": "abhishekpethani@gmail.com",
            "phoneNumber": "1234567890"
        },
        {
            "id": 2,
            "username": "navigator",
            "firstName": "Steve",
            "lastName": "Smith",
            "email": "steve.smith@gmail.com",
            "phoneNumber": "9876543210"
        }
    ]
  }
  ```
---

## 3. GET /users/{id} - Retrieve a Single User by ID

This endpoint retrieves the details of a specific user based on the user ID.

### Request
- **Method:** `GET`
- **URL:** `/users/{id}`
- **Response Type:** `application/json`

### Response
- **Status Code:** `200 OK`
- **Response Body Example:**
  ```json
  {
    "id": 1,
    "username": "explorer",
    "firstName": "Abhishek",
    "lastName": "Pethani",
    "email": "abhishekpethani@gmail.com",
    "phoneNumber": "1234567890"
  }
  ```
- **Error Response:**
  - **Status Code:** `404 Not Found`
  - **Response Body Example:**
    ```json
    {
        "message": "User with ID {id} not found"
    }
    ```
- **Error Response:**
  - **Status Code:** `400 Bad Request`
  - **Response Body Example:**
    ```json
    {
        "error": "Invalid ID type: ID should be a number"
    }
    ```

---

## 4. PUT /users/{id} - Update an Existing User

This endpoint updates the details of an existing user.

### Request
- **Method:** `PUT`
- **URL:** `/users/{id}`
- **Content-Type:** `application/json`
- **Request Body:**
  ```json
  {
    "username": "explorer",
    "firstName": "Abhishek",
    "lastName": "Pethani",
    "email": "abhishekpethani@gmail.com",
    "phoneNumber": "1234567890"
  }
  ```

### Response
- **Status Code:** `200 OK`
- **Response Body Example:**
  ```json
  {
    "id": 1,
    "username": "explorer",
    "firstName": "Abhishek",
    "lastName": "Pethani",
    "email": "abhishekpethani@gmail.com",
    "phoneNumber": "1234567890"
  }
  ```
- **Error Response:**
  - **Status Code:** `404 Not Found`
  - **Response Body Example:**
    ```json
    {
        "message": "User with ID {id} not found"
    }
    ```
- **Error Response:**
  - **Status Code:** `400 Bad Request`
  - **Response Body Example:**
    ```json
    {
        "error": "Invalid ID type: ID should be a number"
    }
    ```
---

## 5. DELETE /users/{id} - Delete a User by ID

This endpoint deletes an existing user by their ID.

### Request
- **Method:** `DELETE`
- **URL:** `/users/{id}`

### Response
- **Status Code:** `200 OK`
- **Response Body Example:**
  ```json
  {
    "message": "User deleted successfully"
  }
  ```
- **Error Response:**
  - **Status Code:** `404 Not Found`
  - **Response Body Example:**
    ```json
    {
        "message": "User with ID {id} not found"
    }
    ```
- **Error Response:**
  - **Status Code:** `400 Bad Request`
  - **Response Body Example:**
    ```json
    {
        "error": "Invalid ID type: ID should be a number"
    }
    ```

---