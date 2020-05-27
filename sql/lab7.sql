set echo on
set linesize 132
set pagesize 66

spool c:/cprg250s/lab7output.txt

rem Made by Brennan Brown


rem QUESTION 1

select   firstname, lastname
from     customers
where    state = 
        (select state
         from customers
         where firstname  = 'LEILA')
         and   firstname != 'LEILA'
order by lastname;


rem QUESTION 2

select   firstname, lastname, title, retail
from     customers natural join orders
                   natural join orderitems
                   natural join books
where    retail >
        (select avg(retail)
         from books)
order by lastname, title;


rem QUESTION 3

select   lastname, title
from     customers natural join orders
                   natural join orderitems
                   natural join books
where    category = 'FITNESS'
order by lastname;


rem QUESTION 4

select   Customers.lastname,
	    (select title 
	     from   books
	     having Customers.customer# = Orders.Customer# and
	            Orders.Order# = Orderitems.Order# and
	            Orderitems.isbn = Books.isbn and
	            Books.category = 'FITNESS')
from     customers
order by Customers.lastname;


rem QUESTION 5

select fname "First Name", lname "Last Name", 
       title "Book Title", retail "Max. Price"
from   author natural join bookauthor
              natural join books
where (lname, retail) IN
	  (select   lname, max(retail)
	   from     author natural join bookauthor
                       natural join books
	   group by lname)
order by lname;

rem QUESTION 6

select title "Book Title", retail "Max. Price"
from   books b,
      (select   fname "First Name", lname "Last Name", 
       from     author natural join bookauthor
                       natural join books
       group by lname) maxretail
where  b.retail = maxretail.retail
order by lname;

spool off