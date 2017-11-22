package comboshed;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ComboShed
{
        private static ArrayList<String> teamNames = new ArrayList<>();
        private static ArrayList<Team> teams = new ArrayList<>();

        static ArrayList<Team> getTeamsSelected(List x)
        {
            Boolean found;
            ArrayList<Team> selected = new ArrayList<>();
            for(int i = 0; i<x.size(); i++) {
                found = false;
                int j = 0;
                while(!found) {
                    String s = (String)x.get(i);
                    if (s.compareTo(teams.get(j).getName()) == 0) {
                        selected.add(teams.get(j));
                        found = true;
                    }
                    j++;
                }
            }
            return selected;
        }

		public static void main (String[] args)
		{
			Team saints = new Team();
			Game saintsGame1 = new Game("Saints", 24, 12, 2017, "1200", "Jets");
			Game saintsGame2 = new Game("Saints", 17, 12, 2017, "1200", "Falcons");
			saints.addGame(saintsGame1);
			saints.addGame(saintsGame2);
			saints.setName("New Orleans Saints");
			Team redWings = new Team();
			Game redWingsGame1 = new Game("Red Wings", 15, 12, 2017, "1930", "Toronto");
			Game redWingsGame2 = new Game("Red Wings", 17, 12, 2017, "1900", "New York");
			redWings.addGame(redWingsGame1);
			redWings.addGame(redWingsGame2);
			redWings.setName("Detroit Red Wings");
			teams.add(redWings);
			teamNames.add(redWings.getName());
			teams.add(saints);
			teamNames.add(saints.getName());
			new UI("ComboShed", teamNames);
		}
}