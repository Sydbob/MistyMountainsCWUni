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
	
	//method that asks for heigth and sets it
	public void SetHeight()
	{
		int height;
		String inputHeight;
		
		out.println(
				"Enter height in m(valid range is 5 to 8848m): ");
		height = in.nextInt();
		while (height < 5 || height > 8848)
		{
			out.println("That's not a valid number. Valid numbers are from 5 to 8848:");
			height = in.nextInt();
		}
		this.height= height;	
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
