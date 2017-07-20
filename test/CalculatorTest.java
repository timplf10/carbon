import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void evaluatesExpression() {
		Calculator calculator = new Calculator();
		int sum = 0;

		sum = calculator.evaluate("1+2+3");
		assertEquals(6, sum);

		sum = calculator.evaluate("2+4+6+8");
		assertEquals(20, sum);
	}
}