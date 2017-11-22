public class Game
{
	String name;
	String day;
	String month;
	String year;
	String time;
	String opponent;
	
	public Game()
	{
		name = "";
		day = "";
		month = "";
		year = "";
		time = "";
		opponent = "";
	}
	
	public Game(String name, String day, String month, String year, String time, String opponent)
	{
		name = name;
		day = day;
		month = month;
		year = year;
		time = time;
		opponent = opponent;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getDay()
	{
		return day;
	}
	
	public String getMonth()
	{
		return month;
	}
	
	public String getYear()
	{
		return year;
	}
	
	public String getTime()
	{
		return time;
	}
	
	public String getOpponent()
	{
		return opponent;
	}
}