import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

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
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsException() {
	    ArrayList emptyList = new ArrayList();
	    Object o = emptyList.get(0);
	}

}