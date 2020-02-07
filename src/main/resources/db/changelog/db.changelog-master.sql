create table user (
    --id bigint primary key AUTO_INCREMENT,
    id IDENTITY NOT NULL PRIMARY KEY,
    login varchar(50),
    password varchar(50));

insert into user (login, password) values ('admin','admin');
insert into user (login, password) values ('guest','guest');