# Web-Services

Es una app para crear un Web Service para registro de reciclado utilizando el framework Spring Boot, MySQL Workbench como bases de datos y Postman para testear la App.

Los servicios implementados son:

•Registra un usuario(User)::User

•Agregar un reciclaje a un usuario(username, UserRecycling)::UserRecycling

•Obtener todos los reciclajes de un usuario::List<UserRecycliny>  

•Obtener el total reciclado::Recycling

•Listar todos los usuarios

•Según un ID te da la información del usuario

•Listar todos los reciclados

•Dado un ID de usuario me da todos los reciclados que hizo ese usuario



Las tablas creadas en la base de dato fueron las siguientes:


CREATE TABLE `reciclados` (

  `id` int NOT NULL AUTO_INCREMENT,
  `bottles` int NULL,
  `tetrabriks` int NULL,
  `glass` int NULL,
  `paperboard` int NULL,
  `cans` int NULL,
  `date` date NULL,
  `id_r` int NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id_r`) REFERENCES `usuario` (`id`)
  
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `usuario` (

  `id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(20) NULL,
  `lastname` varchar(20)  NULL,
  `username` varchar(20)  NOT NULL,
  `address` varchar(20)  NULL,
  `mail` varchar(20)  NULL,
  PRIMARY KEY (`id`)
  
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

