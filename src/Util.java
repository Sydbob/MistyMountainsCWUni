import java.util.ArrayList;

public class Util
{
	
	Util(){};
	
	// method that tries to parse string to int and returns false if it can't
	public static boolean TryParseInt(String value)
	{
		try 
		{
			Integer.parseInt(value); 
			return true;
		} 
		catch (NumberFormatException e)
		{
			return false;
		}
	}
	
	//method that will print out error text when array lists are empty
	public static void NothingToDisplay ()
	{
		System.out.println("\nThere is nothing to display. Add a climber and/or a mountain first!");
		System.out.println("Going back to main menu");
	}
	
	public static boolean MountainsEmpty (ArrayList<Climber> climbers)
	{
		boolean empty = false;
		for(int i =0; i < climbers.size() && !empty; i++ )
		{
			if( !climbers.get(i).GetMountains().isEmpty() )
			{
				empty = false;
			}
			else
			{
				empty = true;
			}
		}
		return empty; 
	}
	

}
