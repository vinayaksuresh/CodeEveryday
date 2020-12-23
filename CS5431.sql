CREATE TABLE Department
(
    DeptId INTEGER NOT NULL,
    DeptName VARCHAR(100),
    CONSTRAINT Department_PK PRIMARY KEY (DeptId),
    CONSTRAINT Department_Unique UNIQUE (DeptName)
);


CREATE TABLE Project
(
    ProjId INTEGER NOT NULL,
    ProjName VARCHAR(100),
    CONSTRAINT Project_PK PRIMARY KEY (ProjId),
    CONSTRAINT Project_Unique UNIQUE (ProjName)
);

CREATE TABLE Task
(
    TaskId INTEGER NOT NULL,
    TaskName VARCHAR(100),
    TaskType VARCHAR(100),
    ProjId INTEGER,
    CONSTRAINT Task_PK PRIMARY KEY (TaskId),
    CONSTRAINT fk_project FOREIGN KEY (ProjId) REFERENCES Project(ProjId)
);

CREATE TABLE Employee
(
    EmpId INTEGER NOT NULL,
    EmpName VARCHAR(100),
    DeptId INTEGER,
    HomeZipCode VARCHAR(10),
    EmpRole VARCHAR(50),
    ManagerId INTEGER,
    CONSTRAINT Employee_PK PRIMARY KEY (EmpId),
    CONSTRAINT fk_department FOREIGN KEY (DeptId) REFERENCES Department(DeptId),
    CONSTRAINT fk_employee FOREIGN KEY (ManagerId) REFERENCES Employee(EmpId)
);

CREATE TABLE ProjectLeader
(
    ProjId INTEGER NOT NULL,
    LeaderId INTEGER NOT NULL,
    StartDate DATE NOT NULL,
    EndDate DATE,
    CONSTRAINT ProjectLeader_PK PRIMARY KEY (ProjId, LeaderId, StartDate),
    CONSTRAINT fk_project_leader FOREIGN KEY (ProjId) REFERENCES Project(ProjId),
    CONSTRAINT fk_emp_leader FOREIGN KEY (LeaderId) REFERENCES Employee(EmpId)
);

CREATE TABLE TaskEmployees
(
    TaskId INTEGER NOT NULL,
    EmpId INTEGER NOT NULL,
    CONSTRAINT TaskEmployees_PK PRIMARY KEY (TaskId, EmpId),
    CONSTRAINT fk_task_emp_empid FOREIGN KEY (EmpId) REFERENCES Employee(EmpId),
    CONSTRAINT fk_task_emp_taskid FOREIGN KEY (TaskId) REFERENCES Task(TaskId)
);



INSERT INTO Department
    (DeptId, DeptName)
VALUES
    (1, 'Development');
INSERT INTO Department
    (DeptId, DeptName)
VALUES
    (2, 'Marketing');
INSERT INTO Department
    (DeptId, DeptName)
VALUES
    (3, 'Research');


INSERT INTO Project
    (ProjId, ProjName)
VALUES
    (1, 'Apollo');
INSERT INTO Project
    (ProjId, ProjName)
VALUES
    (2, 'Plutonium');
INSERT INTO Project
    (ProjId, ProjName)
VALUES
    (3, 'Fusion');


INSERT INTO Task
    (TaskId, TaskName, ProjId)
VALUES
    (1, 'Design', 2);
INSERT INTO Task
    (TaskId, TaskName, ProjId)
VALUES
    (2, 'Analysis', 1);
INSERT INTO Task
    (TaskId, TaskName, ProjId)
VALUES
    (3, 'Audit', 3);

INSERT INTO Employee
    (EmpId, EmpName, EmpRole, HomeZipCode, DeptId, ManagerId)
VALUES
    (1, 'John', 'Director', 90033, 1, null);
INSERT INTO Employee
    (EmpId, EmpName, EmpRole, HomeZipCode, DeptId, ManagerId)
VALUES
    (2, 'Allie', 'Analyst', 67136, 2, null);
INSERT INTO Employee
    (EmpId, EmpName, EmpRole, HomeZipCode, DeptId, ManagerId)
VALUES
    (3, 'Anne', 'Developer', 78723, 1, 1);

INSERT INTO TaskEmployees
    (TaskId, EmpId)
VALUES
    (1, 2);
INSERT INTO TaskEmployees
    (TaskId, EmpId)
VALUES
    (2, 2);
INSERT INTO TaskEmployees
    (TaskId, EmpId)
VALUES
    (3, 3);


INSERT INTO ProjectLeader
    (ProjId, LeaderId, StartDate, EndDate)
VALUES
    (1, 1, DATE('2019-1-21'), DATE('2019-08-01'));
INSERT INTO ProjectLeader
    (ProjId, LeaderId, StartDate)
VALUES
    (2, 2, DATE('2019-09-21'));


-- 1.1. For each employee, display their name, role, department name, the name of the employee’s manager.
SELECT employee.EmpName, employee.EmpRole, department.DeptName, manager.EmpName
FROM Employee as employee
    LEFT JOIN Department as department ON employee.DeptId = department.DeptId
    LEFT JOIN Employee as manager ON manager.EmpId = employee.ManagerId;

-- 1.2. Find the names of the project leaders who lead projects in which the employees have worked on only one project.
SELECT E.EmpName
FROM (SELECT T.ProjId
    FROM TaskEmployees as TE
        LEFT JOIN Task as T
        ON TE.TaskId = T.TaskId
    GROUP BY TE.EmpId
    HAVING COUNT(T.ProjId) = 1) AS derived
    LEFT JOIN ProjectLeader as PL ON derived.ProjId = PL.ProjId
    LEFT JOIN Employee as E ON PL.LeaderId = E.EmpId

-- 1.3. Find the names of the employees who are living in West Lafayette (Zipcode 47906 or 47907).
SELECT EmpName
FROM Employee
WHERE HomeZipCode IN (47906, 47907);

-- 1.4. Find the names of projects where the all employees assigned to these projects work on the same department
SELECT P.ProjName
FROM TaskEmployees as TE
    LEFT JOIN Task as T ON TE.TaskId = T.TaskId
    LEFT JOIN Employee as E ON TE.EmpId = E.EmpId
    LEFT JOIN Project as P ON T.ProjId = P.ProjId
GROUP BY T.ProjId
HAVING COUNT(DISTINCT(E.DeptId)) = 1;

-- 1.10. Find the names of all employees whose managers have lead projects after the year 2000.
SELECT EmpName
FROM Employee
WHERE ManagerId IN (SELECT LeaderId
FROM ProjectLeader
WHERE StartDate > 1999-12-31);


-- 1.11. Find the names of all employees who are managed by a manager who lives in the same zip code as them.
SELECT e.EmpName
FROM Employee as e, Employee as m
WHERE (e.ManagerId = m.EmpId AND e.HomeZipCode = m.HomeZipCode);

-- 1.12. Find the names of all projects where at least two employees from the same department are working on that project.
SELECT P.ProjName
FROM TaskEmployees as TE
    LEFT JOIN Task as T ON TE.TaskId = T.TaskId
    LEFT JOIN Employee as E ON TE.EmpId = E.EmpId
    LEFT JOIN Project as P ON T.ProjId = P.ProjId
GROUP BY T.ProjId, E.DeptId
HAVING COUNT(*) >= 2;

-- 1.4. Find the names of projects where the all employees assigned to these projects work on the same department
SELECT P.ProjName
FROM TaskEmployees as TE
    LEFT JOIN Task as T ON TE.TaskId = T.TaskId
    LEFT JOIN Employee as E ON TE.EmpId = E.EmpId
    LEFT JOIN Project as P ON T.ProjId = P.ProjId
GROUP BY T.ProjId
HAVING COUNT(DISTINCT(E.DeptId)) = 1;



