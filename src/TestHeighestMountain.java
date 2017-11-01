import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestHeighestMountain {
	private Mountain mount1 = new Mountain("m1", 20);
	private Mountain mount2 = new Mountain("m2", 4500);
	private Mountain mount3 = new Mountain("m3", -20);
	private Mountain mount4 = new Mountain("m4", -4000);
	Climber test = new Climber();
	
	@Test
	void testHeighestMountain_normal()
	{		test.GetMountains().add(mount1);
			test.GetMountains().add(mount2);
			Mountain result = test.HighestMountain();
			assertEquals(mount2, result);
			test.GetMountains().clear();
		
	}

	@Test
	void testHeighestMountain_negativeNumbers()
	{
			test.GetMountains().add(mount3);
			test.GetMountains().add(mount4);
			Mountain result = test.HighestMountain();
			assertEquals(mount3, result);
			test.GetMountains().clear();
		
	}
	
	@Test
	void testHeighestMountain_noEntries()
	{
			Mountain result = test.HighestMountain();
			assertEquals(null, result);
		
	}
}
