use ms01_2021_alumno;

Create table Tipo_Documento(
	id_tipo_documento int not null primary key auto_increment, 
    tipo char(2) not null,
    descripcion_larga varchar(60) not null,
    descripcion_corta varchar(20) not null,
    estado char(1) default '1'
);

insert into Tipo_Documento(tipo, descripcion_larga,descripcion_corta) 
values ('01', 'LIBRETA ELECTORAL O DNI','L.E / DNI'),
('04', 'CARNET DE EXTRANJERIA','CARNET EXT.'),
('06', 'REG. UNICO DE CONTRIBUYENTES','RUC'),
('07', 'PASAPORTE','PASAPORTE');

Create table Alumno(
	id_alumno int not null auto_increment primary key ,
    apellido_paterno varchar(60) not null,
    apellido_materno varchar(60) not null,
    nombre varchar(60) not null,
    id_tipo_documento numeric(4) not null,
    numero_documento varchar(20) not null,
	correo varchar(20) not null,
    telefono varchar(20) not null,
    fecha_registro datetime not null default now(),
    estado char(1),

    aud_tipo char(1),
    aud_id_usuario numeric(4) not null,
    aud_fecha timestamp,
    aud_ip varchar(20)
);
