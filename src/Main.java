
import static java.lang.System.*;
import java.util.Scanner;

/**
 * Class that contains main method. 
 * Author: Irina Kovalova S170716899 .
 * Description: Misty Mountains win32 console application; Java CW part 1 for CSC8001 module of MSc(Computer Science).
 * Last updated 11/10/2017 .
 * GitHub repository: https://github.com/Sydbob/MistyMountainsCWUni/tree/master/src .
 * Created using Eclipse Oxygen IDE.
 * JRE: JavaSE-1.8
 */
public class Main 
{
		
	public static void main(String[] args) 
	{
		Club club = new Club();
		ClubStats clubStats = new ClubStats();
		Scanner in = new Scanner(System.in);
			
		clubStats.WelcomeMessage();
		clubStats.SetExitApplication(1);
		
		do 
		{
			clubStats.DisplayMenu();
			clubStats.AskMenuOption();
			
			//add climber menu option
			if (clubStats.GetUserOption() == 1)
			{
				clubStats.DisplayAddClimberMenu();
				char userResponse;
				//ask for info about the climber and make a new climber obj
				do
				{
					club.AddClimber();
					userResponse = clubStats.AskYesNo("Would you like to add a mountain to current climber?");
					while (userResponse == 'y')
					{
						//get the last climber in the list (the 'current one')
						club.GetClimbers().get(club.GetClimbers().size() - 1).AddMountain();
						userResponse = clubStats.AskYesNo("Would you like to add a mountain to current climber?");
					}
					userResponse = clubStats.AskYesNo("Add another climber? ");
				} while (userResponse == 'y');
				
				out.println("Done adding climbers. Going back to main menu");
				clubStats.SetExitApplication(1);
				
			}
			
			//menu option 2 add a mountain to existing climber
			else if (clubStats.GetUserOption() == 2)
			{
				char userResponce;
				if (!club.GetClimbers().isEmpty() )
				{
				do {
					out.println( "\nDisplaying a list of currently exisiting climbers: ");
					club.DisplayClimbersWithID();
					out.println( "To add mountain to a climber enter climber ID ");
					int id = 0;
					String inputId = "";
					inputId = in.nextLine();
					//check if input is an int,, as well as if range is valid
					id = Util.ValidateInt(inputId, "Not a valid ID, enter valid ID", 0, (club.GetClimbers().size() -1) );
					//add the mountain to the climber and ask if they'd like to add another
					club.GetClimbers().get(id).AddMountain();
					userResponce = clubStats.AskYesNo("Would you like to add another mountain?");
					} while (userResponce == 'y');
				}
				else
				{
					Util.NothingToDisplay();
				}
			}
			
			//menu option 3 -- statistics
			else if (clubStats.GetUserOption() == 3)
			{
				if (!club.GetClimbers().isEmpty() && !Util.MountainsEmpty(club.GetClimbers()))
				{
					clubStats.DisplayStatisticsSubMenu();
					clubStats.AskMenuOption();
					if (clubStats.GetUserOption() == 1)
					{
						// Display climber with recorded highest average climbed
						if (club.ClimberWithHighestAverage().GetAverageHeight() > 0) 
						{
							out.println("\n\nDisplaying climber with heighest average climbed.");
							out.print( "Climber name: " + club.ClimberWithHighestAverage().GetName()) ;
							out.print(" (" + club.ClimberWithHighestAverage().AverageHeight() + "m climbed on average)");					
						}
						else
						{
							Util.NothingToDisplay();
						}
					}
					else if (clubStats.GetUserOption() == 2)
					{
						//Display highest mountain climbed by a club member
						out.println("\n\nDisplaying heighest mountain climbed by a club member: " );
						out.print("Mountain name: " + club.ClimberWithHighestMountain().HighestMountain().GetName());
						out.print(", mountain height:" + club.ClimberWithHighestMountain().HighestMountain().GetHeight());
						out.print(", climbed by " + club.ClimberWithHighestMountain().GetName());
						out.println("\nReturning to main menu");
					}
					else if (clubStats.GetUserOption() == 3)
					{
						//Display all mountains recorded with a height greater than a given level
						club.MountainsHigherThanGiven();
						club.DisplaySelectedMountains(club.GetAllMountainsHigherThanGiven());
						club.GetAllMountainsHigherThanGiven().clear();
					}
					else
					{
						//go back to main menu
						clubStats.SetExitApplication(1);
					}
				}
				else
				{
					out.println("\n	\n			### Statistics Sub-Menu ###");
					Util.NothingToDisplay();
				}
			}
			
			//menu option 0 -- terminate the app
			if (clubStats.GetUserOption() == 0)
			{
				clubStats.SetExitApplication(0);
				
			}
						
		} while (clubStats.GetExitApplication() == 1);
		
			
		
		//have to close Scanner when not using in java.... 
		in.close();
		//exit message
		out.println("\nThank you for using Misty Mountains Club application!");
		out.println("################ END OF APPLICATION ##############");
	}
}
