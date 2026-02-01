# Assignment 4 – SOLID Library API

## 📌 Project Description
This project is a simple **Library Management API** implemented in Java using **OOP and SOLID principles**.  
The system allows managing books of different types (**EBook** and **PrintedBook**) with database persistence and reflection utilities.

The project is structured using **Controller – Service – Repository** layers.

---

## 🧱 Project Structure
src/
├─ controller/
│ └─ LibraryController.java
├─ service/
│ ├─ BookService.java
│ └─ CategoryService.java
├─ repository/
│ ├─ BookRepository.java
│ └─ CategoryRepository.java
├─ model/
│ ├─ BookBase.java
│ ├─ EBook.java
│ └─ PrintedBook.java
├─ dto/
│ └─ BookCreateDto.java
├─ exception/
│ ├─ InvalidInputException.java
│ ├─ ValidationException.java
│ └─ DatabaseOperationException.java
├─ utils/
│ ├─ DatabaseConnection.java
│ └─ ReflectionUtils.java
└─ Main.java


Additional files:
resources/
└─ schema.sql

docs/
├─ screenshots/
└─ uml.png


---

## 🧠 OOP & SOLID Principles
- **Abstraction**: `BookBase` is an abstract class
- **Inheritance**: `EBook` and `PrintedBook` extend `BookBase`
- **Polymorphism**: methods like `getType()` and `fullInfo()` are overridden
- **Single Responsibility**: each layer has its own responsibility
- **Open/Closed Principle**: new book types can be added without modifying existing logic

---

## ⚙️ Functionality
- Create books (`EBook`, `PrintedBook`)
- Read all books from database
- Validation of input data
- Custom exceptions handling
- Sorting books by price
- Filtering books by type
- Searching books by title
- Finding the most expensive book
- Reflection-based class inspection

---

## 🔍 Reflection
The project uses `ReflectionUtils` to dynamically inspect:
- Class name
- Fields
- Methods

Reflection output is shown in the console for:
- `EBook`
- `PrintedBook`

---

## ▶️ How to Run
1. Configure PostgreSQL database
2. Execute `schema.sql`
3. Run `Main.java`
4. Observe console output (CRUD + Reflection)

---

## 📸 Screenshots
Screenshots demonstrating:
- Program execution
- CRUD operations
- Reflection output
- Project structure
- UML diagram

are located in:
docs/screenshots/


---

## 👤 Author
**AKZHAN**

Assignment 4 – Object-Oriented Programming 



