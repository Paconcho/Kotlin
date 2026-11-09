-- Ejercicio 1
USE practicas1;

DROP TRIGGER IF EXISTS empregadoBI;
DELIMITER //

CREATE TRIGGER empregadoBI
BEFORE INSERT ON empregado
FOR EACH ROW
BEGIN
    DECLARE v_letras CHAR(23) DEFAULT 'TRWAGMYFPDXBNJZSQVHLCKE';
    DECLARE v_numero INT;
    DECLARE v_letra_correcta CHAR(1);
    DECLARE v_letra_introducida CHAR(1);

    -- Extraemos a parte numérica e a letra introducida
    SET v_numero = CAST(LEFT(NEW.dni, 8) AS UNSIGNED);
    SET v_letra_introducida = UPPER(RIGHT(NEW.dni, 1));
    
    -- Calculamos cal debería ser a letra correcta
    SET v_letra_correcta = SUBSTRING(v_letras, (v_numero % 23) + 1, 1);

    -- Se non coinciden, lanzamos un erro para abortar o INSERT
    IF v_letra_introducida != v_letra_correcta THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'DNI non válido';
    END IF;
END //
DELIMITER ;

-- Ejercicio 2
USE practicas1;

-- 1. Mostrar TODOS os disparadores asociados á base de datos practicas1
SHOW TRIGGERS FROM practicas1;

-- 2. Mostrar a información específica do disparador empregadoBI
SELECT * FROM information_schema.triggers 
WHERE trigger_schema = 'practicas1' AND trigger_name = 'empregadoBI';

-- Ejercicio 3
USE tendabd;

-- 1. Disparador para o INSERT (Nova venda)
DROP TRIGGER IF EXISTS actualizar_vendas_insert;
DELIMITER //
CREATE TRIGGER actualizar_vendas_insert
AFTER INSERT ON vendas
FOR EACH ROW
BEGIN
    UPDATE clientes 
    SET clt_vendas = clt_vendas + 1,
        clt_ultima_venda = NEW.ven_data
    WHERE clt_id = NEW.ven_cliente;
END //
DELIMITER ;


-- 2. Disparador para o DELETE (Se se anula unha venda)
DROP TRIGGER IF EXISTS actualizar_vendas_delete;
DELIMITER //
CREATE TRIGGER actualizar_vendas_delete
AFTER DELETE ON vendas
FOR EACH ROW
BEGIN
    UPDATE clientes 
    SET clt_vendas = clt_vendas - 1,
        -- Buscamos a nova última data de venda que lle queda a ese cliente, se non lle quedan será NULL
        clt_ultima_venda = (SELECT MAX(ven_data) FROM vendas WHERE ven_cliente = OLD.ven_cliente)
    WHERE clt_id = OLD.ven_cliente;
END //
DELIMITER ;


-- 3. Disparador para o UPDATE (Se unha venda cambia de cliente)
DROP TRIGGER IF EXISTS actualizar_vendas_update;
DELIMITER //
CREATE TRIGGER actualizar_vendas_update
AFTER UPDATE ON vendas
FOR EACH ROW
BEGIN
    -- Se cambiou o cliente da venda
    IF OLD.ven_cliente != NEW.ven_cliente THEN
        -- Restamos ao cliente vello
        UPDATE clientes 
        SET clt_vendas = clt_vendas - 1,
            clt_ultima_venda = (SELECT MAX(ven_data) FROM vendas WHERE ven_cliente = OLD.ven_cliente)
        WHERE clt_id = OLD.ven_cliente;
        
        -- Sumamos ao cliente novo
        UPDATE clientes 
        SET clt_vendas = clt_vendas + 1,
            clt_ultima_venda = NEW.ven_data
        WHERE clt_id = NEW.ven_cliente;
    END IF;
END //
DELIMITER ;

-- Ejercicio 4
USE traballadores;

-- Creamos a táboa de rexistro facilitada no enunciado
CREATE TABLE IF NOT EXISTS traballadores.rexistroOperacions (
    idOperacion INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
    usuario CHAR(100), 
    dataHora DATETIME, 
    taboa CHAR(50), 
    operacion CHAR(6), 
    PRIMARY KEY (idOperacion)
) ENGINE = MyISAM;


-- DISPARADORES PARA A TÁBOA DEPARTAMENTO
-- 1. Auditoría INSERT
DROP TRIGGER IF EXISTS audita_depto_insert;
DELIMITER //
CREATE TRIGGER audita_depto_insert
AFTER INSERT ON departamento
FOR EACH ROW
BEGIN
    INSERT INTO rexistroOperacions (usuario, dataHora, taboa, operacion)
    VALUES (USER(), NOW(), 'departamento', 'INSERT');
END //
DELIMITER ;

-- 2. Auditoría UPDATE
DROP TRIGGER IF EXISTS audita_depto_update;
DELIMITER //
CREATE TRIGGER audita_depto_update
AFTER UPDATE ON departamento
FOR EACH ROW
BEGIN
    INSERT INTO rexistroOperacions (usuario, dataHora, taboa, operacion)
    VALUES (USER(), NOW(), 'departamento', 'UPDATE');
END //
DELIMITER ;

-- 3. Auditoría DELETE
DROP TRIGGER IF EXISTS audita_depto_delete;
DELIMITER //
CREATE TRIGGER audita_depto_delete
AFTER DELETE ON departamento
FOR EACH ROW
BEGIN
    INSERT INTO rexistroOperacions (usuario, dataHora, taboa, operacion)
    VALUES (USER(), NOW(), 'departamento', 'DELETE');
END //
DELIMITER ;

-- Ejercicio 5
USE traballadores;

DROP TRIGGER IF EXISTS departamento_borrado_fervenza;
DELIMITER //

CREATE TRIGGER departamento_borrado_fervenza
BEFORE DELETE ON departamento
FOR EACH ROW
BEGIN
    -- Borramos todos os empregados cuxo departamento coincida co número do departamento que imos borrar
    DELETE FROM empregado 
    WHERE empDepartamento = OLD.depNumero;
END //
DELIMITER ;

-- Ejercicio 6
DROP TRIGGER IF EXISTS practicas1.empregadoBI;