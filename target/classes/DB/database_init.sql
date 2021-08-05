CREATE TABLE User (
    id         bigint primary key auto_increment,
    name       varchar(50),
    username   varchar(50),
    password   varchar(255),
    role       enum('ADMIN', 'USER'),
    userRating     enum('PREMIUM', 'MIDDLE', 'JUNIOR', 'BANNED')
);

CREATE TABLE genres
(
    ID   bigint primary key not null auto_increment,
    name varchar(50)
) ;


CREATE TABLE Movies
(
id         bigint primary key not null auto_increment,
name       varchar(50),
path_to_image   varchar(255) NOT NULL,
description varchar(255),
genre_id  bigint
);

ALTER TABLE Movies ADD FOREIGN KEY (genre_id) REFERENCES genres(id);


CREATE TABLE reviews (
    id bigint primary key not null auto_increment,
    review VARCHAR(255)
    movie_id BIGINT,
    constraint FOREIGN KEY(movie_id) REFERENCES movies(id),
    user_id BIGINT,
    constraint FOREIGN KEY(user_id) REFERENCES user(id),
);

CREATE TABLE movieratings (
    id bigint primary key not null auto_increment,
    movie_id BIGINT,
    constraint FOREIGN KEY(movie_id) REFERENCES movies(id),
    user_id BIGINT,
    constraint FOREIGN KEY(user_id) REFERENCES user(id),
    Rating double,
    CONSTRAINT MovieID_UserID UNIQUE (movie_id, user_id),
    CONSTRAINT movie_ratings_chk CHECK (((rating >= 0) and (rating <= 10.0)))
);