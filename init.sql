CREATE DATABASE scholarshipdb;

USE scholarshipdb;

CREATE TABLE qualifierslist (
    serial_number INT AUTO_INCREMENT PRIMARY KEY,
    last_name VARCHAR(100),
    first_name VARCHAR(100),
    middle_name VARCHAR(100),
    academic_institution VARCHAR(200),
    email VARCHAR(100)
);

CREATE TABLE college_qualifiers (
    serial_number INT PRIMARY KEY,
    last_name VARCHAR(100),
    first_name VARCHAR(100),
    middle_name VARCHAR(100),
    academic_institution VARCHAR(200),
    email VARCHAR(100),
    FOREIGN KEY (serial_number) REFERENCES qualifierslist(serial_number)
);

CREATE TABLE senior_high_qualifiers (
    serial_number INT PRIMARY KEY,
    last_name VARCHAR(100),
    first_name VARCHAR(100),
    middle_name VARCHAR(100),
    academic_institution VARCHAR(200),
    email VARCHAR(100),
    FOREIGN KEY (serial_number) REFERENCES qualifierslist(serial_number)
);
