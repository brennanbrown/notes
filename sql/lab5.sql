set echo on
set linesize 132
set pagesize 66

spool c:/cprg250s/lab5output.txt

rem Made by Brennan Brown


rem QUESTION 1

COLUMN   "Total Paid" FORMAT $9,990.00 
select   firstname "First Name", lastname "Last Name", 
         order# "Order #", sum(paideach) "Total Paid"
from     customers natural join orders
                   natural join orderitems
group by firstname, lastname, order#
order by order#;


rem QUESTION 2

COLUMN   "Average # of Books" FORMAT 9,990.00 
select   avg(count(title)) "Average # of Books"
from     orderitems natural join 
         books      natural join
         bookauthor
group by authorid;


rem QUESTION 3

COLUMN   "Average Cost" FORMAT $9,990.00 
select   category  "Category", count(category) "# of Books", 
         avg(cost) "Average Cost" 
from     books
group by category
having   count(*) >= 2
order by category;


rem QUESTION 4

select    fname "First Name", lname "Last Name", 
          count(title) "# of Books Written"
from      orderitems natural join 
          books      natural join
          bookauthor natural join author
group by  fname, lname
having    count(*) >= 10
order by  lname, fname;


rem QUESTION 5

COLUMN   "Most Expensive"  FORMAT $9,990.00
COLUMN   "Least Expensive" FORMAT $9,990.00
select   name "Publisher", max(retail) "Most Expensive", 
         min(retail) "Least Expensive"
from     publisher natural join books     
                   natural join bookauthor
                   natural join author
group by name
order by name;

spool off