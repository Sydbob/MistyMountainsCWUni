import static org.junit.Assert.*;

import org.junit.Test;

public class TestAverageHeight {

	@Test
	public void testAverageHeight_normal()
	{
		Climber test = new Climber();
		test.GetMountains().add(new Mountain("low", 20));
		test.GetMountains().add(new Mountain("highest", 4500));
		float result = test.AverageHeight();
		assertEquals(2260, result, 0.001);
	}
	
	@Test
	public void testAverageHeight_oneEntry()
	{
		Climber test = new Climber();
		test.GetMountains().add(new Mountain("low", 10));
		float result = test.AverageHeight();
		assertEquals(10, result, 0.001);
	}
	
	@Test
	public void testAverageHeight_noEntry()
	{
		Climber test = new Climber();
		float result = test.AverageHeight();
		//acessing empty ArrayList, thus expecting to get "NaN - Not a number" error
		assertEquals(Double.NaN, result, 0.001);
	}
	
	@Test
	public void testAverageHeight_negativeNumbers() 
	{
		Climber test = new Climber();
		test.GetMountains().add(new Mountain("low", -20));
		test.GetMountains().add(new Mountain("highest", -4500));
		float result = test.AverageHeight();
		assertEquals(-2260, result, 0.001);
	}
}
