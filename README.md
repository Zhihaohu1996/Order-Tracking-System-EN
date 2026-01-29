# Order Tracking Web Service
Spring Boot + MySQL + Flyway + Session Login + Vanilla HTML/JS

> This is a **web-based** order workflow tracking system: you can use it directly in a browser (the frontend pages are hosted by the backend service). The backend also provides REST APIs, and the database schema is automatically created/migrated via Flyway.

---

## 1. What this project can do (Feature List)
- ✅ Login (username/password), session-based auth (cookie) to keep users signed in
- ✅ Role-based access control (GM / SALES / PMC / PRODUCTION / WAREHOUSE / GUEST)
- ✅ Order CRUD (GM/SALES)
- ✅ Sensitive field masking (for non-GM/SALES: customer / amount / unit price / payment terms will display as ***)
- ✅ Production planning (PMC)
- ✅ Material evaluation (PMC, supports purchasing / inventory)
- ✅ Process progress tracking (PRODUCTION/PMC)
- ✅ Warehouse receiving logs (WAREHOUSE: supports multiple / partial receiving entries)
- ✅ Receiving confirmation (WAREHOUSE: requires “process completed” before confirmation)
- ✅ Shipping plan (SALES)
- ✅ Shipping confirmation & archiving (WAREHOUSE: once confirmed, the order moves to ARCHIVED)
- ✅ Order photo upload/delete (image/*, single file ≤ 10MB, stored locally in the `uploads` directory)
- ✅ Export CSV (export after filtering the order list)
- ✅ Import orders (upload Excel/CSV, or paste table text directly)
- ✅ User management (GM: create users, reset passwords, enable/disable, delete)
- ✅ Audit logs (GM: search/filter/paginate)

---

## 2. Requirements
- JDK 17+
- Maven 3.9+
- MySQL 8.0+

---

## 3. Database Initialization (One-time setup)
Recommended database name: `order_tracking_auth`

Run in MySQL:
```sql
CREATE DATABASE IF NOT EXISTS order_tracking_auth
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_0900_ai_ci;
