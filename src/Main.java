//Misty mountains university project. Main class.

import static java.lang.System.*;
import java.util.Scanner;

public class Main 
{
		
	public static void main(String[] args) 
	{
		Club club = new Club();
		ClubStats clubStats = new ClubStats();
		Scanner in = new Scanner(System.in);
		
		//making a few dummy climbers for easier testing
		club.GetClimbers().add(new Climber(20, "iri", 'f'));
		club.GetClimbers().add(new Climber(30, "ric", 'm'));
		//making a few dummy mountains
		club.GetClimbers().get(0).GetMountains().add(new Mountain("low", 20));
		club.GetClimbers().get(0).GetMountains().add(new Mountain("high", 4000));
		club.GetClimbers().get(1).GetMountains().add(new Mountain("mid1", 3000));
		club.GetClimbers().get(1).GetMountains().add(new Mountain("mid2", 3500));
		//calculating average heights and highest mountains for dummy climbers
		club.GetClimbers().get(0).AverageHeight();
		club.GetClimbers().get(1).AverageHeight();
		club.GetClimbers().get(0).HighestMountain();
		club.GetClimbers().get(1).HighestMountain();
		
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
				do {
					out.println( "\nDisplaying a list of currently exisiting climbers: ");
					club.DisplayClimbersWithID();
					out.println( "To add mountain to a climber enter climber ID ");
					out.print("\nTo go back to main menu enter 'x'. Your selection: ");
					int id = 0;
					id = in.nextInt();
					String exit = "";
					//check if id is valid here
					while (id >= club.GetClimbers().size())
					{
						out.println( "\nThat's not a valid ID. Enter valid ID: ");
						id = in.nextInt();
					}
					club.GetClimbers().get(id).AddMountain();
					userResponce = clubStats.AskYesNo("Would you like to add another mountain?");
				} while (userResponce == 'y');

			}
			
			//menu option 3 -- statistics
			else if (clubStats.GetUserOption() == 3)
			{
				clubStats.DisplayStatisticsSubMenu();
				clubStats.AskMenuOption();
				if (clubStats.GetUserOption() == 1)
				{
					// Display climber with recorded highest average climbed
					out.println("\n\nDisplaying climber with heighest average climbed.");
					out.print( "Climber name: " + club.ClimberWithHighestAverage().GetName()) ;
					out.print(" (" + club.ClimberWithHighestAverage().AverageHeight() + "m climbed on average)");
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
