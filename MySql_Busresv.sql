create database busresv;
use busresv;
drop database busresv;
CREATE TABLE buses (
    bus_id INT AUTO_INCREMENT PRIMARY KEY,
    bus_number VARCHAR(50) NOT NULL,
    ac boolean,
    total_seats INT NOT NULL,
    route varchar(100)
);
select * from buses;
insert into buses values(1,1,0,20,'Coimbatore to Chennai');
insert into buses values(2,2,1,60,'Chennai to Bangalore');
insert into buses values(3,3,1,40,'Coimbatore to Hyderabad');

CREATE TABLE users (
    username VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL
);

select * from users;
CREATE TABLE bookings (
    passenger_name varchar(30) not null,
	bus_no int not null,
    booking_date DATE NOT NULL
);

select * from bookings;