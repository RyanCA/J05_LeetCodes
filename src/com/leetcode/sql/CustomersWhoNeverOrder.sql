# Write your MySQL query statement below
/*
Customers Who Never Order
https://leetcode.com/problems/customers-who-never-order/

Suppose that a website contains two tables, the Customers table and the Orders table. Write a SQL query to find all customers who never order anything.

Table: Customers.

+----+-------+
| Id | Name  |
+----+-------+
| 1  | Joe   |
| 2  | Henry |
| 3  | Sam   |
| 4  | Max   |
+----+-------+
Table: Orders.

+----+------------+
| Id | CustomerId |
+----+------------+
| 1  | 3          |
| 2  | 1          |
+----+------------+
Using the above tables as example, return the following:

+-----------+
| Customers |
+-----------+
| Henry     |
| Max       |
+-----------+

######Data Preparation######
######Implementation is based on MySQL######

create table Customers(
Id int, 
Name varchar(255),
primary key(Id)
);

create table Orders(
Id int,
CustomerId int,
primary key(Id),
foreign key (CustomerId) references Customers(Id)
);

insert into Customers values(1, 'Joe');
insert into Customers values(2, 'Henry');
insert into Customers values(3, 'Sam');
insert into Customers values(4, 'Max');

insert into Orders values(1, 3);
insert into Orders values(2, 1);

*/

select Name from Customers where Id not in (select CustomerId FROM Orders group by CustomerId);


