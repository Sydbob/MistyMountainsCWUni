import java.util.ArrayList;
import java.util.Scanner;


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
	private ArrayList<Mountain> mountainsGreaterThan = new ArrayList<Mountain>();
	private ArrayList<Mountain> mountains = new ArrayList<Mountain>();
	
	Scanner in = new Scanner(System.in);
	Scanner jin = new Scanner(System.in);
	
	//method that adds a mountain to climber's list of mountains climbed
	public void AddMountain()
	{
		Mountain newMountain = new Mountain();
		newMountain.SetName();
		newMountain.SetHeight();
		this.mountains.add(newMountain);
		AverageHeight();
		HighestMountain();
	}
	
	//method that calculates and returns climbers average height climbed
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
	
	//method that returns heighest mountain climbed by a climber
	public Mountain HighestMountain()
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
	
	//method that asks and sets climber gender
	public char AskGender()
	{
		char gender;
		System.out.println("Enter gender('f' = female; 'm' = male; 'o'= other, 'r' = refuse to answer): ");
		gender = in.next().charAt(0);
		//keep asking until gender is valid
		while(gender != 'f' && gender != 'm' && gender != 'o' && gender != 'r')
		{
			System.out.println("Enter gender('f' = female; 'm' = male; 'o'= other, 'r' = refuse to answer): ");
			gender = in.next().charAt(0);
		}
		this.gender = gender;
		return gender;
		
	}

	//method that asks and sets climber's age
	public int AskAge()
	{
		int age;
		System.out.println("Enter age (valid range is 1 - 120): ");
		age = in.nextInt();
		while( age < 1 || age > 120)
		{
			System.out.print("Enter age (valid range is 1- 120): ");
			age = in.nextInt();
		}
		this.age = age;
		return age;
	}
	
	//method that asks and sets name
	public String AskName()
	{
		String name = "";
		System.out.println("Enter your name: ");
		name = jin.nextLine();
		this.name = name;
		return name;
	}
	
	//method to ask climber for info
	public void AskInfo()
	{
		AskName();
		AskAge();
		AskGender();
	}
	
	//method tht displays climbers age, name and gender
	public void DisplayInfo()
	{
		System.out.println(name);
		System.out.println(age);
		System.out.println(gender);
	}
	
	//method for displaying mountains
	public void DisplayMountains(ArrayList<Mountain> mountains)
	{
		//loop through list of mountain objs and display and and height
		if (!mountains.isEmpty())
		{
			for (int i = 0; i < mountains.size(); i++)
			{
				System.out.println("Mountain name: " + mountains.get(i).GetName());
				System.out.println("Mountain height: " + mountains.get(i).GetHeight());
			}
		}
		else
		{
			System.out.println("There are no mountains to display");
		}
	}
	
	//method that filters and returns mountains greater than a given height
	public ArrayList<Mountain> MountainsGreaterThan()
	{
		mountainsGreaterThan.clear();
		System.out.println("Enter min height by which to filter mountains: ");
		int minHeight= in.nextInt();
		
		//filter mountains higher than minHeight
		for (int i = 0; i < mountains.size(); i++)
		{
			if (mountains.get(i).GetHeight() > minHeight)
			{
				mountainsGreaterThan.add(mountains.get(i));
			}
		}
		return mountainsGreaterThan;
	}
	
}
