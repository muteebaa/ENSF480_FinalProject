DROP DATABASE IF EXISTS DATA_CINEMA;
CREATE DATABASE DATA_CINEMA; 
USE DATA_CINEMA;

DROP TABLE IF EXISTS projectData;

CREATE TABLE projectData (
	Item		int not null AUTO_INCREMENT,
	Theatre			varchar(100),
	Movie		varchar(100),
	dateM	varchar(25),
	dayM			varchar(25),
	timeM			varchar(25),
    Seats	varchar(25),
    primary key (Item)
);

INSERT INTO projectData (Theatre, Movie, dateM, dayM, timeM, Seats)
VALUES
('Crowfoot Cinema', 'Wakanda Forvever', '23/11/2022', 'Tuesday', '2300', '10'),
('Crowfoot Cinema', 'Smile', '24/11/2022', 'Tuesday', '2359',  '10'),
('MarketMall Cinema', 'Black Adam', '25/11/2022', 'Wednesday', '1900',  '10'),
('Sunridge Cinema', 'Wakanda Forvever', '24/11/2022', 'Wednesday', '1100', '10'),
('Sunridge Cinema', 'Smile', '24/11/2022', 'Wednesday', '0500', '10'),
('Crowfoot Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0530', '10'),
('Crowfoot Cinema', 'Smile', '23/11/2022', 'Wednesday', '0530', '10'),
('MarketMall Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0530', '10'),
('Sunridge Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0530', '10'),
('MarketMall Cinema', 'Wakanda Forever', '23/11/2022', 'Wednesday', '0530', '10'),
('Crowfoot Cinema', 'Black Adam', '23/11/2022', 'Wednesday', '0530', '10'),
('MarketMall Cinema', 'Black Adam', '23/11/2022', 'Wednesday', '0530', '10'),
('Crowfoot Cinema', 'Black Adam', '23/11/2022', 'Wednesday', '0530', '10'),
('Sunridge Cinema', 'Black Adam', '23/11/2022', 'Wednesday', '0530', '10'),
('MarketMall Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0530', '10'),
('Crowfoot Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0530', '10'),
('Sunridge Cinema', 'Black Adam', '23/11/2022', 'Wednesday', '0530', '10'),
('Crowfoot Cinema', 'Smile', '23/11/2022', 'Wednesday', '0530', '10'),
('MarketMall Cinema', 'Smile', '23/11/2022', 'Wednesday', '0530', '10'),
('MarketMall Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0530', '10'),
('Crowfoot Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0530', '10'),
('Crowfoot Cinema', 'Smile', '23/11/2022', 'Wednesday', '0530', '10');


