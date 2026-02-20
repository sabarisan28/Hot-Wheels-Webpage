# 🏎️ Hot Wheels E-Commerce Store

A full-stack e-commerce web application for Hot Wheels toy cars, built with Spring Boot backend and vanilla JavaScript frontend.

![Hot Wheels](hot-wheels-pictures-1199-x-900-r98b96ztwy8c2jdw.jpg)

## 🌟 Features

### Customer Features
- 🛍️ Browse 54+ products across 5 categories
- 🖼️ High-quality product images
- 🛒 Shopping cart functionality
- 💳 Secure checkout process
- 👤 User registration and authentication
- 📦 Order management
- 🔍 Product search and filtering

### Admin Features
- 📊 Database statistics
- 🗑️ Clear products functionality
- 📈 Inventory management

### Security Features
- 🔐 BCrypt password encryption
- 🔒 Secure authentication
- 🛡️ CORS protection
- ✅ Input validation

## 🛠️ Tech Stack

### Backend
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **PostgreSQL** (Supabase)
- **Maven**
- **Lombok**
- **BCrypt** for password encryption

### Frontend
- **HTML5**
- **CSS3**
- **Vanilla JavaScript**
- **Node.js** (for local server)

### Database
- **Supabase PostgreSQL** (Cloud)

## 📦 Product Categories

1. **Baby Cars** (12 products) - ₹499-₹719
   - Safe toys for ages 1-12 months
   
2. **Fun Racers** (12 products) - ₹599-₹929
   - Exciting cars for ages 1-6 years
   
3. **Speedsters** (12 products) - ₹699-₹974
   - Advanced cars for ages 6-12 years
   
4. **Collector Editions** (12 products) - ₹999-₹1549
   - Premium collectibles for ages 12+
   
5. **Special Editions** (6 products) - ₹899-₹2499
   - Track sets, garages, and premium items

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Node.js 14+ (for frontend server)
- PostgreSQL database (or Supabase account)

### Installation

1. **Clone the repository**
```bash
git clone https://github.com/sabarisan28/Hot-Wheels-Webpage.git
cd Hot-Wheels-Webpage
```

2. **Configure Database**

Edit `backend/src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://your-database-url:5432/postgres
spring.datasource.username=your-username
spring.datasource.password=your-password
```

3. **Build Backend**
```bash
cd backend
mvn clean install
```

4. **Run Backend**
```bash
mvn spring-boot:run
```
Backend will start on `http://localhost:8080`

5. **Run Frontend**
```bash
# In project root directory
node server.js
```
Frontend will start on `http://localhost:3000`

6. **Access Application**
- Frontend: http://localhost:3000
- Backend API: http://localhost:8080/api
- API Documentation: See below

## 📡 API Endpoints

### Products
```
GET    /api/products           - Get all products
GET    /api/products/{id}      - Get product by ID
POST   /api/products           - Create product
PUT    /api/products/{id}      - Update product
DELETE /api/products/{id}      - Delete product
```

### Users
```
POST   /api/users/register     - Register new user
POST   /api/users/login        - Login user
GET    /api/users              - Get all users
```

### Orders
```
POST   /api/orders             - Create order
GET    /api/orders/user/{id}   - Get user orders
```

### Admin
```
DELETE /api/admin/clear-products - Clear all products
GET    /api/admin/stats         - Get database statistics
```

### Images
```
GET    /images/{filename}      - Get product image
```

## 🧪 Testing

### Test Backend API
```powershell
# Get all products
Invoke-RestMethod -Uri "http://localhost:8080/api/products"

# Register user
$body = @{
    name = "Test User"
    email = "test@example.com"
    password = "password123"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/api/users/register" `
    -Method POST -ContentType "application/json" -Body $body

# Login user
$loginBody = @{
    email = "test@example.com"
    password = "password123"
} | ConvertTo-Json

Invoke-RestMethod -Uri "http://localhost:8080/api/users/login" `
    -Method POST -ContentType "application/json" -Body $loginBody
```

## 📁 Project Structure

```
Hot-Wheels-Webpage/
├── backend/
│   ├── src/main/
│   │   ├── java/com/hotwheels/
│   │   │   ├── config/
│   │   │   │   ├── DataLoader.java
│   │   │   │   ├── WebConfig.java
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   └── CorsConfig.java
│   │   │   ├── controller/
│   │   │   │   ├── ProductController.java
│   │   │   │   ├── UserController.java
│   │   │   │   ├── OrderController.java
│   │   │   │   └── AdminController.java
│   │   │   ├── service/
│   │   │   ├── repository/
│   │   │   ├── model/
│   │   │   └── dto/
│   │   └── resources/
│   │       ├── static/images/
│   │       └── application.properties
│   └── pom.xml
├── index.html
├── server.js
├── README.md
└── .gitignore
```

## 🔐 Security

- Passwords are encrypted using BCrypt
- Case-insensitive email handling
- CORS enabled for frontend integration
- Input validation on all endpoints
- Secure session management

## 📊 Database Schema

### Users Table
```sql
CREATE TABLE users (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Products Table
```sql
CREATE TABLE products (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,
    image_url VARCHAR(255),
    stock INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Orders Table
```sql
CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    total_amount DECIMAL(10,2),
    status VARCHAR(50) DEFAULT 'PENDING',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

### Order Items Table
```sql
CREATE TABLE order_items (
    id BIGSERIAL PRIMARY KEY,
    order_id BIGINT REFERENCES orders(id),
    product_id BIGINT REFERENCES products(id),
    quantity INTEGER NOT NULL,
    price DECIMAL(10,2)
);
```

## 🎨 Screenshots

### Home Page
Browse through our extensive collection of Hot Wheels cars.

### Product Catalog
View all 54 products with images, prices, and stock levels.

### Shopping Cart
Add products to cart and proceed to checkout.

### User Authentication
Secure login and registration system.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is open source and available under the [MIT License](LICENSE).

## 👨‍💻 Author

**Sabarisan**
- GitHub: [@sabarisan28](https://github.com/sabarisan28)
- Email: aathisenthil18@gmail.com

## 🙏 Acknowledgments

- Hot Wheels for the inspiration
- Spring Boot community
- Supabase for database hosting

## 📞 Support

For support, email aathisenthil18@gmail.com or open an issue in the GitHub repository.

## 🔄 Version History

- **v1.0.0** (2026-02-20)
  - Initial release
  - 54 products loaded
  - Full authentication system
  - Shopping cart functionality
  - Order management
  - Image serving
  - Admin panel

## 🚀 Future Enhancements

- [ ] Payment gateway integration
- [ ] Email notifications
- [ ] Product reviews and ratings
- [ ] Wishlist functionality
- [ ] Advanced search and filters
- [ ] Admin dashboard
- [ ] Order tracking
- [ ] Mobile app

---

Made with ❤️ by Sabarisan
