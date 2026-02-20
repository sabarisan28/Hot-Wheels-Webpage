# Hot Wheels Backend - Spring Boot Application

## Tech Stack
- Java 17
- Spring Boot 3.2.0
- Spring Web
- Spring Data JPA
- MySQL 8
- Lombok
- Maven

## Project Structure
```
backend/
├── src/main/java/com/hotwheels/
│   ├── HotWheelsApplication.java
│   ├── controller/
│   │   ├── ProductController.java
│   │   ├── UserController.java
│   │   └── OrderController.java
│   ├── service/
│   │   ├── ProductService.java
│   │   ├── UserService.java
│   │   └── OrderService.java
│   ├── repository/
│   │   ├── ProductRepository.java
│   │   ├── UserRepository.java
│   │   ├── OrderRepository.java
│   │   └── OrderItemRepository.java
│   ├── model/
│   │   ├── Product.java
│   │   ├── User.java
│   │   ├── Order.java
│   │   └── OrderItem.java
│   ├── dto/
│   │   ├── ProductDTO.java
│   │   ├── UserDTO.java
│   │   ├── OrderDTO.java
│   │   └── OrderItemDTO.java
│   └── config/
│       └── CorsConfig.java
├── src/main/resources/
│   └── application.properties
├── database/
│   └── schema.sql
└── pom.xml
```

## Setup Instructions

### 1. Database Setup
Run the SQL script to create database and tables:
```bash
mysql -u root -p < database/schema.sql
```

### 2. Configure Database
Update `src/main/resources/application.properties` with your MySQL credentials:
```properties
spring.datasource.username=root
spring.datasource.password=yourpassword
```

### 3. Build and Run
```bash
cd backend
mvn clean install
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Product APIs
- `GET /api/products` - Get all products
- `GET /api/products/{id}` - Get product by ID
- `POST /api/products` - Add new product
- `PUT /api/products/{id}` - Update product
- `DELETE /api/products/{id}` - Delete product

### User APIs
- `POST /api/users/register` - Register new user
- `GET /api/users` - Get all users

### Order APIs
- `POST /api/orders` - Create new order
- `GET /api/orders/user/{userId}` - Get orders by user ID

## Features
- Clean 3-tier architecture (Controller → Service → Repository)
- JPA entities with relationships
- CORS enabled for frontend integration
- Exception handling
- DTO pattern for data transfer
- Lombok for boilerplate reduction
