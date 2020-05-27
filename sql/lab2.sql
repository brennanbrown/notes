set echo on
set linesize 132
set pagesize 66

spool c:/cprg250s/lab2output.txt

rem Made by Brennan Brown

rem QUESTION 1

select lastname
from customers
where state = 'FL'
order by lastname;

rem QUESTION 2

select title, pubdate
from books
where (retail - cost) > 25
order by title;

rem QUESTION 3

select title
from books
where discount > 3
order by discount;

rem QUESTION 4

select firstname, lastname
from customers
where region = 'N' OR 
      region = 'NE' OR 
      region = 'NW'
order by lastname desc, firstname;

rem QUESTION 5

select firstname, lastname
from customers
where region IN ('N', 'NE', 'NW')
order by lastname desc, firstname;

spool off
