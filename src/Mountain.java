import java.util.Scanner;
import static java.lang.System.*;

public class Mountain
{
	public Mountain(String name, int height)
	{
		this.name = name;
		this.height = height;
	}
	
	public Mountain(){};
	
	String GetName() {return name; }
	int GetHeight() {return height;}
	
	private String name;
	private int height;
	
	Scanner in = new Scanner(System.in);
	
	//method that asks for height and sets it
	public void SetHeight()
	{
		String height = "";
		int inputHeight = 0;
		boolean valid = false;
		while (!valid)
		{
			//check if input is of the right data type
			while (!Util.TryParseInt(height))
			{
				out.println("Enter height in m(valid range is 5 to 8848m): ");
				height = in.next();
			}
			//also check if input is in the valid range
			//there are no mountains higher that 8848m (according to google search data)
			inputHeight = Integer.parseInt(height);
			if (inputHeight < 5 || inputHeight > 8848)
			{
				out.println("That's not a valid number. Valid numbers are from 5 to 8848:");
				height = in.next();
				valid = false;
			}
			else
			{
				//exit the loop if input is valid
				valid = true;
			}
				
		}
		this.height= inputHeight;
	}
	
	//method that asks for a name and sets it
	public void SetName()
	{
		String name; 
		out.println("Enter mountain name: ");
		name= in.nextLine().trim();
		this.name = name;
	}
	
}
