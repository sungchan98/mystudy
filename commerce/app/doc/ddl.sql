
-- 상품
create table products(
  product_no int not null,
  category_name varchar(255) not null,
  product_name varchar(255) not null,
  product_price int not null,
  product_quantity int not null,
  product_size int not null
);

alter table products
  add constraint primary key (product_no),
  modify column product_no int not null auto_increment;

-- 고객
create table customers(
  customer_no int not null,
  email varchar(50) not null,
  name varchar(50) not null,
  gender varchar(50) not null,
  address varchar(50) not null,
  phone_no varchar(50) not null
);

alter table customers
  add constraint primary key (customer_no),
  modify column customer_no int not null auto_increment;


-- 주문
create table orders(
  order_no int not null auto_increment,
  customer_no int not null,
  product_no int not null,
  order_quantity int not null,
  order_price int not null,
  review varchar(300) not null,
  order_date datetime null default now(),
  primary key (order_no),
  foreign key (customer_no) references customers(customer_no),
  foreign key (product_no) references products(product_no)
);




----------------------------------------------------------------------------------------


create table product_files(
  file_no int not null,
  file_path varchar(255) not null,
  product_no int not null
);

alter table product_files
  add constraint primary key (file_no),
  modify column file_no int not null auto_increment,
  add constraint commerce_files_fk foreign key (product_no) references commerces(product_no);



---------------------------------------------------------------
drop table if exists users restrict;
drop table if exists replies restrict;
drop table if exists likes restrict;
drop table if exists logs restrict;
drop table if exists schools restrict;
drop table if exists tags restrict;
drop table if exists member_tags restrict;
drop table if exists school_user restrict;
drop table if exists tokens restrict;
drop table if exists categories restrict;
drop table if exists classes restrict;
drop table if exists class_user restrict;
drop table if exists school_tags restrict;
drop table if exists logIndexes restrict;
drop table if exists purchases restrict;
drop table if exists grades restrict;
drop table if exists follows restrict;
drop table if exists dm restrict;
drop table if exists com_chats restrict;
drop table if exists files restrict;
drop table if exists alerts restrict;
drop table if exists posts restrict;





drop talbe users;
drop talbe replies;
drop talbe likes;
drop talbe logs;
drop talbe schools;
drop talbe tags;
drop talbe member_tags;
drop talbe school_user;
drop talbe tokens;
drop talbe categories;
drop talbe classes;
drop talbe class_user;
drop talbe school_tags;
drop talbe logIndexes;
drop talbe purchases;
drop talbe grades;
drop talbe follows;
drop talbe dm;
drop talbe com_chats;
drop talbe files;
drop talbe alerts;

