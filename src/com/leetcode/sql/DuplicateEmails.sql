/*
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Note: All emails are in lowercase.

*/

--Data perparation
/*
create table Person(
id int,
email varchar(255)
);

insert into Person values (1, 'a@b.com');

insert into Person values (2, 'c@d.com');

insert into Person values (3, 'a@b.com');

drop table Person;

*/



select email from Person group by email having count(email)>1;