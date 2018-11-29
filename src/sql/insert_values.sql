use `iis_project`;

-- PLANES
insert into planes(serial_number, type, manufacturer, date_of_made, last_revision_date, number_of_seats_economic, number_of_seats_business, number_of_seats_first) values('B73720150322', '737', 'Boeing', '2015/03/22', '2018/03/16', 118, 15, 0);
insert into planes(serial_number, type, manufacturer, date_of_made, last_revision_date, number_of_seats_economic, number_of_seats_business, number_of_seats_first) values('A38020170813', 'A380', 'Airbus', '2017/08/13', '2018/08/09', 461, 48, 8);
insert into planes(serial_number, type, manufacturer, date_of_made, last_revision_date, number_of_seats_economic, number_of_seats_business, number_of_seats_first) values('CONC19981130', 'Concorde', 'Aerospatiale', '1998/11/30', '2018/11/21', 140, 12, 0);

-- GATES
insert into gates(gate_number, terminal) values(1, 'A');
insert into gates(gate_number, terminal) values(2, 'A');
insert into gates(gate_number, terminal) values(3, 'B');

-- DESTINATIONS
insert into destinations(country, city, distance) values('Slovakia', 'Bratislava', 218);
insert into destinations(country, city, distance) values('Czech Republic', 'Brno', 226);
insert into destinations(country, city, distance) values('Mali', 'Bamako', 4785);

-- ROLES
insert into role(name) values ('ROLE_USER');
insert into role(name) values ('ROLE_EMPLOYEE');
insert into role(name) values ('ROLE_ADMIN');

-- USERS DETAILS
insert into user_details(email, phone_number, first_name, last_name, identification_number, 
			city, street, house_number, zip, country)
values ('admin@jamnikairport.sk', '0922333444', 'Jozef', 'Mrkva', '9412241234', 'Liptovska Kokava',
		'Kostolna', '666', '03244', 'Slovakia');
insert into user_details(email, phone_number, first_name, last_name, identification_number, 
	city, street, house_number, zip, country)
values ('k.troska@jamnikairport.sk', '0944555333', 'Katarina', 'Troskova', '8754265432', 'Bratislava', 
		'Radvanska', '1', '81101', 'Slovakia');
insert into user_details(email, phone_number, first_name, last_name, identification_number, 
			city, street, house_number, zip, country)
values ('tomas@jedno.org', '0977888999', 'Tomas', 'Jedno', '8912121229', 'Filakovo', 'Ongroundbengerova',
		'53', '98601', 'Slovakia');

-- USERS
insert into user(username, password, user_details_id)
values ( 'admin@jamnikairport.sk', '$2a$10$raAQ73.7fRB2MqfsUsgzZO4LBCeP6YKYzeN69/E90otsuwUZLCml.', '9412241234');
insert into user(username, password, user_details_id)
values ('k.troska@jamnikairport.sk', '$2a$10$2/5lyPozw9Red.3C4kapDOdvdc1.tK7uVLpUOeJby71cc91xz2p7S','8754265432');
insert into user(username, password, user_details_id)
values ('tomas@jedno.org', '$2a$10$vxSBJMfRYDdx5qLlMyK7Y.Gdphjm8DDLjB45gHWjK.73LL48M7GIS', '8912121229');

-- USERS ROLES
insert into users_roles(role_id, user_id) values (1,1);
insert into users_roles(role_id, user_id) values (2,1);
insert into users_roles(role_id, user_id) values (3,1);
insert into users_roles(role_id, user_id) values (1,2);
insert into users_roles(role_id, user_id) values (2,2);
insert into users_roles(role_id, user_id) values (1,3);


-- FLIGHTS
insert into flights(takeoff_date, destination, gate, plane, price) values('2018/12/05 16:00', 1, 3, 'A38020170813', 65.00);
insert into flights(takeoff_date, destination, gate, plane, price) values('2018/12/12 16:00', 1, 3, 'A38020170813', 70.50);
insert into flights(takeoff_date, destination, gate, plane, price) values('2018/12/19 16:00', 1, 3, 'A38020170813', 68.70);
insert into flights(takeoff_date, destination, gate, plane, price) values('2019/01/02 16:00', 1, 3, 'A38020170813', 76.30);
insert into flights(takeoff_date, destination, gate, plane, price) values('2019/01/09 16:00', 1, 3, 'A38020170813', 72.00);
insert into flights(takeoff_date, destination, gate, plane, price) values('2019/01/16 16:00', 1, 3, 'A38020170813', 63.50);
insert into flights(takeoff_date, destination, gate, plane, price) values('2019/01/23 16:00', 1, 3, 'A38020170813', 69.90);
insert into flights(takeoff_date, destination, gate, plane, price) values('2019/01/30 16:00', 1, 3, 'A38020170813', 78.40);
insert into flights(takeoff_date, destination, gate, plane, price) values('2018/12/07 07:25', 3, 2, 'CONC19981130', 395.30);
insert into flights(takeoff_date, destination, gate, plane, price) values('2018/12/14 07:25', 3, 2, 'CONC19981130', 425.00);
insert into flights(takeoff_date, destination, gate, plane, price) values('2018/12/21 07:25', 3, 2, 'CONC19981130', 470.50);
insert into flights(takeoff_date, destination, gate, plane, price) values('2018/12/28 07:25', 3, 2, 'CONC19981130', 476.30);
insert into flights(takeoff_date, destination, gate, plane, price) values('2019/01/04 07:25', 3, 2, 'CONC19981130', 463.80);
insert into flights(takeoff_date, destination, gate, plane, price) values('2019/01/11 07:25', 3, 2, 'CONC19981130', 399.90);
insert into flights(takeoff_date, destination, gate, plane, price) values('2019/01/18 07:25', 3, 2, 'CONC19981130', 405.10);
insert into flights(takeoff_date, destination, gate, plane, price) values('2019/01/25 07:25', 3, 2, 'CONC19981130', 432.90);