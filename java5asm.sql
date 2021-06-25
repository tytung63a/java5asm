-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th6 25, 2021 lúc 02:04 AM
-- Phiên bản máy phục vụ: 10.4.18-MariaDB
-- Phiên bản PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `java5asm`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `accounts`
--

CREATE TABLE `accounts` (
  `username` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `activated` bit(1) DEFAULT NULL,
  `admin` bit(1) DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fullname` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `photo` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `accounts`
--

INSERT INTO `accounts` (`username`, `activated`, `admin`, `email`, `fullname`, `password`, `photo`) VALUES
('admin', b'1', b'1', 'admin@gmail.com', 'admin', 'admin', '1.jpeg'),
('danthuong', b'1', b'0', 'anhvippro@gmail.com', 'anhvippro', 'danthuong', '4.jpeg'),
('giangtran', b'1', b'1', 'giangtran20052001@gmail.com', 'giangtran', 'giangtran', '5.png'),
('idoltungson', b'0', b'0', 'tytung63a@gmail.com', 'Phạm Bách Tùng', 'zxczxc', '4.jpeg'),
('nguoidung', b'0', b'0', 'iamminhducbachtung@gmail.com', 'nguoidung', 'nguoidung', '8.jpg'),
('sondeptrai', b'1', b'1', 'sondeptrai@gmail.com', 'Bùi Văn Sơn', 'sondeptrai', '4.jpeg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `categories`
--

CREATE TABLE `categories` (
  `id` int(11) NOT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `categories`
--

INSERT INTO `categories` (`id`, `description`, `name`) VALUES
(25, 'Áo Mùa Đẹp', 'Áo T Shirt'),
(28, 'Mũ Lưỡi Em EM', 'Mũ Đẹp'),
(29, 'Vớ Dài', 'Vớ Tất'),
(30, 'Thể Thao', 'Adidas'),
(31, 'Nike OF Vip', 'Nike Vip'),
(32, 'Kính', 'Chorme Heart'),
(33, 'Dép Bioline', 'Bioline'),
(35, 'mnbvcxzpoiuytrewq', 'mnbvcxzpoiuytrewq'),
(36, 'a', 'Danh Mục Mới');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orderdetails`
--

CREATE TABLE `orderdetails` (
  `id` bigint(20) NOT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `createdate` date DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `available` int(11) DEFAULT NULL,
  `createdate` date DEFAULT current_timestamp(),
  `image` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `products`
--

INSERT INTO `products` (`id`, `available`, `createdate`, `image`, `name`, `price`, `quantity`, `category_id`) VALUES
(20, 1, '2021-06-21', '5.png', 'Người Kẻ', 1000, 11, 25),
(21, 1, '2021-06-23', '2.jpg', 'Người Đeo Túi', 1000, 5, 29),
(23, 1, '2021-06-15', '2.jpg', 'Người Cafe', 1, 0, 29),
(24, 1, '2021-06-20', '8.jpg', 'Dep Trai hehe', 1000, 11, 32),
(25, 1, '2021-06-15', '2.jpg', 'Người Cafe', 1, 1, 29),
(27, 1, '2021-06-16', '2.jpg', 'Người Đeo Túi', 1000, 19, 28),
(28, 1, '2021-06-20', '8.jpg', 'Dep ngu', 1000, 11, 32),
(29, 1, '2021-06-20', '8.jpg', 'Dep', 1000, 11, 32),
(31, 1, '2021-06-21', '7.jpg', 'Anh Test', 200, 1, 32),
(45, 1, '2021-06-21', '7.jpg', '12ANhVIP', 123, 1, 25),
(48, 1, '2021-06-21', '5.png', '12313123', 1, 1, 32),
(49, 1, '2021-06-23', '33.jpg', 'Sản Phẩm Mới', 1, 1, 33);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`username`);

--
-- Chỉ mục cho bảng `categories`
--
ALTER TABLE `categories`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKhnsosbuy7bhpqpnt3bjr7sh8x` (`order_id`),
  ADD KEY `FK92im1bt9gndrexccag7x5oq92` (`product_id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKk3cjfcgb621qhahps1tre43e4` (`username`);

--
-- Chỉ mục cho bảng `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKog2rp4qthbtt2lfyhfo32lsw9` (`category_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `categories`
--
ALTER TABLE `categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- AUTO_INCREMENT cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `FK92im1bt9gndrexccag7x5oq92` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `FKhnsosbuy7bhpqpnt3bjr7sh8x` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `FKk3cjfcgb621qhahps1tre43e4` FOREIGN KEY (`username`) REFERENCES `accounts` (`username`);

--
-- Các ràng buộc cho bảng `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `FKog2rp4qthbtt2lfyhfo32lsw9` FOREIGN KEY (`category_id`) REFERENCES `categories` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
