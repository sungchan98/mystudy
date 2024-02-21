
-- 상품
create table products(
  product_no int not null,
  category_no varchar(50) not null,
  product_name varchar(50) not null,
  price int not null,
  product_size varchar(50) not null,
  bank varchar(50) not null,
  account_no int not null
);

alter table products
  add constraint primary key (product_no),
  modify column product_no int not null auto_increment;

create table commerce_files(
  file_no int not null,
  file_path varchar(255) not null,
  commerce_no int not null
);

alter table commerce_files
  add constraint primary key (file_no),
  modify column file_no int not null auto_increment,
  add constraint commerce_files_fk foreign key (commerce_no) references commerces(commerce_no);

create table customers(
  customer_no int not null,
  id varchar(50) not null,
  name varchar(50) not null,
  password varchar(100) not null,
  created_date datetime null default now()
);

alter table customers
  add constraint primary key (customer_no),
  modify column customer_no int not null auto_increment;

alter table commerces
  add constraint commerces_fk foreign key (customer_no) references customers(customer_no);

