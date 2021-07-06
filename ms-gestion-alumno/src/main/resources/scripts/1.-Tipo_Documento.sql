Create table Tipo_Documento(
	id_tipo_documento int not null primary key,
    tipo char(2) not null,
    descripcion_larga varchar2(60) not null,
    descripcion_corta varchar2(20) not null,
    estado char(1) default '1'
);

create sequence seq_Tipo_Documento;

insert into Tipo_Documento(id_tipo_documento,tipo, descripcion_larga,descripcion_corta) 
values (seq_Tipo_Documento.nextval,'01', 'LIBRETA ELECTORAL O DNI','L.E / DNI');

insert into Tipo_Documento(id_tipo_documento,tipo, descripcion_larga,descripcion_corta) 
values (seq_Tipo_Documento.nextval,'04', 'CARNET DE EXTRANJERIA','CARNET EXT.');

insert into Tipo_Documento(id_tipo_documento,tipo, descripcion_larga,descripcion_corta) 
values (seq_Tipo_Documento.nextval,'06', 'REG. UNICO DE CONTRIBUYENTES','RUC');

insert into Tipo_Documento(id_tipo_documento,tipo, descripcion_larga,descripcion_corta) 
values (seq_Tipo_Documento.nextval,'07', 'PASAPORTE','PASAPORTE');


select * from Tipo_Documento;

