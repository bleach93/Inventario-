-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Aug 20, 2020 at 04:26 PM
-- Server version: 5.7.28
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `inventario`
--

DELIMITER $$
--
-- Procedures
--
DROP PROCEDURE IF EXISTS `sp_buscar_recibos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_buscar_recibos` (IN `id` INT)  BEGIN
select * from recibos where idRecibos = id;
END$$

DROP PROCEDURE IF EXISTS `sp_disminuir_stock`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_disminuir_stock` (IN `idprod` VARCHAR(45), IN `st` INT)  BEGIN
UPDATE almacen SET stock = stock - st where almacen = idprod;
END$$

DROP PROCEDURE IF EXISTS `sp_editar_departamentos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_departamentos` (IN `id` INT, `nombre` VARCHAR(45))  begin
update departamento set nombre = nombre where idDepartamento = id;
end$$

DROP PROCEDURE IF EXISTS `sp_editar_proveedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_proveedores` (IN `id` INT, IN `nom` VARCHAR(45), IN `tel` VARCHAR(45), IN `dom` VARCHAR(45))  begin
update proveedores set nombre = nom, telefono = tel, domicilio = dom where idProveedores = id;
end$$

DROP PROCEDURE IF EXISTS `sp_editar_usuarios`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_editar_usuarios` (IN `id` INT, IN `nom` VARCHAR(45), IN `us` VARCHAR(45), IN `pass` VARCHAR(45), IN `per` VARCHAR(45))  begin
update Usuarios set nombre = nom, usuario = us, clave = pass, perfil = per where idUsuarios = id;
end$$

DROP PROCEDURE IF EXISTS `sp_eliminar_departamentos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_departamentos` (IN `id` INT)  begin
delete from departamentos where IdDepartamento = id;
end$$

DROP PROCEDURE IF EXISTS `sp_eliminar_proveedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_proveedores` (IN `id` INT)  begin
delete from proveedores where idProveedores = id;
end$$

DROP PROCEDURE IF EXISTS `sp_eliminar_usuarios`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_eliminar_usuarios` (IN `id` INT)  begin
delete from Usuarios where idUsuarios = id;
end$$

DROP PROCEDURE IF EXISTS `sp_insertar_departamentos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_departamentos` (IN `nombre` VARCHAR(45))  begin
insert into departamento (nombre) values (nombre);
end$$

DROP PROCEDURE IF EXISTS `sp_insertar_detallefacturas`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_detallefacturas` (IN `idfact` INT, IN `idprod` VARCHAR(45), IN `cant` INT, IN `tot` DECIMAL(10,2))  BEGIN
INSERT INTO detallefacturas (Facturasid, Materialesid, cantidad, total) VALUES (idfact, idprod, cant, tot);
END$$

DROP PROCEDURE IF EXISTS `sp_insertar_detallerecibo`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_detallerecibo` (IN `recibid` INT, IN `prodid` VARCHAR(45), IN `iddep` INT, IN `cant` INT, IN `tot` DECIMAL(18,2))  BEGIN
insert into detallerecibos (RecibosId, Materialesid, Departamentoid, cantidad, total) values (recibid,prodid,iddep,cant,tot);
END$$

DROP PROCEDURE IF EXISTS `sp_insertar_facturas`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_facturas` (IN `iddepartamento` INT, IN `idprov` INT, IN `fecha` DATE, OUT `idfac` INT)  begin
insert into facturas (Departamentoid, Proveedoresid, fecha) values (iddepartamento, idprov, fecha);
set idfac = @@identity;
end$$

DROP PROCEDURE IF EXISTS `sp_insertar_productos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_productos` (IN `idprod` VARCHAR(45), IN `iddep` INT, IN `descrip` VARCHAR(45), IN `st` INT, IN `punit` DECIMAL(10,2), IN `umed` VARCHAR(45))  begin
  IF EXISTS (select * from almacen where IdAlmacen = idprod) THEN
    update almacen set stock = stock + st where IdAlmacen = idprod;
  ELSE 
    INSERT INTO almacen (IdAlmacen, Departamentoid, descripcion, punitario, stock, umedida) VALUES (idprod, iddep, descrip, punit, st, umed);
  END IF;
end$$

DROP PROCEDURE IF EXISTS `sp_insertar_proveedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_proveedores` (IN `nom` VARCHAR(45), IN `tel` VARCHAR(45), IN `dom` VARCHAR(45))  insert into proveedores(nombre, telefono, domicilio) values (nom, tel, dom)$$

DROP PROCEDURE IF EXISTS `sp_insertar_recibos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_recibos` (IN `fecha` DATE, IN `personae` VARCHAR(45), IN `personar` VARCHAR(45), OUT `idrec` INT)  BEGIN
insert into recibos (FechaSalida, PersonaEntrega, PersonaRecibe) values (fecha, personae, personar);
set idrec = @@identity;
END$$

DROP PROCEDURE IF EXISTS `sp_insertar_usuarios`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insertar_usuarios` (IN `nom` VARCHAR(45), IN `us` VARCHAR(45), IN `pass` VARCHAR(45), IN `per` VARCHAR(45))  begin
insert into Usuarios (nombre, usuario, clave, perfil) values (nom, us, pass, per);
end$$

DROP PROCEDURE IF EXISTS `sp_insert_proveedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_insert_proveedores` (IN `nom` VARCHAR(45), IN `tel` VARCHAR(45), IN `dom` VARCHAR(45))  begin
insert into proveedores (nombre, telefono, domicilio) values (nom, tel, dom);
end$$

DROP PROCEDURE IF EXISTS `sp_mostrarbuscar_departamentos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrarbuscar_departamentos` (IN `nombre` VARCHAR(45))  begin
select * from departamento where nombre LIKE CONCAT('%',nombre,'%');
end$$

DROP PROCEDURE IF EXISTS `sp_mostrarbuscar_productos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrarbuscar_productos` (IN `prod` VARCHAR(45))  begin
select * from almacen where IdAlmacen LIKE CONCAT('%', prod, '%');
end$$

DROP PROCEDURE IF EXISTS `sp_mostrarbuscar_proveedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrarbuscar_proveedores` (IN `nom` VARCHAR(45))  begin 
select * from proveedores where nombre like concat('%',nom,'%');
end$$

DROP PROCEDURE IF EXISTS `sp_mostrarbuscar_usuarios`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrarbuscar_usuarios` (IN `us` VARCHAR(45))  select * from usuario where usuarios like concat('%',us,'%')$$

DROP PROCEDURE IF EXISTS `sp_mostrardetalleFacturas`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrardetalleFacturas` (IN `id` INT)  BEGIN
SELECT d.Materialesid, p.descripcion, d.cantidad, p.umedida, p.punitario, d.total FROM detallefacturas d INNER JOIN almacen p ON p.IdAlmacen = d.Materialesid WHERE Facturasid = id;
END$$

DROP PROCEDURE IF EXISTS `sp_mostrardetallerecibos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrardetallerecibos` (IN `id` INT)  BEGIN
SELECT d.Materialesid, p.descripcion, d.cantidad, p.umedida , p.punitario, l.nombre, d.Total FROM detallerecibos d INNER JOIN almacen p ON p.IdAlmacen = d.Materialesid INNER JOIN departamento l ON l.IdDepartamento = d.Departamentoid WHERE Recibosid = id;
END$$

DROP PROCEDURE IF EXISTS `sp_mostrar_almacen`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrar_almacen` (IN `prod` VARCHAR(45))  BEGIN
SELECT a.IdAlmacen, a.descripcion, a.stock, a.umedida, a.punitario, (a.stock*a.punitario) AS Total,l.nombre FROM almacen a INNER JOIN departamento l ON a.Departamentoid = l.IdDepartamento
WHERE a.IdAlmacen LIKE concat('%',prod,'%');
END$$

DROP PROCEDURE IF EXISTS `sp_mostrar_facturas`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrar_facturas` ()  BEGIN
SELECT f.IdFacturas, p.nombre, l.nombre, f.fecha FROM facturas f INNER JOIN proveedores p ON f.Proveedoresid = p.idProveedores INNER JOIN departamento l ON f.Departamentoid = l.IdDepartamento;
END$$

DROP PROCEDURE IF EXISTS `sp_mostrar_productosrecibos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrar_productosrecibos` (IN `idprod` VARCHAR(45))  BEGIN
SELECT a.IdAlmacen, a.descripcion, a.umedida, a.punitario, l.nombre FROM almacen a INNER JOIN departamento l ON a.Departamentoid = l.IdDepartamento
WHERE a.IdAlmacen LIKE concat('%',idprod,'%');
END$$

DROP PROCEDURE IF EXISTS `sp_mostrar_recibos`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrar_recibos` ()  BEGIN
select * from recibos;
END$$

DROP PROCEDURE IF EXISTS `sp_mostrar_usuarios`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_mostrar_usuarios` (IN `us` VARCHAR(45))  select idUsuarios, nombre,usuario, clave, perfil from usuarios$$

DROP PROCEDURE IF EXISTS `sp_show_usuarios`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_show_usuarios` (IN `us` VARCHAR(45))  begin
select * from usuarios where usuario LIKE CONCAT('%',us,'%');
end$$

DROP PROCEDURE IF EXISTS `sp_sho_usuarios`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_sho_usuarios` (IN `us` VARCHAR(45))  begin
select * from usuarios;
end$$

DROP PROCEDURE IF EXISTS `sp_s_proveedores`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_s_proveedores` (IN `nom` VARCHAR(45))  begin
select * from tblProveedores where Nombre LIKE CONCAT('%',nom,'%');
end$$

DROP PROCEDURE IF EXISTS `sp_s_usuarios`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_s_usuarios` (IN `us` VARCHAR(45))  begin
select * from usuarios where usuario LIKE CONCAT('%',us,'%');
end$$

DROP PROCEDURE IF EXISTS `sp_validar_usuario`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_validar_usuario` (IN `us` VARCHAR(45), IN `pass` VARCHAR(45))  begin
select * from usuarios where usuario = us and clave = pass;
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `almacen`
--

DROP TABLE IF EXISTS `almacen`;
CREATE TABLE IF NOT EXISTS `almacen` (
  `IdAlmacen` varchar(45) NOT NULL,
  `Departamentoid` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `stock` int(11) NOT NULL,
  `umedida` varchar(45) NOT NULL,
  `punitario` decimal(10,2) NOT NULL,
  PRIMARY KEY (`IdAlmacen`),
  KEY `Depid` (`Departamentoid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `almacen`
--

INSERT INTO `almacen` (`IdAlmacen`, `Departamentoid`, `descripcion`, `stock`, `umedida`, `punitario`) VALUES
('1', 2, 'PRUEBA', 1, '1', '1.00');

-- --------------------------------------------------------

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
CREATE TABLE IF NOT EXISTS `departamento` (
  `IdDepartamento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`IdDepartamento`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `departamento`
--

INSERT INTO `departamento` (`IdDepartamento`, `nombre`) VALUES
(1, 'Papeleria'),
(2, 'Abarrotes'),
(3, 'Abarrotes');

-- --------------------------------------------------------

--
-- Table structure for table `detallefacturas`
--

DROP TABLE IF EXISTS `detallefacturas`;
CREATE TABLE IF NOT EXISTS `detallefacturas` (
  `IdDetalleFacturas` int(11) NOT NULL AUTO_INCREMENT,
  `Facturasid` int(11) NOT NULL,
  `Materialesid` varchar(45) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`IdDetalleFacturas`),
  KEY `tbldetallefactura_ibfk_1` (`Facturasid`),
  KEY `tbldetallefactura_ibfk_2` (`Materialesid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detallefacturas`
--

INSERT INTO `detallefacturas` (`IdDetalleFacturas`, `Facturasid`, `Materialesid`, `cantidad`, `total`) VALUES
(1, 39, '1', 14, '144.00');

-- --------------------------------------------------------

--
-- Table structure for table `detallerecibos`
--

DROP TABLE IF EXISTS `detallerecibos`;
CREATE TABLE IF NOT EXISTS `detallerecibos` (
  `idDetalleRecibos` int(11) NOT NULL AUTO_INCREMENT,
  `Recibosid` int(11) NOT NULL,
  `Materialesid` varchar(45) NOT NULL,
  `Departamentoid` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  PRIMARY KEY (`idDetalleRecibos`),
  KEY `tbldetrecibos_ibfk_1` (`Recibosid`),
  KEY `tbldetrecibos_ibfk_2` (`Departamentoid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
CREATE TABLE IF NOT EXISTS `facturas` (
  `idFacturas` int(11) NOT NULL AUTO_INCREMENT,
  `Proveedoresid` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `Departamentoid` int(11) NOT NULL,
  PRIMARY KEY (`idFacturas`),
  KEY `Proveedoresid` (`Proveedoresid`),
  KEY `tblfacturas_ibfk_1` (`Departamentoid`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `facturas`
--

INSERT INTO `facturas` (`idFacturas`, `Proveedoresid`, `fecha`, `Departamentoid`) VALUES
(37, 5, '2020-08-04', 3),
(38, 5, '2020-08-10', 2),
(39, 5, '2020-08-03', 2),
(40, 6, '2020-08-03', 3),
(41, 5, '2020-08-03', 3);

-- --------------------------------------------------------

--
-- Table structure for table `proveedores`
--

DROP TABLE IF EXISTS `proveedores`;
CREATE TABLE IF NOT EXISTS `proveedores` (
  `idProveedores` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `domicilio` varchar(45) NOT NULL,
  PRIMARY KEY (`idProveedores`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proveedores`
--

INSERT INTO `proveedores` (`idProveedores`, `nombre`, `telefono`, `domicilio`) VALUES
(3, 'proveedo', '2182718', 'djcfdjkfds'),
(4, 'proveedor11', '9122927', 'calle 10'),
(5, 'coca cola', '6691969394', 'mazatlan'),
(6, 'coca cola', '1827728728', 'mazatlan');

-- --------------------------------------------------------

--
-- Table structure for table `recibos`
--

DROP TABLE IF EXISTS `recibos`;
CREATE TABLE IF NOT EXISTS `recibos` (
  `IdRecibos` int(11) NOT NULL AUTO_INCREMENT,
  `FechaSalida` date NOT NULL,
  `PersonaRecibe` varchar(45) NOT NULL,
  `PersonaEntrega` varchar(45) NOT NULL,
  PRIMARY KEY (`IdRecibos`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `recibos`
--

INSERT INTO `recibos` (`IdRecibos`, `FechaSalida`, `PersonaRecibe`, `PersonaEntrega`) VALUES
(1, '2020-08-18', 'Eduardo', ''),
(2, '2020-08-18', 'Eduardo', ''),
(3, '2020-08-04', 'Eduardo', ''),
(4, '2020-08-04', 'Eduardo', ''),
(5, '2020-08-04', 'Eduardo', ''),
(6, '2020-08-10', 'EDUARDO', ''),
(7, '2020-08-10', 'EDUARDO', ''),
(8, '2020-08-04', 'Eduardo', ''),
(9, '2020-08-11', 'EDUARDO', ''),
(10, '2020-08-11', 'EDUARDO', ''),
(11, '2020-08-11', 'EDUARDO', ''),
(12, '2020-08-11', 'EDUARDO', ''),
(13, '2020-08-11', 'EDUARDO', '');

-- --------------------------------------------------------

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `idUsuarios` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `perfil` varchar(45) NOT NULL,
  PRIMARY KEY (`idUsuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuarios`
--

INSERT INTO `usuarios` (`idUsuarios`, `nombre`, `usuario`, `clave`, `perfil`) VALUES
(1, 'r', 'root', 'root', 'Administrador'),
(2, 'ed', 'eduardo', '123', 'Administrador'),
(3, 'felipe', 'felipe', '123', 'Administrador'),
(4, 'jj', 'jjj', 'jj', 'Empleado'),
(5, 'Jose', 'jose', '123', 'Empleado'),
(6, 'Eduardo', 'eduardooo', '123', 'Empleado'),
(7, 'juan', 'juan', '123', 'Empleado');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `almacen`
--
ALTER TABLE `almacen`
  ADD CONSTRAINT `Depid` FOREIGN KEY (`Departamentoid`) REFERENCES `departamento` (`IdDepartamento`);

--
-- Constraints for table `detallefacturas`
--
ALTER TABLE `detallefacturas`
  ADD CONSTRAINT `tbldetallefactura_ibfk_1` FOREIGN KEY (`Facturasid`) REFERENCES `facturas` (`idFacturas`),
  ADD CONSTRAINT `tbldetallefactura_ibfk_2` FOREIGN KEY (`Materialesid`) REFERENCES `almacen` (`IdAlmacen`);

--
-- Constraints for table `detallerecibos`
--
ALTER TABLE `detallerecibos`
  ADD CONSTRAINT `tbldetrecibos_ibfk_1` FOREIGN KEY (`Recibosid`) REFERENCES `recibos` (`idRecibos`),
  ADD CONSTRAINT `tbldetrecibos_ibfk_2` FOREIGN KEY (`Departamentoid`) REFERENCES `departamento` (`IdDepartamento`);

--
-- Constraints for table `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `tblfacturas_ibfk_1` FOREIGN KEY (`Departamentoid`) REFERENCES `departamento` (`IdDepartamento`),
  ADD CONSTRAINT `tblfacturas_ibfk_2` FOREIGN KEY (`Proveedoresid`) REFERENCES `proveedores` (`idProveedores`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
