-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Aug 16, 2022 at 11:36 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `yum_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `tableData`
--

CREATE TABLE `tableData` (
  `id` int(255) NOT NULL,
  `username` varchar(256) CHARACTER SET utf8 NOT NULL,
  `email` varchar(256) CHARACTER SET utf8 NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 NOT NULL,
  `phone` varchar(15) CHARACTER SET utf8 NOT NULL,
  `url` varchar(25) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tableData`
--

INSERT INTO `tableData` (`id`, `username`, `email`, `password`, `phone`, `url`) VALUES
(1, '_mehdi_sahraei', 'mahdi_sahrai@yahoo.com', '1917220098', '09187472645', 'upload/1636096346615.jpg'),
(2, '', '', '1', '', ''),
(3, '', '', '1917220098', '09187472645', 'upload/1636117619255.jpg'),
(4, '2', '2', '3333', '232261', 'upload/1636118843651.jpg'),
(5, '', '', '33333', '09', 'upload/1660629272447.jpg'),
(6, '1', '1', '111111', '06565565665', ''),
(7, 'meh', 'meh@yahoo.com', '143232', '', 'upload/1660638568177.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tableData`
--
ALTER TABLE `tableData`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tableData`
--
ALTER TABLE `tableData`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
