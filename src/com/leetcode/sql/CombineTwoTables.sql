/*
Combine Two Tables

https://leetcode.com/problems/combine-two-tables/

Table: Person

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| PersonId    | int     |
| FirstName   | varchar |
| LastName    | varchar |
+-------------+---------+
PersonId is the primary key column for this table.
Table: Address

+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| AddressId   | int     |
| PersonId    | int     |
| City        | varchar |
| State       | varchar |
+-------------+---------+
AddressId is the primary key column for this table.

Write a SQL query for a report that provides the following information for each person in the Person table, regardless if there is an address for each of those people:

FirstName, LastName, City, State

######Data Preparation######

drop table Address;
drop table Person;

create table Person(
  PersonId int,
  FirstName varchar(255),
  LastName varchar(255)
);

create table Address(
  AddressId int,
  PersonId int,
  City varchar(255),
  State varchar(255)
);

*/



select p.FirstName, p.LastName, a.City, a.State from Person p 
       left join Address a
       on p.PersonId = a.PersonId;