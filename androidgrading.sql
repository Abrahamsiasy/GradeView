-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 03, 2019 at 07:59 AM
-- Server version: 5.7.23
-- PHP Version: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `androidgrading`
--

-- --------------------------------------------------------

--
-- Table structure for table `attain`
--

DROP TABLE IF EXISTS `attain`;
CREATE TABLE IF NOT EXISTS `attain` (
  `examDate` date NOT NULL,
  `id` int(10) NOT NULL,
  `department` varchar(100) NOT NULL,
  `exampType` varchar(100) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
CREATE TABLE IF NOT EXISTS `grade` (
  `id` int(8) DEFAULT NULL,
  `subject_1` varchar(2) NOT NULL,
  `subject_2` varchar(2) NOT NULL,
  `subject_3` varchar(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`id`, `subject_1`, `subject_2`, `subject_3`) VALUES
(12345, 'A', 'B', 'A'),
(12344, 'C', 'C', 'A'),
(12345, 'A', 'B', 'A'),
(12344, 'C', 'C', 'A');

-- --------------------------------------------------------

--
-- Table structure for table `grade1`
--

DROP TABLE IF EXISTS `grade1`;
CREATE TABLE IF NOT EXISTS `grade1` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `subject` varchar(30) NOT NULL,
  `grade` varchar(2) NOT NULL,
  `ects` int(2) NOT NULL,
  `chours` int(2) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grade1`
--

INSERT INTO `grade1` (`id`, `subject`, `grade`, `ects`, `chours`, `type`) VALUES
(1, 'Engineering Design', 'A', 7, 4, 'MAJOR'),
(2, 'Engineering Modelling', 'B', 6, 3, 'MAJOR'),
(3, 'Algorithms & Data Structures', 'B', 7, 4, 'MINOR'),
(4, 'The Software Process', 'A', 7, 4, 'MAJOR'),
(5, 'Algorithms & Data Structures', 'B', 7, 3, 'MINOR'),
(6, 'The Software Process', 'A', 7, 4, 'MAJOR'),
(7, 'Fundamental of web', 'B-', 7, 4, 'MAJOR'),
(8, 'Oprating System', 'C', 6, 3, 'MAJOR');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
CREATE TABLE IF NOT EXISTS `member` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `full_name` varchar(50) NOT NULL,
  `password_hash` varchar(256) NOT NULL,
  `salt` varchar(256) NOT NULL,
  `created_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`user_id`, `username`, `full_name`, `password_hash`, `salt`, `created_date`) VALUES
(1, 'a', 'a', '$2y$10$wPnNkly43pOTByYzE4fRROPcT8tSpXoU8HSWQYF63d7N6ySkr6pFO', 'b6952a469bc35edc275e5f48e06c685f472b3106c21cf33d715913a8737a0ec1', '2019-04-18 08:54:06'),
(2, 'b', 'b', '$2y$10$7683PB0W45LT58GKFUjLkueVC0lhptm8YMzfQ7IrNrcU9Gkg0xigG', '92b5f3f5671ecb5ea72b9f998e884c83cec785ea147e2a4fd34011239914cdd1', '2019-04-18 08:55:26'),
(3, 'e', 'e', '$2y$10$eO0dSkLVqPCByCMqFkul1eTRaMrJsXGAVeN2AvzVEdKEBhMOoo5jm', '891860243659f52048eac9049f6003f9c02fd87433995075e950eace8759ab5f', '2019-04-18 10:19:06'),
(4, 'q', 'q', '$2y$10$xHrTXPCh35afPPs4zHiu2uyuAMFOA8cHbE1potetG2/.td8jcZ6qG', '925a132852c55ba34cfcf731f6b855bd578381f14534d7515ac2704f87bd677a', '2019-04-19 12:26:51'),
(5, 'test', 'test', '$2y$10$Sp6S2OO5gL8woKgcH4GhyeprC0J03i4xaHZzTPug5Id2w5PlP8d7.', '27c19ef39cab01e901b53f3296a6bb113e2669fcdd4dfd35a5628bf395faf9b0', '2019-04-19 12:30:23');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
