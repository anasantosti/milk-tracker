# Milk Tracker Backend API

Backend API for the **Milk Tracker** application, built with Java, Spring Boot, MySQL, and Spring Data JPA.

This project allows farmers or dairy producers to register daily milk production, view historical records, calculate monthly totals, and export reports.

---

# Technologies

- Java 26
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Bean Validation
- Apache POI (Excel export)

---

# Features

## Milk Registration

- Register daily milk production
- One entry per day
- Update existing entries
- Delete entries

---

## History & Reports

- View monthly production history

### Calculations

- Monthly total liters
- Daily average
- Recorded days count

### Export Reports

- Excel (monthly)
- Excel (yearly)

---

## API Features

- RESTful API
- DTO validation
- Exception handling
- Clean architecture
- Database persistence with MySQL

---

# Project Structure

```text
src/main/java/com/yourcompany/milktracker
│
├── config
├── controller
├── dto
├── entity
├── exception
├── repository
├── service
├── mapper
└── util
```
---
# Start Application

```bash
./mvnw spring-boot:run
```

Application will run on:

```text
http://localhost:8080
```

---

# Validation Rules

- Date is required
- Liters must be greater than or equal to zero
- Only one entry per date is allowed

---

# Future Improvements

- Authentication with JWT
- Multiple farms support
- Dashboard with charts
- PDF exports
- Cloud storage
- Mobile app integration
- Offline synchronization
- Production analytics
