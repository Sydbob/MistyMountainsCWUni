import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.*;


public class Climber
{
	
	public Climber() {} 
	public Climber (int age, String name, char gender)
	{
		this.age = age;
		this.name = name;
		this.gender = gender;
	}
	
	public int GetAge() {return age;}
	public String GetName() {return name;}
	public char GetGender() {return gender;}
	public int GetHighestHeight() {return highestMountainHeight;}
	public float GetAverageHeight() {return averageHeight;}
	public ArrayList<Mountain> GetMountains() {	return mountains;}
	public ArrayList<Mountain> GetMountainsGreaterThan() {return mountainsGreaterThan;}
	
	private int age;
	private String name;
	private char gender;
	private float averageHeight;
	private int highestMountainHeight;
	private static final int MIN_AGE = 1;
	private static final int MAX_AGE = 120;
	private ArrayList<Mountain> mountainsGreaterThan = new ArrayList<Mountain>();
	private ArrayList<Mountain> mountains = new ArrayList<Mountain>();
	
	Scanner in = new Scanner(System.in);
	Scanner jin = new Scanner(System.in);
	
	/**
	 * Method that adds a mountain to climber's list of mountains climbed.
	 * It also updates climber's highest mountain and average height climbed.
	 */
	public void AddMountain()
	{
		Mountain newMountain = new Mountain();
		newMountain.SetName();
		newMountain.SetHeight();
		this.mountains.add(newMountain);
		AverageHeight();
		HighestMountain();
	}
	
	
	/**
	 * method that calculates and returns climbers average height climbed
	 * @return return average height (float)
	 */
	public float AverageHeight()
	{
		averageHeight =0;
		//loop through array and add all heights together
		for (int i = 0; i < mountains.size(); i++)
		{
			averageHeight += mountains.get(i).GetHeight();
		}
		//divide the total sum of heights to get average value
		averageHeight = averageHeight / mountains.size();
		return averageHeight;
		
	}
	

	/**
	 * Method that returns highest mountain climbed by a climber
	 * @return Returns highest mountain (Mountain-type object)
	 */
	public Mountain HighestMountain()
	{
		if (!mountains.isEmpty())
		{	
		int highestPosIndex = 0;
		for (int i = 0; i < mountains.size(); i++)
		{
			//check if height of the element in highestPosInde is < height of element in pos i
			if (mountains.get(highestPosIndex).GetHeight() < mountains.get(i).GetHeight())
			{
				highestPosIndex = i;
			}
		}
		highestMountainHeight = mountains.get(highestPosIndex).GetHeight();
		return mountains.get(highestPosIndex);
		}
		else
		{
			return null;
		}
	}
	
	
	/**
	 * Method that asks and sets climber's gender
	 */
	public void AskGender()
	{
		String gender = "";
		boolean valid = false;
		//keep asking until gender is valid
		while(!valid)
		{
			out.println("Enter gender('f' = female; 'm' = male; 'o'= other, 'r' = refuse to answer): ");
			//read the input, remove whitespaces and convert to lower case
			gender = in.nextLine().trim().toLowerCase();
			//if input is not valid go back to start of the loop
			if (gender.equals("f") || gender.equals("m") || gender.equals("r") || gender.equals("o"))
			{
				valid= true;
			}
			else
			{
				//exit the loop if input is valid
				valid = false;
			}
			
		}
		this.gender = gender.charAt(0);		
	}


	/**
	 * Method that asks and sets climber's age
	 */
	public void AskAge()
	{
		String age;
		int climberAge = 0;
		out.println("Enter age (valid range is " + MIN_AGE + "-" + MAX_AGE + "): ");
		age = in.nextLine();
		//check validity of the input (both for valid range and valid type)
		climberAge = Util.ValidateInt(age, "Enter age ", MIN_AGE, MAX_AGE);
		this.age = climberAge;
	}
	
	
	/**
	 * method that asks and sets name
	 */
	public void AskName()
	{
		String name = "";
		out.println("Enter your name: ");
		name = jin.nextLine().trim();
		this.name = name;
	}

	/**
	 * method to ask climber for info
	 */
	public void AskInfo()
	{
		AskName();
		AskAge();
		AskGender();
	}
	
	/**
	 * method that displays climbers age, name and gender
	 */
	public void DisplayInfo()
	{
		out.println(name);
		out.println(age);
		out.println(gender);
	}
	
	/**
	 * method for displaying mountains
	 * @param  an array list of Mountain objects to be displayed
	 */
	public void DisplayMountains(ArrayList<Mountain> mountains)
	{
		//loop through list of mountain objs and display and and height
		if (!mountains.isEmpty())
		{
			for (int i = 0; i < mountains.size(); i++)
			{
				out.println("Mountain name: " + mountains.get(i).GetName());
				out.println("Mountain height: " + mountains.get(i).GetHeight());
			}
		}
		else
		{
			out.println("There are no mountains to display that are higher than your input");
		}
	}

	/**
	 * method that filters and returns mountains greater than a given height
	 * @param minHeight (int) minimum height by which method filters the mountains
	 * @return returns an array list of mountains that are greater than minHeight
	 */
	public ArrayList<Mountain> MountainsGreaterThan(int minHeight)
	{
		mountainsGreaterThan.clear();
		//filter mountains higher than minHeight
		for (int i = 0; i < mountains.size(); i++)
		{
			if (mountains.get(i).GetHeight() > minHeight)
			{
				mountainsGreaterThan.add(mountains.get(i));
			}
		}
		if (mountainsGreaterThan.isEmpty())
		{
			return null;
		}
		else 
		{
		return mountainsGreaterThan;
		}
	}
	
}
