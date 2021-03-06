import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;

public class Club 
{
	public Club() {}
	public ArrayList<Climber> GetClimbers() {return climbers;}
	public ArrayList<Mountain> GetAllMountainsHigherThanGiven(){return allMountainsHigherThanGiven;}
	
	private ArrayList<Climber> climbers = new ArrayList<Climber>();
	private ArrayList<Mountain> allMountainsHigherThanGiven = new ArrayList<Mountain>();
	private ArrayList<Mountain> allDocumentedMountains= new ArrayList<Mountain>();
	
	Scanner in = new Scanner(System.in);
	
	/**
	 * Method that adds new climber with String name, int age and char gender (user input)
	 */
	public void AddClimber()
	{
		Climber newClimber = new Climber();
		//get name age, gender
		newClimber.AskInfo();
		//check if the name provided is unique
		for (int i = 0; i < climbers.size(); i++)
		{
			if(climbers.get(i).GetName().trim().toLowerCase().equals(newClimber.GetName().trim().toLowerCase()))
			{
				out.println("That name is already taken. Enter a new one: ");
				newClimber.AskName();
			}
		}
		this.climbers.add(newClimber);
	}
	
	
	/**
	 * method that finds a climber with highest average height climbed in the club
	 * @return returns a Climber-type object with highest average score
	 */
	public Climber ClimberWithHighestAverage()
	{
		if (!climbers.isEmpty())
		{
		int highestAverageIndex= 0;
		for (int i = 0; i < climbers.size(); i++)
		{
			//compare average heights of each climber and save the pos index of one with highest average
			if (climbers.get(i).GetAverageHeight() > climbers.get(highestAverageIndex).GetAverageHeight())
			{
				highestAverageIndex =i;
			}
		}
		return climbers.get(highestAverageIndex);
		}
		else
		{
			return null;
		}
	}

	/**
	 * method that finds  climber with highest climbed mountain in the club
	 * @return returns Climber-type object with recorded highest mountain climbed
	 */
	public Climber ClimberWithHighestMountain()
	{
		int highestClimberIndex= 0;
		for(int i = 0; i < climbers.size(); i++)
		{
			if(climbers.get(highestClimberIndex).GetHighestHeight() < climbers.get(i).GetHighestHeight())
			{
				highestClimberIndex = i;
			}
		}
		return climbers.get(highestClimberIndex);
	}
	

	/**
	 * method that selects and returns all mountains higher than given level(user input)
	 */
	public void MountainsHigherThanGiven()
	{
		int minHeight;
		String inputMinHeight = "";
		allMountainsHigherThanGiven.clear();
		//add all climber mountains to an array list
		for(int i =0; i < climbers.size(); i++ )
		{
			for (int k = 0; k < climbers.get(i).GetMountains().size(); k++)
			{
				allDocumentedMountains.add(climbers.get(i).GetMountains().get(k));
			}
		}
		//take input
		out.println("Enter min height by which to filter mountains (valid range is " + Mountain.MIN_HEIGHT + "-" + Mountain.MAX_HEIGHT + "): ");
		//make sure provided input is of the right type
		inputMinHeight = in.nextLine();
		
		//a method that will check validity of the input (both for valid range and valid type)
		minHeight = Util.ValidateInt(inputMinHeight, "Enter minimum height by which to filter mountains ", Mountain.MIN_HEIGHT, Mountain.MAX_HEIGHT);
		//add to a separate list if > minHeight
		for (int i = 0; i < allDocumentedMountains.size(); i++)
		{
			if (allDocumentedMountains.get(i).GetHeight() >= minHeight)
			{
				allMountainsHigherThanGiven.add(allDocumentedMountains.get(i));
			}
		}
		//clear the list to prevent issues in the future
		allDocumentedMountains.clear();	
	}
	

	/**
	 * method to display climbers and ID
	 */
	public void DisplayClimbersWithID()
	{
		if (!climbers.isEmpty())
		{
			for (int i =0; i < climbers.size(); i++)
			{
				out.println("ID: " + i + " Climber name: " + climbers.get(i).GetName());
			}
		}
		else
		{
			Util.NothingToDisplay();
		}
		
	}

	
	/**
	 * method to display mountains
	 * @param mountainsSelected takes in an array list of Mountain objects to display
	 */
	public void DisplaySelectedMountains(ArrayList<Mountain> mountainsSelected)
	{
		if (!mountainsSelected.isEmpty())
		{
			out.println("\n\nDisplaying selected mountains: ");
			for (int i=0; i< mountainsSelected.size(); i++)
			{
				out.println(mountainsSelected.get(i).GetName() + " (" + mountainsSelected.get(i).GetHeight() + "m heigh)");
			}
		}
		else
		{
			Util.NothingToDisplay();
		}
	}
}
