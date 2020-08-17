
drop procedure if exists sp_registra_reporte_mantenimiento_sin_asignar;
delimiter **
create procedure sp_registra_reporte_mantenimiento_sin_asignar(in fechau date,in descripcionu varchar(300),in tipou varchar(10))
begin
insert into angel.reporte_mantenimiento values(0,fechau,3,descripcionu,'Sin Resolver',tipou,'Sin asignar');
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_trae_reportes_mantenimiento_abiertos_asignados;
delimiter **
create procedure sp_trae_reportes_mantenimiento_abiertos_asignados()
begin
select angel.reporte_mantenimiento.* from angel.reporte_mantenimiento where binary angel.reporte_mantenimiento.estado=1 or angel.reporte_mantenimiento.estado=3;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
drop procedure if exists sp_soluciona_especial;
delimiter **
create procedure sp_soluciona_especial(in id_reporteu int,in solucionu varchar(300))
begin
update angel.reporte_mantenimiento set angel.reporte_mantenimiento.estado=3,angel.reporte_mantenimiento.solucion=solucionu where binary angel.reporte_mantenimiento.id_repor_mantenimiento=id_reporteu;
select 1;
end;**
delimiter ;
/*---------------------------------------------------------------------------*/
select * from reporte_mantenimiento;