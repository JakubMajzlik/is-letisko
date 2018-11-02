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
insert into destinations(country, city) values('Slovenska republika', 'Bratislava');
insert into destinations(country, city) values('Ceska republika', 'Brno');
insert into destinations(country, city) values('Mali', 'Bamako');