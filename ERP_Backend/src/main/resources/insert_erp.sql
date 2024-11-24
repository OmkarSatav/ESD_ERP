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
