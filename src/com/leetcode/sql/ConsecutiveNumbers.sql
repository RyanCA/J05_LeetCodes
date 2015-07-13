# Write your MySQL query statement below

/*
Consecutive Numbers 

https://leetcode.com/problems/consecutive-numbers/

The key is to join same table three time with specific conditions

Write a SQL query to find all numbers that appear at least three times consecutively.

+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
For example, given the above Logs table, 1 is the only number that appears consecutively for at least three times.

#########data preparation########

drop table Logs;

create table Logs(
Id int,
Num int
);

insert into Logs values(1, 1);

insert into Logs values(2, 1);

insert into Logs values(3, 1);

insert into Logs values(4, 2);

insert into Logs values(5, 1);

insert into Logs values(6, 2);

insert into Logs values(7, 2);


*/


#if without group by clause, the record appeared more than 3 times will be displayed multiple times

select l1.Num as ConsecutiveNums 
from Logs as l1 left join Logs as l2 on l1.id+1 = l2.Id 
                left join Logs as l3 on l2.id+1 = l3.Id 
where l1.Num = l2.Num and l2.Num = l3.Num
group by l1.Num;
                

