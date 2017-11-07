import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestClubsHighestAverage
{
	
	private Climber testC1 = new Climber(20, "bob", 'm' );
	private Climber testC2 = new Climber(45, "mary", 'f');
	
	Club test = new Club();
	
	@Test
	void testClubsHighestAverage_normal() 
	{
		//adding climbers
		test.GetClimbers().add(testC1);
		test.GetClimbers().add(testC2);
		//adding mountains to climbers
		test.GetClimbers().get(0).GetMountains().add(new Mountain("low", 20));
		test.GetClimbers().get(0).GetMountains().add(new Mountain("high", 4000));
		test.GetClimbers().get(1).GetMountains().add(new Mountain("mid1", 3000));
		test.GetClimbers().get(1).GetMountains().add(new Mountain("mid2", 3500));
		//calculating average height and highest mountain for each climber
		test.GetClimbers().get(0).AverageHeight();
		test.GetClimbers().get(1).AverageHeight();
		//testing the highest average method
		Climber result = test.ClimberWithHighestAverage();
		assertEquals(testC2, result);
		test.GetClimbers().clear();
		
	}
	
	@Test
	void testClubsHighestAverage_oneEntry() 
	{
		//adding climbers
		test.GetClimbers().add(testC1);
		//adding mountains to climbers
		test.GetClimbers().get(0).GetMountains().add(new Mountain("low", 20));
		//calculating average height and highest mountain for each climber
		test.GetClimbers().get(0).AverageHeight();

		//testing the highest average method
		Climber result = test.ClimberWithHighestAverage();
		assertEquals(testC1, result);
		test.GetClimbers().clear();
		
	}
	
	@Test
	void testClubsHighestAverage_negativeNumbers() 
	{
		//adding climbers
		test.GetClimbers().add(testC1);
		test.GetClimbers().add(testC2);
		//adding mountains to climbers
		test.GetClimbers().get(0).GetMountains().add(new Mountain("low", -20));
		test.GetClimbers().get(0).GetMountains().add(new Mountain("high", -4000));
		test.GetClimbers().get(1).GetMountains().add(new Mountain("mid1", -3000));
		test.GetClimbers().get(1).GetMountains().add(new Mountain("mid2", -3500));
		//calculating average height and highest mountain for each climber
		test.GetClimbers().get(0).AverageHeight();
		test.GetClimbers().get(1).AverageHeight();
		//testing the highest average method
		Climber result = test.ClimberWithHighestAverage();
		assertEquals(testC1, result);
		test.GetClimbers().clear();
		
	}
	
	@Test
	void testClubsHighestAverage_noMountains() 
	{
		//adding climbers but not mountains
		test.GetClimbers().add(testC1);
		test.GetClimbers().add(testC2);
		//testing the highest average method
		Climber result = test.ClimberWithHighestAverage();
		//climber1 expected, both climbers will have NaN average heights, so it will default to first climber in the arraylist
		assertEquals(testC1, result);
		test.GetClimbers().clear();
		
	}
	
	@Test
	void testClubsHighestAverage_noClimbers() 
	{
		//testing the highest average method with no climbers added
		Climber result = test.ClimberWithHighestAverage();
		assertEquals(null, result);
	}

}
