create table User (
    id         bigint not null auto_increment,
    username   varchar(50),
    password   varchar(255),
    role       enum("Admin", "User"),
    is_blocked boolean

    primary key(id)
);



insert into User(id, username, password, role, is_blocked)
values (1, 'admin', md5('admin'), 'admin', false);

insert into User(id, username, password, role, is_blocked)
values (2, 'user', md5('user'), 'user', false);