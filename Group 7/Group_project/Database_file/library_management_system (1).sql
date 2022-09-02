-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 01, 2022 at 11:06 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_return_records`
--

CREATE TABLE `book_return_records` (
  `ID` int(11) NOT NULL,
  `Book_id` varchar(35) DEFAULT NULL,
  `Book_Title` varchar(50) DEFAULT NULL,
  `STUDENT_ID` varchar(50) DEFAULT NULL,
  `Student_Fullname` varchar(50) NOT NULL,
  `Staff_Fullname` varchar(50) NOT NULL,
  `Staff_ID` varchar(35) DEFAULT NULL,
  `NOcopies` int(11) DEFAULT NULL,
  `Release_Date` date DEFAULT NULL,
  `BookReturn_Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book_return_records`
--

INSERT INTO `book_return_records` (`ID`, `Book_id`, `Book_Title`, `STUDENT_ID`, `Student_Fullname`, `Staff_Fullname`, `Staff_ID`, `NOcopies`, `Release_Date`, `BookReturn_Date`) VALUES
(1, 'Aoo1', 'Java', '04/2020/2015', 'Menu Michael', 'Blessing Owusu', 'TC001', 798, '2022-08-14', '2022-09-14');

-- --------------------------------------------------------

--
-- Table structure for table `book_table`
--

CREATE TABLE `book_table` (
  `Book_Id` int(11) NOT NULL,
  `Book_Title` varchar(50) DEFAULT NULL,
  `Book_Edition` varchar(50) DEFAULT NULL,
  `Book_Author` varchar(50) DEFAULT NULL,
  `Book_Publisher` varchar(50) DEFAULT NULL,
  `Book_Copies` int(11) DEFAULT NULL,
  `Book_Source` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `book_table`
--

INSERT INTO `book_table` (`Book_Id`, `Book_Title`, `Book_Edition`, `Book_Author`, `Book_Publisher`, `Book_Copies`, `Book_Source`) VALUES
(1, 'Java', '9th', 'Farrel', 'Farrel', 798, 'Farrel');

-- --------------------------------------------------------

--
-- Table structure for table `borrowerrecords`
--

CREATE TABLE `borrowerrecords` (
  `ID` int(11) NOT NULL,
  `Book_Id` varchar(50) DEFAULT NULL,
  `Book_Title` varchar(50) DEFAULT NULL,
  `STUDENT_ID` varchar(50) DEFAULT NULL,
  `Student_Fullname` varchar(50) NOT NULL,
  `Staff_Fullname` varchar(50) NOT NULL,
  `Staff_ID` varchar(50) DEFAULT NULL,
  `NOcopies` int(11) DEFAULT NULL,
  `Release_Date` date DEFAULT NULL,
  `Due_Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `borrowerrecords`
--

INSERT INTO `borrowerrecords` (`ID`, `Book_Id`, `Book_Title`, `STUDENT_ID`, `Student_Fullname`, `Staff_Fullname`, `Staff_ID`, `NOcopies`, `Release_Date`, `Due_Date`) VALUES
(1, 'A001', 'Java', '04/2020/2015D', 'Menu Michael', 'Blessing Owusu', 'TC001', 789, '2022-08-14', '2022-09-14');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `ID` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `gender` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `Program` varchar(50) DEFAULT NULL,
  `year` int(11) DEFAULT NULL,
  `Phone_no` varchar(50) DEFAULT NULL,
  `Address` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`ID`, `first_name`, `last_name`, `gender`, `email`, `Program`, `year`, `Phone_no`, `Address`) VALUES
(1, 'Ampaabeng', 'Samuel', 'Male', 'Ampaabeng@gmail.com', 'Computer Science', 200, '0543997452', 'EC-oo1-254');

-- --------------------------------------------------------

--
-- Table structure for table `usertable`
--

CREATE TABLE `usertable` (
  `ID` int(11) NOT NULL,
  `Staff_LastName` varchar(50) NOT NULL,
  `Staff_FirstName` varchar(50) NOT NULL,
  `Staff_Email` varchar(50) DEFAULT NULL,
  `Staff_Address` varchar(50) DEFAULT NULL,
  `Staff_Password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `usertable`
--

INSERT INTO `usertable` (`ID`, `Staff_LastName`, `Staff_FirstName`, `Staff_Email`, `Staff_Address`, `Staff_Password`) VALUES
(1, 'Samuel', 'Ampaabeng', 'Ampaabeng@gmail.com', 'EC-007-657', 'Samuel');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_return_records`
--
ALTER TABLE `book_return_records`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `book_table`
--
ALTER TABLE `book_table`
  ADD PRIMARY KEY (`Book_Id`);

--
-- Indexes for table `borrowerrecords`
--
ALTER TABLE `borrowerrecords`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `usertable`
--
ALTER TABLE `usertable`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_return_records`
--
ALTER TABLE `book_return_records`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `book_table`
--
ALTER TABLE `book_table`
  MODIFY `Book_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `borrowerrecords`
--
ALTER TABLE `borrowerrecords`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `usertable`
--
ALTER TABLE `usertable`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
