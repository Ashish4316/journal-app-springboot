# Changelog

All notable changes to this project will be documented in this file.

## [1.0.0] - 2026-02-02

### Added
- Initial release of Journal Application
- User management with unique username constraint
- Journal entry CRUD operations
- MongoDB integration with Spring Data
- RESTful API endpoints for users and journal entries
- User-entry association using MongoDB DBRef
- Comprehensive README documentation
- Maven wrapper for easy builds
- Spring Boot 4.x with Java 17 support

### Technical Details
- Spring Boot 4.0.1
- Spring Data MongoDB 5.x
- MongoDB document modeling
- Lombok for boilerplate reduction
- Custom MongoDB configuration for explicit database selection

### API Endpoints
- User endpoints: GET, POST, PUT at /user
- Journal endpoints: GET, POST, PUT, DELETE at /journal

---

## Future Roadmap

### [1.1.0] - Planned
- User authentication with Spring Security
- Password encryption using BCrypt
- JWT token-based authentication

### [1.2.0] - Planned
- Search functionality for journal entries
- Pagination support for listings
- Tags/categories for journal entries

### [2.0.0] - Planned
- Frontend UI with React/Angular
- File attachments for journal entries
- Export journals as PDF
