-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 05, 2020 at 06:45 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gofood`
--
CREATE DATABASE IF NOT EXISTS `gofood` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `gofood`;

-- --------------------------------------------------------

--
-- Table structure for table `data_pesanan`
--

CREATE TABLE `data_pesanan` (
  `id_user` varchar(50) NOT NULL,
  `An.` varchar(100) NOT NULL,
  `kode_pesanan` varchar(50) NOT NULL,
  `id_restoran` varchar(50) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `restoran` varchar(100) NOT NULL,
  `menu_pesan` varchar(100) NOT NULL,
  `jumlah` int(3) NOT NULL,
  `harga` int(11) NOT NULL,
  `total` int(20) NOT NULL,
  `status` varchar(11) NOT NULL,
  `waktu` varchar(20) NOT NULL,
  `keterangan` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `data_pesanan`
--

INSERT INTO `data_pesanan` (`id_user`, `An.`, `kode_pesanan`, `id_restoran`, `id_menu`, `restoran`, `menu_pesan`, `jumlah`, `harga`, `total`, `status`, `waktu`, `keterangan`) VALUES
('abdul_anu1', 'Abdullah Nashih Ulwan', 'P202065212517', 'gofood', 1, 'GoFood', 'Ayam Bakar', 3, 17000, 51000, 'Terkirim', '2020/6/5 21:25', 'Paha 1, Dada 2'),
('abdul_anu1', 'Abdullah Nashih Ulwan', 'P202065212517', 'gofood', 3, 'GoFood', 'Blenger Burger', 1, 14000, 14000, 'Dibatalkan', '2020/6/5 21:25', ''),
('abdul_anu1', 'Abdullah Nashih Ulwan', 'P2020652205', 'gofood', 2, 'GoFood', 'PAKET GEPREK BENSU NASI DAUN JERUK !', 1, 10000, 10000, 'Diantar', '2020/6/5 22:0', ''),
('abdul_anu1', 'Abdullah Nashih Ulwan', 'P202065222849', 'gofood', 2, 'GoFood', 'PAKET GEPREK BENSU NASI DAUN JERUK !', 1, 10000, 10000, 'Diantar', '2020/6/5 22:28', '');

-- --------------------------------------------------------

--
-- Table structure for table `favorite`
--

CREATE TABLE `favorite` (
  `user` varchar(50) NOT NULL,
  `id_restoran` varchar(50) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `restoran` varchar(100) NOT NULL,
  `menu` varchar(100) NOT NULL,
  `harga` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `favorite`
--

INSERT INTO `favorite` (`user`, `id_restoran`, `id_menu`, `restoran`, `menu`, `harga`) VALUES
('abdul_anu1', 'gofood', 2, 'GoFood', 'PAKET GEPREK BENSU NASI DAUN JERUK !', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `menu`
--

CREATE TABLE `menu` (
  `id_restoran` varchar(50) NOT NULL,
  `id_menu` int(11) NOT NULL,
  `restoran` varchar(100) NOT NULL,
  `menu` varchar(50) NOT NULL,
  `gambar_menu` varchar(100) NOT NULL,
  `harga_menu` int(7) NOT NULL,
  `diskon_menu` int(7) NOT NULL,
  `deskripsi_menu` text NOT NULL,
  `publish` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `menu`
--

INSERT INTO `menu` (`id_restoran`, `id_menu`, `restoran`, `menu`, `gambar_menu`, `harga_menu`, `diskon_menu`, `deskripsi_menu`, `publish`) VALUES
('gofood', 1, 'GoFood', 'Ayam Bakar', 'img\\\\restoran\\\\gofood\\\\Ayam Bakar.jpg', 17000, 23000, 'ayam bakar yg super enak ini, dimana lagi kalo bukan \r\n\\\"ayam bakar kambal\\\" da  sering diajak ma orang orang\r\ntp ga  pernah sempet, tp demi nyam-ers  akhirnya\r\ndisempatkan lah makan, and bener, ga', 1),
('gofood', 2, 'GoFood', 'PAKET GEPREK BENSU NASI DAUN JERUK !', 'img\\\\restoran\\\\gofood\\\\Ayam.jpg', 10000, 15000, 'Aroma nasi nya Harum banget, Gurih dan nikmat, Nasinya\r\naja enak bayangin di tambah ayam super pedas, makin\r\nsempurna makan siang kamu hari ini', 1),
('gofood', 3, 'GoFood', 'Blenger Burger', 'img\\\\restoran\\\\gofood\\\\Burger.jpg', 14000, 20000, 'burger gede yg super lengkap, mulai dr pattynya yang\r\nlumayan tebel, salad dan potongan  timun tomat,\r\ncheddar sliced, saus nya yg tumpeh2..\r\nLuar biasa deh sensasi makan nya.', 1),
('soleh', 12, 'Bakso Kang Soleh', 'Bakso Akan Soleh', 'img\\\\restoran\\\\soleh\\\\Bakso.jpg', 10000, 0, 'Bakso Paling Matep Sejagat raya', 1);

-- --------------------------------------------------------

--
-- Table structure for table `pesan`
--

CREATE TABLE `pesan` (
  `id` int(11) NOT NULL,
  `id_user` varchar(50) NOT NULL,
  `dari` varchar(50) NOT NULL,
  `pesan` text NOT NULL,
  `baca` tinyint(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pesan`
--

INSERT INTO `pesan` (`id`, `id_user`, `dari`, `pesan`, `baca`) VALUES
(18, 'abdul_anu1', 'Abdullah Ulwan', 'Pesanan Anda dengan kode pesanan P202065222849 telah dibayarkan oleh Abdullah Ulwan', 0),
(19, 'abdul_anu1', 'Abdullah Ulwan', 'Anda Telah Menerima saldo Rp. 100000 dari Abdullah Ulwan', 0),
(20, 'abdul_anu1', 'GoFood', 'Maaf, Pesanan Blenger Burger kami batalkan.\n Uang Sebesar Rp.14000 kami kembalikan. \n\n kode pesanan:P202065212517', 0),
(21, 'abdul_anu1', 'GoFood', 'Pesanan Ayam Bakar telah dikirim. Selamat menikmati', 0);

-- --------------------------------------------------------

--
-- Table structure for table `restoran`
--

CREATE TABLE `restoran` (
  `restoran` varchar(30) NOT NULL,
  `id_restoran` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `restoran`
--

INSERT INTO `restoran` (`restoran`, `id_restoran`, `password`) VALUES
('GoFood', 'gofood', 'gofood'),
('Bakso Kang Soleh', 'soleh', 'soleh');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `profile` varchar(150) NOT NULL,
  `alamat` text NOT NULL,
  `saldo` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `password`, `nama`, `profile`, `alamat`, `saldo`) VALUES
('abdul', '123', 'Abdullah Ulwan', 'img\\\\user\\\\abdul\\\\profile.jpg', 'Jl. Sukabumi Dalam No. 215', 9880000),
('abdul_anu1', 'abdul', 'Abdullah Nashih Ulwan', 'img\\\\user\\\\abdul_anu1\\\\profile.jpg', 'Jl. Sukabumi Dalam No 100', 129000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_pesanan`
--
ALTER TABLE `data_pesanan`
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_menu` (`id_menu`),
  ADD KEY `id_restoran` (`id_restoran`);

--
-- Indexes for table `favorite`
--
ALTER TABLE `favorite`
  ADD KEY `user` (`user`),
  ADD KEY `id_menu` (`id_menu`),
  ADD KEY `id_restoran` (`id_restoran`);

--
-- Indexes for table `menu`
--
ALTER TABLE `menu`
  ADD PRIMARY KEY (`id_menu`),
  ADD KEY `id_restoran` (`id_restoran`);

--
-- Indexes for table `pesan`
--
ALTER TABLE `pesan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_user` (`id_user`);

--
-- Indexes for table `restoran`
--
ALTER TABLE `restoran`
  ADD PRIMARY KEY (`id_restoran`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `menu`
--
ALTER TABLE `menu`
  MODIFY `id_menu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `pesan`
--
ALTER TABLE `pesan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `data_pesanan`
--
ALTER TABLE `data_pesanan`
  ADD CONSTRAINT `data_pesanan_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `data_pesanan_ibfk_2` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `data_pesanan_ibfk_4` FOREIGN KEY (`id_restoran`) REFERENCES `restoran` (`id_restoran`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `favorite`
--
ALTER TABLE `favorite`
  ADD CONSTRAINT `favorite_ibfk_2` FOREIGN KEY (`user`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `favorite_ibfk_3` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id_menu`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `favorite_ibfk_4` FOREIGN KEY (`id_restoran`) REFERENCES `restoran` (`id_restoran`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `menu`
--
ALTER TABLE `menu`
  ADD CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`id_restoran`) REFERENCES `restoran` (`id_restoran`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pesan`
--
ALTER TABLE `pesan`
  ADD CONSTRAINT `pesan_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`username`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
