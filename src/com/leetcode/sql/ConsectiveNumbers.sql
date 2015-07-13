/*
https://leetcode.com/problems/employees-earning-more-than-their-managers/

The Employee table holds all employees including their managers. Every employee has an Id, and there is also a column for the manager Id.

+----+-------+--------+-----------+
| Id | Name  | Salary | ManagerId |
+----+-------+--------+-----------+
| 1  | Joe   | 70000  | 3         |
| 2  | Henry | 80000  | 4         |
| 3  | Sam   | 60000  | NULL      |
| 4  | Max   | 90000  | NULL      |
+----+-------+--------+-----------+
Given the Employee table, write a SQL query that finds out employees who earn more than their managers. For the above table, Joe is the only employee who earns more than his manager.

+----------+
| Employee |
+----------+
| Joe      |
+----------+
 */

/*
 * Data Preparation
 * 
  create table employee(
  id int,
  Name varchar(255),
  Salary int,
  ManagerId int);
  
  insert into employee values(1, 'Joe', 7000, 3);
  
  insert into employee values(2, 'Henry', 8000, 4);
  
  insert into employee values(3, 'Sam', 6000, NULL);
  
  insert into employee values(4, 'Max', 9000, NULL);
  
  drop table employee;
*/

select e.name FROM Employee  as e inner join Employee  as m where e.ManagerId = m.id and e.Salary > m.Salary;


  