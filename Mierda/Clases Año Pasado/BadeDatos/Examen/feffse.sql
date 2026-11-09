use utilidades;
drop function if exists letraDNI;
DELIMITER //

create function letraDNI(nDNI int)
returns char(1)
BEGIN
	declare cadenaLetras varchar(23) default 'TRWAGMYFPDXBNJZSQVHLCKE';
	declare valor int;
    set valor = nDNI % 23;
    return substring(cadenaLetras, valor + 1, 1);
END //
DELIMITER ;
