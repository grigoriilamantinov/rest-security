drop table if exists users_authorities;
drop table if exists users;
drop table if exists authorities;

create table if not exists authorities
(
    id   integer not null
        constraint authorities_pk
            primary key,
    role varchar
);

create table if not exists users
(
    first_name varchar not null,
    login      varchar not null
        constraint users_pk
            primary key,
    password   varchar not null
);

create table if not exists users_authorities
(
    users_login varchar not null
        constraint users_authorities_users_login_fk
            references users,
    roles_id    integer not null
        constraint users_authorities_authorities_id_fk
            references authorities
);
