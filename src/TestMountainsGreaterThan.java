import static org.junit.Assert.*;
import java.util.ArrayList;


import org.junit.Test;

public class TestMountainsGreaterThan {
	private Mountain mount1 = new Mountain("m1", 20);
	private Mountain mount2 = new Mountain("m2", 4500);
	private Mountain mount3 = new Mountain("m3", -20);
	private Mountain mount4 = new Mountain("m4", -4000);
	Climber test = new Climber();

	@Test
	public void testMountainsGreaterThan_normal() 
	{
		test.GetMountains().add(mount1);
		test.GetMountains().add(mount2);
		ArrayList<Mountain> result = new ArrayList<Mountain>();
		result = test.MountainsGreaterThan(200);		
		assertEquals(mount2, result.get(0));
	}
	
	@Test
	public void testMountainsGreaterThan_negative() 
	{
		test.GetMountains().add(mount3);
		test.GetMountains().add(mount4);
		ArrayList<Mountain> result = new ArrayList<Mountain>();
		result = test.MountainsGreaterThan(200);		
		assertEquals(null, result);
	}
	
	@Test
	public void testMountainsGreaterThan_empty() 
	{
		ArrayList<Mountain> result = new ArrayList<Mountain>();
		result = test.MountainsGreaterThan(200);		
		assertEquals(null, result);
	}

}
