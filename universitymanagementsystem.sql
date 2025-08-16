-- Active: 1714068689435@@127.0.0.1@3306


create database UniversityManagementSystem;

show databases;

use universitymanagementsystem;

create table login(username varchar(25), password varchar(25));

create table student(name varchar(40), fname varchar(40), rollno varchar(20), dob varchar(40), address varchar(100), phone varchar(20), email varchar(40), nid varchar(20), sscgpa varchar(20), hscgpa varchar(20), course varchar(40), batch varchar(40)); 

create table teacher(name varchar(40), fname varchar(40), empId varchar(20), dob varchar(40), address varchar(100), phone varchar(20), email varchar(40), nid varchar(20), sscgpa varchar(20), hscgpa varchar(20), education varchar(40), department varchar(40)); 

create table studentleave(rollno varchar(20), date varchar(50), duration varchar(20));

create table teacherleave(empId varchar(20), date varchar(50), duration varchar(20));

create table subject(rollno varchar(20), semester varchar(20), subject1 varchar(50), subject2 varchar(50), subject3 varchar(50), subject4 varchar(50), subject5 varchar(50));

create table marks(rollno varchar(20), semester varchar(20), marks1 varchar(50), marks2 varchar(50), marks3 varchar(50), marks4 varchar(50), marks5 varchar(50));

create table fee(course varchar(20), semester1 varchar(20), semester2 varchar(20), semester3 varchar(20), semester4 varchar(20), semester5 varchar(20), semester6 varchar(20), semester7 varchar(20), semester8 varchar(20));

create table examination (exam_id VARCHAR(20),exam_name VARCHAR(50),course VARCHAR(40),date VARCHAR(20));



insert into fee values("BSC Sofware Engineering", "48000", "43000","44000","47000","48000","45000","47000","44000");

insert into fee values("CSE", "45000", "44000","46000","42000","42000","44000","45000","47000");

insert into fee values("BBA", "48000", "43000","43000","43000","43000","43000","43000","43000");

insert into fee values("Ethical Hacking", "48000", "47000","44000","48000","44000","43000","43000","43000");

insert into fee values("MBA", "48000", "43000","43000","43000","43000","43000","43000","43000");

insert into fee values("English(Hons)", "48000", "43000","43000","43000","43000","43000","43000","43000");

insert into fee values("MSC Software Engineering", "48000", "43000","43000","43000","43000","43000","43000","43000");

insert into fee values("EEE", "48000", "43000","43000","43000","43000","43000","43000","43000");

INSERT INTO examination VALUES('JUNIT-EXAM','Midterm','CSE','2025-09-01');





show tables;

insert into login values('admin','12345');

show columns from login;

show columns from student;

show columns from teacher;

select * from login;

select * from student;

select * from teacher;

select * from subject;

select * from marks;

select * from fee;


