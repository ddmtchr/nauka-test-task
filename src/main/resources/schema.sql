create table if not exists employee (
                          id bigserial primary key,
                          name varchar(255) not null,
                          surname varchar(255) not null,
                          birth_date date not null,
                          department varchar(255) not null,
                          salary double precision not null
);