set echo on
set linesize 132
set pagesize 66

spool c:/cprg250s/assignment1.txt

rem Made by Brennan Brown


rem QUESTION 1

select   first_name "First",       surname "Last", 
	     customer_number "Cust #", account_type "Type"
from     wgb_customer 
	     natural join wgb_account
order by surname,         first_name, 
	     customer_number, account_type;
 

rem QUESTION 2

select   first_name "First",    surname "Last",
         Phone "Phone",         c.customer_number "Cust #",
         a.account_type "Type", balance "$"
from     wgb_customer c,  wgb_account a, wgb_account_type t
where    c.customer_number =  a.customer_number
and      a.account_type    =  t.account_type
and      account_description = 'Chequing'
order by surname,             first_name, 
	     c.customer_number,   a.account_type;


rem QUESTION 3

select   first_name "First",  surname "Last",
         Phone "Phone",       customer_number "Cust #",
         account_type "Type", balance "$"
from     wgb_customer 
	     natural join wgb_account
	     natural join wgb_account_type
where    account_description = 'Chequing'
order by surname,             first_name, 
	     customer_number,     account_type;

rem QUESTION 4

select   first_name "First",  surname "Last",
         Phone "Phone",       customer_number "Cust #",
         account_type "Type", balance "$"
from     wgb_customer 
	     join wgb_account
	     using (customer_number)
	     join wgb_account_type
	     using (account_type)
where    account_description = 'Chequing'
order by surname,             first_name, 
	     customer_number,     account_type;


rem QUESTION 5

select   first_name "First",     surname "Last",
         Phone "Phone",          c.customer_number "Cust #",
         a.account_type "Type",  balance "$"
from     wgb_customer c
	     join wgb_account a
	     on (c.customer_number = a.customer_number)
	     join wgb_account_type t
	     on (a.account_type = t.account_type)
where    account_description = 'Chequing'
order by surname,              first_name, 
	     c.customer_number,    a.account_type;



rem QUESTION 6

select   first_name "First",           surname "Last",
         customer_number "Cust #",     t.account_type "Type",
         transaction_number "Trans #", transaction_type "T", 
         transaction_date "Date",      transaction_amount "Amount"
from     wgb_customer c
         join wgb_account a
	     using (customer_number)
	     join wgb_transaction t
	     using (customer_number)
order by surname, first_name, customer_number,
         t.account_type, transaction_number;



rem QUESTION 7

select   first_name "First",           surname "Last",
         customer_number "Cust #",     t.account_type "Type",
         transaction_number "Trans #", transaction_type "T", 
         transaction_date "Date",      transaction_amount "Amount"
from     wgb_customer c
         join wgb_account a
	     using (customer_number)
	     join wgb_transaction t
	     using (customer_number)
where    (t.account_type = '1' OR t.account_type = '2')
         AND postal_code LIKE 'T%'
order by surname, first_name,          customer_number,
         t.account_type,               transaction_number;


rem QUESTION 8

select   first_name "First",           surname "Last",
         customer_number "Cust #",     t.account_type "Type",
         transaction_number "Trans #", transaction_type "T", 
         transaction_date "Date",      transaction_amount "Amount"
from     wgb_customer c
         left outer join wgb_account a
	     using (customer_number)
	     left outer join wgb_transaction t
	     using (customer_number)
order by surname, first_name,          customer_number,
         t.account_type,               transaction_number;


rem QUESTION 9

select   first_name "First", surname "Last"
from     wgb_customer
         natural join wgb_account
         natural join wgb_account_type
where    account_description  = 'Chequing'
AND      account_description != 'RRSP''s'
order by surname, first_name;


rem QUESTION 10

select   customer_number "Cust #"
from     wgb_account 
where    balance > 0
order by customer_number;


spool off