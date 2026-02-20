# 🎯 Load All 58 Products with Images

## Current Status
- ✅ 56 images copied to `backend/src/main/resources/static/images/`
- ✅ DataLoader created with 58 products
- ✅ Static image serving configured
- ✅ Frontend updated to use backend images
- ⚠️ Only 6 old products in database

## Step-by-Step: Load All Products

### Step 1: Clear Existing Products

Run this PowerShell command:

```powershell
# Delete all existing products
$products = Invoke-RestMethod -Uri "http://localhost:8080/api/products"
foreach ($product in $products) {
    try {
        Invoke-RestMethod -Uri "http://localhost:8080/api/products/$($product.id)" -Method DELETE
        Write-Host "Deleted product: $($product.name)" -ForegroundColor Green
    } catch {
        Write-Host "Error deleting product $($product.id): $($_.Exception.Message)" -ForegroundColor Red
    }
}

# Verify deletion
$remaining = Invoke-RestMethod -Uri "http://localhost:8080/api/products"
Write-Host "`nRemaining products: $($remaining.Count)" -ForegroundColor Cyan
```

### Step 2: Restart Backend

The DataLoader will automatically insert all 58 products when it detects an empty database.

**Stop backend:**
- Go to backend terminal
- Press `Ctrl+C`

**Start backend:**
```bash
cd backend
set JAVA_HOME=C:\Program Files\Java\jdk-17
mvn spring-boot:run
```

**Watch the logs:**
You should see:
```
INFO - Initializing database with sample products...
INFO - Successfully inserted 58 products into database
```

### Step 3: Verify Products Loaded

```powershell
$products = Invoke-RestMethod -Uri "http://localhost:8080/api/products"
Write-Host "Total products loaded: $($products.Count)" -ForegroundColor Green

# Show first 10 products
$products | Select-Object -First 10 | Format-Table id, name, price, imageUrl, stock
```

**Expected output:**
```
Total products loaded: 58
```

### Step 4: Test Image Access

```powershell
# Test if images are accessible
$testImage = "download (1).jpeg"
try {
    Invoke-WebRequest -Uri "http://localhost:8080/images/$testImage" -UseBasicParsing
    Write-Host "✅ Images are accessible!" -ForegroundColor Green
} catch {
    Write-Host "❌ Images not accessible" -ForegroundColor Red
}
```

### Step 5: Refresh Frontend

1. Open: http://localhost:3000
2. Refresh the page (F5)
3. You should see all 58 products with images!

---

## Product Categories

### Baby Cars (12 products)
- Ages: 1-12 months
- Price range: ₹499.99 - ₹719.99
- Images: download (10-21).jpeg

### Fun Racers (12 products)
- Ages: 1-6 years
- Price range: ₹599.99 - ₹929.99
- Images: download (1-8).jpeg, images (1-3).jpeg

### Speedsters (12 products)
- Ages: 6-12 years
- Price range: ₹699.99 - ₹974.99
- Images: download (22-30).jpeg, images (4-6).jpeg

### Collector Editions (12 products)
- Ages: 12+ years
- Price range: ₹999.99 - ₹1549.99
- Images: images (7-11).jpeg, download (31-37).jpeg

### Special Editions (6 products)
- Track sets, garages, monster trucks
- Price range: ₹899.99 - ₹2499.99
- Images: download (9).jpeg, images (12-13).jpeg, etc.

---

## Image URL Format

All product images are served from:
```
http://localhost:8080/images/{imageUrl}
```

Examples:
- `http://localhost:8080/images/download (1).jpeg`
- `http://localhost:8080/images/images (7).jpeg`
- `http://localhost:8080/images/download.jpeg`

---

## Troubleshooting

### Products Not Loading?
```powershell
# Check if backend is running
Invoke-RestMethod -Uri "http://localhost:8080/api/products"
```

### Images Not Showing?
1. Check image exists:
```powershell
Test-Path "backend\src\main\resources\static\images\download (1).jpeg"
```

2. Check image is accessible:
```powershell
Invoke-WebRequest -Uri "http://localhost:8080/images/download (1).jpeg" -UseBasicParsing
```

3. Check browser console (F12) for errors

### DataLoader Not Running?
Check backend logs for:
```
INFO - Initializing database with sample products...
```

If you see:
```
INFO - Products already exist in database. Skipping data initialization.
```

Then products weren't deleted. Go back to Step 1.

---

## Quick Commands

### Delete all products and restart:
```powershell
# Delete products
$products = Invoke-RestMethod -Uri "http://localhost:8080/api/products"
$products | ForEach-Object { Invoke-RestMethod -Uri "http://localhost:8080/api/products/$($_.id)" -Method DELETE }

# Then restart backend (Ctrl+C and mvn spring-boot:run)
```

### Check product count:
```powershell
(Invoke-RestMethod -Uri "http://localhost:8080/api/products").Count
```

### View all product names:
```powershell
(Invoke-RestMethod -Uri "http://localhost:8080/api/products").name
```

---

## Success Criteria

✅ 58 products in database
✅ All products have imageUrl
✅ Images accessible at http://localhost:8080/images/*
✅ Frontend displays all products
✅ Images load correctly in browser
✅ No broken image icons

---

## Next Steps

After loading all products:
1. Test browsing products at http://localhost:3000
2. Test adding products to cart
3. Test buying products
4. Check that all images display correctly
5. Verify stock levels are shown

Your Hot Wheels store will have a full catalog of 58 products! 🏎️
