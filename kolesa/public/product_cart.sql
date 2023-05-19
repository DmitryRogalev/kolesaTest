create table product_cart
(
    id         serial
        primary key,
    person_id  integer
        constraint fksgnkc1ko2i1o9yr2p63ysq3rn
            references person,
    product_id integer
        constraint fkhpnrxdy3jhujameyod08ilvvw
            references product
);

alter table product_cart
    owner to postgres;

