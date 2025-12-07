drop table if exists customers;

create table if not exists customers (
    index text primary key,
    customer_id text not null,
    firstname text not null,
    lastname text not null,
    company text not null,
    city text not null,
    country text not null,
    phone1 text not null,
    phone2 text not null,
    email text not null,
    subscription_date text not null,
    website text not null
);