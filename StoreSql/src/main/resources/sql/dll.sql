

use store;

CREATE table 'store_detail'(
'id' int primary key AUTO_INCREMENT,
'store_name' varchar(25) not null,
'store_date' date not null unique,
'store_income' varchar(25) not null,
'store_expense' varchar(20) not null,
'store_day' varchar(15) not null

);