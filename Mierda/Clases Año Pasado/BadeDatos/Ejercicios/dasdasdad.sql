use tendabd;
SELECT 
    v.ven_id AS 'ID Venta', 
    v.ven_data AS 'Fecha Venta', 
    c.clt_id AS 'ID Cliente', 
    c.clt_nome AS 'Nombre Cliente',
    c.clt_ultima_venda AS 'Última venta guardada en su ficha'
FROM vendas v
JOIN clientes c ON v.ven_cliente = c.clt_id
ORDER BY v.ven_data DESC;

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

SELECT ven_id, ven_cliente, ven_data FROM vendas WHERE ven_cliente = 1;
INSERT INTO vendas (ven_cliente, ven_data, ven_total) 
VALUES (1, NOW(), 50.00);