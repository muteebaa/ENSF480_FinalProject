/*
 * @authour: muteeba jamal <a href="mailto:muteeba.jamal@ucalgary.ca">
 * muteeba.jamal@ucalgary.ca</a>
 * @authour: shahzill naveed <a href="mailto:shahzill.naveed@ucalgary.ca">
 * shahzill.naveed@ucalgary.ca</a>
 * @authour: michele pham <a href="mailto:michele.pham@ucalgary.ca">
 * michele.pham@ucalgary.ca</a>
 * @authour: samira khan <a href="mailto:samira.khan@ucalgary.ca">
 * samira.khan@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 */

DROP DATABASE IF EXISTS MOVIE_THEATER;
CREATE DATABASE MOVIE_THEATER; 
USE MOVIE_THEATER;

DROP TABLE IF EXISTS MOVIE;
CREATE TABLE MOVIE (
	movieID			int not null AUTO_INCREMENT,
	nameMovie		varchar(25),
	released		varchar(25),			
	primary key (movieID)
);

INSERT INTO MOVIE (nameMovie, released)
VALUES
('Wakanda Forever', 'true'),
('Smile', 'true'),
('Black Adam', 'true'),
('Strange World','true'),
('Devotion', 'true'),
('Top Gun', 'true'),
('Avatar 2', 'false'),
('Puss in Boots','false');

DROP TABLE IF EXISTS MOVIE_DATE;
CREATE TABLE MOVIE_DATE (
	dateID			int not null AUTO_INCREMENT,
	dateMovie		varchar(25),		
	primary key (dateID)
);

INSERT INTO MOVIE_DATE (dateMovie)
VALUES
('27/11/2022'),
('28/11/2022'),
('29/11/2022'),
('30/11/2022'),
('01/12/2022'),
('02/12/2022'),
('03/12/2022');


DROP TABLE IF EXISTS SHOWTIMES;
CREATE TABLE SHOWTIMES (
	showtimeID		int not null AUTO_INCREMENT,
	displaytime		varchar(25),
	seats			int,					
	primary key (showtimeID)
);

INSERT INTO SHOWTIMES (displaytime, seats)
VALUES
('8:00', 20),
('10:00', 20),
('12:00', 20),
('14:00', 20),
('16:00', 20),
('18:00', 20),
('20:00', 20),
('22:00', 20);


DROP TABLE IF EXISTS SEAT_CHART;
CREATE TABLE SEAT_CHART (
	seatID				int not null AUTO_INCREMENT,
	seatNumber			varchar(25),
	available			varchar(25),					
	primary key (seatID)
);

INSERT INTO SEAT_CHART (seatNumber, available)
VALUES
('A1', 'true'),
('A2', 'true'),
('A3', 'true'),
('A4', 'true'),
('A5', 'true'),
('B1', 'true'),
('B2', 'true'),
('B3', 'true'),
('B4', 'true'),
('B5', 'true'),
('C1', 'true'),
('C2', 'true'),
('C3', 'true'),
('C4', 'true'),
('C5', 'true'),
('D1', 'true'),
('D2', 'true'),
('D3', 'true'),
('D4', 'true'),
('D5', 'true');

DROP TABLE IF EXISTS USERS;
CREATE TABLE USERS (
	userID					int not null AUTO_INCREMENT,
	userName				varchar(250),
	userEmail				varchar(250),
	userPassword			varchar(250),
	userCardInfo			varchar(250),					
	primary key (userID)
);

INSERT INTO USERS (userName, userEmail, userPassword, userCardInfo)
VALUES
('Michele Pham', 'michele.pham@ucalgary.ca', 'michi1234', '3265 4325 9743 2180'),
('Samira Khan', 'samira.khan@ucalgary.ca', '1234samira', '1294 3275 8903 8732'),
('Muteeba Jamal', 'muteeba.jamal@ucalgary.ca', 'muteeba123', '3827 9320 2938 4839'),
('Shahazill Naveed', 'shahzill.naveed@ucalgary.ca', 'shahzil', '1234 4321 4433 2211');