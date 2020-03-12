-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-03-2020 a las 13:28:31
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.1.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `polideportivo`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades`
--

CREATE TABLE `actividades` (
  `id` int(11) NOT NULL,
  `nombre` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `fecha_inicio` date NOT NULL,
  `dias_semana` varchar(64) COLLATE utf8_unicode_ci NOT NULL,
  `horas` int(11) NOT NULL,
  `max_participantes` int(11) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `actividades`
--

INSERT INTO `actividades` (`id`, `nombre`, `fecha_inicio`, `dias_semana`, `horas`, `max_participantes`, `precio`) VALUES
(2, 'zumba', '2020-01-08', 'sabado, domingo', 16, 20, 45),
(3, 'zumba', '2020-03-02', 'bai bai', 16, 20, 45),
(4, 'spining', '2020-02-03', 'dias ias', 12, 12, 30),
(5, 'spining', '2020-02-03', 'lunes, miercoles', 8, 12, 24),
(6, 'cros fit', '2020-03-08', 'miercoles, viernes', 8, 20, 24);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripciones`
--

CREATE TABLE `inscripciones` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  `id_actividad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `inscripciones`
--

INSERT INTO `inscripciones` (`id`, `id_usuario`, `id_actividad`) VALUES
(22, 1, 6),
(23, 2, 6),
(24, 3, 6),
(25, 4, 6),
(26, 5, 6),
(31, 6, 5),
(1, 6, 6),
(32, 7, 5),
(27, 7, 6),
(33, 8, 5),
(28, 8, 6),
(34, 9, 5),
(2, 9, 6),
(35, 10, 5),
(29, 10, 6),
(30, 11, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre_apellido` varchar(32) COLLATE utf8_unicode_ci NOT NULL,
  `dni` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `codigo` varchar(8) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre_apellido`, `dni`, `codigo`) VALUES
(1, 'iker gallastegi', '11111111a', '1000'),
(2, 'iñigo rosado', '22222222a', '1001'),
(3, 'oier ugalde', '33333333a', '1002'),
(4, 'beñat bilbao', '44444444a', '1003'),
(5, 'markel rajado', '55555555a', '1004'),
(6, 'aitor gonzalez', '66666666a', '1005'),
(7, 'paul horcajada', '77777777a', '1006'),
(8, 'zigor etxebarria', '88888888a', '1007'),
(9, 'aitzol estebez', '99999999a', '1008'),
(10, 'xabier oyarzun', '10101010a', '1009'),
(11, 'andoni garcia', '12121212a', '1010'),
(12, 'oier garcia', '13131313a', '1011'),
(13, 'aritz santana', '14141414a', '1012'),
(14, 'anartz vargas', '15151515a', '1013'),
(15, 'beñat bikuña', '16161616a', '1014'),
(16, 'Eñaut Agirre', '22332233k', '2002'),
(17, 'Iker Herran', '78665544p', '8765'),
(18, 'eider eztai', '44556677h', '0987');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_usuario_2` (`id_usuario`,`id_actividad`),
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_actividad` (`id_actividad`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `dni` (`dni`),
  ADD UNIQUE KEY `codigo` (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividades`
--
ALTER TABLE `actividades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `inscripciones`
--
ALTER TABLE `inscripciones`
  ADD CONSTRAINT `inscripciones_ibfk_1` FOREIGN KEY (`id_actividad`) REFERENCES `actividades` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `inscripciones_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
