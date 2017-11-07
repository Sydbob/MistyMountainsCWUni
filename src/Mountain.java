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
		//a method that will check validity of the input (both for valid range and valid type)
		inputHeight = Util.ValidateInt(height, "Enter mountain height ", 5, 8848);
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
