-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 12-03-2019 a las 22:43:18
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `empleados`
--
CREATE DATABASE IF NOT EXISTS `empleados` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `empleados`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `banco`
--

CREATE TABLE `banco` (
  `codigoBanco` int(11) NOT NULL,
  `nombreBanco` varchar(50) NOT NULL,
  `CuentaBanco` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `concepto`
--

CREATE TABLE `concepto` (
  `codigoConcepto` int(11) NOT NULL,
  `nombreConcepto` varchar(50) NOT NULL,
  `efecto_concepto` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departamentos`
--

CREATE TABLE `departamentos` (
  `depCodigo` int(11) NOT NULL,
  `depNombre` varchar(50) NOT NULL,
  `depStatus` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--

CREATE TABLE `detalle` (
  `CodigoNomina` int(11) NOT NULL,
  `codigoEmp` int(11) NOT NULL,
  `codigoConcepto` int(11) NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `emp_codigo` int(11) NOT NULL,
  `nombre_emp` varchar(50) NOT NULL,
  `NIT_emp` varchar(20) NOT NULL,
  `direccion_emp` varchar(50) NOT NULL,
  `sueldo_nominal` double NOT NULL,
  `empStatus` varchar(1) NOT NULL,
  `departamento_depCodigo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `emp_codigo` int(11) NOT NULL,
  `nombre_emp` varchar(20) NOT NULL,
  `NIT_emp` varchar(20) NOT NULL,
  `direccion_emp` varchar(30) NOT NULL,
  `sueldo_nominal` double NOT NULL,
  `empStatus` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nominaencabezada`
--

CREATE TABLE `nominaencabezada` (
  `codNomina` int(11) NOT NULL,
  `montoNomina` double DEFAULT NULL,
  `banco_codigoBanco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `Nombre_Usurio` varchar(60) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `Contraseña` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`Nombre_Usurio`, `Contraseña`) VALUES
('Ester', '5495');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `banco`
--
ALTER TABLE `banco`
  ADD PRIMARY KEY (`codigoBanco`);

--
-- Indices de la tabla `departamentos`
--
ALTER TABLE `departamentos`
  ADD PRIMARY KEY (`depCodigo`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`emp_codigo`,`empStatus`),
  ADD KEY `fk_deptoEmpleados` (`departamento_depCodigo`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`emp_codigo`,`empStatus`);

--
-- Indices de la tabla `nominaencabezada`
--
ALTER TABLE `nominaencabezada`
  ADD PRIMARY KEY (`codNomina`),
  ADD KEY `fk_codigoBanco` (`banco_codigoBanco`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `fk_deptoEmpleados` FOREIGN KEY (`departamento_depCodigo`) REFERENCES `departamentos` (`depCodigo`);

--
-- Filtros para la tabla `nominaencabezada`
--
ALTER TABLE `nominaencabezada`
  ADD CONSTRAINT `fk_codigoBanco` FOREIGN KEY (`banco_codigoBanco`) REFERENCES `banco` (`codigoBanco`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
