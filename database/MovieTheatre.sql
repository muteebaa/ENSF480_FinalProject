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
('Crowfoot Cinema', 'Smile', '23/11/2022', 'Wednesday', '0545', '10'),
('MarketMall Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0550', '10'),
('Sunridge Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0525', '10'),
('MarketMall Cinema', 'Wakanda Forever', '23/11/2022', 'Wednesday', '0520', '10'),
('Crowfoot Cinema', 'Black Adam', '23/11/2022', 'Wednesday', '0521', '10'),
('MarketMall Cinema', 'Black Adam', '23/11/2022', 'Wednesday', '0522', '10'),
('Crowfoot Cinema', 'Black Adam', '23/11/2022', 'Wednesday', '0534', '10'),
('Sunridge Cinema', 'Black Adam', '23/11/2022', 'Wednesday', '0556', '10'),
('MarketMall Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0517', '10'),
('Crowfoot Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0538', '10'),
('Sunridge Cinema', 'Black Adam', '23/11/2022', 'Wednesday', '0534', '10'),
('Crowfoot Cinema', 'Smile', '23/11/2022', 'Wednesday', '0542', '10'),
('MarketMall Cinema', 'Black Adam', '23/11/2022', 'Wednesday', '0543', '10'),
('MarketMall Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0541', '10'),
('Crowfoot Cinema', 'Wakanda Forvever', '23/11/2022', 'Wednesday', '0529', '10'),
('Crowfoot Cinema', 'Smile', '23/11/2022', 'Wednesday', '0519', '10');



CREATE TABLE userData (
	Item		int not null AUTO_INCREMENT,
	Email			varchar(100),
	Password		varchar(100),
	CNumber			varchar(100),
    Cvv				varchar(100),
    Expiry			varchar(100),
    FeePaid         boolean,
    primary key (Item)
);

INSERT INTO userData (Email, Password, CNumber, Cvv, Expiry, FeePaid)
VALUES
('shah@gmail.com', 'shah', '350519263647', '333', '06/25', 0),
('muteeba@gmail.com', 'muteeba', '35054564658', '322', '12/24', 1),
('michi@gmail.com', 'michi', '350544948', '586', '11/23', 1),
('samira@gmail.com', 'samira', '35051654899', '944', '09/25', 1);


