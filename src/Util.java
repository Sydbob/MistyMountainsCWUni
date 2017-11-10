import java.util.ArrayList;
import java.util.Scanner;

/**
 * a class that holds a number of global methods
 */
public class Util
{
	
	Util(){};
	public static Scanner in = new Scanner(System.in);
	
	/**
	 * method that validates if user's input is of an int type and if it's in valid range
	 * @param value (String) user input that will be evaluated
	 * @param errorText (String) text to display if evaluation fails
	 * @param minRange minimum range for the input
	 * @param maxRange maximum range for the input
	 * @return returns an integer
	 */
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

	/**
	 * method that will print out error text when array lists are empty
	 */
	public static void NothingToDisplay ()
	{
		System.out.println("\nThere is nothing to display. Add a climber and/or a mountain first!");
		System.out.println("Going back to main menu");
	}

	/**
	 * method that checks whether climber have any mountains recorded
	 * @param climbers takes in an array list of club's climbers
	 * @return returns true if climbers have no mountains
	 */
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
