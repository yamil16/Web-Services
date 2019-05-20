Esquemas:

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

Datos:

INSERT INTO `usuario` VALUES 
	(null,'Matias','San Roman', 'matt', 'Pinto','matt@'),
	(null,'Yamil','Lacoste','yamil_14', '25demayo','yamil@');

INSERT INTO `reciclados` VALUES 
	(null,1,1,1,1,1,null,1),
	(null,2,2,2,2,2,null,2),
    	(null,3,3,3,3,3,null,1);

PostMan:

{
  "firstname": "Hola",
  "lastname": "Chau",
  "username": "HC",
  "address": "HC133",
  "mail": "HC@gmail.com"
}

{
  "bottles": 5,
  "tetrabriks": 5,
  "glass": 5,
  "paperboard": 5,
  "cans": 5,
  "id_r": 1		
}