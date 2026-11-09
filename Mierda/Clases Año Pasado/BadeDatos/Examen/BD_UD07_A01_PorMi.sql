-- Ejercicio 1
drop procedure if exists ejemploVariable;
DELIMITER //

CREATE PROCEDURE ejemploVariable()
BEGIN
declare VNumero int default 0;
declare Duplicada condition for 1062;
declare vFinal bit default 0;
declare continue handler for not found set vFinal = 1;
select vNumero, vFinal;

END
//
DELIMITER ;

call ejemploVariable();

-- Ejercicio2
drop procedure if exists asignarValores;
use utilidades;
DELIMITER //

CREATE PROCEDURE asignarValores()
BEGIN
	declare vEstado varchar(30) default 'servido';
    declare idade int;
	declare vNomeProvincia varchar(60);
    set @idade = 26;
    set @@autocommit = 'off';

    select pro_nome INTO vNomeProvincia
    from utilidades.provincias
    where pro_id = 15;
END
//
DELIMITER ;

call asignarValores(); 

-- Ejercicio3
drop procedure if exists comprobarNumero;
DELIMITER //

create procedure comprobarNumero()
BEGIN
declare vNumero int;
set vNumero = -85;
	if vNumero > 0 then
		select 'positivo' as Resultado;
	elseif vNumero < 0 then
		select 'negativo' as Resultado;
	else 
		select 'cero' as Resultado;
	end if;
end //
DELIMITER ; 

call comprobarNumero();

-- Ejercicio4
drop procedure if exists mostrarEstado;
DELIMITER //

create procedure mostrarEstado()
BEGIN
	declare vCodigo CHAR default 'V';
    declare vDescripcion varchar(20);
    
    set vDescripcion = case vCodigo
		when 'S' then 'Soltero/a'
        when 'C' then 'Casado/a'
        when 'D' then 'Divorciado/a'
        when 'V' then 'Viudo/a'
        when 'U' then 'Union Libre/a'
        when 'P' then 'Separado/a'
	else 'Codigo desconocido'
    END;
    
    select vCodigo as Codigo, vDescripcion as EstadoCivil;
END //

DELIMITER ;

call mostrarEstado();

-- Ejercicio5
drop procedure if exists contarPares;
DELIMITER //

create procedure contarPares()
BEGIN
	declare vNumero, vNumeroInicio, vNumeroFinal smallint unsigned;
	declare vContadorPares smallint unsigned default 0;
    
	set vNumeroInicio = 25;
    set vNumeroFinal = 50;
    set vNumero = vNumeroInicio;
    while vNumero <= vNumeroFinal do
		if vNumero % 2 = 0 then
			set vContadorPares = vContadorPares + 1;
		end if;
        set vNumero= vNumero + 1;
	end while;
    select vNumeroInicio, vNumeroFinal, vContadorPares;
end//
DELIMITER ; 

call contarPares();
    
-- Ejercicio6
drop procedure if exists adivinaNumero;
DELIMITER //

create procedure adivinaNumero()
BEGIN
	declare vNumeroAdivinar int default 12;
    declare vNumeroIntentos int default 0;
    declare vNumeroAleatorio int unsigned;
    
    repeat
		set vNumeroAleatorio = floor(1 + (Rand() * 100));
        set vNumeroIntentos = vNumeroIntentos + 1;
		until vNumeroAleatorio = vNumeroAdivinar
    end repeat;
    
    select vNumeroIntentos as Intentos;
end;

//
DELIMITER ;
call adivinaNumero();

-- Ejercicio7.1
select * from provincias;

prepare insertarDatos from 'insert into provincias (pro_id, pro_nome) values (?, ?)';
set @codigo = 55;
set @nombre = 'Gibraltar';
execute insertarDatos using @codigo, @nombre;

select * from provincias;

deallocate prepare insertarDatos;

-- Ejercicio7.2
set @nomeBD = 'utilidades';
set @sql = concat(
	'select table_name
    from information_schema.tables
    where table_schema = ''' ,@nomeBD, ''''
);

prepare listarTaboas from @sql;
execute listarTaboas;

deallocate prepare listarTaboas;