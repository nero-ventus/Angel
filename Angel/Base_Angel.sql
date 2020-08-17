drop database if exists angel;
create database if not exists angel;
use angel;
create table codigo_venta(
	codigo varchar(16) primary key,
    estado_uso int not null
);
/*	estado_uso
	1=En Uso
	2=Libre
*/
------------------------------------------------------------
create table estados_mexico(
	id_estado int primary key auto_increment,
    estado_mexico varchar(20)
);
insert into angel.estados_mexico values(0,'Ciudad de Mexico');
insert into angel.estados_mexico values(0,'Aguascalientes');
insert into angel.estados_mexico values(0,'Baja California');
insert into angel.estados_mexico values(0,'Baja California Sur');
insert into angel.estados_mexico values(0,'Campeche');
insert into angel.estados_mexico values(0,'Chiapas');
insert into angel.estados_mexico values(0,'Chihuahua');
insert into angel.estados_mexico values(0,'Coahuila');
insert into angel.estados_mexico values(0,'Colima');
insert into angel.estados_mexico values(0,'Durango');
insert into angel.estados_mexico values(0,'Estado de México');
insert into angel.estados_mexico values(0,'Guanajuato');
insert into angel.estados_mexico values(0,'Guerrero');
insert into angel.estados_mexico values(0,'Hidalgo');
insert into angel.estados_mexico values(0,'Jalisco');
insert into angel.estados_mexico values(0,'Michoacán');
insert into angel.estados_mexico values(0,'Morelos');
insert into angel.estados_mexico values(0,'Nayarit');
insert into angel.estados_mexico values(0,'Nuevo León');
insert into angel.estados_mexico values(0,'Oaxaca');
insert into angel.estados_mexico values(0,'Puebla');
insert into angel.estados_mexico values(0,'Querétaro');
insert into angel.estados_mexico values(0,'Quintana Roo');
insert into angel.estados_mexico values(0,'San Luis Potosí');
insert into angel.estados_mexico values(0,'Sinaloa');
insert into angel.estados_mexico values(0,'Sonora');
insert into angel.estados_mexico values(0,'Tabasco');
insert into angel.estados_mexico values(0,'Tamaulipas');
insert into angel.estados_mexico values(0,'Tlaxcala');
insert into angel.estados_mexico values(0,'Veracruz');
insert into angel.estados_mexico values(0,'Yucatán');
insert into angel.estados_mexico values(0,'Zacatecas');
------------------------------------------------------------
create table direccion(
	id_direccion int primary key auto_increment,
    n_exterior int not null,
    calle varchar(100) not null,
    municipio varchar(100) not null,
    id_estado int,
    foreign key (id_estado) references estados_mexico(id_estado)
);
------------------------------------------------------------
create table cuenta_usuario(
	correo varchar(100) primary key,
    contra varchar(50) not null,
    estado_cuenta int not null,
    codigo varchar(16),
    foreign key (codigo) references codigo_venta(codigo)
);
/*	estado_cuenta
	1=Validada
	2=No validada
*/
------------------------------------------------------------
create table usuario(
	id_usuario int primary key auto_increment,
    nombre varchar(50) not null,
    apellido_p varchar(50) not null,
    apellido_m varchar(50) not null,
    id_direccion int,
    correo varchar(100),
    foreign key (correo) references cuenta_usuario (correo),
    foreign key (id_direccion) references direccion(id_direccion)
);
------------------------------------------------------------
create table afecciones(
	id_afeccion int primary key auto_increment,
    nombre varchar(30) not null
);
insert into angel.afecciones values(1,'Asma');
insert into angel.afecciones values(2,'Fibrosis quística');
insert into angel.afecciones values(3,'Diabetes');
insert into angel.afecciones values(4,'Hipoglucemia');
insert into angel.afecciones values(5,'Parálisis cerebral');
insert into angel.afecciones values(6,'Autismo');
insert into angel.afecciones values(7,'Deficit de atencion');
insert into angel.afecciones values(8,'Hiperactiviadad');
------------------------------------------------------------
create table infante(
	id_infante int primary key auto_increment,
    nombre varchar(20) not null,
    apellido_p varchar(15) not null,
    apellido_m varchar(15) not null,
    peso int not null,
    altura int not null,
    sexo int not null,
    fecha_naci date not null
);
/*	sexo
	1=Masculino
	2=Femenino
*/
------------------------------------------------------------
create table rela_infante_afecciones(
	id_rela_in_afe int auto_increment primary key,
    id_infante int,
    id_afeccion int,
    foreign key (id_infante) references infante (id_infante),
    foreign key (id_afeccion) references afecciones (id_afeccion)
);
------------------------------------------------------------
create table rela_usuario_infante(
	id_rela_usua_infan int primary key auto_increment,
    id_usuario int,
    id_infante int,
    foreign key (id_usuario) references usuario (id_usuario),
    foreign key (id_infante) references infante (id_infante)
);
------------------------------------------------------------
create table preguntas(
	id_pregunta int primary key auto_increment,
    texto varchar(200) not null,
    id_usuario int,
    foreign key (id_usuario) references usuario(id_usuario)
);
------------------------------------------------------------
create table juego(
	id_juego int primary key auto_increment,
    nombre varchar(20) not null
);
insert into juego values(1,'Juego1');
insert into juego values(2,'Juego2');
insert into juego values(3,'Juego3');
insert into juego values(4,'Juego4');
------------------------------------------------------------
create table puntuaciones(
	id_puntuacion int primary key auto_increment,
    puntuacion int not null,
    id_infante int,
    id_juego int,
    foreign key (id_infante) references infante (id_infante),
    foreign key (id_juego) references juego (id_juego)
);
------------------------------------------------------------
create table foto(
	id_foto int primary key auto_increment,
    foto longblob not null,
    nombre varchar(50) not null
);
------------------------------------------------------------
create table temas(
	id_tema int primary key auto_increment,
    nombre varchar(30) not null
);
------------------------------------------------------------
create table consejos(
	id_consejo int primary key auto_increment,
    texto varchar(1000) not null
);
------------------------------------------------------------
create table rela_foto_consejo(
	id_rela_fo_con int primary key auto_increment,
    id_foto int,
    id_consejo int,
    foreign key (id_foto) references foto (id_foto),
    foreign key (id_consejo) references consejos (id_consejo)
);
------------------------------------------------------------
create table especialistas(
	id_especialista int primary key auto_increment,
    nombre varchar(20) not null,
    apellido_paterno varchar(20) not null,
    apellido_materno varchar(20) not null,
    correo varchar(100) not null,
    telefono varchar(20) not null,
    id_direccion int,
    id_foto int,
    foreign key (id_direccion) references direccion (id_direccion),
    foreign key (id_foto) references foto (id_foto)
);
------------------------------------------------------------
create table notificacion(
	id_noti int primary key auto_increment,
    volumen int not null,
    tono varchar(20) not null,
    tipo_noti int not null
);
/*	tipo_noti
	1=Sonido & Vibra
	2=Sonido
    3=Vibra
    4=Silencio
*/
------------------------------------------------------------
create table config_lexterna(
	id_configle int primary key auto_increment,
    distancia_permitida int not null,
    estado_servicio int not null,
    id_usuario int,
    id_noti int,
    foreign key (id_noti) references notificacion (id_noti),
    foreign key (id_usuario) references usuario (id_usuario)
);
/*	estado_servicio
	1=Activado
    2=Desactivado
*/
------------------------------------------------------------
create table dispositivo(
	id_dispositivo varchar(100) primary key,
    posicion_global varchar(100),
    codigo varchar(16),
    foreign key (codigo) references codigo_venta (codigo)
);
------------------------------------------------------------
create table rela_dispo_infante(
	id_rela_dispo_infan int primary key auto_increment,
    id_dispositivo varchar(100) not null,
    id_infante int not null,
    foreign key (id_dispositivo) references dispositivo (id_dispositivo),
	foreign key (id_infante) references infante (id_infante)
);
------------------------------------------------------------
/*Eliminar cuartos en version final*/
create table cuartos(
	id_cuarto int primary key auto_increment,
    nombre_cuarto varchar(20) not null
);
insert into angel.cuartos values(0,'Dormitorio');
insert into angel.cuartos values(0,'Estudio');
insert into angel.cuartos values(0,'Baño');
insert into angel.cuartos values(0,'Cocina');
insert into angel.cuartos values(0,'Cuarto de Lavado');
insert into angel.cuartos values(0,'Comedor');
insert into angel.cuartos values(0,'Sala');
------------------------------------------------------------
create table sensores(
	id_sensor varchar(50) primary key,
    codigo varchar(16),
    id_cuarto int,
    estado_permiso int not null,
    foreign key (codigo) references codigo_venta (codigo),
    foreign key (id_cuarto) references cuartos (id_cuarto)
);
/*	estado_permiso
	1=Permitido
    2=Prohibido
*/
------------------------------------------------------------
create table config_linterna(
	id_configli int primary key auto_increment,
    estado_servicio int not null,
    id_usuario int,
    id_noti int,
    foreign key (id_noti) references notificacion (id_noti),
    foreign key (id_usuario) references usuario (id_usuario)
);
/*	estado_servicio
	1=Activado
    2=Desactivado
*/
-------------------------------------------------------------
create table colo_piel(
	id_colo_piel int primary key auto_increment,
    descrip varchar(20)
);
insert into angel.colo_piel values(0,'Normal');
insert into angel.colo_piel values(0,'Palido');
insert into angel.colo_piel values(0,'Colorado');
-------------------------------------------------------------
create table cansancio(
	id_cansa int primary key auto_increment,
    descrip varchar(20)
);
insert into angel.cansancio values(0,'Si');
insert into angel.cansancio values(0,'No');
-------------------------------------------------------------
create table dolor_ganganta(
	id_dolor_g int primary key auto_increment,
    descrip varchar(20)
);
insert into angel.dolor_ganganta values(0,'Si');
insert into angel.dolor_ganganta values(0,'No');
-------------------------------------------------------------
create table flema(
	id_flema int primary key auto_increment,
    descrip varchar(20)
);
insert into angel.flema values(0,'No');
insert into angel.flema values(0,'Transparente');
insert into angel.flema values(0,'Verde');
insert into angel.flema values(0,'Blanca');
insert into angel.flema values(0,'Sangrienta');
-------------------------------------------------------------
create table escuri_nasal(
	id_escuri_n int primary key auto_increment,
    descrip varchar(20)
);
insert into angel.escuri_nasal values(0,'Si');
insert into angel.escuri_nasal values(0,'No');
-------------------------------------------------------------
create table dolor_abdomi(
	id_dolor_ab int primary key auto_increment,
    descrip varchar(20)
);
insert into angel.dolor_abdomi values(0,'No');
insert into angel.dolor_abdomi values(0,'Leve');
insert into angel.dolor_abdomi values(0,'Moderado');
insert into angel.dolor_abdomi values(0,'Intenso');
-------------------------------------------------------------
create table nauseas(
	id_nauseas int primary key auto_increment,
    descrip varchar(20)
);
insert into angel.nauseas values(0,'Si');
insert into angel.nauseas values(0,'No');
-------------------------------------------------------------
create table vomito(
	id_vomito int primary key auto_increment,
    descrip varchar(20)
);
insert into angel.vomito values(0,'Si');
insert into angel.vomito values(0,'No');
-------------------------------------------------------------
create table dolor_cabeza(
	id_dolor_ca int primary key auto_increment,
    descrip varchar(20)
);
insert into angel.dolor_cabeza values(0,'Si');
insert into angel.dolor_cabeza values(0,'No');
-------------------------------------------------------------
create table diarrea(
	id_diarrea int primary key auto_increment,
    descrip varchar(20)
);
insert into angel.diarrea values(0,'Si');
insert into angel.diarrea values(0,'No');
-------------------------------------------------------------
create table reporte(
	id_reporte int auto_increment primary key,
    fecha date,
    id_infante int,
    talla int,
    peso int,
    temperatura double,
    frecuencia_cardiaca int,
    id_colo_piel int,
    id_cansa int,
    id_dolor_g int,
    id_flema int,
    id_escuri_n int,
    id_dolor_ab int,
    id_nauseas int,
    id_vomito int,
    id_dolor_ca int,
    id_diarrea int,
    foreign key (id_infante) references infante (id_infante),
    foreign key (id_colo_piel) references colo_piel (id_colo_piel),
    foreign key (id_cansa) references cansancio (id_cansa),
    foreign key (id_dolor_g) references dolor_ganganta (id_dolor_g),
    foreign key (id_flema) references flema (id_flema),
    foreign key (id_escuri_n) references escuri_nasal (id_escuri_n),
    foreign key (id_dolor_ab) references dolor_abdomi (id_dolor_ab),
    foreign key (id_nauseas) references nauseas (id_nauseas),
    foreign key (id_vomito) references vomito (id_vomito),
    foreign key (id_dolor_ca) references dolor_cabeza (id_dolor_ca),
    foreign key (id_diarrea) references diarrea (id_diarrea)
);
-------------------------------------------------------------
create table enfermedades(
	id_enferme int auto_increment primary key,
    edad_min int,
    edad_max int,
    talla_min int,
    talla_max int,
    tempe_min int,
    tempe_max int,
    frec_c_min int,
    frec_c_max int,
    id_colo_piel int,
    id_cansa int,
    id_dolor_g int,
    id_flema int,
    id_escuri_n int,
    id_dolor_ab int,
    id_nauseas int,
    id_vomito int,
    id_dolor_ca int,
    id_diarrea int,
    foreign key (id_colo_piel) references colo_piel (id_colo_piel),
    foreign key (id_cansa) references cansancio (id_cansa),
    foreign key (id_dolor_g) references dolor_ganganta (id_dolor_g),
    foreign key (id_flema) references flema (id_flema),
    foreign key (id_escuri_n) references escuri_nasal (id_escuri_n),
    foreign key (id_dolor_ab) references dolor_abdomi (id_dolor_ab),
    foreign key (id_nauseas) references nauseas (id_nauseas),
    foreign key (id_vomito) references vomito (id_vomito),
    foreign key (id_dolor_ca) references dolor_cabeza (id_dolor_ca),
    foreign key (id_diarrea) references diarrea (id_diarrea)
);
-------------------------------------------------------------
create table respuestas(
	id_repuesta int primary key auto_increment,
    texto varchar(300),
    id_pregunta int,
    foreign key (id_pregunta) references preguntas(id_pregunta)
);
-------------------------------------------------------------
create table administrador(
    correo varchar(100) primary key,
    contra varchar(30) not null,
    nombre varchar(30) not null,
	modulo int not null
);
/*
	1=Localizacion
    2=Seguimiento medico
    3=Estimulacion temprena
    4=Consejos y Directorio
    5=Usuario
    6=FAQS
*/
-------------------------------------------------------------
create table tickets(
	id_ticket int primary key auto_increment,
    id_usuario int,
    correo_admin varchar(100) null,
    estado int,
    modulo int,
    pregunta varchar(300),
    respuesta varchar(300),
    foreign key (id_usuario) references angel.usuario(id_usuario),
    foreign key (correo_admin) references angel.administrador(correo)
);
/*
	estado:
    1=Pendiente
    2=En proceso
    3=solucionado
	modulo:
	1=Localizacion
    2=Seguimiento medico
    3=Estimulacion temprena
    4=Consejos y Directorio
    5=Usuario
    6=FAQS
*/
-------------------------------------------------------------
create table ingeniero(
	correo varchar(100) primary key,
    contra varchar(30) not null,
    nombre varchar(30),
    apellidos varchar(30)
);
-------------------------------------------------------------
create table gerente(
	correo_inge varchar(100) unique,
    foreign key (correo_inge) references angel.ingeniero(correo)
);
-------------------------------------------------------------
create table operador(
	correo varchar(100) primary key,
    contra varchar(30) not null,
    nombre varchar(30),
    apellidos varchar(30)
);
-------------------------------------------------------------
create table reporte_evento(
	id_repor_evento int primary key auto_increment,
    fecha date,
    estado int,
    descripcion varchar(300),
    solucion varchar(300),
    correo_inge varchar(100) null,
    correo_usua varchar(100),
    foreign key (correo_inge) references angel.ingeniero(correo),
    foreign key (correo_usua) references angel.usuario(correo)
);
/*
	estado:
    1=Abierto
    2=Cerrado
*/
-------------------------------------------------------------
create table etiquetas(
	id_etiqueta int primary key auto_increment,
    nombre varchar(30)
);
-------------------------------------------------------------
create table rela_etiquetas_reporte(
	id_rela_eti_repor int primary key auto_increment,
    id_reporte_evento int,
    id_etiqueta int,
    cantidad int,
    foreign key(id_reporte_evento) references angel.reporte_evento (id_repor_evento),
    foreign key(id_etiqueta) references angel.etiquetas (id_etiqueta)
);
-------------------------------------------------------------
drop procedure if exists sp_usuario;
delimiter **
create procedure sp_usuario(in tipo int,in nombreu varchar(50),in apellido_pu varchar(50),in apellido_mu varchar(50),in correou varchar(100),in contrau varchar(50),in codigou varchar(16),in nexu int,in calleu varchar(100),in municipiou varchar(100),in estadou int,in correoo varchar(100))
begin
declare validacorreo int;
declare validacodigo int;
declare msj int;
declare codigoc varchar(16);
declare ultimo int;
declare ultimo2 int;
declare ultimo3 int;
if(tipo=0) then
	set validacorreo=(select count(angel.cuenta_usuario.codigo) from angel.cuenta_usuario where angel.cuenta_usuario.correo=correou);
    set validacodigo=(select angel.codigo_venta.estado_uso from angel.codigo_venta where angel.codigo_venta.codigo=codigou);
    if(validacodigo=2) then
		if(validacorreo=0)then
			update angel.codigo_venta set angel.codigo_venta.estado_uso=1 where angel.codigo_venta.codigo=codigou;
			insert into angel.direccion values(0,nexu,calleu,municipiou,estadou);
			set ultimo=(select ifnull(max(angel.direccion.id_direccion),0) from angel.direccion);
			insert into angel.cuenta_usuario values(correou,contrau,2,codigou);
			insert into angel.usuario values(0,nombreu,apellido_pu,apellido_mu,ultimo,correou);
            insert into angel.notificacion values(0,10,'predeterminado1',2);
            set ultimo2=(select ifnull(max(angel.usuario.id_usuario),0) from angel.usuario);
            set ultimo3=(select ifnull(max(angel.notificacion.id_noti),0) from angel.notificacion);
            insert into angel.config_linterna values(0,2,ultimo2,ultimo3);
            insert into angel.config_lexterna values(0,3,2,ultimo2,ultimo3);
			set msj=1;
			select msj as mensaje;
		else
			set msj=3;
			select msj as mensaje;
		end if;
    else
		set msj=2;
        select msj as mensaje;
    end if;
else
	if(tipo=1) then
		set validacorreo=(select count(angel.cuenta_usuario.correo) from angel.cuenta_usuario where binary angel.cuenta_usuario.correo=correoo);
        if(validacorreo=1) then
			if(binary correoo=correou) then
				update angel.direccion inner join angel.usuario set angel.direccion.n_exterior=nexu,angel.direccion.calle=calleu,angel.direccion.municipio=municipiou,angel.direccion.id_estado=estadou where binary angel.direccion.id_direccion=angel.usuario.id_direccion and binary angel.usuario.correo=correoo;
				update angel.usuario set angel.usuario.nombre=nombreu,angel.usuario.apellido_p=apellido_pu,angel.usuario.apellido_m=apellido_mu where binary angel.usuario.correo=correoo;
				update angel.cuenta_usuario set angel.cuenta_usuario.contra=contrau where binary angel.cuenta_usuario.correo=correoo;
				set msj=1;
				select msj as mensaje;
			else
				update angel.direccion inner join angel.usuario set angel.direccion.n_exterior=nexu,angel.direccion.calle=calleu,angel.direccion.municipio=municipiou,angel.direccion.id_estado=estadou where binary angel.direccion.id_direccion=angel.usuario.id_direccion and binary angel.usuario.correo=correoo;
				set codigoc=(select angel.codigo_venta.codigo from angel.codigo_venta inner join angel.cuenta_usuario where binary angel.codigo_venta.codigo=angel.cuenta_usuario.codigo and binary angel.cuenta_usuario.correo=correoo);
				insert into angel.cuenta_usuario values(correou,contrau,2,codigoc);
				update angel.usuario set angel.usuario.nombre=nombreu,angel.usuario.apellido_p=apellido_pu,angel.usuario.apellido_m=apellido_mu,angel.usuario.correo=correou where binary angel.usuario.correo=correoo;
				delete from angel.cuenta_usuario where angel.cuenta_usuario.correo=correoo;
				set msj=1;
				select msj as mensaje;
            end if;
		else
			set msj=0;
			select msj as mensaje;
        end if;
    end if;
end if;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getusuario;
delimiter **
create procedure sp_getusuario(in correou varchar(100),in contrau varchar(50))
begin
select angel.usuario.* from angel.usuario inner join angel.cuenta_usuario where binary angel.cuenta_usuario.correo=correou and binary angel.cuenta_usuario.contra=contrau and binary angel.cuenta_usuario.correo=angel.usuario.correo;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_codigo_venta;
delimiter **
create procedure sp_codigo_venta(in tipo int,in codigou varchar(16),in estado_usou int)
begin
declare validarepe int;
declare mensa int;
set validarepe=(select count(angel.codigo_venta.codigo) from angel.codigo_venta where binary angel.codigo_venta.codigo=codigou);
if(tipo=0) then
	if(validarepe=0) then
		insert into angel.codigo_venta values(codigou,estado_usou);
		set mensa=1;
		select mensa;
	else
		set mensa=2;
		select mensa;
	end if;
end if;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getcuenta_usuario;
delimiter **
create procedure sp_getcuenta_usuario(in correou varchar(100))
begin
select angel.cuenta_usuario.* from angel.cuenta_usuario where binary angel.cuenta_usuario.correo=correou;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_infante;
delimiter **
create procedure sp_infante(in tipo int,in nombreu varchar(20),in apellido_pu varchar(15),in apellido_mu varchar(15),in pesou int,in alturau int,in sexou int,in fecha_nu date,in correou varchar(100),in id_dispositivou varchar(100),in id_infanu int)
begin
declare id1 int;
declare id2 int;
declare dispovalida int;
if(tipo=0) then
	set dispovalida=(select count(angel.dispositivo.id_dispositivo) from angel.dispositivo where binary angel.dispositivo.id_dispositivo=id_dispositivou);
	if(dispovalida=1) then
		insert into angel.infante values(0,nombreu,apellido_pu,apellido_mu,pesou,alturau,sexou,fecha_nu);
		set id1=(select ifnull(max(angel.infante.id_infante),0) from angel.infante);
		set id2=(select angel.usuario.id_usuario from angel.usuario where binary angel.usuario.correo=correou);
		insert into angel.rela_usuario_infante values(0,id2,id1);
		insert into angel.puntuaciones values(0,0,id1,1);
		insert into angel.puntuaciones values(0,0,id1,2);
		insert into angel.puntuaciones values(0,0,id1,3);
		insert into angel.puntuaciones values(0,0,id1,4);
		insert into angel.rela_dispo_infante values(0,id_dispositivou,id1);
		select id1;
	else
		set id1=0;
        select id1;
	end if;
else
	if(tipo=1) then
		update angel.infante set angel.infante.nombre=nombreu,angel.infante.apellido_p=apellido_pu,angel.infante.apellido_m=apellido_mu,angel.infante.peso=pesou,angel.infante.altura=alturau,angel.infante.sexo=sexou,angel.infante.fecha_naci=fecha_nu where binary angel.infante.id_infante=id_infanu;
        update angel.rela_dispo_infante set angel.rela_dispo_infante.id_dispositivo=id_dispositivou where binary angel.rela_dispo_infante.id_infante=id_infanu;
        set id1=1;
        select id1;
    end if;
end if;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_infante_s;
delimiter **
create procedure sp_infante_s(in id_infanteu int,in id_afec int)
begin
insert into angel.rela_infante_afecciones values(0,id_infanteu,id_afec);
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getdirec;
delimiter **
create procedure sp_getdirec(in id_direcu int)
begin
select angel.direccion.* from angel.direccion where binary angel.direccion.id_direccion=id_direcu;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getdispositivo;
delimiter **
create procedure sp_getdispositivo(in id_infanu int)
begin
select angel.dispositivo.* from angel.dispositivo inner join angel.rela_dispo_infante where binary angel.dispositivo.id_dispositivo=angel.rela_dispo_infante.id_dispositivo and binary angel.rela_dispo_infante.id_infante=id_infanu;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getdispositivos;
delimiter **
create procedure sp_getdispositivos(in correou varchar(100))
begin
declare codigoc varchar(16);
set codigoc=(select angel.codigo_venta.codigo from angel.codigo_venta inner join angel.cuenta_usuario where binary angel.codigo_venta.codigo=angel.cuenta_usuario.codigo and binary angel.cuenta_usuario.correo=correou);
select angel.dispositivo.* from angel.dispositivo where not exists(select angel.rela_dispo_infante.* from angel.rela_dispo_infante where binary angel.rela_dispo_infante.id_dispositivo=angel.dispositivo.id_dispositivo) and binary angel.dispositivo.codigo=codigoc;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getinfantes;
delimiter **
create procedure sp_getinfantes(in correou varchar(100))
begin
declare codigoc varchar(16);
set codigoc=(select angel.codigo_venta.codigo from angel.codigo_venta inner join angel.cuenta_usuario where binary angel.codigo_venta.codigo=angel.cuenta_usuario.codigo and binary angel.cuenta_usuario.correo=correou);
select angel.infante.* from angel.infante inner join angel.rela_dispo_infante,angel.dispositivo where binary angel.infante.id_infante=angel.rela_dispo_infante.id_infante and binary angel.rela_dispo_infante.id_dispositivo=angel.dispositivo.id_dispositivo and angel.dispositivo.codigo=codigoc;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getafecciones;
delimiter **
create procedure sp_getafecciones(in id_infanu int)
begin
select angel.afecciones.* from angel.afecciones inner join angel.rela_infante_afecciones where binary angel.afecciones.id_afeccion=angel.rela_infante_afecciones.id_afeccion and binary angel.rela_infante_afecciones.id_infante=id_infanu;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_deleterela_afec_infan;
delimiter **
create procedure sp_deleterela_afec_infan(in id_infanu int)
begin
declare valida int;
set valida=(select count(angel.rela_infante_afecciones.id_afeccion) from angel.rela_infante_afecciones where binary angel.rela_infante_afecciones.id_infante=id_infanu);
if(valida>0) then
	delete from angel.rela_infante_afecciones where binary angel.rela_infante_afecciones.id_infante=id_infanu;
end if;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_deleteinfan;
delimiter **
create procedure sp_deleteinfan(in id_infanu int)
begin
declare valida int;
declare existe_infan int;
set existe_infan=(select count(angel.infante.id_infante) from angel.infante where binary angel.infante.id_infante=id_infanu);
if(existe_infan=1) then
	delete from angel.reporte where binary angel.reporte.id_infante=id_infanu;
	set valida=(select count(angel.rela_infante_afecciones.id_afeccion) from angel.rela_infante_afecciones where binary angel.rela_infante_afecciones.id_infante=id_infanu);
	if(valida>0) then
		delete from angel.rela_infante_afecciones where binary angel.rela_infante_afecciones.id_infante=id_infanu;
	end if;
    delete from angel.puntuaciones where binary angel.puntuaciones.id_infante=id_infanu;
    delete from angel.rela_dispo_infante where binary angel.rela_dispo_infante.id_infante=id_infanu;
    delete from angel.rela_usuario_infante where binary angel.rela_usuario_infante.id_infante=id_infanu;
    delete from angel.infante where binary angel.infante.id_infante=id_infanu;
    select 1;
end if;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getinfante;
delimiter **
create procedure sp_getinfante(in id_infanu int, in correou varchar(100))
begin
select angel.infante.* from angel.infante inner join angel.rela_usuario_infante,angel.usuario where binary angel.infante.id_infante=id_infanu and binary angel.rela_usuario_infante.id_infante=angel.infante.id_infante and binary angel.rela_usuario_infante.id_usuario=angel.usuario.id_usuario and binary angel.usuario.correo=correou;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getsensores;
delimiter **
create procedure sp_getsensores(in correou varchar(100))
begin
select angel.sensores.* from angel.sensores inner join angel.cuenta_usuario where binary angel.sensores.codigo=angel.cuenta_usuario.codigo and binary angel.cuenta_usuario.correo=correou;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getconfig_li;
delimiter **
create procedure sp_getconfig_li(in correou varchar(100))
begin
select angel.config_linterna.* from angel.config_linterna inner join angel.usuario where binary angel.config_linterna.id_usuario=angel.usuario.id_usuario and binary angel.usuario.correo=correou;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getnoti;
delimiter **
create procedure sp_getnoti(in correou varchar(100))
begin
select angel.notificacion.* from angel.notificacion inner join angel.config_linterna,angel.usuario where binary angel.notificacion.id_noti=angel.config_linterna.id_noti and binary angel.config_linterna.id_usuario=angel.usuario.id_usuario and binary angel.usuario.correo=correou;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_actualiza_noti;
delimiter **
create procedure sp_actualiza_noti(in correou varchar(100),in volumenu int,in tonou varchar(20),in tipo_notiu int)
begin
declare id1 int;
set id1=(select angel.notificacion.id_noti from angel.notificacion inner join angel.config_linterna,angel.usuario where binary angel.notificacion.id_noti=angel.config_linterna.id_noti and binary angel.config_linterna.id_usuario=angel.usuario.id_usuario and binary angel.usuario.correo=correou);
update angel.notificacion set angel.notificacion.volumen=volumenu,angel.notificacion.tono=tonou,angel.notificacion.tipo_noti=tipo_notiu where binary angel.notificacion.id_noti=id1;
set id1=1;
select id1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_actualiza_config_li;
delimiter **
create procedure sp_actualiza_config_li(in correou varchar(100),in estado_serviu int)
begin
declare id1 int;
set id1=(select angel.config_linterna.id_configli from angel.config_linterna inner join angel.usuario where binary angel.config_linterna.id_usuario=angel.usuario.id_usuario and binary angel.usuario.correo=correou);
update angel.config_linterna set angel.config_linterna.estado_servicio=estado_serviu where binary angel.config_linterna.id_configli=id1;
set id1=1;
select id1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_delete_usuario;
delimiter **
create procedure sp_delete_usuario(in correou varchar(100))
begin
declare iddirecu int;
delete angel.quejas from angel.quejas inner join angel.usuario where binary angel.quejas.id_usuario=angel.usuario.id_usuario and binary angel.usuario.correo=correou;
delete angel.config_linterna from angel.config_linterna inner join angel.usuario where binary angel.config_linterna.id_usuario=angel.usuario.id_usuario and binary angel.usuario.correo=correou;
delete angel.config_lexterna from angel.config_lexterna inner join angel.usuario where binary angel.config_lexterna.id_usuario=angel.usuario.id_usuario and binary angel.usuario.correo=correou;
set iddirecu=(select angel.direccion.id_direccion from angel.direccion inner join angel.usuario where binary angel.direccion.id_direccion=angel.usuario.id_direccion and  binary angel.usuario.correo=correou);
delete angel.usuario from angel.usuario where binary angel.usuario.correo=correou;
delete angel.direccion from angel.direccion where binary angel.direccion.id_direccion=iddirecu;
delete angel.cuenta_usuario from angel.cuenta_usuario where binary angel.cuenta_usuario.correo=correou;
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_actualiza_sensor;
delimiter **
create procedure sp_actualiza_sensor(in correou varchar(100),in idsensou varchar(50),in id_cuartou int,in estadou int)
begin
declare valida int;
set valida=(select count(angel.sensores.id_cuarto) from angel.sensores inner join angel.cuenta_usuario where binary angel.sensores.codigo=angel.cuenta_usuario.codigo and angel.cuenta_usuario.correo=correou and binary angel.sensores.id_sensor=idsensou);
if(valida>0) then
	update angel.sensores inner join angel.cuenta_usuario set angel.sensores.id_cuarto=id_cuartou,angel.sensores.estado_permiso=estadou where binary angel.sensores.codigo=angel.cuenta_usuario.codigo and angel.cuenta_usuario.correo=correou and binary angel.sensores.id_sensor=idsensou;
	select 1;
else
	select 0;
end if;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_getconfig_le;
delimiter **
create procedure sp_getconfig_le(in correou varchar(100))
begin
select angel.config_lexterna.* from angel.config_lexterna inner join angel.usuario where binary angel.config_lexterna.id_usuario=angel.usuario.id_usuario and binary angel.usuario.correo=correou;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_actualiza_config_le;
delimiter **
create procedure sp_actualiza_config_le(in correou varchar(100),in estado_serviu int,in distapu int)
begin
update angel.config_lexterna inner join angel.usuario set angel.config_lexterna.estado_servicio=estado_serviu,angel.config_lexterna.distancia_permitida=distapu where binary angel.config_lexterna.id_usuario=angel.usuario.id_usuario and binary angel.usuario.correo=correou;
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_registra_reporte;
delimiter **
create procedure sp_registra_reporte(in fechau date,in id_infau int,in tallau int,in pesou int,in tempeu double,in frecuu int,in colou int,in cansau int,in dolor_gu int,in flemau int,in escuri_nu int,in dolor_abu int,in nauseasu int,in vomito int,in dolor_cau int,in diarreau int)
begin
insert into angel.reporte values(0,fechau,id_infau,tallau,pesou,tempeu,frecuu,colou,cansau,dolor_gu,flemau,escuri_nu,dolor_abu,nauseasu,vomito,dolor_cau,diarreau);
update angel.infante set angel.infante.altura=tallau,angel.infante.peso=pesou where binary angel.infante.id_infante=id_infau;
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_reportes;
delimiter **
create procedure sp_trae_reportes(in id_infanteu int)
begin
select angel.reporte.* from angel.reporte where binary angel.reporte.id_infante=id_infanteu;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_reporte;
delimiter **
create procedure sp_trae_reporte(in id_reporteu int)
begin
select angel.reporte.* from angel.reporte where binary angel.reporte.id_reporte=id_reporteu;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_registra_pregunta;
delimiter **
create procedure sp_registra_pregunta(in txtu varchar(300),in correou varchar(100))
begin
declare id_usuau int;
set id_usuau=(select angel.usuario.id_usuario from angel.usuario where binary angel.usuario.correo=correou);
insert into angel.preguntas values(0,txtu,id_usuau);
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_preguntas;
delimiter **
create procedure sp_trae_preguntas()
begin
select angel.preguntas.* from angel.preguntas where angel.preguntas.id_pregunta not in(select angel.respuestas.id_pregunta from angel.respuestas);
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_pregunta;
delimiter **
create procedure sp_trae_pregunta(in id_preguntau int)
begin
select angel.preguntas.* from angel.preguntas where binary angel.preguntas.id_pregunta=id_preguntau;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_registra_respuesta;
delimiter **
create procedure sp_registra_respuesta(in txtu varchar(300),in id_preguntau int)
begin
insert into angel.respuestas values(0,txtu,id_preguntau);
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_respuestas;
delimiter **
create procedure sp_trae_respuestas()
begin
select angel.respuestas.* from angel.respuestas;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_elimina_pregunta;
delimiter **
create procedure sp_elimina_pregunta(in id_pregunu int)
begin
delete from angel.respuestas where binary angel.respuestas.id_pregunta=id_pregunu;
delete from angel.preguntas where binary angel.preguntas.id_pregunta=id_pregunu;
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_registra_admi;
delimiter **
create procedure sp_registra_admi(in correou varchar(100), in contrau varchar(30), in nombreu varchar(30),in modulou int)
begin
declare existe int;
set existe=(select count(angel.administrador.correo) from angel.administrador where binary angel.administrador.correo=correou);
if(existe=0) then
	insert into angel.administrador values(correou,contrau,nombreu,modulou);
    select 1;
else
	select 2;
end if;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_admi1;
delimiter **
create procedure sp_trae_admi1(in correou varchar(100), in contrau varchar(30))
begin
declare verifica int;
set verifica=(select count(angel.administrador.correo) from angel.administrador where binary angel.administrador.correo=correou and angel.administrador.contra=contrau);
if(verifica>0) then
    select 	angel.administrador.* from angel.administrador where binary angel.administrador.correo=correou;
else
	select 2;
end if;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_admi2;
delimiter **
create procedure sp_trae_admi2(in correou varchar(100))
begin
select 	angel.administrador.* from angel.administrador where binary angel.administrador.correo=correou;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_registra_ticket;
delimiter **
create procedure sp_registra_ticket(in id_usuariou int,in modulou int,in pregunta varchar(300))
begin
insert into angel.tickets values (0,id_usuariou,null,1,modulou,pregunta,'Sin respuesta');
select last_insert_id() from angel.tickets;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_ticket;
delimiter **
create procedure sp_trae_ticket(in id_ticketu int)
begin
select angel.tickets.* from angel.tickets where binary angel.tickets.id_ticket=id_ticketu;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_actualiza_ticket_estado;
delimiter **
create procedure sp_actualiza_ticket_estado(in modulou int)
begin
update angel.tickets set angel.tickets.estado=2 where binary angel.tickets.modulo=modulou and binary angel.tickets.estado=1;
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_tickets;
delimiter **
create procedure sp_trae_tickets(in modulou int)
begin
select angel.tickets.* from angel.tickets where binary angel.tickets.modulo=modulou and binary angel.tickets.respuesta='Sin respuesta';
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_responde_ticket;
delimiter **
create procedure sp_responde_ticket(in id_ticketu int,in correo_admiu varchar(100),in respuestau varchar(300))
begin
update angel.tickets set angel.tickets.correo_admin=correo_admiu,angel.tickets.respuesta=respuestau,angel.tickets.estado=3 where binary angel.tickets.id_ticket=id_ticketu;
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_registra_operador;
delimiter **
create procedure sp_registra_operador(in correou varchar(100),in contrau varchar(30),in nombreu varchar(30),in apellidosu varchar(30))
begin
insert into angel.operador values(correou,contrau,nombreu,apellidosu);
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_operador;
delimiter **
create procedure sp_trae_operador(in correou varchar(100),in contrau varchar(30))
begin
select angel.operador.* from angel.operador where binary angel.operador.correo=correou and binary angel.operador.contra=contrau;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_registra_ingeniero;
delimiter **
create procedure sp_registra_ingeniero(in correou varchar(100),in contrau varchar(30),in nombreu varchar(30),in apellidosu varchar(30))
begin
insert into angel.ingeniero values(correou,contrau,nombreu,apellidosu);
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_ingeniero;
delimiter **
create procedure sp_trae_ingeniero(in correou varchar(100),in contrau varchar(30))
begin
declare verifica int;
set verifica=(select count(angel.gerente.correo_inge) from angel.gerente where binary angel.gerente.correo_inge=correou);
if(verifica=0) then
	select angel.ingeniero.* from angel.ingeniero where binary angel.ingeniero.correo=correou and binary angel.ingeniero.contra=contrau;
else
	select null;
end if;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_ingeniero_sin_contra;
delimiter **
create procedure sp_trae_ingeniero_sin_contra(in correou varchar(100))
begin
declare verifica int;
set verifica=(select count(angel.gerente.correo_inge) from angel.gerente where binary angel.gerente.correo_inge=correou);
if(verifica=0) then
	select angel.ingeniero.* from angel.ingeniero where binary angel.ingeniero.correo=correou;
else
	select null;
end if;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_ingenieros;
delimiter **
create procedure sp_trae_ingenieros()
begin
select angel.ingeniero.* from angel.ingeniero inner join angel.gerente where binary angel.ingeniero.correo!=angel.gerente.correo_inge;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_ingeniero_o_gerente;
delimiter **
create procedure sp_trae_ingeniero_o_gerente(in correou varchar(100))
begin
select angel.ingeniero.* from angel.ingeniero where binary angel.ingeniero.correo=correou;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_registra_gerente;
delimiter **
create procedure sp_registra_gerente(in correou varchar(100),in contrau varchar(30),in nombreu varchar(30),in apellidosu varchar(30))
begin
insert into angel.ingeniero values(correou,contrau,nombreu,apellidosu);
insert into angel.gerente values(correou);
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_gerente;
delimiter **
create procedure sp_trae_gerente(in correou varchar(100),in contrau varchar(30))
begin
declare verifica int;
set verifica=(select count(angel.gerente.correo_inge) from angel.gerente where binary angel.gerente.correo_inge=correou);
if(verifica=1) then
	select angel.ingeniero.* from angel.ingeniero where binary angel.ingeniero.correo=correou and binary angel.ingeniero.contra=contrau;
else
	select null;
end if;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_registra_reporte_evento;
delimiter **
create procedure sp_registra_reporte_evento(in fechau date,in descripcionu varchar(300),in correo_usuau varchar(100))
begin
insert into angel.reporte_evento values(0,fechau,1,descripcionu,'Sin Resolver',null,correo_usuau);
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_reportes_evento_abiertos_sin_asignar;
delimiter **
create procedure sp_trae_reportes_evento_abiertos_sin_asignar()
begin
select * from angel.reporte_evento where angel.reporte_evento.estado=1 and  angel.reporte_evento.correo_inge is null;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_reportes_evento_abiertos_asignados_sin_resolver;
delimiter **
create procedure sp_trae_reportes_evento_abiertos_asignados_sin_resolver()
begin
select angel.reporte_evento.* from angel.reporte_evento where binary angel.reporte_evento.estado=1 and binary angel.reporte_evento.correo_inge is not null and binary angel.reporte_evento.solucion='Sin Resolver';
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_reportes_evento_abiertos_asignados;
delimiter **
create procedure sp_trae_reportes_evento_abiertos_asignados()
begin
select angel.reporte_evento.* from angel.reporte_evento where binary angel.reporte_evento.estado=1 and binary angel.reporte_evento.correo_inge is not null;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_reportes_evento_cerrados_solucionados;
delimiter **
create procedure sp_trae_reportes_evento_cerrados_solucionados()
begin
select angel.reporte_evento.* from angel.reporte_evento where binary angel.reporte_evento.estado=2 and binary angel.reporte_evento.correo_inge is not null;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_asigna_reporte_evento;
delimiter **
create procedure sp_asigna_reporte_evento(in id_reporteu int,in correo_asigu varchar(100))
begin
update angel.reporte_evento set angel.reporte_evento.correo_inge=correo_asigu where binary angel.reporte_evento.id_repor_evento=id_reporteu;
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_asigna_reporte_evento_etiqueta;
delimiter **
create procedure sp_asigna_reporte_evento_etiqueta(in nombre_etiquetau varchar(30),in id_reporteu int)
begin
declare id_etiquetau int;
insert into angel.etiquetas values(0,nombre_etiquetau);
set id_etiquetau=(select last_insert_id());
insert into angel.rela_etiquetas_reporte values(0,id_reporteu,id_etiquetau,0);
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_relaciona_reporte_evento_etiqueta;
delimiter **
create procedure sp_relaciona_reporte_evento_etiqueta(in id_etiquetau int,in id_reporteu int)
begin
declare cantidad_n int;
set cantidad_n=(select angel.rela_etiquetas_reporte.cantidad from angel.rela_etiquetas_reporte where binary angel.rela_etiquetas_reporte.id_etiqueta=id_etiquetau);
set cantidad_n=(cantidad_n+1);
update angel.rela_etiquetas_reporte set angel.rela_etiquetas_reporte.cantidad=angel.rela_etiquetas_reporte.cantidad+1 where binary angel.rela_etiquetas_reporte.id_etiqueta=id_etiquetau;
delete angel.reporte_evento from angel.reporte_evento where binary angel.reporte_evento.id_repor_evento=id_reporteu;
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_cantidad_etiqueta;
delimiter **
create procedure sp_trae_cantidad_etiqueta(in id_etiquetau int)
begin
select angel.rela_etiquetas_reporte.cantidad from angel.rela_etiquetas_reporte where binary angel.rela_etiquetas_reporte.id_etiqueta=id_etiquetau;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_get_relacion_reporte_evento_etiqueta;
delimiter **
create procedure sp_get_relacion_reporte_evento_etiqueta(in id_reporteu int)
begin
select angel.etiquetas.* from angel.etiquetas inner join angel.rela_etiquetas_reporte where binary angel.rela_etiquetas_reporte.id_reporte_evento=id_reporteu  and binary angel.rela_etiquetas_reporte.id_etiqueta=angel.etiquetas.id_etiqueta;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_etiquetas_todas;
delimiter **
create procedure sp_trae_etiquetas_todas()
begin
select angel.etiquetas.* from angel.etiquetas;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_cerrar_reporte_evento;
delimiter **
create procedure sp_cerrar_reporte_evento(in id_reporteu int)
begin
update angel.reporte_evento set angel.reporte_evento.estado=2 where binary angel.reporte_evento.id_repor_evento=id_reporteu;
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_reportes_evento_sin_responder_ingeniero;
delimiter **
create procedure sp_trae_reportes_evento_sin_responder_ingeniero(in correo_ingeu varchar(100))
begin
select angel.reporte_evento.* from angel.reporte_evento where binary angel.reporte_evento.solucion='Sin Resolver' and binary angel.reporte_evento.correo_inge=correo_ingeu;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_reportes_evento_respondidos_ingeniero;
delimiter **
create procedure sp_trae_reportes_evento_respondidos_ingeniero(in correo_ingeu varchar(100))
begin
select angel.reporte_evento.* from angel.reporte_evento where binary angel.reporte_evento.solucion!='Sin Resolver' and binary angel.reporte_evento.correo_inge=correo_ingeu;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_reporte_evento_abierto;
delimiter **
create procedure sp_trae_reporte_evento_abiertos(in id_reporteu int)
begin
select angel.reporte_evento.* from angel.reporte_evento where binary angel.reporte_evento.estado=1 and binary angel.reporte_evento.id_repor_evento=id_reporteu;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_reporte_evento_cerrado;
delimiter **
create procedure sp_trae_reporte_evento_cerrado(in id_reporteu int)
begin
select angel.reporte_evento.* from angel.reporte_evento where binary angel.reporte_evento.estado=2 and binary angel.reporte_evento.id_repor_evento=id_reporteu;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_soluciona_reporte_evento;
delimiter **
create procedure sp_soluciona_reporte_evento(in id_reporteu int,in solucionu varchar(300))
begin
update angel.reporte_evento set angel.reporte_evento.solucion=solucionu where binary angel.reporte_evento.id_repor_evento=id_reporteu;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/