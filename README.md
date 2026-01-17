# Assignment 3 – Simple Library System

Author: **AKZHAN**

## Description
This is a simple console-based Library System written in **Java**.
The project uses **PostgreSQL** database and **JDBC** connection.

The goal of the project is to demonstrate basic OOP concepts and CRUD operations.

## Project Structure
- model – book and category classes
- repository – work with database
- service – validation and logic
- controller – example controller
- utils – database connection and schema initialization

## OOP Used
- Inheritance (`EBook`, `PrintedBook`)
- Polymorphism (`BookBase`)
- Custom exception (`ValidationException`)

## Database
Database name: `library`

Tables:
- categories
- books

Tables are created from:
resources/schema.sql



## How to Run
1. Start PostgreSQL
2. Create database `library`
3. Update credentials in `DatabaseConnection.java`
4. Run `Main.java`

## Notes
All operations are demonstrated in the `Main` class and printed to the console.

Screenshots are located in:
docs/screenshots/



