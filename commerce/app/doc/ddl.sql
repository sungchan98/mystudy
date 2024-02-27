
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
