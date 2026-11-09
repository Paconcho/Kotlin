-- Tarefa 1
DELIMITER //
CREATE PROCEDURE Exercicio1()
BEGIN
    DECLARE vNumero INT DEFAULT 0;
    
    DECLARE claveDuplicada CONDITION FOR 1062;
    
    DECLARE vFinal BIT DEFAULT 0;
    
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET vFinal = 1;
    
    SELECT vNumero, vFinal;
END //
DELIMITER ;

-- Tarefa 2
DROP PROCEDURE IF EXISTS asignaValores;
DELIMITER //
CREATE PROCEDURE asignaValores()
BEGIN
    DECLARE vEstado VARCHAR(20);
    DECLARE vNomeProvincia VARCHAR(50);
    
    SET vEstado = 'servido';
    
    SET @idade = 26;
    
    SET @@autocommit = 0; -- Equivale a OFF
    
    SELECT nomeProvincia INTO vNomeProvincia
    FROM utilidades.provincia
    WHERE codigo = 15;

    SELECT vEstado, @idade, @@autocommit, vNomeProvincia;
END //
DELIMITER ;

CALL asignaValores();

-- Tarefa 3
DELIMITER //
CREATE PROCEDURE Tarefa3(IN vNumero INT)
BEGIN
    IF vNumero > 0 THEN 
        SELECT 'positivo' AS Resultado;
    ELSEIF vNumero < 0 THEN
        SELECT 'negativo' AS Resultado;
    ELSE
        SELECT 'cero' AS Resultado;
    END IF;
END //
DELIMITER ;

-- Tarefa 4
DELIMITER //
CREATE PROCEDURE Tarefa4(IN vCodigo CHAR(1))
BEGIN
    CASE vCodigo
        WHEN 'S' THEN SELECT 'Solteiro/a' AS EstadoCivil;
        WHEN 'C' THEN SELECT 'Casado/a' AS EstadoCivil;
        WHEN 'D' THEN SELECT 'Divorciado/a' AS EstadoCivil;
        WHEN 'V' THEN SELECT 'Viúvo/a' AS EstadoCivil;
        WHEN 'U' THEN SELECT 'Unión Libre/a' AS EstadoCivil;
        WHEN 'P' THEN SELECT 'Separado/a' AS EstadoCivil;
        ELSE SELECT 'Código non válido' AS EstadoCivil;
    END CASE;
END //
DELIMITER ;

-- Tarefa 5
DROP PROCEDURE IF EXISTS contarPares;
DELIMITER //
CREATE PROCEDURE contarPares()
BEGIN
    DECLARE vNumero, vNumeroInicio, vNumeroFinal SMALLINT UNSIGNED;
    DECLARE vContadorPares SMALLINT UNSIGNED DEFAULT 0;
    
    SET vNumeroInicio = 25;
    SET vNumeroFinal = 50;
    SET vNumero = vNumeroInicio;
    
    WHILE vNumero <= vNumeroFinal DO
        IF vNumero % 2 = 0 THEN 
            SET vContadorPares = vContadorPares + 1;
        END IF;
        SET vNumero = vNumero + 1;
    END WHILE;
    
    SELECT vNumeroInicio, vNumeroFinal, vContadorPares;
END //
DELIMITER ;

CALL contarPares();

-- Tarefa 6
DELIMITER //
CREATE PROCEDURE AdiviñarNumero()
BEGIN
    DECLARE vObxectivo INT DEFAULT 42; -- O valor a acertar
    DECLARE vIntento INT;
    DECLARE vContador INT DEFAULT 0;
    
    REPEAT
        -- Xeramos un número aleatorio entre 1 e 100
        SET vIntento = FLOOR(1 + (RAND() * 100));
        SET vContador = vContador + 1;
    UNTIL vIntento = vObxectivo
    END REPEAT;
    
    SELECT vObxectivo AS 'Número a acertar', vContador AS 'Intentos totais';
END //
DELIMITER ;

CALL AdiviñarNumero();

-- Tarefa 7.1: Inserción dinámica
SET @codigo = 36;
SET @nome = 'Pontevedra';

SET @sql_insert = 'INSERT INTO utilidades.provincia (codigo, nomeProvincia) VALUES (?, ?)';
PREPARE stmt1 FROM @sql_insert;
EXECUTE stmt1 USING @codigo, @nome;
DEALLOCATE PREPARE stmt1;


-- Tarefa 7.2: Mostrar táboas dunha BD variable
SET @nomeBD = 'utilidades';

SET @sql_tables = CONCAT('SHOW TABLES FROM ', @nomeBD);
PREPARE stmt2 FROM @sql_tables;
EXECUTE stmt2;
DEALLOCATE PREPARE stmt2;