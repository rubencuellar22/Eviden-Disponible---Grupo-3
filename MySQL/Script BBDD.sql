create database if not exists personal_disponibles;

use personal_disponibles;

drop table job_technology;
drop table empleado;

create table grupo(
    grupos varchar(255) primary key,
    grupo1 varchar(255),
    grupo2 varchar(255),
    grupo3 varchar(255),
    grupo4 varchar(255),
    cc varchar(50)
);

create table if not exists empleado ( 
	gin int primary key,
    name varchar(255) not null,
    subgroup varchar(10) not null,
    status varchar(255) not null,
    bench varchar(255),
    das varchar(7) unique key not null,
    ciudad varchar(50) not null,
    line_manager varchar(50) not null,
    jornada decimal(38,2) not null,
    gcm varchar(30) not null,
    categoria varchar(50),
    nivelgcm int not null,
    scr decimal(38,2) not null,
    cc varchar(50) not null,
    ccname varchar(255) not null,
    group1 varchar(100) not null,
    group2 varchar(100) not null,
    group3 varchar(100) not null,
    group4 varchar(100) not null,
    n_4 varchar(255) not null,
    agrupacion varchar(255),
    job_technology varchar(100) not null,
    jobtechnology_profile varchar(255) not null,
    skills varchar(255),
    role varchar(255) not null,
    rlt varchar(100),
    sklanguages varchar(255) not null,
    skmethods text,
    sktechskills text,
    skcertif text,
    sktechnologies text,
    skbusskills text,
    grupos varchar(255),
    foreign key(grupos) references grupo(grupos)
);

-- UPDATE excel SET grupos = CONCAT(group1, ' | ', group2, ' | ', group3, ' | ', group4);

create table job_technology(
	id_job_technology int primary key auto_increment,
    job_technology varchar(100) not null,
    gin int not null,
    foreign key(gin) references empleado(gin)
);

create table job_technology_profile(
	id_job_technology_profile int primary key auto_increment,
    job_technology_profile varchar(100) not null,
    nivel int not null,
    gin int not null,
    foreign key(gin) references empleado(gin)
);

create table tech_skills(
	id_tech_skills int primary key auto_increment,
    tech_skills text not null,
    nivel int not null,
    gin int not null,
    foreign key(gin) references empleado(gin)
);

create table role(
    role varchar(255) primary key,
    nivel int not null,
    gin int not null,
    foreign key(gin) references empleado(gin)
);

create table sub_skills(
	id_sub_skills int primary key auto_increment,
    sub_skills text not null,
    nivel int not null,
    gin int not null,
    foreign key(gin) references empleado(gin)
);

create table certificaciones(
	id_certificaciones int primary key auto_increment,
    certificaciones text not null,
    nivel int not null,
    gin int not null,
    foreign key(gin) references empleado(gin)
);

create table metodologias(
	id_metodologias int primary key auto_increment,
    metodologias varchar(255) not null,
    nivel int not null,
    gin int not null,
    foreign key(gin) references empleado(gin)
);

create table idiomas(
	id_idiomas int primary key auto_increment,
    idiomas varchar(255) not null,
    nivel int not null,
    gin int not null,
    foreign key(gin) references empleado(gin)
);

create table tecnologias(
	id_tecnologias int primary key auto_increment,
    tecnologias text not null,
    nivel int not null,
    gin int not null,
    foreign key(gin) references empleado(gin)
);

select * from excel;

insert into empleado(gin,name,subgroup,status,bench,das,ciudad,line_manager,jornada,gcm,categoria,nivelgcm,scr,cc,ccname,group1,group2,group3,group4,n_4,agrupacion,job_technology,jobtechnology_profile,skills,role,rlt,sklanguages,skmethods,sktechskills,skcertif,sktechnologies,skbusskills)
 values(86,'Nombre_86','A2','RESKILLING',2003-12-20,'A000548','Madrid','Manager_14',87.5,'ICC05', 'AG3BN2', 5, 37.97, 'ESJAHD5427', 'AMS DIRECTORY', 'DIGITAL', 'AMS', 'Practice AMS Direct', 'Practice AMS General', 'nombre_4','' , 'BAU;BAU','ORACLE VERSION', 'JAVA/J2BC','SENIOR APPLICATION DEVELOPER [4 Senior]', '', 'English (B1/B2 Intermediate)|Spanish (C2 Mastery)', 'SCRUM (1)|ERD Entity Relationship Diagram (4)|Object Oriented Analysis & Design (OOAD) (3)|Rational Unified Process (RUP) (3)|Unified Modeling Language (UML) (3)|Web Services (General) (4)|Web Services Description Language (WSDL) (3)|XML Schema Definition (XSD) (3)|Yourdon (1)', 'Product Design & Creation (4)|Database Modelling (5)|Requirements Definition & Management (4)|Agile Processes & Methodologies (1)|Electronic Data Interchange (EDI) (4)|Geographical Information Systems (GIS) (1)', '', 'dskjsdkjfsfsjfdlsdfjslfdjsdkfsds','');
