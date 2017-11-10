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
	int GetHeight() {return height; }
	
	private String name;
	private int height;
	public static final int MIN_HEIGHT = 5;
	public static final int MAX_HEIGHT = 8848;
	
	Scanner in = new Scanner(System.in);
	
	/**
	 * Method that asks for mountain height and sets it
	 */
	public void SetHeight()
	{
		String height = "";
		int inputHeight = 0;
		//check validity of the input (both for valid range and valid type)
		inputHeight = Util.ValidateInt(height, "Enter mountain height ", MIN_HEIGHT, MAX_HEIGHT);
		this.height= inputHeight;
	}
	

	/**
	 * Method that asks for mountain name and sets it
	 */
	public void SetName()
	{
		String name; 
		out.println("Enter mountain name: ");
		name= in.nextLine().trim();
		this.name = name;
	}
	
}
