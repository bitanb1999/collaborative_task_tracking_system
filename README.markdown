# Task Tracking Platform

A Spring Boot application for task management and team collaboration with secure user authentication, task CRUD operations, and team/project features.

## Features
- **User Authentication**: Register, login, and manage profiles with JWT-based authentication and BCrypt password hashing.
- **Task Management**: Create, read, update, delete tasks with title, description, due date, status, filtering, sorting, and search.
- **Team Collaboration**: Create/join teams, assign tasks, add comments and attachments.
- **RESTful API**: Endpoints for authentication, tasks, and collaboration with validation and error handling.
- **Generative AI**: Placeholder for AI-generated task descriptions (extendable with a real model).
- **Database**: PostgreSQL for data storage.
- **Optional**: Real-time notifications (not implemented in this version but extensible via WebSockets).

## Prerequisites
- Java 17
- Maven 3.8+
- PostgreSQL 14+
- IDE (e.g., IntelliJ IDEA, Eclipse)

## Setup Instructions
1. **Clone the Repository**
   ```bash
   git clone https://github.com/yourusername/task-tracking-platform.git
   cd task-tracking-platform
   ```

2. **Configure PostgreSQL**
   - Create a database named `taskdb`.
   - Update `src/main/resources/application.properties` with your database credentials:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/taskdb
     spring.datasource.username=yourusername
     spring.datasource.password=yourpassword
     ```

3. **Build and Run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
   The application runs on `http://localhost:8080`.

4. **API Endpoints**
   - **Auth**: `/api/auth/register`, `/api/auth/login`, `/api/auth/logout`
   - **User**: `/api/users/profile`
   - **Tasks**: `/api/tasks`, `/api/tasks/{id}`, `/api/tasks/search`, `/api/tasks/filter`
   - **Teams**: `/api/teams`, `/api/teams/{id}/members`, `/api/teams/{id}/tasks`
   - **Comments**: `/api/tasks/{taskId}/comments`
   - **Attachments**: `/api/tasks/{taskId}/attachments`

   Use tools like Postman to test endpoints. Include JWT token in the `Authorization` header for protected routes.

## Project Structure
```
src/main/java/com/example/tasktracker/
├── config/             # Security, JWT, and AI configuration
├── controller/         # REST controllers
├── model/             # Entity classes
├── repository/        # JPA repositories
├── service/           # Business logic
├── security/          # JWT and security utilities
└── util/              # Helper classes
```

## Technologies
- Spring Boot 3.2
- Spring Security with JWT
- PostgreSQL
- Maven
- Hibernate/JPA
- Lombok

## Code Quality
- Follows Spring Boot best practices.
- Organized in a modular structure.
- Includes Javadoc and inline comments.
- Uses validation and proper error handling.

## Extending the Project
- **Real-time Notifications**: Add WebSockets using Spring's `@EnableWebSocket` and `WebSocketConfigurer`.
- **Generative AI**: Replace `AiService` placeholder with a real AI model API (e.g., OpenAI).
- **Attachments**: Store files in cloud storage (e.g., AWS S3) instead of the database.

## Testing
- Run unit tests: `mvn test`
- Integration tests are included for controllers and services.

## Submission
The project is hosted at: [GitHub Repository](https://github.com/yourusername/task-tracking-platform)

## Notes
- The generative AI feature is a placeholder. To integrate a real model, update `AiService` with API calls.
- Real-time notifications are not implemented but can be added using Spring WebSockets.