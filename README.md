<div align="center">
  <img src="SCHOLARGATE.png" width="500" height="500">
</div>


# 🎓Scholarship Management System with Java and MySQL

The Scholarship Management System is a Java-based application designed to manage qualifiers for scholarships. It integrates with a MySQL database to store, retrieve, and update information about applicants, including their academic qualifications and personal details. This system is an efficient way to maintain a centralized database for scholarship records, ensuring data accuracy and accessibility.

# ✨Key Features

**1. 📂Data Store and Management**

Stores details of qualifiers, such as their name, educational background, and contact information.

Separates qualifiers based on their educational level (e.g., college or senior high school).

**2. 🔄CRUD Operations:**

**Create:** Add new qualifiers to the system.

**Read:** Retrieve qualifier information from the database.

**Update:** Modify existing records for qualifiers.

**Delete:** Remove qualifiers from the system.

**3. 🗃️ Database Integration:**

Built on a MySQL database to handle data storage with tables for qualifierslist, college_qualifiers, and senior_high_qualifiers.

Foreign key relationships ensure referential integrity between tables.

# 🛠️Technology Stack

**Programming Language:** Java

**Database:** MySQL

**⚙️Tools:**

JDBC for database connectivity

dbdiagram.io for schema design

GitHub for version control and collaboration

# 🗺️Database Schema

**📋 Tables:**

qualifierslist - Stores general information about all qualifiers.

college_qualifiers - Specific table for college-level qualifiers.

senior_high_qualifiers - Specific table for senior high school qualifiers.

**🔗Relationships:**

qualifierslist serves as the parent table, linked to college_qualifiers and senior_high_qualifiers through the serial_number field.

# 🗃️ Project Structure

**Java Code:**
DatabaseConnection.java: Handles all database operations.

Main.java: Acts as the entry point for the application.

**Database Files:**

init.sql: SQL script to create tables and populate initial data.

schema.png: Visual representation of the database schema.

**Documentation:**

README.md: Describes project setup, usage, and features.

# 🚀How it Works

**Initialization:**

Execute the init.sql script to set up the database schema and populate sample data.

**Running the App:**

Use the Java application to interact with the database for operations like adding new qualifiers or updating existing ones.

**Database Operations:**

All operations are executed using prepared SQL statements to ensure security and prevent SQL injection.
