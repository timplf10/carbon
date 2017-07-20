package birchtest;

import static org.junit.Assert.assertEquals;
import birch.MountainBike;
import birch.TrmException;

import java.util.ArrayList;

import org.junit.Test;

public class TestAA {
	@Test
	public void evaluatesExpression() {

		MountainBike mtb = new MountainBike(10, 20, 30, 40);

		//System.out.println(mtb.toString());
		
		//XCadence: 20Height: 10 Cadence: 20 Gear: 40 Speed: 30
		
		assertEquals("XCadence: 20Height: 10 Cadence: 20 Gear: 40 Speed: 30", mtb.toString());
	}
	
	@Test(expected = TrmException.class)
	public void testForTrmException() {
		MountainBike mtb = new MountainBike(100, 200, 300, 400);		
		mtb.throwNow();
	}	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIndexOutOfBoundsException() {
	    ArrayList emptyList = new ArrayList();
	    Object o = emptyList.get(0);
	}

}