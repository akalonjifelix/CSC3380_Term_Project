import java.util.ArrayList;
public class Team
{
	private String teamName;
	private ArrayList schedule;
	
	public Team()
	{
		teamName = "";
		schedule = new ArrayList();
	}
	
	public void setName(String name)
	{
		teamName = name;
	}
	
	public String getName()
	{
		return teamName;
	}
	
	public ArrayList getSchedule()
	{
		return schedule;
	}
	
	public void addGame(Game game)
	{
		schedule.add(game);
	}
}