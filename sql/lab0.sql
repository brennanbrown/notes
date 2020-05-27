set echo on
set linesize 132
set pagesize 66

spool c:/cprg250s/lab0output.txt

rem Made by Brennan Brown

rem
rem JustLee Database
rem
describe customers
select * from books;

rem
rem Walnut Grove Bank Database
rem
describe WGB_CUSTOMER
select * from WGB_ACCOUNT;
select * from WGB_TRANSACTION;

rem
rem Couch Potato Video Database
rem
describe CP_CATEGORY
select * from CP_TITLE;
select * from CP_PRICE;

spool off