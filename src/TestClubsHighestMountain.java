import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class TestClubsHighestMountain {
	private Climber testC1 = new Climber(20, "bob", 'm' );
	private Climber testC2 = new Climber(45, "mary", 'f');
	
	Club test = new Club();

	@Test
	void testClubsHighestMountain_normal()
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
		test.GetClimbers().get(0).HighestMountain();
		test.GetClimbers().get(1).HighestMountain();
		//testing the highest average method
		Climber result = test.ClimberWithHighestMountain();
		assertEquals(testC1, result);
		test.GetClimbers().clear();
	}
	
	@Test
	void testClubsHighestMountain_negativeNumbers()
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
		test.GetClimbers().get(0).HighestMountain();
		test.GetClimbers().get(1).HighestMountain();
		//testing the highest average method
		Climber result = test.ClimberWithHighestMountain();
		assertEquals(testC1, result);
		test.GetClimbers().clear();
	}
	
	@Test
	void testClubsHighestMountain_oneEntry()
	{
		test.GetClimbers().add(testC1);
		test.GetClimbers().get(0).GetMountains().add(new Mountain("low", 20));
		test.GetClimbers().get(0).HighestMountain();
		//testing the highest average method
		Climber result = test.ClimberWithHighestMountain();
		assertEquals(testC1, result);
		test.GetClimbers().clear();
	}
	
	@Test
	void testClubsHighestMountain_noMountains()
	{
		test.GetClimbers().add(testC1);
		test.GetClimbers().add(testC2);
		//testing the highest average method
		Climber result = test.ClimberWithHighestMountain();
		//since neither climbers have mountains will default to climber 1
		assertEquals(testC1, result);
		test.GetClimbers().clear();
	}
	
	@Test
	void testClubsHighestMountain_noClimbers()
	{
		Climber result = test.ClimberWithHighestAverage();
		assertEquals(null, result);
		test.GetClimbers().clear();
	}

}
