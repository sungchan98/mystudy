-- DDL(Data Definition Language)

drop table if exists boards restrict;
drop table if exists boards_files restrict;
drop table if exists members restrict;
drop table if exists assignments restrict;




create table boards(
  board_no int not null,
  title varchar(255) not null,
  content text not null,
  writer varchar(30) not null,
  category int not null,
  created_date datetime null default now()
);

alter table boards
  add constraint primary key(board_no),
  modify column board_no int not null auto_increment;

create table board_files(
  file_no int not null,
  file_path varchar(255) not null,
  board_no int not null
);

alter table board_files
  add constraint primary key (file_no),
  modify column file_no int not null auto_increment,
  add constraint boards_files_fk foreign key (board_no) references boards(board_no);







create table assignments(
  assignment_no int not null,
  title varchar(255) not null,
  content text not null,
  deadline date not null
);

alter table assignments
  add constraint primary key (assignment_no),
  modify column assignment_no int not null auto_increment;







create table members(
  member_no int not null,
  email varchar(255) not null,
  name varchar(255) not null,
  password varchar(100) not null,
  created_date datetime null default now()
);

alter table members
  add constraint primary key (member_no),
  modify column member_no int not null auto_increment;







alter table boards
  add column category int not null;

update boards set category=1;

drop table lect2;
drop table lms_address;
drop table lms_application;
drop table lms_centers;
drop table lms_departments;
drop table lms_lectures;
drop table lms_level;
drop table lms_managers;
drop table lms_members;
drop table lms_photos;
drop table lms_rooms;
drop table lms_students;
drop table lms_teacher_lecture;
drop table lms_teachers;