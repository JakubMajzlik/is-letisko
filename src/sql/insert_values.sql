use `iis_project`;

-- PLANES
insert into planes(serial_number, type, manufacturer, date_of_made, last_revision_date, number_of_seats_economic, number_of_seats_business, number_of_seats_first) values('B73720150322', '737', 'Boeing', '22/03/2015', '16/03/2018', 118, 15, 0);
insert into planes(serial_number, type, manufacturer, date_of_made, last_revision_date, number_of_seats_economic, number_of_seats_business, number_of_seats_first) values('A38020170813', 'A380', 'Airbus', '13/08/2017', '09/08/2018', 461, 48, 8);
insert into planes(serial_number, type, manufacturer, date_of_made, last_revision_date, number_of_seats_economic, number_of_seats_business, number_of_seats_first) values('CONC19981130', 'Concorde', 'Aerospatiale', '30/11/1998', '21/11/2018', 140, 12, 0);

-- GATES
insert into gates(gate_number, terminal) values(1, 'A');
insert into gates(gate_number, terminal) values(2, 'A');
insert into gates(gate_number, terminal) values(3, 'B');

-- DESTINATIONS
insert into destinations(country, city) values('Slovakia', 'Bratislava');
insert into destinations(country, city) values('Czech Republic', 'Brno');
insert into destinations(country, city) values('Mali', 'Bamako');

-- ROLES
insert into role(name) values ('ROLE_USER');
insert into role(name) values ('ROLE_EMPLOYEE');
insert into role(name) values ('ROLE_ADMIN');

-- USERS DETAILS
insert into passenger_details(email, phone_number, first_name, last_name, identification_number, 
			city, street, house_number, zip, country)
values ('jozef.mrkva@gmail.com', '0922333444', 'Jozef', 'Mrkva', '9412241234', 'Liptovska Kokava',
		'Kostolna', '666', '03244', 'Slovakia');
insert into passenger_details(email, phone_number, first_name, last_name, identification_number, 
	city, street, house_number, zip, country)
values ('k.troska@googlemail.com', '0944555333', 'Katarina', 'Troskova', '8754265432', 'Bratislava', 
		'Radvanska', '1', '81101', 'Slovakia');
insert into passenger_details(email, phone_number, first_name, last_name, identification_number, 
			city, street, house_number, zip, country)
values ('tomas@jedno.org', '0977888999', 'Tomas', 'Jedno', '8912121229', 'Filakovo', 'Ongroundbengerova',
		'53', '98601', 'Slovakia');

-- USERS
insert into user(username, password, user_details_id)
values ( 'jozef.mrkva@gmail.com', '$2a$10$raAQ73.7fRB2MqfsUsgzZO4LBCeP6YKYzeN69/E90otsuwUZLCml.', '9412241234');
insert into user(username, password, user_details_id)
values ('k.troska@googlemail.com', '$2a$10$2/5lyPozw9Red.3C4kapDOdvdc1.tK7uVLpUOeJby71cc91xz2p7S','8754265432');
insert into user(username, password, user_details_id)
values ('tomas@jedno.org', '$2a$10$vxSBJMfRYDdx5qLlMyK7Y.Gdphjm8DDLjB45gHWjK.73LL48M7GIS', '8912121229');

-- USERS ROLES
insert into users_roles(role_id, user_id) values (1,1);
insert into users_roles(role_id, user_id) values (2,1);
insert into users_roles(role_id, user_id) values (3,1);
insert into users_roles(role_id, user_id) values (1,3);
insert into users_roles(role_id, user_id) values (2,3);
insert into users_roles(role_id, user_id) values (1,2);

-- FLIGHTS
insert into flights(takeoff_date, destination, gate, plane, price) values('05/11/2018 16:00', 1, 3, 'A38020170813', 65.00);
insert into flights(takeoff_date, destination, gate, plane, price) values('12/11/2018 16:00', 1, 3, 'A38020170813', 70.50);
insert into flights(takeoff_date, destination, gate, plane, price) values('19/11/2018 16:00', 1, 3, 'A38020170813', 68.70);
insert into flights(takeoff_date, destination, gate, plane, price) values('07/11/2018 07:25', 3, 2, 'CONC19981130', 395.30);
insert into flights(takeoff_date, destination, gate, plane, price) values('14/11/2018 07:25', 3, 2, 'CONC19981130', 425.00);

-- FLIGHT TICKETS
insert into flight_tickets(boarding_time, flight, class, user_identification_number) values('15:00', 3, 'Economic', '8912121229');