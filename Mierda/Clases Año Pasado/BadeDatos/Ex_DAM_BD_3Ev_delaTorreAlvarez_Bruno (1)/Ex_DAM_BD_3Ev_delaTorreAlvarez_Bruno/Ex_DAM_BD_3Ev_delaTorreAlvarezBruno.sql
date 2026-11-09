use bd_peluqeria;

-- Ejercicio 1
drop procedure if exists ServiciosHoy;
DELIMITER //

create procedure ServiciosHoy()
BEGIN
	select clt.nombre as Nombrecliente, sv.tipo_servicio as servicio,  emp.nombre as empleado
	from tbl_servicios as sv
    join tbl_empleados as emp on sv.nif_empleado = emp.nif
	join tbl_clientes as clt on sv.nif_cliente = clt.nif
    where date(sv.fecha_servicio) = CURDATE();
END //
DELIMITER ; 

call ServiciosHoy();

-- Ejercicio 2
drop procedure if exists NuevoServicio;
DELIMITER //

create procedure NuevoServicio(
in clt_nif varchar(9),
in clt_nombre varchar(30),
in clt_apellido1 varchar(30),
in clt_apellido2 varchar(30),
in clt_direccion varchar(60),
in clt_telefono varchar(9),
in emp_nif varchar(9),
in sv_fecha_servicio datetime,
in sv_tipo_servivio varchar(50),
in sv_valoracion varchar(100)
)
BEGIN
	declare continue handler for SQLSTATE '23000'
	select 'El cliente existe' as 'duplicado'; 
	
    insert into tbl_clientes(nif, nombre, apellido1, apellido2, direccion, telefono) values (clt_nif, clt_nombre, clt_apellido1, clt_apellido2, clt_direccion, clt_telefono);
	insert into tbl_empleados(nif) values (emp_nif);
    insert into tbl_servicios(nif_cliente, nif_empleado, fecha_servicio, tipo_servicio, valoracion) values (clt_nif, emp_nifsv_fecha_servicio, sv_tipo_servicio, sv_valoracion);
    
END //
DELIMITER ; 

call NuevoServicio('88889999V', 'Carlos', 'Príncipe' ,'Morodo', 'Calle Menor 10', '666111222', 'e00000002', now(), 'Corte y color', 'Buena');
call NuevoServicio('22222222b', 'ana', 'lopez' ,'fernandez', 'avenida galicia 12', '600222222', 'e00000002', '2025-02-02', 'tinte', 'bien');

-- Ejercicio 3
drop trigger if exists ControlBonoBI;
DELIMITER //

create trigger ControlBonoBI
before insert on tbl_servicios
for each row
BEGIN
	 if exists(select 1 from tbl_bonos where nif = new.nif_cliente and cantidad_actual > 0)
     then 
     update tbl_bonos -- hacemos update para refrescar
     set cantidad_actual = cantidad_actual - 1 where nif = new.nif_cliente and cantidad_actual > 0 -- Aqui resto el bono
     limit 1; -- Maximo 1 bono
     end if;
END //
DELIMITER ;

-- Ejercicio 4
drop function if exists fn_ingresos_empleado;
DELIMITER //

create function fn_ingresos_empleado(nif_empleado char(9))
returns decimal(5 , 2) deterministic
BEGIN
	declare servicios_totales smallint;
    declare ingresos decimal (5, 2);
    
    select count(*) into servicios_totales
    from tbl_servicios
    where nif_empleado = emp_nif_empleado;
	
    set ingresos = servicios_totales * 0.35;
    
    return ingresos;

END //
DELIMITER ; 

select fn_ingresos_empleado();

-- Ejercicio 5
drop function if exists fn_comision_variable;
DELIMITER //

create function fn_comision_variable(nif_empleado char(9))
returns int deterministic
BEGIN
	declare tipos int;
    declare porcentaje_incremento int default 0;
    
    select count(distinct tipo_servicio) into tipos
    from tbl_servicios
    where nif_empleado = nif_empleado;
    
    if(tipos) > 2 
    then
    set porcentaje_incremento = 15;
    end if;
	
    return porcentaje_incremento;
END //
DELIMITER ; 

select fn_comision_variable('e00000003') AS incremento;

select nif, nombre, fn_ingresos_empleado(nif) as ingresos_sin_incremento,
					fn_comision_variable(nif) as porcentaje,
                    fn_ingresos_empleado(nif) + (fn_ingresos_empleado(nif) * fn_comision_variable(nif) / 100) as total
from tbl_empleados
where nif = 'e00000001';


-- Ejercicio 6
drop procedure if exists Servicio_Mas_Rentable;

DeLIMITER //
create procedure Servicio_Mas_Rentable()
BEGIN
	select tipo_servicio as servicio,
    count(*) as total_servicios, sum(0.35) as ingresos_totales
    from tbl_servicios group by tipo_servicio
    order by ingresos_totales ASC;
END //
DELIMITER ;

call Servicio_Mas_Rentable();
