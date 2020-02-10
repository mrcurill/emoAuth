create table user (
    --id bigint primary key AUTO_INCREMENT,
    id IDENTITY NOT NULL PRIMARY KEY,
    login varchar(50),
    password varchar(50));

insert into user (login, password) values ('admin','admin');
insert into user (login, password) values ('guest','guest');


create table view (
    id IDENTITY NOT NULL PRIMARY KEY,
    name varchar(50));

insert into view (name) values ('view1');
insert into view (name) values ('view2');


create table component (
    id IDENTITY NOT NULL PRIMARY KEY,
    name varchar (50));

insert into component (name) values ('component1');
insert into component (name) values ('component2');
insert into component (name) values ('component3');
insert into component (name) values ('component4');
insert into component (name) values ('component5');


create table view_on_comp (
    id identity not null primary key,
    view_id bigint not null ,
    component_id bigint not null,
    CONSTRAINT FK_VIEW_ID FOREIGN KEY (view_id)
      REFERENCES view (id),
    CONSTRAINT FK_COMPONENT_ID FOREIGN KEY (component_id)
      REFERENCES component (id)
);

insert into view_on_comp (view_id,component_id) values (1,1);
insert into view_on_comp (view_id,component_id) values (1,2);
insert into view_on_comp (view_id,component_id) values (2,1);


create table view_off_comp (
    id identity not null primary key,
    view_id bigint not null ,
    component_id bigint not null,
    CONSTRAINT FK2_VIEW_ID FOREIGN KEY (view_id)
      REFERENCES view (id),
    CONSTRAINT FK2_COMPONENT_ID FOREIGN KEY (component_id)
      REFERENCES component (id)
);

insert into view_off_comp (view_id,component_id) values (1,3);
insert into view_off_comp (view_id,component_id) values (1,4);
insert into view_off_comp (view_id,component_id) values (2,3);

create table view_disabled_comp (
    id identity not null primary key,
    view_id bigint not null ,
    component_id bigint not null,
    CONSTRAINT FK3_VIEW_ID FOREIGN KEY (view_id)
      REFERENCES view (id),
    CONSTRAINT FK3_COMPONENT_ID FOREIGN KEY (component_id)
      REFERENCES component (id)
);

insert into view_disabled_comp (view_id,component_id) values (1,5);
insert into view_disabled_comp (view_id,component_id) values (2,4);
insert into view_disabled_comp (view_id,component_id) values (2,5);