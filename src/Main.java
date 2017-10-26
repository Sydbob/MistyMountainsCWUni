//Misty mountains university project. Main class.
import static java.lang.System.*;
import java.util.ArrayList;


public class Main 
{
	//method to display mountains
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
			out.println("\nThere are no mountains to display");
		}
	}

	//method to display climbers and ID
	public void DisplayClimbersWithID(ArrayList<Climber> climbers)
	{
		if (!climbers.isEmpty())
		{
			for (int i =0; i < climbers.size(); i++)
			{
				out.println("ID: " + i + "Climber name: " + climbers.get(i));
			}
		}
		else
		{
			out.println("\nThere are no climbers to display");
		}
	}
	
	public static void main(String[] args) 
	{
		Club club = new Club();
		ClubStats clubStats = new ClubStats();
		
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
		clubStats.SetOne(clubStats.GetExitApplication());
		
		do 
		{
			clubStats.DisplayMenu();
			clubStats.AskMenuOption();
			
		} while (clubStats.GetExitApplication() == 1);
		
		//exit message
		out.println("\nThank you for using Misty Mountains Club application!");
		out.println("################ END OF APPLICATION ##############");
	}
}
