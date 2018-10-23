create database if not exists `iis_project`;
use `iis_project`;


create table if not exists `passenger_details` (
	`email` varchar(254) default null,
    `phone_number` varchar(20) default null,
    `first_name` varchar(45) not null,
    `last_name` varchar(45) not null,
    `identification_number` varchar(10) not null,
    `city` varchar(45) not null,
    `street` varchar(45) not null,
    `house_number` varchar(5) not null,
    `zip` varchar(5) not null,
    `country` varchar(45) not null,
    
    primary key(`identification_number`)
   
    
);

create table if not exists `user` (
	`id` int(11) auto_increment,
	`username` varchar(254) not null,
	`password` varchar(80) not null,
	`enabled` tinyint default 1, 
    `user_details_id` varchar(10) not null,
    
	primary key(`id`),
    
    constraint `fk_user_details` foreign key(`user_details_id`) references `passenger_details`(`identification_number`)
);

create table if not exists `role` (
	`id` int(11) auto_increment,
    `name` varchar(50) not null,
    
    primary key(`id`)
);

create table if not exists `users_roles` (
	`role_id` int(11)  not null,
    `user_id` int(11) not null,
    
    PRIMARY KEY (`user_id`,`role_id`),
  
	KEY `fk_role` (`role_id`),
  
	CONSTRAINT `fk_user_id2` FOREIGN KEY (`user_id`) 
	REFERENCES `user` (`id`) 
	ON DELETE NO ACTION ON UPDATE NO ACTION,
  
	CONSTRAINT `fk_role` FOREIGN KEY (`role_id`) 
	REFERENCES `role` (`id`) 
	ON DELETE NO ACTION ON UPDATE NO ACTION
);

create table if not exists `destinations` (
	`id` int(11) auto_increment,
    `country` varchar(64) not null,
    `city` varchar(64) not null,
    
    primary key(`id`)
);

create table if not exists `gates` (
	`gate_number` int(3) not null,
    `terminal` varchar(1) not null,
    
    primary key(`gate_number`)
);

create table if not exists `planes` (
	`serial_number` varchar(16) not null,
    `type` varchar(16) not null,
    `manufacturer` varchar(32) not null,
    `date_of_made` date not null,
    `last_revision_date` date default null,
    `number_of_seats` int(4) default 0,
    `max_payload_in_tons` int(4) default 0,
    
    primary key(`serial_number`)
);

create table if not exists `seats` (
	`number` varchar(4) not null,
    `plane` varchar(16) not null,
    `class` varchar(16) not null,
    
    primary key(`number`, `plane`),
    
    key `fk_plane_seat`(`plane`), 
    constraint `fk_plane_seat` foreign key(`plane`) references `planes`(`serial_number`)
);

create table if not exists `flights` (
	`id` int(11) auto_increment,
    `takeoff_date` timestamp not null,
    `destination` int(11) not null,
    `gate` int(11) not null,
    `plane` varchar(16) not null,
    
    primary key(`id`),
    
    key `fk_destination`(`destination`), 
    constraint `fk_destination` foreign key(`destination`) references `destinations`(`id`),
    key `fk_gate`(`gate`), 
    constraint `fk_gate` foreign key(`gate`) references `gates`(`gate_number`),
    key `fk_plane_flights`(`plane`), 
    constraint `fk_plane_flights` foreign key(`plane`) references `planes`(`serial_number`)
);

create table if not exists `flight_tickets` (
	`id` int(11) auto_increment,
    `boarding_time` timestamp not null,
    `flight` int(11) not null,
    `seat` varchar(4) not null,
    `plane` varchar(16) not null,
    `user_identification_number` varchar(10) not null,
    
    primary key(`id`),
    
    key `fk_flight`(`flight`), 
    constraint `fk_flight` foreign key(`flight`) references `flights`(`id`),
    key `fk_plane_tickets`(`plane`), 
    constraint `fk_plane_tickets` foreign key(`plane`) references `planes`(`serial_number`),
    key `fk_seat`(`seat`, `plane`),
    constraint `fk_seat` foreign key(`seat`, `plane`) references `seats`(`number`, `plane`),
    key `fk_id_ticket`(`user_identification_number`), 
    constraint `fk_id_ticket` foreign key(`user_identification_number`) references `passenger_details`(`identification_number`)
);
