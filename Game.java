package comboshed;

public class Game
{
	private String name;
	private int day;
	private int month;
	private int year;
	private int timeH;
	private int timeM;
	private String time;
	private String opponent;
	
	public Game()
	{
		name = "";
		day = 1;
		month = 1;
		year = 1900;
		timeH = 0;
		timeM = 0;
		time = "";
		opponent = "";
	}
	
	public Game(String name1, int day1, int month1, int year1, int time1, int time2, String opponent1)
	{
		name = name1;
		day = day1;
		month = month1;
		year = year1;
		timeH = time1;
		timeM = time2;
		opponent = opponent1;
		if (time1<13) {
			time = Integer.toString(timeH) + ":" + Integer.toString(timeM);
		}
		else
		{
			time = Integer.toString(timeH-12) + ":" + Integer.toString(timeM);
		}
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
	
	public int getTimeH()
	{
		return timeH;
	}

	public int getTimeM()
{
	return timeM;
}

	public String getTime() {
		if(timeM==0){
			return time+"0";
		}
		else
		{
			return time;
		}
	}
	
	public String getOpponent()
	{
		return opponent;
	}
}