import java.util.ArrayList;
import java.util.Scanner;

//a class that holds a number of global methods
public class Util
{
	
	Util(){};
	public static Scanner in = new Scanner(System.in);
	
	//method that validates user input: a. if it's a valid type(int), b. if it's in th valid range
	public static int ValidateInt (String value, String errorText, int minRange, int maxRange)
	{
		int parsedValue = 0; 
		boolean valid = false;
		boolean parsed = false;
		//main loop that will run both int and range test
		while (!valid)
		{
			//loop that will run parse test while it keeps filing
			while(!parsed)
			{
				try
				{
					Integer.parseInt(value);
					parsed = true; //exit the loop if it parsed successfully
				}
				catch (NumberFormatException e)
				{
					System.out.print(errorText + "(valid range is "+ minRange + "-" + maxRange + "): ");
					value = in.nextLine();
					parsed= false;
				}
			}
			//set a new value to the result of the parse to be able to compare it to a range
			parsedValue = Integer.parseInt(value);
			if (parsedValue < minRange || parsedValue > maxRange)
			{
				System.out.print(errorText + "(valid range is "+ minRange + "-" + maxRange + "): ");
				value = in.nextLine();
				//back to the start of the main loop if range check failed
				valid = false;
				parsed = false;
			}
			else
			{
				//exit the main loop if successful
				valid = true;
			}
		}
		return parsedValue;
	}
	
	// method that tries to parse string to int and returns false if it can't (doesn't check range)
	
	

	//method that will print out error text when array lists are empty
	public static void NothingToDisplay ()
	{
		System.out.println("\nThere is nothing to display. Add a climber and/or a mountain first!");
		System.out.println("Going back to main menu");
	}
	
	//method that checks if ArrayList of climbers is empty, returns true if it is
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
