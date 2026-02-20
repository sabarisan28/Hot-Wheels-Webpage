-- Clear all data from Hot Wheels database
-- Run this in Supabase SQL Editor

-- Step 1: Delete order items (has foreign keys to orders and products)
DELETE FROM order_items;

-- Step 2: Delete orders (has foreign key to users)
DELETE FROM orders;

-- Step 3: Delete products (now safe to delete)
DELETE FROM products;

-- Step 4: Optionally delete users (if you want fresh start)
-- DELETE FROM users;

-- Verify deletion
SELECT 'order_items' as table_name, COUNT(*) as count FROM order_items
UNION ALL
SELECT 'orders', COUNT(*) FROM orders
UNION ALL
SELECT 'products', COUNT(*) FROM products
UNION ALL
SELECT 'users', COUNT(*) FROM users;

-- Expected result: All counts should be 0 (except users if you didn't delete them)
