# Journal Application - Spring Boot + MongoDB

A RESTful Journal Application built with Spring Boot 4.x and MongoDB, allowing users to create, manage, and organize their personal journal entries.

## 🚀 Features

- **User Management**: Create and manage user accounts with unique usernames
- **Journal Entries**: Full CRUD operations for personal journal entries
- **User-Entry Association**: Each journal entry is linked to a specific user via MongoDB DBRef
- **Unique Constraints**: Enforced unique username with MongoDB indexing
- **RESTful API**: Clean REST endpoints following best practices

## 🛠️ Tech Stack

- **Framework**: Spring Boot 4.0.1
- **Database**: MongoDB
- **Build Tool**: Maven
- **Java Version**: 17
- **Libraries**: 
  - Spring Data MongoDB
  - Lombok (for reducing boilerplate)
  - Spring Web MVC

## 📁 Project Structure

```
src/main/java/com/example/First/project/
├── FirstProjectApplication.java    # Main entry point
├── config/
│   └── MongoConfig.java           # MongoDB configuration
├── controller/
│   ├── JouranlEntryController.java # Journal REST endpoints
│   └── UserController.java         # User REST endpoints
├── entity/
│   ├── JournalEntry.java          # Journal document model
│   └── Users.java                  # User document model
├── repository/
│   ├── JournalEntryRepository.java # Journal data access
│   └── UserRepository.java         # User data access
└── service/
    ├── JournalEntryService.java   # Journal business logic
    └── UserService.java            # User business logic
```

## 🔌 API Endpoints

### User Endpoints (`/user`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/user` | Get all users |
| POST | `/user` | Create a new user |
| PUT | `/user/{userName}` | Update user details |

### Journal Endpoints (`/journal`)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/journal/{username}` | Get all journal entries for a user |
| GET | `/journal/id/{myId}` | Get a specific journal entry by ID |
| POST | `/journal/{userName}` | Create a new journal entry |
| PUT | `/journal/id/{userName}/{myId}` | Update a journal entry |
| DELETE | `/journal/id/{username}/{myId}` | Delete a journal entry |

## ⚙️ Configuration

Application runs on port `9090` by default. MongoDB connection is configured in `application.yaml`:

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/JournalDb
      database: JournalDb
      auto-index-creation: true

server:
  port: 9090
```

## 🏃 Running the Application

### Prerequisites
- Java 17+
- MongoDB running on localhost:27017

### Steps

1. Clone the repository
```bash
git clone <repository-url>
cd First-project
```

2. Start MongoDB
```bash
mongod
```

3. Run the application
```bash
./mvnw spring-boot:run
```

Or on Windows:
```cmd
mvnw.cmd spring-boot:run
```

## 📝 Sample API Requests

### Create a User
```bash
curl -X POST http://localhost:9090/user \
  -H "Content-Type: application/json" \
  -d '{"username": "john", "password": "secret123"}'
```

### Create a Journal Entry
```bash
curl -X POST http://localhost:9090/journal/john \
  -H "Content-Type: application/json" \
  -d '{"title": "My First Entry", "content": "Today was a great day!"}'
```

### Get User's Journal Entries
```bash
curl http://localhost:9090/journal/john
```

## 📄 License

This project is for learning purposes.

## 👤 Author

Ashish Kumar Yadav
