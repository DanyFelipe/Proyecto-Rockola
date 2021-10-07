create database rockola;
use rockola;

CREATE TABLE Canciones (
    idCancion INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(30) NOT NULL,
    generos VARCHAR(30) NOT NULL,
    artista VARCHAR(30) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (idCancion)
);
/*==================== PARA PROBAR =========================*/

insert into Canciones(nombre,generos,artista) values('Everything She Wants','Rock, Pop','Wham');
insert into Canciones(nombre,generos,artista) values('Together Forever','Rock','Rick Astley');

Update Canciones set nombre='Juke Box Boy',generos='Rock, Disco',artista='Baltimora' WHERE idCancion = 3;
