create table category
(
    id   serial
        primary key,
    name varchar(255)
);

alter table category
    owner to postgres;

