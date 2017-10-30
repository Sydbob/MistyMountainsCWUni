public class Util
{
	
	Util(){};
	
	//global method that tries to parse string to int and returns false if it can't
	public static boolean TryParseInt(String value)
	{
		try 
		{
			Integer.parseInt(value); 
			return true;
		} 
		catch (NumberFormatException e)
		{
			return false;
		}
	}
	

}
