create table orders
(
    id         serial
        primary key,
    count      integer not null,
    date_time  timestamp(6),
    number     varchar(255),
    price      real    not null,
    status     smallint,
    person_id  integer not null
        constraint fk1b0m4muwx1t377w9if3w6wwqn
            references person,
    product_id integer not null
        constraint fk787ibr3guwp6xobrpbofnv7le
            references product
);

alter table orders
    owner to postgres;

