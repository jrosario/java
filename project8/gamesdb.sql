-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2017 at 06:41 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.0.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gamesdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Cust_Phone_Num` bigint(10) NOT NULL,
  `First_Name` varchar(15) NOT NULL,
  `Last_Name` varchar(15) NOT NULL,
  `email` varchar(40) NOT NULL,
  `Address` varchar(30) NOT NULL,
  `City` varchar(20) NOT NULL,
  `State` varchar(2) NOT NULL,
  `ZIP` varchar(5) NOT NULL,
  `DOB` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Cust_Phone_Num`, `First_Name`, `Last_Name`, `email`, `Address`, `City`, `State`, `ZIP`, `DOB`) VALUES
(702496565, 'Chanda', 'Killingbeck', 'calessandrinip@sphinn.com', '333 Green Court', 'Las Vegas', 'NV', '89147', '1972-07-10'),
(7021119958, 'Louis', 'Petrolli', 'losband@reverbnation.com', '587 David Park', 'Las Vegas', 'NV', '89147', '1997-07-28'),
(7021234078, 'Thain', 'Gile', 'tpennazzic@latimes.com', '8 Ohio Parkway', 'Las Vegas', 'NV', '89148', '1989-09-07'),
(7021856655, 'Latashia', 'Fripps', 'ljeromsons@csmonitor.com', '506 Alpine Trail', 'Las Vegas', 'NV', '89148', '1992-03-19'),
(7022024228, 'Rhodia', 'Cudbird', 'rsilbermannj@hc360.com', '48 Lotheville Place', 'Las Vegas', 'NV', '89147', '1972-01-03'),
(7022136522, 'Camille', 'Luciano', 'cvangoq@census.gov', '57 Hoffman Alley', 'Las Vegas', 'NV', '89135', '1992-03-13'),
(7022427047, 'Saree', 'Freddi', 'sdallow7@boston.com', '4945 Nobel Junction', 'Las Vegas', 'NV', '89117', '1965-04-08'),
(7022838921, 'Kori', 'Bilovsky', 'khiggan9@ezinearticles.com', '1474 Mallard Center', 'Las Vegas', 'NV', '89135', '1992-01-17'),
(7023177883, 'Fancy', 'Angus', 'fjanas3@4shared.com', '2 Comanche Park', 'Las Vegas', 'NV', '89148', '1984-11-13'),
(7023193701, 'Rock', 'Van Dijk', 'rshanko@domainmarket.com', '450 Esch Point', 'Las Vegas', 'NV', '89148', '1954-09-13'),
(7023747638, 'Anthe', 'Woolstenholmes', 'abrindeda@ask.com', '1005 Dovetail Alley', 'Las Vegas', 'NV', '89147', '1990-09-08'),
(7023791881, 'Nealy', 'Bunhill', 'nsteanel@soundcloud.com', '83933 Briar Crest Court', 'Las Vegas', 'NV', '89147', '2001-04-22'),
(7023912048, 'Trisha', 'Beamont', 'tbernte@foxnews.com', '2 Elka Center', 'Las Vegas', 'NV', '89147', '1968-07-06'),
(7023992281, 'Lester', 'Slowly', 'lilemf@bandcamp.com', '7662 Shopko Street', 'Las Vegas', 'NV', '89147', '1968-11-19'),
(7024341458, 'Joella', 'Jost', 'jlejeune8@wordpress.org', '45582 Forster Park', 'Las Vegas', 'NV', '89148', '1999-08-02'),
(7024453709, 'Christan', 'Hammatt', 'cberringeri@digg.com', '132 Vernon Place', 'Las Vegas', 'NV', '89148', '2000-09-04'),
(7025085735, 'Kary', 'O\'Toole', 'ktrowell4@creativecommons.org', '11 Ludington Alley', 'Las Vegas', 'NV', '89147', '1962-10-25'),
(7025538313, 'Terrel', 'Menloe', 'tprogern@rambler.ru', '7571 Basil Hill', 'Las Vegas', 'NV', '89147', '1959-09-16'),
(7026391339, 'Raquel', 'Kynnd', 'rfroomeb@si.edu', '47998 Wayridge Avenue', 'Las Vegas', 'NV', '89147', '1953-04-13'),
(7026426774, 'Brinn', 'Akett', 'bstyantt@nbcnews.com', '321 Graedel Point', 'Las Vegas', 'NV', '89147', '1962-10-03'),
(7026502412, 'Alard', 'Chrisp', 'adomanski5@who.int', '1974 Farragut Place', 'Las Vegas', 'NV', '89117', '1968-05-11'),
(7026519842, 'Appolonia', 'Francesconi', 'aryalh@microsoft.com', '82 Grover Lane', 'Las Vegas', 'NV', '89135', '2000-08-31'),
(7026729225, 'Ogdan', 'Lafay', 'omcmurtym@census.gov', '6063 Dovetail Road', 'Las Vegas', 'NV', '89135', '1955-02-21'),
(7027346582, 'Tanny', 'Beckingham', 'tschoenrockg@mayoclinic.com', '9914 Lerdahl Place', 'Las Vegas', 'NV', '89147', '1978-11-15'),
(7027961517, 'Codie', 'Langran', 'chorick0@free.fr', '892 Thackeray Circle', 'Las Vegas', 'NV', '89147', '2000-10-24'),
(7028493140, 'Ernie', 'Langdale', 'ekentishr@dion.ne.jp', '87 Prairieview Lane', 'Las Vegas', 'NV', '89147', '1972-09-26'),
(7028586958, 'Dusty', 'Brasher', 'drenzini6@china.com.cn', '31 Stoughton Parkway', 'Las Vegas', 'NV', '89147', '2005-10-18'),
(7029089687, 'Dasie', 'Yeld', 'ddorberk@japanpost.jp', '552 Myrtle Terrace', 'Las Vegas', 'NV', '89117', '1988-12-18');

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `Product_No` int(11) NOT NULL,
  `Title` varchar(60) NOT NULL,
  `Publisher` varchar(25) NOT NULL,
  `Designer` varchar(25) NOT NULL,
  `Category` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`Product_No`, `Title`, `Publisher`, `Designer`, `Category`) VALUES
(1, 'Through the Ages: A New Story of Civilization', 'IELLO', 'Vlaada Chvatil', 'Tableau Building Hand Management Auction/Bidding Card Drafting'),
(2, 'Twilight Struggle', 'GMT Games', 'Ananda Gupta', 'Area Control Hand Management Simultaneous Action Selection Dice Rolling'),
(3, 'Terra Mystica', 'Z-Man Games', 'Jens Drogemuller', 'Route/Network Building Variable Phase Order Variable Player Powers '),
(4, 'Star Wars: Rebellion', 'Fantasy Flight Games', 'Corey Konieczka', 'Area Control Area Movement Dice Rolling Hand Management'),
(5, 'Scythe', 'Stonemaier Games', 'Jamey Stegmaier', 'Area Control Grid Movement Variable Player Powers '),
(6, 'Gloomhaven', 'Cephalofair Games', 'Isaac Childres', 'Action/Movement Programming Co-operative Hand Management Grid Movement'),
(7, '7 Wonders Duel', 'Repos Production', 'Antoine Bauza', 'Card Drafting Set Collection  '),
(8, 'Caverna: The Cave Farmers', 'Mayfair Games', 'Uwe Rosenburg', 'Tile Placement Worker Placement  '),
(9, 'Terraforming Mars', 'Stronghold Games', 'Jacob Fryxelius', 'Card Drafting Hand Management Tile Placement Territory Building'),
(10, 'The Castles of Burgundy', 'Ravensburger', 'Stefan Feld', 'Dice Rolling Set Collection Tile Placement Variable Phase Order'),
(11, 'Puerto Rico', 'Rio Grande Games', 'Andreas Seyfarth', 'Variable Phase Order Tableau Building  '),
(12, 'Agricola', 'Z-Man Games', 'Uwe Rosenburg', 'Card Drafting Hand Management Variable Player Powers Worker Placement'),
(13, 'War of the Ring', 'Ares Games', 'Roberto Di Meglio', 'Area Control Area Movement Dice Rolling Hand Management'),
(14, 'Mage Knight', 'Asmodee', 'Vlaada Chvatil', 'Card Drafting Co-operative Deck/Pool Building Hand Management'),
(15, 'Blood Rage', 'Asmodee', 'Eric M. Lang', 'Action Point Allowance System Area Control Card Drafting Hand Management'),
(16, 'Power Grid', 'Rio Grande Games', 'Friedemann Friese', 'Route/Network Building Auction/Bidding  '),
(17, 'Eclipse', 'Asmodee', 'Touko Tahkokallio', 'Area Control Dice Rolling Grid Movement Tile Placement'),
(18, 'Mansions of Madness: Second Edition', 'Fantasy Flight Games', 'Nikki Valens', 'Area Movemen Co-operative Dice Rolling Hand Management'),
(19, 'Robinson Crusoe: Adventures on the Cursed Island', 'Z-Man Games', 'Ignacy Trzewiczek', 'Action/Movement Programming Co-operative Dice Rolling Worker Placement'),
(20, 'Android: Netrunner', 'Fantasy Flight Games', 'Richard Garfield', 'Action Point Allowance System Hand Management Secret Unit Deployment Variable Player Powers');

-- --------------------------------------------------------

--
-- Table structure for table `game_copy`
--

CREATE TABLE `game_copy` (
  `Copy_Num` varchar(6) NOT NULL,
  `Product_Num` int(11) NOT NULL,
  `Status` varchar(3) DEFAULT NULL,
  `Loan_Num` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `game_copy`
--

INSERT INTO `game_copy` (`Copy_Num`, `Product_Num`, `Status`, `Loan_Num`) VALUES
('7WD001', 7, 'IN', 0),
('AGR001', 12, 'IN', 0),
('ANE001', 20, 'IN', 0),
('BRA001', 15, 'IN', 0),
('CCF001', 8, 'IN', 0),
('COB001', 10, 'IN', 0),
('ECL001', 17, 'IN', 0),
('GLO001', 6, 'IN', 0),
('MKN001', 14, 'IN', 0),
('MM2001', 18, 'IN', 0),
('PGR001', 16, 'IN', 0),
('PRI001', 11, 'IN', 0),
('RCA001', 19, 'IN', 0),
('SCY001', 5, 'IN', 0),
('SWR001', 4, 'IN', 0),
('TFA001', 9, 'IN', 0),
('TMY001', 3, 'IN', 0),
('TST001', 2, 'IN', 0),
('TTA001', 1, 'OUT', 1),
('WOR001', 13, 'IN', 0);

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE `loan` (
  `Loan_Num` int(11) NOT NULL,
  `Cust_Num` bigint(10) NOT NULL,
  `Copy_Num` varchar(6) NOT NULL,
  `Start_Date` date NOT NULL,
  `Due_Date` date NOT NULL,
  `Return_Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`Loan_Num`, `Cust_Num`, `Copy_Num`, `Start_Date`, `Due_Date`, `Return_Date`) VALUES
(1, 7021796517, 'TTA001', '2017-04-23', '2017-04-24', NULL),
(2, 7021796517, 'TST001', '2017-04-23', '2017-04-24', '2017-04-24'),
(3, 7021796517, 'TMY001', '2017-04-23', '2017-04-24', '2017-04-24'),
(4, 7021796517, 'SWR001', '2017-04-23', '2017-04-24', '2017-04-24'),
(5, 7021796517, 'SCY001', '2017-04-23', '2017-04-24', '2017-04-24'),
(6, 7021796517, 'GLO001', '2017-04-23', '2017-04-24', '2017-04-24'),
(7, 7021796517, '7WD001', '2017-04-23', '2017-04-24', '2017-04-24'),
(8, 7021796517, 'CCF001', '2017-04-23', '2017-04-24', '2017-04-24'),
(9, 7021796517, 'TFA001', '2017-04-23', '2017-04-24', '2017-04-24'),
(10, 7021796517, 'COB001', '2017-04-23', '2017-04-24', '2017-04-24'),
(11, 7021796517, 'PRI001', '2017-04-23', '2017-04-24', '2017-04-24'),
(12, 7021796517, 'AGR001', '2017-04-23', '2017-04-24', '2017-04-24'),
(13, 7021796517, 'WOR001', '2017-04-23', '2017-04-24', '2017-04-24'),
(14, 7021796517, 'MKN001', '2017-04-23', '2017-04-24', '2017-04-24'),
(15, 7021796517, 'BRA001', '2017-04-23', '2017-04-24', '2017-04-24');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Cust_Phone_Num`);

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`Product_No`);

--
-- Indexes for table `game_copy`
--
ALTER TABLE `game_copy`
  ADD PRIMARY KEY (`Copy_Num`);

--
-- Indexes for table `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`Loan_Num`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
