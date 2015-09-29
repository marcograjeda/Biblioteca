CREATE DATABASE BibliotecaHojaTrabajo

GO
CREATE TABLE Autor(
codigo INT PRIMARY KEY IDENTITY(1,1),
nombre VARCHAR(50)
)

GO
CREATE TABLE Libro(
codigo INT PRIMARY KEY IDENTITY(1,1),
titulo VARCHAR(50),
isbn VARCHAR(50),
editorial VARCHAR(50),
paginas INT
)

GO
CREATE TABLE Ejemplar(
codigo INT PRIMARY KEY IDENTITY(1,1),
localizacion VARCHAR(50),
codigoL INT FOREIGN KEY REFERENCES Libro(codigo)
)

GO
CREATE TABLE Usuario(
codigo INT PRIMARY KEY IDENTITY(1,1),
nombre VARCHAR(50),
telefono INT,
direccion VARCHAR(50)
)

GO
CREATE TABLE Autor_Libro(
codigoL INT FOREIGN KEY REFERENCES Libro(codigo),
codigoA INT FOREIGN KEY REFERENCES Autor(codigo)
)

GO 
CREATE TABLE Prestamo(
codigoE INT FOREIGN KEY REFERENCES Ejemplar(codigo),
codigoU INT FOREIGN KEY REFERENCES Usuario(codigo),
fecha DATE
)

GO 
CREATE TABLE Devolucion(
codigoE INT FOREIGN KEY REFERENCES Ejemplar(codigo),
codigoU INT FOREIGN KEY REFERENCES Usuario(codigo),
fecha DATE
)

INSERT INTO Autor VALUES ('Dante Aligeri'),
('Dan Brown'),
('Gabriel Garcia Marquez'),
('Homero'),
('Jose Batres Montufar'),
('Paulo Coelho'),
('Jose Milla'),
('Howard Phillips'),
('Jenofonte'),
('Isabel Allende')

INSERT INTO Libro VALUES('Divinina Comedia', 'As45', 'Casa Blanca', 200),
('Inferno', 'Cocodrilo', 'BE85', 155),
('Cien Anios de Soledad', 'BESO', 'Cz91', 250),
('Odisea', 'CIENTO', 'DX82', 350),
('Don Pablo', 'ROMA', 'Ey73', 178),
('El Alquimista', 'MORA', 'Fv64', 450),
('La historia de un Pepe', 'AYTA', 'gW55', 100),
('En las montañas de la locura', 'YATA', 'hU46', 125),
('Anabasis', 'ATYA', 'IT60', 360),
('Eva Luna', 'LANIK', 'JK25', 890)

INSERT INTO Ejemplar VALUES ('A', 1),
('B', 2),
('C', 3),
('D', 4),
('E', 5),
('F', 6),
('G', 7),
('H', 8),
('Y', 9),
('J', 10)

INSERT INTO Usuario VALUES ('Marco', 78945678, 'Ciudad'),
('Pablo', 45693827, 'Ciudad'),
('Eddie', 54789632, 'Ciudad'),
('Javier', 12548796, 'Antigua Ciudad'),
('Omar', 14528796, 'Antigua Ciudad'),
('Anderson', 58967896, 'Nueva Villa'),
('Edson', 69328756, 'Nueva Villa'),
('David', 9875632, 'Nueva Villa'),
('Jose', 55669988, 'Vieja Ciudad'),
('Juan', 66988573, 'Vieja Ciudad')

INSERT INTO Autor_Libro VALUES (1,1),
(2,2),
(3,3),
(4,4),
(5,5),
(6,6),
(7,7),
(8,8),
(9,9),
(10,10)

GO
INSERT INTO Prestamo VALUES (10,1, '2015/05/01'),
(7,6, '2015/06/07'),
(5,4, '2015/09/08'),
(8,3, '2015/07/20'),
(9,2, '2015/08/08')

GO
INSERT INTO Devolucion VALUES (10,1, '2015/05/06')

Select * From Autor
Select * From Autor_Libro
Select * From Devolucion
Select * From Ejemplar
Select * From Libro
Select * From Prestamo
Select * From Usuario