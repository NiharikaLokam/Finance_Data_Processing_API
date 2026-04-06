# Finance Data Processing and Access Control Backend

## 📌 Overview
This project is a backend system for managing financial records with role-based access control. It provides APIs for creating, retrieving, filtering, and summarizing financial data, designed to support a finance dashboard.

---

## 🚀 Features

### 🔐 Role-Based Access Control
- ADMIN → Full access (create, delete, manage records)
- ANALYST → View + filter + summary
- VIEWER → Read-only access

### 📊 Financial Records
- Create financial records
- View all records (with pagination)
- View record by ID
- Delete records
- Filter by type (income/expense) and category

### 📈 Dashboard Summary
- Total Income
- Total Expense
- Net Balance

### 🛡 Validation & Error Handling
- Input validation using `@Valid`
- Global exception handling
- Proper HTTP status codes

---

## 🧱 Tech Stack

- Java
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- H2 / MySQL Database
- Maven

---

## 📂 Project Structure


controller/
service/
repository/
entity/
security/
exception/
dto/


---

## 🔗 API Endpoints

### 📌 Records

| Method | Endpoint | Description |
|-------|--------|------------|
| POST | /api/records | Create record (ADMIN) |
| GET | /api/records | Get all records |
| GET | /api/records/{id} | Get record by ID |
| DELETE | /api/records/{id} | Delete record (ADMIN) |
| GET | /api/records/filter | Filter records |

---

### 📊 Dashboard

| Method | Endpoint | Description |
|-------|--------|------------|
| GET | /api/records/summary | Financial summary |

---

## 🔐 Authentication

Basic Auth is used:

| Role | Username | Password |
|------|---------|---------|
| ADMIN | admin | 123 |
| ANALYST | analyst | 123 |
| VIEWER | viewer | 123 |

---

## ▶️ How to Run

1. Clone the repository

git clone https://github.com/your-username/finance-data-processing-api.git


2. Open in IDE (IntelliJ / Eclipse)

3. Run the main class:

FinanceDataProcessingAndAccessControlApplication


4. Server runs at:

http://localhost:8080


---

## 🧪 Testing APIs

Use Postman:

### Create Record
POST `/api/records`


{
"amount": 1000,
"type": "income",
"category": "salary",
"date": "2026-04-05",
"notes": "monthly salary"
}


---

## ⚠️ Assumptions

- Authentication is implemented using in-memory users
- Roles are predefined (ADMIN, ANALYST, VIEWER)
- Only ADMIN can modify data
- Simplified setup for demonstration purposes
