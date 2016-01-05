CREATE DATABASE "Javier"
GO
USE "Javier"
GO
CREATE TABLE TipoDeUsuario(
id INT IDENTITY (1,1),
Tipo VARCHAR (255),
PRIMARY KEY(id)
)
GO
INSERT INTO TipoDeUsuario
VALUES ('Administrador')
GO
INSERT INTO TipoDeUsuario
VALUES ('Empleado')
GO
CREATE TABLE Usuario(
idUsuario INT IDENTITY (1,1) NOT NULL,
nombreU VARCHAR (255) NOT NULL,
nickName VARCHAR (255) NOT NULL,
pass VARCHAR (255) NOT NULL,
idTipoUsuario INT NOT NULL,
PRIMARY KEY (idUsuario),
FOREIGN KEY (idTipoUsuario) REFERENCES TipoDeUsuario(id)
)
CREATE TABLE Cliente (
 nit VARCHAR (255) NOT NULL,
 nombreCl VARCHAR (255) NOT NULL,
 apellidoCl VARCHAR (255) NOT NULL,
 direccion VARCHAR (255) NOT NULL,
 dpi VARCHAR (11) NOT NULL,
 PRIMARY KEY (dpi)
)
CREATE TABLE Stock (
 idArticulo INT IDENTITY (1,1) NOT NULL,
 tipo VARCHAR (255) NOT NULL,
 marca VARCHAR(255) NOT NULL,
 datos VARCHAR(255) NOT NULL,
 existencia INT NOT NULL,
 precio NUMERIC (7,2) NOT NULL,
 idUsuario INT ,
 PRIMARY KEY (idArticulo),
 FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario) 
)

CREATE TABLE Factura(
numFac INT IDENTITY (1,1) NOT NULL,
fecha INT NOT NULL,
nit INT ,
idUsuario INT NOT NULL,
idServicio INT NOT NULL,
tarjeta INT,
efecivo INT ,
PRIMARY KEY (numFac),
FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
)
CREATE TABLE Servicio(
idServicio INT IDENTITY (1,1) NOT NULL,
Descripcion VARCHAR (255) NOT NULL,
idVenta INT ,
numFac INT ,
PRIMARY KEY (idServicio),
FOREIGN KEY (numFac) REFERENCES Factura(numFac)
)
CREATE TABLE Venta(
idVenta INT IDENTITY (1,1) NOT NULL,
numFac INT NOT NULL,
cantidad INT NOT NULL,
idArticulo INT  NOT NULL,
idUsuario INT NOT NULL,
PRIMARY KEY (idVenta),
FOREIGN KEY (idArticulo) REFERENCES Stock(idArticulo),
FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
FOREIGN KEY (numFac) REFERENCES Factura(numFac)
)

CREATE TABLE Vehiculo(
idVehiculo INT IDENTITY (1,1) NOT NULL,
marca VARCHAR (255) NOT NULL,
modelo VARCHAR (255) NOT NULL,
placa VARCHAR (255) NOT NULL,
dpi VARCHAR (11),
PRIMARY KEY (idVehiculo),
FOREIGN KEY (dpi) REFERENCES Cliente(dpi)
)
CREATE TABLE OrdenTrabajo(
dpi  VARCHAR (11) NOT NULL,
descripcionTrabajo VARCHAR (255) NOT NULL,
idVehiculo INT NOT NULL,
idOrdenTrabajo INT IDENTITY (1,1) NOT NULL,
fechaSalida INT,
fechaEntrada INT,
PRIMARY KEY (idOrdenTrabajo),
FOREIGN KEY (idVehiculo) REFERENCES Vehiculo(idVehiculo),
FOREIGN KEY (dpi) REFERENCES Cliente(dpi)
)
CREATE TABLE Reportes(
idReportes INT IDENTITY (1,1) NOT NULL,
idUsuario INT NOT NULL,
dpi VARCHAR (11) NOT NULL,
idVenta INT NOT NULL,
idServicio INT NOT NULL,
idOrdenTrabajo INT NOT NULL,
PRIMARY KEY (idReportes),
FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
FOREIGN KEY (dpi) REFERENCES Cliente(dpi),
FOREIGN KEY (idVenta) REFERENCES Venta (idVenta),
FOREIGN KEY (idServicio) REFERENCES Servicio(idServicio),
FOREIGN KEY (idOrdenTrabajo) REFERENCES OrdenTrabajo(idOrdenTrabajo)
)
CREATE PROCEDURE InsertarUsuario
@nombreU VARCHAR (255), 
@nickName VARCHAR (255),
@pass VARCHAR (255),
@idTipoUsuario INT
AS
BEGIN
INSERT INTO Usuario(nombreU,nickName,pass,idTipoUsuario)
VALUES (@nombreU,@nickName,@pass,@idTipoUsuario)
END
GO
CREATE PROCEDURE InsertarCliente 
@nit VARCHAR (255),
@nombreCl VARCHAR (255),
@apellidoCl VARCHAR (255),
@direccion VARCHAR (255),
@dpi NUMERIC (11)
AS
BEGIN
INSERT INTO Cliente(nit,nombreCl,apellidoCl,direccion,dpi)
VALUES (@nit,@nombreCl,@apellidoCl,@direccion,@dpi)
END
GO
CREATE PROCEDURE InsertarStock
@tipo VARCHAR(255),
@marca VARCHAR(255),
@datos VARCHAR (255),
@existencia INT,
@precio NUMERIC (7,2),
@id INT
AS
BEGIN
INSERT INTO Stock(tipo, marca , datos,existencia,precio , idUsuario)
VALUES(@tipo,@marca,@datos,@existencia,@precio,@id)
END
GO
CREATE PROCEDURE EliminarCliente
	@dpi varchar(255)
AS
DELETE FROM Cliente WHERE dpi =@dpi
GO
CREATE PROCEDURE InsertarVehiculo
@marca VARCHAR (255),
@modelo VARCHAR (255),
@placa VARCHAR (255),
@dpi VARCHAR (255)
AS
BEGIN
INSERT INTO Vehiculo(marca,modelo,placa,dpi)
VALUES (@marca,@modelo,@placa,@dpi)
END
GO
CREATE PROCEDURE EliminarVehiculo
	@placa VARCHAR (255)
AS
DELETE FROM Vehiculo WHERE placa=@placa
GO
EXEC InsertarVehiculo 'Toyota','93','P457BPN','487589'
GO
EXEC EliminarVehiculo 'P457BPN'
GO
EXEC InsertarUsuario 'Javier','Javier','1yoda1',1
EXEC InsertarUsuario 'Jhonn','JDiaz','123',1
EXEC InsertarUsuario 'Edgar','EGuevara','456',2
EXEC InsertarUsuario 'JuanPerez' , 'Juan' , 'guatemala' , 1
GO
EXEC InsertarStock 'Llantas','Pirelli','110/90-16',23,150.00,1
GO
EXEC InsertarCliente '223253-3','Juan','Perez','Guatemala','487589'
GO
EXEC EliminarCliente '2011001'
GO
SELECT Vehiculo.marca , Vehiculo.modelo , Vehiculo.placa , Cliente.nombreCl FROM Vehiculo INNER JOIN Cliente ON Vehiculo.dpi = Cliente.dpi
SELECT * FROM Stock
GO