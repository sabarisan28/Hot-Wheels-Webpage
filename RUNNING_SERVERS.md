# 🚀 Hot Wheels - Servers Running

## ✅ BOTH SERVERS ARE LIVE!

### 🌐 Frontend Server
- **URL**: http://localhost:3000
- **Status**: ✅ RUNNING
- **Technology**: Node.js HTTP Server
- **Port**: 3000

### ⚙️ Backend API Server
- **URL**: http://localhost:8080
- **Status**: ✅ RUNNING
- **Technology**: Spring Boot 3.2.0 + Java 17
- **Port**: 8080

### 💾 Database
- **Provider**: Supabase PostgreSQL
- **Status**: ✅ CONNECTED
- **Location**: AWS Mumbai (ap-south-1)

---

## 🌐 Access Your Application

### Main Application
```
http://localhost:3000
```
Open this in your browser to use the Hot Wheels e-commerce site!

### API Endpoints
```
http://localhost:8080/api/products
http://localhost:8080/api/users
http://localhost:8080/api/orders
```

---

## 📊 Current Data

- **Products**: 6 items
- **Total Stock**: 315 units
- **Total Value**: ₹5,649.94

---

## 🎯 How to Use

### 1. Open the Application
Your browser should already be open at: http://localhost:3000

If not, click this link or paste it in your browser.

### 2. Register an Account
1. Click "Login" button
2. Click "Need an account? Register"
3. Fill in your details
4. Click Submit

### 3. Login
1. Enter your email and password
2. Click Submit
3. You'll see "Hello, [Your Name]" in the header

### 4. Shop!
1. Browse products (loaded from database)
2. Click "Add to Cart"
3. Click "Cart" to view your items
4. Click "Proceed to checkout"

### 5. Buy Now
1. Click "Buy Now" on any product
2. Confirm purchase
3. Order is saved to database

---

## 🔍 Test the API

### Get All Products
```bash
curl http://localhost:8080/api/products
```

Or in PowerShell:
```powershell
Invoke-RestMethod -Uri "http://localhost:8080/api/products"
```

### Get All Users
```bash
curl http://localhost:8080/api/users
```

---

## 🛑 Stop the Servers

### Stop Frontend Server
1. Go to the terminal running Node.js
2. Press `Ctrl+C`

### Stop Backend Server
1. Go to the terminal running Spring Boot
2. Press `Ctrl+C`

---

## 🔄 Restart the Servers

### Restart Frontend
```bash
node server.js
```

### Restart Backend
```bash
cd backend
set JAVA_HOME=C:\Program Files\Java\jdk-17
mvn spring-boot:run
```

---

## 📁 Server Files

### Frontend Server
- **File**: `server.js`
- **Serves**: `index.html` and all assets
- **Port**: 3000

### Backend Server
- **Location**: `backend/`
- **Main Class**: `HotWheelsApplication.java`
- **Port**: 8080

---

## 🔧 Troubleshooting

### Frontend Not Loading?
1. Check if Node.js server is running
2. Try: http://localhost:3000
3. Check browser console (F12) for errors

### Backend Not Responding?
1. Check if Spring Boot is running
2. Try: http://localhost:8080/api/products
3. Check backend terminal for errors

### Database Connection Issues?
1. Check Supabase credentials in `application.properties`
2. Verify internet connection
3. Check backend logs for SQL errors

---

## 📊 Architecture

```
┌─────────────────────────────────────────────────┐
│  Browser (http://localhost:3000)                │
│  ├─ index.html                                  │
│  ├─ CSS Styles                                  │
│  └─ JavaScript (API calls)                      │
└────────────────┬────────────────────────────────┘
                 │
                 │ HTTP Requests
                 ▼
┌─────────────────────────────────────────────────┐
│  Node.js Server (Port 3000)                     │
│  └─ Serves static files                         │
└─────────────────────────────────────────────────┘

┌─────────────────────────────────────────────────┐
│  Spring Boot API (Port 8080)                    │
│  ├─ ProductController                           │
│  ├─ UserController                              │
│  ├─ OrderController                             │
│  └─ Services & Repositories                     │
└────────────────┬────────────────────────────────┘
                 │
                 │ JDBC
                 ▼
┌─────────────────────────────────────────────────┐
│  Supabase PostgreSQL (Cloud)                    │
│  ├─ users table                                 │
│  ├─ products table                              │
│  ├─ orders table                                │
│  └─ order_items table                           │
└─────────────────────────────────────────────────┘
```

---

## ✨ Features Working

- ✅ Frontend served on localhost:3000
- ✅ Backend API on localhost:8080
- ✅ Database connected to Supabase
- ✅ User registration & login
- ✅ Product browsing
- ✅ Shopping cart
- ✅ Order placement
- ✅ Real-time data sync

---

## 🎉 Success!

Your Hot Wheels e-commerce application is now running on localhost with:
- Professional Node.js frontend server
- Spring Boot REST API backend
- Cloud PostgreSQL database
- Full CRUD operations
- User authentication
- Shopping cart & orders

**Visit**: http://localhost:3000 to start shopping! 🏎️💨
