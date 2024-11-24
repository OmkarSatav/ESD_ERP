CREATE DATABASE ERP;

USE ERP;

-- Creating Departments table
CREATE TABLE Departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    capacity INT NOT NULL
);

-- Display all tables
SHOW TABLES;

-- Display structure of Departments table
DESCRIBE Departments;

-- Creating Employees table
CREATE TABLE Employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    title VARCHAR(100),
    photograph_path VARCHAR(255),
    department INT
);

-- Display all tables
SHOW TABLES;

-- Display structure of Employees table
DESCRIBE Employees;

-- Creating Employee_Salary table
CREATE TABLE Employee_Salary (
    id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    payment_date DATE NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    description VARCHAR(100)
);

-- Display all tables
SHOW TABLES;

-- Display structure of Employee_Salary table
DESCRIBE Employee_Salary;

