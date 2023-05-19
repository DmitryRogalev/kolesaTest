create table image
(
    id         serial
        primary key,
    file_name  varchar(255),
    product_id integer not null
        constraint fkgpextbyee3uk9u6o2381m7ft1
            references product
);

alter table image
    owner to postgres;

