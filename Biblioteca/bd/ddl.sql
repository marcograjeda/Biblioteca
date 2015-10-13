CREATE DATABASE BibliotecaHojaTrabajo
GO

USE BibliotecaHojaTrabajo
GO


/*Creando tablas*/
CREATE TABLE Rango (
	idRango INT IDENTITY(1,1) NOT NULL,
	nombreRango VARCHAR(255) NOT NULL,
	PRIMARY KEY(idRango),
);

CREATE TABLE Usuario (
	idUsuario INT IDENTITY(1,1) NOT NULL,
	nombreUsuario VARCHAR(255) NOT NULL,
	rango VARCHAR(255) NOT NULL,
	clave VARCHAR(255) NOT NULL,
	PRIMARY KEY(idUsuario),
);


CREATE TABLE Autor (
	idAutor INT IDENTITY(1,1) NOT NULL,
	nombreAutor VARCHAR(255) NOT NULL,
	PRIMARY KEY(idAutor),
);

CREATE TABLE Editorial (
	idEditorial INT IDENTITY(1,1) NOT NULL,
	nombreEditorial VARCHAR(255) NOT NULL,
	PRIMARY KEY(idEditorial),
);


CREATE TABLE Libro (
	idLibro INT IDENTITY(1,1) NOT NULL,
	isbn VARCHAR(255) NOT NULL,
	nombreLibro VARCHAR(255) NOT NULL,
	idEditorial INT NOT NULL,
	precio MONEY NOT NULL,
	disponible BIT NOT NULL,
	PRIMARY KEY(idLibro),
	FOREIGN KEY (idEditorial) REFERENCES Editorial(idEditorial)
);

CREATE TABLE Prestamo (
	idPrestamo INT IDENTITY(1,1) NOT NULL,
	idLibro INT NOT NULL,
	fechaPrestamo VARCHAR(255) NOT NULL,
	fechaDevolucion VARCHAR(255) NOT NULL,
	fechaEntrega VARCHAR(255),
	entrega BIT NOT NULL,
	PRIMARY KEY(idPrestamo),
	FOREIGN KEY (idLibro) REFERENCES Libro(idLibro)
);



 GO 
/*------------------------Vistas--------------------------*/

CREATE VIEW VistaLibro
AS
	SELECT Libro.idLibro, Libro.nombreLibro AS 'Nombre', isbn, Editorial.nombreEditorial AS 'Editorial', Libro.precio, disponible FROM Libro
		INNER JOIN Editorial ON Libro.idEditorial = Editorial.idEditorial
GO

CREATE VIEW VistaPrestamo
AS
	SELECT Prestamo.idPrestamo, Libro.idLibro, Libro.nombreLibro AS 'Libro', fechaPrestamo, fechaDevolucion, fechaEntrega, entrega FROM Prestamo
		INNER JOIN Libro ON Prestamo.idLibro = Libro.idLibro
GO


 /*------------Procedimientos almacenados-----------------*/

 CREATE PROCEDURE CrearEditorial
	@nombre AS VARCHAR(255)
AS
	INSERT INTO Editorial(nombreEditorial)
		VALUES(@nombre)
GO

CREATE PROCEDURE ModificarEditorial
	@nombre AS VARCHAR(255),
	@id AS INT
AS
	UPDATE Editorial SET nombreEditorial = @nombre
		WHERE Editorial.idEditorial = @id
GO

CREATE PROCEDURE EliminarEditorial
	@id AS INT
AS
	DELETE Editorial WHERE Editorial.idEditorial = @id
GO
--

--
 CREATE PROCEDURE CrearAutor
	@nombre AS VARCHAR(255)
AS
	INSERT INTO Autor(nombreAutor)
		VALUES(@nombre)
GO

CREATE PROCEDURE ModificarAutor
	@nombre AS VARCHAR(255),
	@id AS INT
AS
	UPDATE Autor SET nombreAutor = @nombre
		WHERE Autor.idAutor = @id
GO

CREATE PROCEDURE EliminarAutor
	@id AS INT
AS
	DELETE Autor WHERE Autor.idAutor = @id
GO

--
 CREATE PROCEDURE CrearRango
	@nombre AS VARCHAR(255)
AS
	INSERT INTO Rango(nombreRango)
		VALUES(@nombre)
GO

CREATE PROCEDURE ModificarRango
	@nombre AS VARCHAR(255),
	@id AS INT
AS
	UPDATE Rango SET nombreRango = @nombre
		WHERE Rango.idRango = @id
GO

CREATE PROCEDURE EliminarRango
	@id AS INT
AS
	DELETE Rango WHERE Rango.idRango = @id
GO

--

--
 CREATE PROCEDURE CrearUsuario
	@nombre AS VARCHAR(255),
	@rango AS VARCHAR(255),
	@clave AS VARCHAR(255)
AS
	INSERT INTO Usuario(nombreUsuario, rango, clave)
		VALUES(@nombre, @rango, @clave)
GO

CREATE PROCEDURE ModificarUsuario
	@nombre AS VARCHAR(255),
	@rango AS VARCHAR(255),
	@clave AS VARCHAR(255),
	@id AS INT
AS
	UPDATE Usuario SET nombreUsuario = @nombre, rango = @rango, clave = @clave
		WHERE Usuario.idUsuario = @id
GO

CREATE PROCEDURE EliminarUsuario
	@id AS INT
AS
	DELETE Usuario WHERE Usuario.idUsuario = @id
GO

--
 CREATE PROCEDURE CrearLibro
	@nombre AS VARCHAR(255),
	@isbn AS VARCHAR(255),
	@idEditorial AS INT,
	@precio AS MONEY
AS
	INSERT INTO Libro(nombreLibro, isbn, idEditorial, precio, disponible)
		VALUES(@nombre, @isbn, @idEditorial, @precio, '1')
GO

CREATE PROCEDURE ModificarLibro
	@id AS INT,
	@nombre AS VARCHAR(255),
	@isbn AS VARCHAR(255),
	@idEditorial AS INT,
	@precio AS MONEY
AS
	UPDATE Libro SET nombreLibro = @nombre, isbn = @isbn, idEditorial = @idEditorial, precio = @precio
		WHERE Libro.idLibro = @id
GO

CREATE PROCEDURE EliminarLibro
	@id AS INT
AS
	DELETE Usuario WHERE Usuario.idUsuario = @id
GO
--
CREATE PROCEDURE CrearPrestamo
	@idLibro AS INT,
	@fechaPrestamo AS VARCHAR(255),
	@fechaDevolucion AS VARCHAR(255)
AS
	INSERT INTO Prestamo(idLibro, fechaPrestamo, fechaDevolucion, entrega)
		VALUES(@idLibro, @fechaPrestamo, @fechaDevolucion, '0')
	UPDATE Libro SET disponible = '0'
		WHERE Libro.idLibro = @idLibro
GO

CREATE PROCEDURE DevolverLibro
	@id AS INT,
	@idLibro AS INT,
	@fechaEntrega AS VARCHAR(255)
AS
	UPDATE Prestamo SET fechaEntrega = @fechaEntrega, entrega = '1'
		WHERE Prestamo.idPrestamo = @id
	UPDATE Libro SET disponible = '1'
		WHERE Libro.idLibro = @idLibro
GO

