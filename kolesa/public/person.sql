create table person
(
    id       serial
        primary key,
    login    varchar(100),
    password varchar(255),
    role     varchar(255)
);

alter table person
    owner to postgres;

