create table users(
    id int not null auto_increment primary key,
    name varchar(200) not null,
    email varchar(200) not null,
    dateBirth date,
    document varchar(10)
);