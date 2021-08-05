insert into users (name,username,password,role, userRating)
 values ( 'Eugene','admin',MD5('admin'),'Admin' , 'Premium');

insert into users (name,username,password,role, userRating)
 values ( 'Pavel','user',MD5('user'),'User' , 'Middle');

insert into users (name,username,password,role, userRating)
 values ( 'Andrey','andrey',MD5('andrey'),'User' , 'Junior');

insert into users (name,username,password,role, userRating)
 values ( 'Kirill','kirill',MD5('kirill'),'User', 'Junior');

insert into users (name,username,password,role, userRating)
 values ( 'Sergey','sergey',MD5('sergey'),'User' , 'Junior');


insert into genres (Name) values ('Comedy');
insert into genres (Name) values ('Cartoons');
insert into genres (Name) values ('Thriller');
insert into genres (Name) values ('Drama');
insert into genres (Name) values ('Detective');


INSERT INTO Movies (name, path_to_image, description, genre_id)
            VALUES ('KnockingOnHeaverDoor', 'static/img/KnockingOnHeaverDoor.jpg', 'Movie is a 1997 German crime comedy,
            by Thomas Jahn, starring Til Schweiger, Moritz Bleibtreu, Jan Josef Liefers and Rutger Hauer. ', 1);

INSERT INTO Movies (name, path_to_image, description, genre_id)
            VALUES ('Interstellar', 'static/img/Interstellar.jpg', 'Interstellar is a 2014 British-American epic science
            fiction film directed and produced by Christopher Nolan.', 3);

INSERT INTO Movies (name, path_to_image, description, genre_id)
            VALUES ('ShawshankRedemption', 'static/img/ShawshankRedemption.jpg', 'The Shawshank Redemption is a 1994
             American drama film written and directed by Frank Darabont, based on the 1982 Stephen King novella Rita
             Hayworth and Shawshank Redemption.', 4);

INSERT INTO Movies (name, path_to_image, description, genre_id)
            VALUES ('TheGreenMile', 'static/img/TheGreenMile.jpg', 'The Green Mile is a 1999 American fantasy drama
            film written and directed by Frank Darabont and based on Stephen Kings 1996 novel of the same name. It
            stars Tom Hanks as a death row corrections officer during the Great Depression who witnesses supernatural
            events that occur after an enigmatic inmate (Michael Clarke Duncan) is brought to his facility.', 4);

INSERT INTO Movies (name, path_to_image, description, genre_id)
            VALUES ('TheLordOfTheRings', 'static/img/TheLordOfTheRings.jpg', 'The Lord of the Rings is a film series
             of three epic fantasy adventure films directed by Peter Jackson, based on the novel written by
             J. R. R. Tolkien. The films are subtitled The Fellowship of the Ring (2001), The Two Towers (2002), and
             The Return of the King (2003). ', 3);
