use ERP;

INSERT INTO Departments (name, capacity)
VALUES
    ('Academic', 500),
    ('Accounts', 50),
    ('Support', 15),
    ('Administration', 5);

SELECT *FROM Departments;

INSERT INTO Employees (first_name, last_name, email, title, photograph_path, department)
VALUES
    -- Employees in Academic (department_id = 1)
    ('Mahesh', 'Patil', 'mahesh.patil@university.com', 'Professor', 'https://drive.google.com/file/d/1Y4gohuq15K3pyWNSyH___ydK7_1fadbk/view?usp=sharing', 1),
    ('Ramesh', 'Solanki', 'ramesh.solanki@university.com', 'Lecturer', 'https://drive.google.com/file/d/1Y4gohuq15K3pyWNSyH___ydK7_1fadbk/view?usp=sharing', 1),
    ('Jai', 'Deshmukh', 'jai.deshmukh@university.com', 'Senior Lecturer', 'https://drive.google.com/file/d/1Y4gohuq15K3pyWNSyH___ydK7_1fadbk/view?usp=sharing', 1),
    ('Naresh', 'Chavan', 'naresh.chavan@university.com', 'Research Associate', 'https://drive.google.com/file/d/1Y4gohuq15K3pyWNSyH___ydK7_1fadbk/view?usp=sharing', 1),
    ('Himanshu', 'Shah', 'himanshu.shah@university.com', 'Teaching Assistant', 'https://drive.google.com/file/d/1Y4gohuq15K3pyWNSyH___ydK7_1fadbk/view?usp=sharing', 1),

    -- Employees in Accounts (department_id = 2)
    ('Suresh', 'Vora', 'suresh.vora@university.com', 'Accountant', 'https://drive.google.com/file/d/1Y4gohuq15K3pyWNSyH___ydK7_1fadbk/view?usp=sharing', 2),
    ('Nita', 'Pandya', 'nita.pandya@university.com', 'Accounts Manager', 'https://drive.google.com/file/d/1Y4gohuq15K3pyWNSyH___ydK7_1fadbk/view?usp=sharing', 2),

    -- Employees in Support (department_id = 3)
    ('Ashok', 'Thakare', 'ashok.thakare@university.com', 'IT Technician', 'https://drive.google.com/file/d/1Y4gohuq15K3pyWNSyH___ydK7_1fadbk/view?usp=sharing', 3),
    ('Meena', 'Patadia', 'meena.patadia@university.com', 'Support Executive', 'https://drive.google.com/file/d/1Y4gohuq15K3pyWNSyH___ydK7_1fadbk/view?usp=sharing', 3),

    -- Employees in Administration (department_id = 4)
    ('Rajesh', 'Modi', 'rajesh.modi@university.com', 'Admin Manager', 'https://drive.google.com/file/d/1Y4gohuq15K3pyWNSyH___ydK7_1fadbk/view?usp=sharing', 4),
    ('Pooja', 'Bhatt', 'pooja.bhatt@university.com', 'Administrative Assistant', 'https://drive.google.com/file/d/1Y4gohuq15K3pyWNSyH___ydK7_1fadbk/view?usp=sharing', 4);


SELECT *FROM Employees;


INSERT INTO Employee_Salary (employee_id, payment_date, amount, description)
VALUES
    -- Academic Employees
    (1, '2024-11-01', 3500.00, 'Salary for November 2024'),
    (2, '2024-11-01', 3500.00, 'Salary for November 2024'),
    (3, '2024-11-01', 3000.00, 'Salary for November 2024'),
    (4, '2024-11-01', 3500.00, 'Salary for November 2024'),
    (5, '2024-11-01', 3000.00, 'Salary for November 2024'),

    -- Accounts Employees
    (6, '2024-11-01', 3500.00, 'Salary for November 2024'),
    (7, '2024-11-01', 5000.00, 'Salary for November 2024'),

    -- Support Employees
    (8, '2024-11-01', 3000.00, 'Salary for November 2024'),
    (9, '2024-11-01', 2800.00, 'Salary for November 2024'),

    -- Administration Employees
    (10, '2024-11-01', 4000.00, 'Salary for November 2024'),
    (11, '2024-11-01', 3500.00, 'Salary for November 2024');


select *from Employee_salary;
