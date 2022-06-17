insert into users (first_name, login, password) values ('Vasilii', 'vas', 'vaspass');
insert into users (first_name, login, password) values ('Peter', 'pet', 'petpass');
insert into users (first_name, login, password) values ('Victor', 'vic', 'vicpass');

insert into authorities (id, role) values (1, 'Operator');
insert into authorities (id, role) values (2, 'Analytic');
insert into authorities (id, role) values (3, 'Admin');

insert into users_authorities (users_login, roles_id) values ('vas', 1);
insert into users_authorities (users_login, roles_id) values ('vas', 3);
insert into users_authorities (users_login, roles_id) values ('pet', 1);
insert into users_authorities (users_login, roles_id) values ('pet', 2);
