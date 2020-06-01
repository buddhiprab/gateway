create schema if not exists api;

create table if not exists api.request_trace
(
    id                  int auto_increment primary key,
    url                 varchar2(2048) not null,
    creation_time       timestamp default systimestamp
);
