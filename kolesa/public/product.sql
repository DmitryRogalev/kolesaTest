create table product
(
    id          serial
        primary key,
    title       text         not null
        constraint uk_qka6vxqdy1dprtqnx9trdd47c
            unique,
    description text,
    date_time   timestamp(6),
    price       real         not null
        constraint product_price_check
            check (price >= (1)::double precision),
    seller      varchar(255) not null,
    warehouse   varchar(255) not null,
    category_id integer      not null
        constraint fk1mtsbur82frn64de7balymq9s
            references category
);

alter table product
    owner to postgres;

