-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- 생성 시간: 23-01-06 12:30
-- 서버 버전: 10.4.25-MariaDB
-- PHP 버전: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 데이터베이스: `board`
--

-- --------------------------------------------------------

--
-- 테이블 구조 `board`
--

CREATE TABLE `board` (
  `BOARD_IDX` bigint(20) NOT NULL,
  `BOARD_TITLE` varchar(50) NOT NULL,
  `BOARD_WRITER` varchar(25) NOT NULL,
  `BOARD_LIKES` int(11) NOT NULL DEFAULT 0,
  `BOARD_COMMENTS` int(11) NOT NULL DEFAULT 0,
  `BOARD_CREATE_TIME` datetime NOT NULL,
  `BOARD_VIEWS` int(11) NOT NULL DEFAULT 0,
  `BOARD_PHOTO` varchar(50) DEFAULT NULL,
  `BOARD_CONTENTS` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 테이블의 덤프 데이터 `board`
--

INSERT INTO `board` (`BOARD_IDX`, `BOARD_TITLE`, `BOARD_WRITER`, `BOARD_LIKES`, `BOARD_COMMENTS`, `BOARD_CREATE_TIME`, `BOARD_VIEWS`, `BOARD_PHOTO`, `BOARD_CONTENTS`) VALUES
(1, '123야식추천좀', '닮은살갈', 183, 0, '2022-10-01 15:27:25', 332, '', '먹고잔다vs참고잔'),
(3, '귀여운 고양이 보고가세요', '고양이관리자', 7, 0, '2022-10-03 15:27:25', 29, '4481c0973a12be.jpg', '귀여워!'),
(4, '귀여운 강아지 보고가세요~~', '너무 귀엽죠?', 0, 0, '2022-10-04 15:27:25', 14, 'IMG_4817.jpg', '귀여워!'),
(129, '제목1', '난난나', 0, 0, '2022-12-22 10:18:43', 2, '', '내용1'),
(130, '제목2', '난난나', 0, 0, '2022-12-22 10:18:57', 1, '4481c0973a12be.jpg', '내용2'),
(131, '제목2', '난난나', 0, 0, '2022-12-22 10:19:04', 0, 'asd.jpg', '내용2'),
(132, '제목3', '난난나', 0, 0, '2022-12-22 10:19:22', 0, 'IMG_4817.jpg', '내용3'),
(134, '테스트 ', '난난나', 0, 0, '2022-12-22 10:57:46', 0, 'IMG_4817.jpg', '입니다'),
(155, 'ㅂㅈㄷ', '난난나', 0, 0, '2022-12-22 11:47:34', 0, '', 'ㅁㄴㅇ'),
(156, 'ㅈㄷㄷ', '난난나', 0, 0, '2022-12-22 15:56:56', 0, '죄송합니다..!.jpeg', 'ㅈㄷㄷ'),
(157, 'qwe', '난난나', 0, 0, '2022-12-22 15:57:03', 1, '', 'asd'),
(158, '', '난난나', 0, 0, '2022-12-22 16:29:01', 0, '', ''),
(159, 'qwe', '난난나', 0, 0, '2022-12-22 16:42:27', 0, '죄송합니다..!.jpeg', 'wer'),
(160, 'test', '난난나', 0, 0, '2022-12-22 16:52:46', 0, '죄송합니다..!.jpeg', 'test'),
(161, 'test', '난난나', 0, 0, '2022-12-22 16:52:54', 0, '죄송합니다..!.jpeg', 'test'),
(162, '', '난난나', 0, 0, '2022-12-22 16:53:59', 0, '', ''),
(163, 'ㅁㄴㅇ', '난난나', 0, 0, '2022-12-22 17:59:02', 0, 'asd.jpg', 'ㅂㅈㄷ'),
(164, 'ㅂㅈㄷ', '난난나', 0, 0, '2022-12-22 18:00:11', 0, 'A1.jpg', '123');

-- --------------------------------------------------------

--
-- 테이블 구조 `comments`
--

CREATE TABLE `comments` (
  `COM_IDX` int(11) NOT NULL,
  `BOARD_IDX` int(11) NOT NULL,
  `COM_CONTENTS` text NOT NULL,
  `COM_WRITER` varchar(50) NOT NULL,
  `COM_REG_DATE` datetime NOT NULL,
  `COM_LIKES` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- 테이블의 덤프 데이터 `comments`
--

INSERT INTO `comments` (`COM_IDX`, `BOARD_IDX`, `COM_CONTENTS`, `COM_WRITER`, `COM_REG_DATE`, `COM_LIKES`) VALUES
(1, 1, '테스트 댓글1', '박재완', '2022-11-02 17:51:19', 3),
(2, 1, '테스트 댓글2', '정경주', '2022-11-30 17:51:19', 2),
(3, 1, '123213', '로론로', '2022-12-21 15:14:45', 2),
(4, 2, 'qweqwe', '로론로', '2022-12-21 15:24:27', 1),
(5, 2, '테스트 댓글2', '정경주', '2022-11-30 17:51:19', 2),
(6, 1, '테스트', '로론로', '2022-12-21 15:30:23', 1),
(7, 1, '123123123', '로론로', '2022-12-21 17:37:33', 1),
(8, 4, 'ㅁㄴㅇㅁㅇ', '로론로', '2022-12-22 16:09:30', 1),
(9, 1, 'test', '로론로', '2022-12-22 16:51:29', 1),
(10, 1, 'test', '로론로', '2022-12-22 16:51:42', 1);

--
-- 덤프된 테이블의 인덱스
--

--
-- 테이블의 인덱스 `board`
--
ALTER TABLE `board`
  ADD PRIMARY KEY (`BOARD_IDX`);

--
-- 테이블의 인덱스 `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`COM_IDX`);

--
-- 덤프된 테이블의 AUTO_INCREMENT
--

--
-- 테이블의 AUTO_INCREMENT `board`
--
ALTER TABLE `board`
  MODIFY `BOARD_IDX` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=165;

--
-- 테이블의 AUTO_INCREMENT `comments`
--
ALTER TABLE `comments`
  MODIFY `COM_IDX` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
