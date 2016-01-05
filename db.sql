CREATE DATABASE "Proyecto"
GO
USE "Proyecto"
GO
CREATE TABLE TipoDeUsuario(
	ID INT IDENTITY (1,1), 
	TipoDeUsuario VARCHAR (255),
	PRIMARY KEY (ID)
)
CREATE TABLE ActividadesRealizables(
	ID INT IDENTITY (1,1),
	Actividad VARCHAR (255),
	PRIMARY KEY (ID)
)
CREATE TABLE Usuario(
	ID INT IDENTITY (1,1),
	Nombre VARCHAR (255),
	Pass VARCHAR (255),
	IDTipoDeUsuario INT,
	PRIMARY KEY (ID),
	FOREIGN KEY (IDTipoDeUsuario) REFERENCES TipoDeUsuario (ID)
)
CREATE TABLE Clientes(
	ID INT IDENTITY (1,1),
	Nombre VARCHAR(255),
	CantidadVisitas INT,
	PRIMARY KEY (ID)	
)
CREATE TABLE IngresoDeVehiculo(
	ID INT IDENTITY (1,1),
	Duenio INT,
	Marca VARCHAR (255),
	Modelo VARCHAR (255),
	Anio NUMERIC (4),
	ActividadARealizar INT,
	PRIMARY KEY (ID),
	FOREIGN KEY (Duenio) REFERENCES Clientes (ID)
)
GO
INSERT INTO TipoDeUsuario
VALUES ('Administrador')
GO
INSERT INTO TipoDeUsuario
VALUES ('Empleado')
GO
CREATE PROCEDURE InsertarUsuario
	@Nombre VARCHAR(255),
	@Pass VARCHAR(255),
	@IDTipoDeUsuario INT
AS
BEGIN
	INSERT INTO Usuario
	VALUES(@Nombre, @Pass, @IDTipoDeUsuario)
END
GO
EXEC InsertarUsuario 'JuanPerez' , 'guatemala' , 1
GO
EXEC InsertarUsuario'JoseVasquez' , 'usa' , 2
GO
SELECT Usuario.Nombre , Usuario.Pass, TipoDeUsuario.TipoDeUsuario FROM Usuario INNER JOIN TipoDeUsuario ON Usuario.IDTipoDeUsuario =TipoDeUsuario.ID
