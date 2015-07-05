-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 05-06-2012 a las 02:02:48
-- Versión del servidor: 5.5.8
-- Versión de PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `inmobiliaria`
--
CREATE DATABASE `inmobiliaria` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci;
USE `inmobiliaria`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `barrios`
--

CREATE TABLE IF NOT EXISTS `barrios` (
  `barrio` int(4) NOT NULL,
  `nombre` varchar(40) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`barrio`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcar la base de datos para la tabla `barrios`
--

INSERT INTO `barrios` (`barrio`, `nombre`) VALUES
(101, 'CENTRO'),
(102, 'OBSERVATORIO'),
(103, 'JARDIN'),
(104, 'ALTO ALBERDI'),
(105, 'NUEVA CORDOBA'),
(106, 'IES21');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inmuebles`
--

CREATE TABLE IF NOT EXISTS `inmuebles` (
  `inmueble` int(4) NOT NULL,
  `domicilio` varchar(40) COLLATE latin1_general_ci NOT NULL,
  `tipo` varchar(1) COLLATE latin1_general_ci NOT NULL,
  `situacion` varchar(1) COLLATE latin1_general_ci NOT NULL,
  `propietario` int(4) NOT NULL,
  `barrio` int(4) NOT NULL,
  `importe` decimal(9,2) NOT NULL,
  PRIMARY KEY (`inmueble`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcar la base de datos para la tabla `inmuebles`
--

INSERT INTO `inmuebles` (`inmueble`, `domicilio`, `tipo`, `situacion`, `propietario`, `barrio`, `importe`) VALUES
(11, 'LAPRIDA 490', 'C', 'V', 1005, 101, 50000.00),
(12, 'CHILE 1480', 'C', 'V', 1005, 101, 93000.00),
(13, 'SOL DE MAYO 2489', 'C', 'A', 1004, 102, 650.00),
(14, 'SARMIENTO 3604', 'C', 'A', 1004, 102, 470.00),
(15, 'INDEPENDENCIA 1181', 'D', 'V', 1003, 103, 48000.00),
(16, 'JUJUY 74', 'D', 'V', 1003, 103, 63000.00),
(17, 'CHACO 389', 'D', 'A', 1002, 104, 350.00),
(18, 'COLON 4075', 'D', 'A', 1002, 104, 710.00),
(19, 'CHUBUT 508', 'L', 'V', 1001, 105, 39000.00),
(20, 'RESISTENCIA 5021', 'L', 'V', 1001, 105, 75000.00),
(21, 'OLMOS 691', 'L', 'A', 1005, 101, 1400.00),
(22, 'DEAN FUNES 2705', 'L', 'A', 1005, 101, 1200.00),
(23, 'SANTIAGO DEL ESTERO 914', 'C', 'V', 1004, 102, 84000.00),
(24, 'CASTRO BARROS 691', 'C', 'A', 1004, 102, 890.00),
(25, 'CASTRO BARROS 1745', 'D', 'V', 1003, 103, 61000.00),
(26, 'CASEROS 3452', 'D', 'A', 1003, 103, 575.00),
(27, 'FLORIDA 2489', 'L', 'V', 1002, 104, 81000.00),
(28, 'PUEYRREDON 5001', 'L', 'A', 1002, 104, 2400.00),
(29, 'SAN MARTIN 4501', 'C', 'V', 1001, 105, 123000.00),
(30, 'TINOGASTA 2697', 'C', 'A', 1001, 105, 745.00),
(31, 'GENERAL PAZ', 'C', 'V', 1001, 101, 280000.00),
(32, 'ROSALES 1141', 'D', 'V', 1002, 102, 150000.00),
(33, 'ROSALES 3698', 'L', 'V', 1003, 103, 64700.00),
(34, 'AGUSTIN GARZON 1647', 'C', 'A', 1004, 104, 585.00),
(35, 'JAVIER LUQUE 272', 'D', 'A', 1005, 105, 621.00),
(36, 'PADRE LOZANO 3399', 'L', 'A', 1001, 101, 1325.00),
(37, 'RONDEAU 111', 'C', 'V', 1006, 106, 91000.00),
(38, 'RONDEAU 222', 'D', 'V', 1006, 106, 92000.00),
(39, 'RONDEAU 333', 'L', 'V', 1006, 106, 93000.00),
(40, 'RONDEAU 444', 'C', 'A', 1006, 106, 910.00),
(41, 'RONDEAU 555', 'D', 'A', 1006, 106, 920.00),
(42, 'RONDEAU 666', 'L', 'A', 1006, 106, 930.00);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietarios`
--

CREATE TABLE IF NOT EXISTS `propietarios` (
  `propietario` int(4) NOT NULL,
  `nombre` varchar(40) COLLATE latin1_general_ci NOT NULL,
  `telefono` varchar(20) COLLATE latin1_general_ci NOT NULL,
  PRIMARY KEY (`propietario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci;

--
-- Volcar la base de datos para la tabla `propietarios`
--

INSERT INTO `propietarios` (`propietario`, `nombre`, `telefono`) VALUES
(1001, 'PEREZ CARLOS', '4880101'),
(1002, 'LOCICERO OSCAR', '4336602'),
(1003, 'PAEZ SILVIA', '4557703'),
(1004, 'FERNANDEZ CAROLINA', '4919104'),
(1005, 'BENITEZ PEDRO', '4718205'),
(1006, 'CARRIZO MIGUEL', '4010203');
