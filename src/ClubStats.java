import static java.lang.System.*;

import java.util.Scanner;

public class ClubStats
{
	ClubStats(){}
	
	public void SetExitApplication(int value){exitApplication = value;}
	public int GetExitApplication() {return exitApplication;}
	public int GetUserOption(){return userOptionChoice;}
	
	private int userOptionChoice;
	private int exitApplication;
	
	Scanner in = new Scanner(System.in);
	
	//this method displays main menu
	public void DisplayMenu()
	{
		out.println("\n\n			   ### MAIN MENU ###");
		out.println("What would you like to do? ");
		out.println("0 --> Exit the Application");
		out.println("1 --> Add new climber" );
		out.println("2 --> Add new mountain to an existing climber");
		out.println("3 --> Display club statistics [will open a sub-menu with option]");
	}
	
	//this method displays statistics sub-menu
	public void DisplayStatisticsSubMenu()
	{
		out.println("\n	\n			### Statistics Sub-Menu ###");
		out.println("You're in statistics sub-menu. Below are options to chose from:");
		out.println("0--> Go back to main menu");
		out.println("1--> Display climber with recorded highest average climbed");
		out.println("2--> Display highest mountain climbed by a club member");
		out.println("3--> Display all mountains recorded with a height greater than a given level");
	}
	
	//method that displays add climber sub-menu
	public void DisplayAddClimberMenu()
	{
		out.println("\n		### Add climber sub-menu##");
		out.println("You're now in the add climber menu. Adding a climber: ");
	}
	
	//method thats asks and returns an option (from 0 to 4)
	public void AskMenuOption()
	{
		String userInput = "";
		int menuChoice = 0; 
		boolean valid = false;
		out.print("Choose an option (0/1/2/3): ");
		userInput = in.nextLine().trim();
		while (!valid)
		{
			//check if input is an int
			while (!Util.TryParseInt(userInput))
			{
			out.print("\nThat's not a valid option. Valid options are: 0, 1, 2, 3. Pick an option:");
			userInput = in.nextLine();
			}
			menuChoice = Integer.parseInt(userInput);
			//check if range is valid
			if (menuChoice < 0 || menuChoice > 3)
			{
				out.println("\nNot a valid option. Valid options are 0/1/2/3. Choose a valid option: ");
				userInput = in.nextLine();
				valid = false;
			}
			else
			{
				valid = true;
			}
		}
		userOptionChoice = menuChoice;
	}
	
	//method that will ask yes/no and return a y/n char
	public char AskYesNo(String question)
	{
		String answer = "";
		boolean valid = false;
		do
		{
			out.print(question + "(y/n): ");
			answer = in.nextLine().trim().toLowerCase();
			if (answer.equals("y") || answer.equals("n"))
			{
				valid = true;
			}
			else
			{
				valid = false;
			}
		} while (!valid);
		return answer.trim().toLowerCase().charAt(0);
	}
	
	//method that prints out a welcome message
	public void WelcomeMessage()
	{
		//ascii art done by Joan Stark (taken from https://www.ascii-code.com/)
		out.println("#################################################################################");
		out.println("			Welcome to Misty Mountains Club!");
		out.println("	        _    .  ,   .           .");
		out.println("	    *  / \\_ *  / \\_      _  *        *   /\\'__        *");
		out.println("	      /    \\  /    \\,   ((        .    _/  /  \\  *'.");
		out.println("	 .   /\\/\\  /\\/ :' __ \\_  `          _^/  ^/    `--.");
		out.println("	    /    \\/  \\  _/  \\-'\\      *    /.' ^_   \\_   .'\\  *");
		out.println("	  /\\  .-   `. \\/     \\ /==~=-=~=-=-;.  _/ \\ -. `_/   \\ *. ");
		out.println("	 /  `-.__ ^   / .-'.--\\ =-=~_=-=~=^/  _ `--./ .-'  `-");
		//ascii text generated by http://patorjk.com/software/taag/#p=display&f=Slant&t=Misty%20Mountains
		out.println("    __  ____      __           __  ___                  __        _           ");
		out.println("   /  |/  (_)____/ /___  __   /  |/  /___  __  ______  / /_____ _(_)___  _____");
		out.println("  / /|_/ / / ___/ __/ / / /  / /|_/ / __ \\/ / / / __ \\/ __/ __ `/ / __ \\/ ___/");
		out.println(" / /  / / (__  ) /_/ /_/ /  / /  / / /_/ / /_/ / / / / /_/ /_/ / / / / (__  ) ");
		out.println("/_/  /_/_/____/\\__/\\__, /  /_/  /_/\\____/\\__,_/_/ /_/\\__/\\__,_/_/_/ /_/____/  ");
		out.println("                  /____/                                                      ");
		out.println("#################################################################################");
		
	}
}
