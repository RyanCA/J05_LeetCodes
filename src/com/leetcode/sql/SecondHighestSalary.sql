# Write your MySQL query statement below
/*
Second Highest Salary

https://leetcode.com/problems/second-highest-salary/

drop table Employee;

create table Employee(
Id int,
Salary int);

insert into Employee values(1, 100);
insert into Employee values(2, 200);
insert into Employee values(3, 300);

*/

select distinct max(salary) from Employee where salary not in (select distinct max(salary) from Employee)

#select distinct max(salary) from Employee where salary not in (select distinct salary from Employee group by salary desc limit 1)