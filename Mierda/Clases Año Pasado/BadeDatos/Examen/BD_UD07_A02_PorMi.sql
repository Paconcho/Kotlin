-- Ejercicio 1.1
USE traballadores;

DROP PROCEDURE IF EXISTS actualizarEmpregadosDepartamento;
DELIMITER //

CREATE PROCEDURE actualizarEmpregadosDepartamento()
BEGIN
    -- Actualizamos a columna depEmpregados de todos os departamentos
    UPDATE departamento d
    SET d.depEmpregados = (
        SELECT COUNT(*) 
        FROM empregado e 
        WHERE e.empDepartamento = d.depCodigo -- Axusta 'depCodigo' se a PK se chama de outro xeito
    );
END //
DELIMITER ;

-- Ejercicio 1.2
USE utilidades;

DROP PROCEDURE IF EXISTS vertaboas;
DELIMITER //

CREATE PROCEDURE vertaboas(IN pdbNome VARCHAR(100))
BEGIN
    IF (pdbNome = '*') THEN 
        SELECT table_schema, table_name, table_type, engine, table_rows
        FROM information_schema.tables
        ORDER BY table_schema, table_name;
    ELSE
        -- Comprobamos se o esquema existe
        IF EXISTS (
            SELECT schema_name 
            FROM information_schema.schemata
            WHERE schema_name = pdbNome
        ) THEN 
            SELECT table_name, table_type, engine, table_rows
            FROM information_schema.tables
            WHERE table_schema = pdbNome
            ORDER BY table_name;
        ELSE
            -- Mensaxe exacta solicitada en galego
            SELECT CONCAT(' A base de datos ', pdbNome, ' non existe no servidor ') AS mensaje_error;
        END IF;
    END IF;
END //
DELIMITER ;

-- Ejercicio 1.3
USE tendaBD;

DROP PROCEDURE IF EXISTS CargarDatosProbaVendas;
DELIMITER //

CREATE PROCEDURE CargarDatosProbaVendas(IN p_num_filas INT)
BEGIN
    DECLARE i INT DEFAULT 0;
    DECLARE v_cliente INT;
    DECLARE v_tenda INT;
    DECLARE v_empregado INT;

    WHILE i < p_num_filas DO
        -- Obtemos un código aleatorio de cada táboa
        SET v_cliente = (SELECT clt_id FROM clientes ORDER BY RAND() LIMIT 1);
        SET v_tenda = (SELECT tda_id FROM tendas ORDER BY RAND() LIMIT 1);
        SET v_empregado = (SELECT emp_id FROM empregados ORDER BY RAND() LIMIT 1);

        -- Inserimos omitindo ven_id e ven_factura
        INSERT INTO vendas (ven_cliente, ven_tenda, ven_empregado, ven_data)
        VALUES (v_cliente, v_tenda, v_empregado, NOW());

        SET i = i + 1;
    END WHILE;

    SELECT CONCAT('Inseríronse correctamente ', p_num_filas, ' filas de proba.') AS Resultado;
END //
DELIMITER ;

-- Ejercicio 1.4
USE tendaBD;

-- 1. CREACIÓN DE TÁBOAS SEGUNDO ENUNCIADO (Corrixindo 'contrasenna' por 'password')
CREATE TABLE IF NOT EXISTS usuario (
    login VARCHAR(16) NOT NULL, 
    password CHAR(40) NOT NULL,
    PRIMARY KEY (login)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS log_erro_conexion (
    id INT UNSIGNED AUTO_INCREMENT NOT NULL,
    login VARCHAR(16) NOT NULL, 
    password CHAR(40) NOT NULL,
    data_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id)
) ENGINE = InnoDB;

TRUNCATE usuario; -- Limpamos para as probas
INSERT INTO usuario VALUES ('pepe', 'pepePass'), ('luisa', 'luisaPass');


DROP PROCEDURE IF EXISTS controlarIntentosErrados;
DELIMITER //

CREATE PROCEDURE controlarIntentosErrados(
    IN p_login VARCHAR(16), 
    IN p_password CHAR(40), 
    OUT p_resultado INT
)
BEGIN
    DECLARE v_existe INT;
    DECLARE v_intentos INT DEFAULT 0;
    DECLARE v_pass_bloqueo CHAR(40) DEFAULT 'H347B52(((]ERR';
   
    -- Comprobar se coincide login e password
    SELECT COUNT(*) INTO v_existe
    FROM usuario
    WHERE login = p_login AND password = p_password;
   
    IF v_existe > 0 THEN 
        SET p_resultado = 0; -- Éxito
    ELSE
        -- Se falla, rexistramos o erro
        INSERT INTO log_erro_conexion (login, password, data_hora)
        VALUES (p_login, p_password, NOW());
         
        -- Contamos cantos fallos leva nos últimos 3 minutos (usando TIMESTAMPDIFF)
        SELECT COUNT(*) INTO v_intentos
        FROM log_erro_conexion
        WHERE login = p_login 
          AND TIMESTAMPDIFF(MINUTE, data_hora, NOW()) <= 3;
         
        -- Se supera os 5 intentos cambiamos o password ao de bloqueo
        IF v_intentos > 5 THEN 
            UPDATE usuario 
            SET password = v_pass_bloqueo 
            WHERE login = p_login;
            
            SET p_resultado = 2; -- Bloqueado
        ELSE 
            SET p_resultado = 1; -- Erro sen bloqueo aínda
        END IF;
    END IF;
END //
DELIMITER ;

-- Ejercicio 2.1
USE utilidades;

DROP FUNCTION IF EXISTS nombre_mes_Galego;
DELIMITER //
CREATE FUNCTION nombre_mes_Galego(nMes INT)
RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
    DECLARE nombre VARCHAR(20);
    CASE nMes
        WHEN 1 THEN SET nombre = 'Xaneiro';
        WHEN 2 THEN SET nombre = 'Febreiro';
        WHEN 3 THEN SET nombre = 'Marzo';
        WHEN 4 THEN SET nombre = 'Abril';
        WHEN 5 THEN SET nombre = 'Maio';
        WHEN 6 THEN SET nombre = 'Xuño';
        WHEN 7 THEN SET nombre = 'Xullo';
        WHEN 8 THEN SET nombre = 'Agosto';
        WHEN 9 THEN SET nombre = 'Setembro';
        WHEN 10 THEN SET nombre = 'Outubro';
        WHEN 11 THEN SET nombre = 'Novembro';
        WHEN 12 THEN SET nombre = 'Decembro';
        ELSE SET nombre = 'Mes non válido';
    END CASE;
    RETURN nombre;
END
//
DELIMITER ;

-- Probas
SELECT nombre_mes_Galego(11) AS Mes;
SELECT nombre_mes_Galego(month(curdate())) AS MesActual;

-- Ejercicio 2.2
DROP FUNCTION IF EXISTS rangoNotas;
DELIMITER //
CREATE FUNCTION rangoNotas(pnNota DECIMAL(4,2))
RETURNS VARCHAR(20) DETERMINISTIC
BEGIN
    DECLARE valoracion VARCHAR(20);
    CASE 
        WHEN pnNota >= 0 AND pnNota < 5 THEN SET valoracion = 'suspenso';
        WHEN pnNota >= 5 AND pnNota < 6 THEN SET valoracion = 'aprobado';
        WHEN pnNota >= 6 AND pnNota < 7 THEN SET valoracion = 'ben';
        WHEN pnNota >= 7 AND pnNota < 9 THEN SET valoracion = 'notable';
        WHEN pnNota >= 9 AND pnNota <= 10 THEN SET valoracion = 'sobresaínte';
        ELSE SET valoracion = 'erro na nota';
    END CASE;
    RETURN valoracion;
END
//
DELIMITER ;

-- Probas
SELECT rangoNotas(4.5) AS Nota, rangoNotas(9.75) AS Nota2, rangoNotas(11) AS Nota3;

-- Ejercicio 2.3
DROP FUNCTION IF EXISTS defineLetraDNI;
DELIMITER //
CREATE FUNCTION defineLetraDNI(nDni INT)
RETURNS CHAR(1)
BEGIN
    DECLARE cadenaLetras VARCHAR(23) DEFAULT 'TRWAGMYFPDXBNJZSQVHLCKE';
    DECLARE valorNumero INT;
    
    SET valorNumero = nDni % 23;
    RETURN SUBSTRING(cadenaLetras, valorNumero + 1, 1);
END
//
DELIMITER ;

-- Proba
SELECT defineLetraDNI(78945872) AS LetraDNI;

-- Ejercicio 2.4
DROP FUNCTION IF EXISTS letraNIE;
DELIMITER //
CREATE FUNCTION letraNIE(nNie VARCHAR(8))
RETURNS CHAR(1) DETERMINISTIC
BEGIN
    DECLARE n CHAR(1);
    DECLARE cadenaLetras VARCHAR(23) DEFAULT 'TRWAGMYFPDXBNJZSQVHLCKE';
    DECLARE numNie BIGINT; 
    DECLARE valorNumero INT; 
    
    -- Substitución da letra inicial polo seu valor numérico correspondente
    IF (LEFT(nNie, 1) = 'X') THEN
        SET n = '0';
    ELSEIF (LEFT(nNie, 1) = 'Y') THEN
        SET n = '1';
    ELSEIF (LEFT(nNie, 1) = 'Z') THEN
        SET n = '2';
    ELSE 
        RETURN '0'; -- Retorna 0 se o formato non é válido
    END IF;
    
    -- Concatenamos o número transformado cos 7 díxitos numéricos do NIE
    SET numNie = CAST(CONCAT(n, RIGHT(nNie, 7)) AS UNSIGNED);
    SET valorNumero = numNie % 23;
    
    RETURN SUBSTRING(cadenaLetras, valorNumero + 1, 1);
END
//
DELIMITER ;

-- Proba
SELECT letraNIE('X4621164') AS LetraNIE;

-- Ejercicio 2.5
DROP FUNCTION IF EXISTS calcularIBAN;
DELIMITER //
CREATE FUNCTION calcularIBAN(p_ccc CHAR(20))
RETURNS CHAR(24) DETERMINISTIC
BEGIN
    DECLARE v_valores_es CHAR(6) DEFAULT '142800'; -- 'E'=14, 'S'=28, '00'=00
    DECLARE v_bloque1 BIGINT;
    DECLARE v_bloque2 BIGINT;
    DECLARE v_resto INT;
    DECLARE v_control INT;
    DECLARE v_control_texto CHAR(2);

    -- Dividimos a cadea enorme en dous bloques manipulables matematicamente para simular o módulo 97
    -- Bloque 1: Primeiros 12 díxitos do CCC
    SET v_bloque1 = CAST(LEFT(p_ccc, 12) AS UNSIGNED);
    SET v_resto = v_bloque1 % 97;

    -- Bloque 2: Resto anterior + seguintes 8 díxitos do CCC + o valor de 'ES00' (142800)
    SET v_bloque2 = CAST(CONCAT(v_resto, RIGHT(p_ccc, 8), v_valores_es) AS UNSIGNED);
    SET v_resto = v_bloque2 % 97;

    -- O díxito de control do IBAN é 98 menos o resto do módulo 97
    SET v_control = 98 - v_resto;

    -- Aseguramos que teña dous díxitos (se é menor que 10, engadimos un cero á esquerda)
    IF v_control < 10 THEN
        SET v_control_texto = CONCAT('0', v_control);
    ELSE
        SET v_control_texto = CAST(v_control AS CHAR(2));
    END IF;

    -- Devolvemos o IBAN completo formado por ES + díxitos de control + Código de Conta (CCC)
    RETURN CONCAT('ES', v_control_texto, p_ccc);
END
//
DELIMITER ;

-- Proba (Cambia os 20 díxitos pola túa conta de proba)
SELECT calcularIBAN('21000418450200051332') AS IBAN;

-- Ejercicio 3.1
ALTER PROCEDURE utilidades.vertaboas
COMMENT 'Mostra a información das táboas das bases de datos que se pasan como parámetro'
SQL SECURITY INVOKER;

-- Ejercicio 3.2
DROP FUNCTION IF EXISTS utilidades.letraNIE;



 