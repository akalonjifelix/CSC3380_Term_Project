package comboshed;


public class Game
{
	private String name;
	private int day;
	private int month;
	private int year;
	private String time;
	private String opponent;
	
	public Game()
	{
		name = "";
		day = 1;
		month = 1;
		year = 1900;
		time = "";
		opponent = "";
	}
	
	public Game(String name1, int day1, int month1, int year1, String time1, String opponent1)
	{
		name = name1;
		day = day1;
		month = month1;
		year = year1;
		time = time1;
		opponent = opponent1;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getDay()
	{
		return day;
	}
	
	public int getMonth()
	{
		return month;
	}
	
	public int getYear()
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
