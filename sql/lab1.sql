set echo on
set linesize 132
set pagesize 66

spool c:/cprg250s/lab1output.txt

rem Made by Brennan Brown

rem QUESTION 1

select title as "Book Title" 
from books 
order by title;

rem QUESTION 2

select lastname || ', ' || 
firstname       || ', ' || 
address         || ', ' || 
city            || ', ' || 
state           || ', ' || 
zip 
"Customer Information"
from customers 
order by lastname, firstname;

rem QUESTION 3

select title, cost, retail, 
(retail-cost)/cost*100 "% Profit"
from books 
order by "% Profit";

rem QUESTION 4

select pubid
as "Publisher ID"
from publisher
order by pubid;

spool off
