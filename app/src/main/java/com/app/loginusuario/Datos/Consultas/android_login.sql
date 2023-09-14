-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-09-2023 a las 01:05:41
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `android_login`
--
CREATE DATABASE IF NOT EXISTS `android_login` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `android_login`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `dni` varchar(255) DEFAULT NULL,
  `nombres` varchar(255) DEFAULT NULL,
  `apellidos` varchar(255) DEFAULT NULL,
  `nom_user` varchar(255) DEFAULT NULL,
  `contrasenia` varchar(255) DEFAULT NULL,
  `edad` int(11) NOT NULL,
  `correo` varchar(255) DEFAULT NULL,
  `celular` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `dni`, `nombres`, `apellidos`, `nom_user`, `contrasenia`, `edad`, `correo`, `celular`) VALUES
(1, '42604613', 'Venita', 'Sisselot', 'Venita123', '941boJW34W', 56, 'venita.sisselot@.com', '(+51) 227-848-73'),
(2, '04502956', 'Horton', 'Lamzed', 'Horton123', '261mnWB06C', 38, 'horton.lamzed@.com', '(+51) 225-530-01'),
(3, '87220582', 'Buiron', 'MacDougal', 'Buiron123', '264mqSL27R', 59, 'buiron.macdougal@.com', '(+51) 046-361-00'),
(4, '83219669', 'Katti', 'Lanney', 'Katti123', '752lpGY34T', 44, 'katti.lanney@.com', '(+51) 326-303-89'),
(5, '83520017', 'Nicolette', 'Huxter', 'Nicolette123', '177qmKF76O', 33, 'nicolette.huxter@.com', '(+51) 369-151-31'),
(6, '54435949', 'Cyrillus', 'Simonyi', 'Cyrillus123', '047lfKV56R', 22, 'cyrillus.simonyi@.com', '(+51) 684-847-16'),
(7, '50285998', 'Leonerd', 'Banker', 'Leonerd123', '239ykAR93F', 44, 'leonerd.banker@.com', '(+51) 065-832-16'),
(8, '55758523', 'Dynah', 'Bryce', 'Dynah123', '129ojRI33L', 45, 'dynah.bryce@.com', '(+51) 330-570-46'),
(9, '28549993', 'Karrie', 'Fonzo', 'Karrie123', '840pkJD39E', 50, 'karrie.fonzo@.com', '(+51) 723-340-47'),
(10, '38999689', 'Jeremy', 'Merryweather', 'Jeremy123', '974vdRG71L', 33, 'jeremy.merryweather@.com', '(+51) 714-563-16'),
(11, '07354457', 'Sydney', 'Purves', 'Sydney123', '302vtCF64E', 51, 'sydney.purves@.com', '(+51) 478-040-05'),
(12, '82304455', 'Charmain', 'McCrainor', 'Charmain123', '362nuVG91Q', 42, 'charmain.mccrainor@.com', '(+51) 261-895-70'),
(13, '69624339', 'Hilario', 'Lawlance', 'Hilario123', '270roGH64E', 58, 'hilario.lawlance@.com', '(+51) 436-858-29'),
(14, '41243530', 'Grethel', 'Barracks', 'Grethel123', '017gmQZ57S', 57, 'grethel.barracks@.com', '(+51) 694-771-87'),
(15, '82729222', 'Tobiah', 'Pimlott', 'Tobiah123', '495vnRZ93X', 57, 'tobiah.pimlott@.com', '(+51) 707-610-45'),
(16, '96064820', 'Dorree', 'Huc', 'Dorree123', '879jyUZ97D', 17, 'dorree.huc@.com', '(+51) 229-986-94'),
(17, '02591326', 'Wayland', 'Wapples', 'Wayland123', '737ltSP61H', 32, 'wayland.wapples@.com', '(+51) 303-339-33'),
(18, '93481907', 'Buckie', 'O\'Grady', 'Buckie123', '127xeHU21I', 13, 'buckie.o\'grady@.com', '(+51) 681-288-34'),
(19, '77156269', 'Agnes', 'Lupton', 'Agnes123', '152uzXC79Q', 58, 'agnes.lupton@.com', '(+51) 717-425-35'),
(20, '81173465', 'Trude', 'Aloshikin', 'Trude123', '436ugWL84H', 16, 'trude.aloshikin@.com', '(+51) 700-604-95'),
(21, '19866493', 'Poppy', 'O\'Reagan', 'Poppy123', '242ziEL50W', 24, 'poppy.o\'reagan@.com', '(+51) 994-058-90'),
(22, '10826357', 'Dene', 'Munsey', 'Dene123', '073jkVR91N', 30, 'dene.munsey@.com', '(+51) 053-113-99'),
(23, '01103696', 'Lek', 'Pennick', 'Lek123', '485rtMQ37A', 25, 'lek.pennick@.com', '(+51) 647-181-23'),
(24, '81873580', 'Elmer', 'Hackwell', 'Elmer123', '791niXM04V', 24, 'elmer.hackwell@.com', '(+51) 783-353-73'),
(25, '46733164', 'Arman', 'Bauer', 'Arman123', '713ofHX96G', 60, 'arman.bauer@.com', '(+51) 026-872-46'),
(26, '90180250', 'Roseanna', 'Quadri', 'Roseanna123', '061spBR87W', 25, 'roseanna.quadri@.com', '(+51) 158-305-63'),
(27, '59130648', 'Tulley', 'Linzee', 'Tulley123', '449fhQJ53J', 33, 'tulley.linzee@.com', '(+51) 638-086-37'),
(28, '76621907', 'Meryl', 'Allison', 'Meryl123', '750yiPG44D', 45, 'meryl.allison@.com', '(+51) 891-702-18'),
(29, '53523951', 'Kariotta', 'Thay', 'Kariotta123', '380wcRC71L', 25, 'kariotta.thay@.com', '(+51) 191-662-26'),
(30, '60423866', 'Ignace', 'Cavnor', 'Ignace123', '108jzKD24K', 14, 'ignace.cavnor@.com', '(+51) 265-736-28'),
(31, '01049689', 'Bret', 'Beaby', 'Bret123', '021yfHS45D', 18, 'bret.beaby@.com', '(+51) 562-464-18'),
(32, '13142098', 'Abbott', 'Fawdrey', 'Abbott123', '991hfST77I', 12, 'abbott.fawdrey@.com', '(+51) 050-550-49'),
(33, '52277425', 'Ambrosius', 'Tithecote', 'Ambrosius123', '979nmNH97I', 44, 'ambrosius.tithecote@.com', '(+51) 512-157-01'),
(34, '48985393', 'Abelard', 'Goldie', 'Abelard123', '245ejHW23D', 22, 'abelard.goldie@.com', '(+51) 235-020-05'),
(35, '72771822', 'Perri', 'Basey', 'Perri123', '219jhIS46B', 42, 'perri.basey@.com', '(+51) 318-112-79'),
(36, '76631934', 'Waiter', 'Cocks', 'Waiter123', '008xvTK92T', 14, 'waiter.cocks@.com', '(+51) 413-342-18'),
(37, '60734713', 'Andrea', 'Cannop', 'Andrea123', '709ogDN03K', 57, 'andrea.cannop@.com', '(+51) 050-066-77'),
(38, '60267725', 'Adolf', 'Hicklingbottom', 'Adolf123', '737vxEK26I', 12, 'adolf.hicklingbottom@.com', '(+51) 738-244-03'),
(39, '55274310', 'Steven', 'Cowlas', 'Steven123', '488aiAW42H', 29, 'steven.cowlas@.com', '(+51) 062-225-56'),
(40, '94023444', 'Lind', 'Feldbrin', 'Lind123', '018qdAX80U', 21, 'lind.feldbrin@.com', '(+51) 243-856-82'),
(41, '57098706', 'Vinni', 'Janos', 'Vinni123', '406geVS47E', 44, 'vinni.janos@.com', '(+51) 223-703-41'),
(42, '19471313', 'Rowney', 'Obispo', 'Rowney123', '680csDO71V', 52, 'rowney.obispo@.com', '(+51) 476-285-00'),
(43, '68622778', 'Tadeas', 'Neilan', 'Tadeas123', '094ccAD35E', 43, 'tadeas.neilan@.com', '(+51) 457-397-40'),
(44, '34857555', 'Gail', 'Fitzsymons', 'Gail123', '954mfXM34E', 25, 'gail.fitzsymons@.com', '(+51) 083-312-11'),
(45, '77281308', 'Quincy', 'Florez', 'Quincy123', '283pcBZ51R', 43, 'quincy.florez@.com', '(+51) 165-650-77'),
(46, '23413319', 'Cherin', 'McKelvie', 'Cherin123', '632yzYJ52N', 20, 'cherin.mckelvie@.com', '(+51) 799-665-77'),
(47, '55283697', 'Ferrel', 'Duffill', 'Ferrel123', '639iwYV28O', 33, 'ferrel.duffill@.com', '(+51) 564-302-83'),
(48, '14374183', 'Loralyn', 'Garrow', 'Loralyn123', '761ywBV43H', 15, 'loralyn.garrow@.com', '(+51) 562-890-50'),
(49, '94681663', 'Margo', 'Hellin', 'Margo123', '406plOC64X', 30, 'margo.hellin@.com', '(+51) 125-142-12'),
(50, '10739595', 'Lawry', 'Crossland', 'Lawry123', '171rsBU61Y', 56, 'lawry.crossland@.com', '(+51) 924-451-46'),
(51, "123L", 'Eliot', 'Arias', 'Fortaleza', '123456', 21, 'asds@asd.com', '959596552'),
(53, "NU12LL", 'Eliot', 'Arias', 'Fortaleza1', '123456', 21, 'asds@asd.com', '959596552'),
(54, "NULL", 'Eliot', 'Arias', 'Fortaleza13', '123456', 21, 'asds@asd.com', '959596552'),
(55, '74996280', 'Eliot', 'Arias', 'Fortaleza131', '123456', 21, 'asds@asd.com', '959596552'),
(56, '74996280', 'Abel', 'Huacarpuma', 'Abl1234', '123456', 21, 'asds@asd.com', '959596552');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `nom_user` (`nom_user`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
