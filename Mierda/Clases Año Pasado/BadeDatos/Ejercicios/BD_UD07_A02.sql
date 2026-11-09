-- Ejercicio 1
use traballadores;

DELIMITER //
CREATE PROCEDURE ActualizarEmpleados()
BEGIN

	UPDATE departamento d
    SET d.depEmpregados = (
    SELECT COUNT(*)
    FROM empregado e
    WHERE e.empDepartamento = d.depNumero
    );
END //
    
DELIMITER ;

-- Ejercicio 2
use utilidades;

DELIMITER //
CREATE PROCEDURE vertablas(IN p_nome_bd VARCHAR(64))
BEGIN

	IF p_nome_bd = '*' THEN
		SELECT table_schema, table_name, table_type, engine, table_rows
        FROM information_schema.tables
        ORDER BY table_schema, table_name;
	ELSE 
		IF EXISTS (SELECT 1 FROM informacion_schema.schemata WHERE schema_name = p_nome_bd) THEN
        SELECT table_name, table_type, engine, table_rows
            FROM information_schema.tables
            WHERE table_schema = p_nome_bd
            ORDER BY table_name;
            ELSE
				SELECT CONCAT('A base de datos ', p_nome_bd, ' non existe no servidor') AS Erro;
        END IF;
        END IF;
END //

DELIMITER ;

-- Ejercicio 3
use tendabd;

DELIMITER //

CREATE PROCEDURE CargarDatosProbaVendas(IN p_num_filas INT)
BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE ven_cliente INT;
    DECLARE ven_tenda INT;
    DECLARE ven_empregado INT;


    WHILE i < p_num_filas DO
        
        SET ven_cliente = (SELECT clt_id FROM clientes ORDER BY RAND() LIMIT 1);
        SET ven_tenda = (SELECT tda_id FROM tendas ORDER BY RAND() LIMIT 1);
        SET ven_empregado = (SELECT emp_id FROM empregados ORDER BY RAND() LIMIT 1);

        INSERT INTO vendas (ven_cliente, ven_tenda, ven_empregado, ven_data)
        VALUES (ven_cliente, ven_tenda, ven_empregado, CURDATE());
        
        SET i = i + 1;
    END WHILE;
    
    SELECT CONCAT('Inseríronse correctamente ', p_num_filas, ' filas de proba.') AS Resultado;
END //

DELIMITER ;

-- Ejercicio 4

delimiter // 
create function rangoNotas(nNota float)
returns varchar(20)
begin
	declare valoracion varchar(20);
	case 
		when nNota >= 0 and nNota < 5 then set valoracion = 'Suspenso';
    when nNota >= 5 and nNota < 6 then set valoracion = 'Aprobado';
    when nNota >= 6 and nNota < 7 then set valoracion = 'Bien';
    when nNota >= 7 and nNota < 9 then set valoracion = 'Notable';
    when nNota >= 9 and nNota <= 10 then set valoracion = 'Sobresaliente';
    else set valoracion = 'Valor fuera de rango';
  end case;
	return valoracion;
end
//
delimiter ;

select rangoNotas(7.5) as Valoracion;


	
DELIMITER //



CREATE FUNCTION utilidades.obter_letra_dni(numero_dni INT) 
RETURNS CHAR(1)
DETERMINISTIC
BEGIN
    DECLARE letras CHAR(23);
    DECLARE resto INT;
    DECLARE letra CHAR(1);

    -- Definimos a cadea coas letras na orde correspondente (0-22)
    SET letras = 'TRWAGMYFPDXBNJZSQVHLCKE';
    
    -- Calculamos o resto da división por 23
    SET resto = numero_dni % 23;
    
    -- Extraemos a letra. En SQL, a función SUBSTRING empeza na posición 1,
    -- polo que sumamos 1 ao resto.
    SET letra = SUBSTRING(letras, resto + 1, 1);
    
    RETURN letra;
END //

DELIMITER ;
		

