# 🚀 Hot Wheels - Quick Start Guide

## ✅ Current Status: RUNNING

### Backend API
- **URL**: http://localhost:8080
- **Status**: ✅ Running
- **Database**: ✅ Supabase PostgreSQL Connected
- **Products**: ✅ 6 products loaded

### Frontend
- **File**: index.html
- **Status**: ✅ Open in browser
- **Connection**: ✅ Connected to backend

---

## 🎯 Quick Actions

### View Your Application
```bash
# Open frontend
start index.html
```

### Test Backend API
```powershell
# Get all products
Invoke-WebRequest -Uri "http://localhost:8080/api/products" -UseBasicParsing

# Get all users
Invoke-WebRequest -Uri "http://localhost:8080/api/users" -UseBasicParsing
```

### Stop/Start Backend
```bash
# Stop: Press Ctrl+C in the backend terminal

# Start:
cd backend
set JAVA_HOME=C:\Program Files\Java\jdk-17
mvn spring-boot:run
```

---

## 📱 User Flow

### 1. Register Account
1. Open index.html
2. Click "Login" → "Need an account? Register"
3. Enter name, email, password
4. Click Submit

### 2. Login
1. Click "Login"
2. Enter email and password
3. Click Submit
4. See "Hello, [Name]" in header

### 3. Shop
1. Browse products (loaded from database)
2. Click "Add to Cart"
3. Click "Cart" to view
4. Click "Proceed to checkout"

### 4. Buy Now
1. Click "Buy Now" on any product
2. Confirm purchase
3. Order saved to database

---

## 🔧 Troubleshooting

### Backend Not Running?
```bash
cd backend
set JAVA_HOME=C:\Program Files\Java\jdk-17
mvn spring-boot:run
```

### Products Not Loading?
1. Check backend is running: http://localhost:8080/api/products
2. Check browser console (F12) for errors
3. Sample products will auto-create if database is empty

### Can't Login?
1. Make sure you registered first
2. Check email/password are correct
3. Check backend logs for errors

---

## 📊 Database Info

### Supabase Connection
- **Host**: aws-1-ap-south-1.pooler.supabase.com
- **Database**: postgres
- **User**: postgres.nnmahjuxilxxtaarqbrn

### Tables Created
- ✅ users
- ✅ products
- ✅ orders
- ✅ order_items

---

## 🎨 Features Available

### ✅ Implemented
- Product catalog from database
- User registration & login
- Shopping cart
- Order creation
- Real-time stock display
- Responsive design
- Error handling

### 🔜 Future Enhancements
- Product search
- Order history
- Admin panel
- Payment integration
- Email notifications
- Product reviews

---

## 📞 Support

### Check Logs
- Backend logs: Terminal running mvn spring-boot:run
- Frontend logs: Browser console (F12)

### Common Issues
1. **CORS Error**: Backend CORS is enabled, refresh page
2. **Connection Refused**: Backend not running
3. **404 Error**: Check API endpoint URLs
4. **Database Error**: Check Supabase connection

---

## 🎉 You're All Set!

Your Hot Wheels e-commerce platform is fully operational with:
- ✅ Cloud database (Supabase PostgreSQL)
- ✅ REST API backend (Spring Boot)
- ✅ Interactive frontend (HTML/CSS/JS)
- ✅ User authentication
- ✅ Shopping cart & orders

**Start shopping at**: file:///C:/Users/sabar/OneDrive/Desktop/hot wheels/index.html

Happy coding! 🏎️💨
