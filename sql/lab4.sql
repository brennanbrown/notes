set echo on
set linesize 132
set pagesize 66

spool c:/cprg250s/lab4output.txt

rem Lab 4: Single Row Functions
rem Made by Brennan Brown

rem QUESTION 1

select   lname "Last Name", title "Book Title",
         TO_NUMBER(TO_CHAR(pubdate, 'fmMonth DD, YYYY')) "Date",
from     author natural join bookauthor
                natural join books 
order by title;


rem QUESTION 2

select   title "Book Title", isbn "ISBN #", category
from     books
where    category = 'COMPUTER'
order by title;  

rem QUESTION 3

select   title "Book Title", pubdate "Date Published",
         ADD_MONTHS (pubdate, 6*1) "Review Date"
from     author     natural join bookauthor
         bookauthor natural join books 
order by pubdate;  


rem QUESTION 4

select    title "Book Title", retail "Retail Price", 
          discount "Discount Price", 
          retail - NVL(retail-discount,0) "Profit"
from      books
order by "Profit";  


rem QUESTION 5

select   title "Title", ((retail-cost) / cost * 100) "Margin",
         discount "Discount"
from     books
CASE     when ((retail-cost) / cost * 100) >= 60
            AND discount is null 
            THEN 'Very High Profit'
         when ((retail-cost) / cost * 100) >= 30 
            AND ((retail-cost) / cost * 100) < 60 
            AND discount is null 
            THEN 'High Profit'
         when ((retail-cost) / cost * 100) >= 0
            AND ((retail-cost) / cost * 100) < 30 
            AND discount is null 
            THEN 'Loss Leader'
        else 'Discounted, will NOT be restocked'
            end "Pricing Structure"
order by title;  

spool off
