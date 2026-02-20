# Clear Products from Database

To load all 58 new products with images, you need to clear existing products first.

## Option 1: Via Supabase SQL Editor

1. Go to: https://supabase.com/dashboard
2. Select your project
3. Go to SQL Editor
4. Run this query:

```sql
-- Delete all products (this will also delete related order_items due to foreign key)
DELETE FROM order_items;
DELETE FROM products;

-- Verify deletion
SELECT COUNT(*) FROM products;
```

## Option 2: Via API (PowerShell)

```powershell
# Get all products
$products = Invoke-RestMethod -Uri "http://localhost:8080/api/products"

# Delete each product
foreach ($product in $products) {
    Invoke-RestMethod -Uri "http://localhost:8080/api/products/$($product.id)" -Method DELETE
}
```

## After Clearing

1. Stop the backend (Ctrl+C)
2. Restart the backend:
```bash
cd backend
set JAVA_HOME=C:\Program Files\Java\jdk-17
mvn spring-boot:run
```

3. The DataLoader will automatically insert 58 products!

## Check Results

```powershell
$products = Invoke-RestMethod -Uri "http://localhost:8080/api/products"
Write-Host "Total products: $($products.Count)"
```

Should show: **Total products: 58**
