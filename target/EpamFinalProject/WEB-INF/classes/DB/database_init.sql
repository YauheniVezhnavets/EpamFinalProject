create table User (
    id         bigint primary key auto_increment,
    name       varchar(50),
    username   varchar(50),
    password   varchar(255),
    role       enum("Admin", "User"),
    rating     enum("Premium", "Middle", "Junior", "Banned")
);



insert into User(name,username,password,role, rating)
 values ( 'Eugene','admin',MD5('admin'),'Admin' , 'Premium');

insert into User(name,username,password,role, rating)
 values ( 'Pavel','user',MD5('user'),'User' , 'Middle');

insert into User(name,username,password,role, rating)
 values ( 'Andrey','andrey',MD5('andrey'),'User' , 'Junior');

insert into User(name,username,password,role, rating)
 values ( 'Kirill','kirill',MD5('kirill'),'User', 'Junior');

insert into User(name,username,password,role, rating)
 values ( 'Sergey','sergey',MD5('sergey'),'User' , 'Junior');