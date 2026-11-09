Enunciado: Para cumplir con normativas de calidad, crea una función llamada 
f_generar_ticket_control que reciba el nif_cliente, el nif_empleado y la fecha de un 
servicio de la tabla tbl_servicios. Debe extraer la parte numérica de ambos NIFs, 
concatenarlos junto con el año y mes del servicio, y calcular el código de control final 
aplicando el residuo de la división entre 97. La función debe retornar la cadena formateada: TK-Resto-Año.


SQL
DROP FUNCTION IF EXISTS f_generar_ticket_control;
DELIMITER //
CREATE FUNCTION f_generar_ticket_control(
    p_cliente CHAR(9), 
    p_empleado CHAR(9), 
    p_fecha DATETIME
)
RETURNS VARCHAR(30) DETERMINISTIC
BEGIN
    DECLARE v_num_cli VARCHAR(8);
    DECLARE v_num_emp VARCHAR(8);
    DECLARE v_cadena_completa VARCHAR(30);
    DECLARE v_bloque1 BIGINT;
    DECLARE v_bloque2 BIGINT;
    DECLARE v_resto INT;

    -- Extraemos solo los números ignorando la letra final (Como hacías en el NIE/DNI)
    SET v_num_cli = LEFT(p_cliente, 8);
    SET v_num_emp = RIGHT(p_empleado, 8); -- Asumiendo formato 'e00000001' extrae los 8 números

    -- Concatenamos todo junto al año y mes para generar la mega-cadena numérica
    SET v_cadena_completa = CONCAT(v_num_cli, v_num_emp, DATE_FORMAT(p_fecha, '%Y%m'));

    -- Simulamos el módulo por bloques porque supera el rango máximo de almacenamiento entero de MySQL
    SET v_bloque1 = CAST(LEFT(v_cadena_completa, 10) AS UNSIGNED);
    SET v_resto = v_bloque1 % 97;
    
    SET v_bloque2 = CAST(CONCAT(v_resto, RIGHT(v_cadena_completa, 10)) AS UNSIGNED);
    SET v_resto = v_bloque2 % 97;

    RETURN CONCAT('TK-', v_resto, '-', YEAR(p_fecha));
END //
DELIMITER ;

Enunciado: Crea un procedimiento en bd_peluqueria llamado sp_control_acceso_empleado que reciba el nif del empleado y un código pin de acceso (puedes usar el teléfono como pin para la prueba).

Si coincide, el parámetro OUT p_resultado devuelve 0.

Si no coincide, registra el fallo en una tabla de log (puedes asumir que existe o crearla) y cuenta los fallos en los últimos 3 minutos con TIMESTAMPDIFF.

Si lleva más de 3 fallos, le baja el sueldo a 0 (cuenta suspendida) y el parámetro OUT devuelve 2. Si no llega a 3, devuelve 1.

Solución con el nivel de complejidad de tu PDF:

SQL
-- Necesitamos la tabla de logs con marcas de tiempo dinámicas
CREATE TABLE IF NOT EXISTS tbl_log_accesos_empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nif_empleado CHAR(9),
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

DROP PROCEDURE IF EXISTS sp_control_acceso_empleado;
DELIMITER //
CREATE PROCEDURE sp_control_acceso_empleado(
    IN p_nif CHAR(9), 
    IN p_pin CHAR(9), 
    OUT p_resultado INT
)
BEGIN
    DECLARE v_valido INT DEFAULT 0;
    DECLARE v_intentos_errados INT DEFAULT 0;

    -- 1. Comprobación estricta de existencia
    SELECT COUNT(*) INTO v_valido 
    FROM tbl_empleados 
    WHERE nif = p_nif AND telefono = p_pin;

    IF v_valido > 0 THEN
        SET p_resultado = 0; -- Acceso correcto
    ELSE
        -- 2. Registro del intento fallido
        INSERT INTO tbl_log_accesos_empleados (nif_empleado) VALUES (p_nif);
        
        -- 3. Control de tiempo estricto usando TIMESTAMPDIFF (Como en tu tarea 1.4)
        SELECT COUNT(*) INTO v_intentos_errados
        FROM tbl_log_accesos_empleados
        WHERE nif_empleado = p_nif 
          AND TIMESTAMPDIFF(MINUTE, fecha_hora, NOW()) <= 3;

        IF v_intentos_errados > 3 THEN
            -- Lógica de castigo/bloqueo de cuenta
            UPDATE tbl_empleados SET sueldo = 0.00 WHERE nif = p_nif;
            SET p_resultado = 2; -- Cuenta Bloqueada
        ELSE
            SET p_resultado = 1; -- Credenciales incorrectas
        END IF;
    END IF;
END //
DELIMITER ;

Enunciado: Crea un disparador BEFORE INSERT en la tabla tbl_servicios. Cada vez que se registre un servicio, debe comprobar si el 
cliente tiene un bono activo en tbl_bonos. Si tiene sesiones disponibles (cantidad_actual > 0), se le resta 1 automáticamente. 
  Si el bono existe pero está en 0, debe bloquear la inserción del servicio mostrando el error 'El cliente no dispone de saldo en su bono'.

Solución con el nivel de complejidad de tu PDF:

SQL
DROP TRIGGER IF EXISTS tg_consumir_bono_servicio;
DELIMITER //
CREATE TRIGGER tg_consumir_bono_servicio
BEFORE INSERT ON tbl_servicios
FOR EACH ROW
BEGIN
    DECLARE v_saldo_bono INT DEFAULT -1;

    -- Comprobamos si el cliente tiene algún bono registrado
    SELECT cantidad_actual INTO v_saldo_bono 
    FROM tbl_bonos 
    WHERE nif = NEW.nif_cliente
    ORDER BY fecha_inicial DESC 
    LIMIT 1;

    -- Si se encuentra un bono para el cliente
    IF v_saldo_bono = 0 THEN
        -- Interrumpimos la operación de forma radical aplicando las directrices de examen
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'El cliente no dispone de saldo en su bono';
    ELSEIF v_saldo_bono > 0 THEN
        -- Si tiene saldo, actualizamos la tabla madre restando una sesión
        UPDATE tbl_bonos 
        SET cantidad_actual = cantidad_actual - 1
        WHERE nif = NEW.nif_cliente;
    END IF;
END //
DELIMITER ;



