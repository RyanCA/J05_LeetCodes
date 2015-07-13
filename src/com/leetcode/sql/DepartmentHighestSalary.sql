/*
Department Highest Salary 
https://leetcode.com/problems/department-highest-salary/

The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who have the highest salary in each of the departments. For the above tables, Max has the highest salary in the IT department and Henry has the highest salary in the Sales department.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+

######Data Preparation######

drop table Employee;

drop table department;

create table Employee(
Id int,
Name varchar(255),
Salary int,
DepartmentId int
);

create table Department(
Id int,
Name varchar(255)
);

insert into Employee values(1, 'Joe', 70000, 1);
insert into Employee values(2, 'Henry', 80000, 2);
insert into Employee values(3, 'Sam', 60000, 2);
insert into Employee values(4, 'Max', 90000, 1);

insert into Department values(1, 'IT');

insert into Department values(2, 'Sales');

*/
#select * from Employee;

#Key the max(salary) must placed outside of the 3rd select clause to the 2nd select loop, otherwise it can not 
#list the max salary based on each departments. I don't know why it just cannot

select d.Name, e.Name as Employee, e.Salary from  (
  select max(salary) as Salary, DepartmentId from (
    select Salary, DepartmentId from Employee group by Salary, DepartmentId order by DepartmentId asc, Salary desc
    ) as t1 group by t1.DepartmentId 
  ) as t2 inner join Department as d on t2.DepartmentId=d.Id
          left join Employee as e on e.Salary = t2.Salary and e.DepartmentId = t2.DepartmentId
