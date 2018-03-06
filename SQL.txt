
Öncelikle veritabaný oracle kullanmýþtýr. Console dan student adýnda bir schema açýlmasý ve dba yetkisi verilmesi gerekmektedir. 
Daha sonra ilgili create cümlelerini yazmak yeterli olacaktýr.

create user student identified by 1907; 
grant dba to student;  


create  table TBL_STUDENT
(   
   student_id INT NOT NULL,
   name VARCHAR(50) NOT NULL,
   surname VARCHAR(50) NOT NULL,
   mobile_phone VARCHAR(11),
   city_id INT,  
   district_id INT,
   description VARCHAR(2000),
   PRIMARY KEY (student_id) 

)

CREATE SEQUENCE PUBLIC.SEQ_TBL_STUDENT START WITH 1 INCREMENT BY 1

create table TBL_CITY
(   
   city_id INT NOT NULL, 
   city_name VARCHAR(255),
   PRIMARY KEY (city_id) 

)

CREATE SEQUENCE PUBLIC.SEQ_TBL_CITY START WITH 1 INCREMENT BY 1

insert into tbl_city (city_id,city_name)values (1,'Ankara')
insert into tbl_city (city_id,city_name)values (2,'Ýstanbul')
insert into tbl_city (city_id,city_name)values (3,'Kayseri')

create table TBL_DISTRICT
(   
   district_id INT NOT NULL, 
   city_id INT,
   district_name VARCHAR(255),
   PRIMARY KEY (district_id) 

)
CREATE SEQUENCE PUBLIC.SEQ_TBL_DISTRICT START WITH 1 INCREMENT BY 1
insert into tbl_district (district_id,city_id,district_name)(seq_tbl_district.nextval,1,'Yenimahalle')
insert into tbl_district (district_id,city_id,district_name)(seq_tbl_district.nextval,1,'Keçiören')
insert into tbl_district (district_id,city_id,district_name)(seq_tbl_district.nextval,2,'Ümraniye')
insert into tbl_district (district_id,city_id,district_name)(seq_tbl_district.nextval,2,'Kadýköy')
insert into tbl_district (district_id,city_id,district_name)(seq_tbl_district.nextval,3,'Ümraniye')
insert into tbl_district (district_id,city_id,district_name)(seq_tbl_district.nextval,3,'Kadýköy')