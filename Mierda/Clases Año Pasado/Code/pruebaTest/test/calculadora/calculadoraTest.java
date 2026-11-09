package calculadora;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class calculadoraTest {

	@Test
	public void testSumar() {
		// 1. Arrange (Preparar)
		calculadora calc = new calculadora();

		// 2. Act (Actuar)
		int resultado = calc.sumar(2, 3);

		// 3. Assert (Afirmar/Validar)
		assertEquals(5, resultado, "2 + 3 debe ser 5");

	}
}
