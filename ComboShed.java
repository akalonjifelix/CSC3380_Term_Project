package comboshed;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeremy LeJeune, Aaron Felix, Jenna Meadors, Patrick Do
 * CSC 3380 Term Project
 * @version 1.0
 */
public class ComboShed
{
        private static ArrayList<String> teamNames = new ArrayList<>();
        private static ArrayList<Team> teams = new ArrayList<>();

        static ArrayList<Team> getTeamsSelected(List selectedNames)
        {
            Boolean found;
            ArrayList<Team> selected = new ArrayList<>();
            for(int i = 0; i<selectedNames.size(); i++) {
                found = false;
                int j = 0;
                while(!found) {
                    String s = (String)selectedNames.get(i);
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
            saints.setName("New Orleans Saints");
			Game saintsGame1 = new Game(saints.getName(), 24, 12, 2017, "1200", "New York Jets");
			Game saintsGame2 = new Game(saints.getName(), 17, 12, 2017, "1200", "Atlanta Falcons");
			saints.addGame(saintsGame1);
			saints.addGame(saintsGame2);
			Team redWings = new Team();
            redWings.setName("Detroit Red Wings");
			Game redWingsGame1 = new Game(redWings.getName(), 15, 12, 2017, "1930", "Toronto Maple Leafs");
			Game redWingsGame2 = new Game(redWings.getName(), 17, 12, 2017, "1900", "New York Rangers");
			redWings.addGame(redWingsGame1);
			redWings.addGame(redWingsGame2);
			teams.add(redWings);
			teamNames.add(redWings.getName());
			teams.add(saints);
			teamNames.add(saints.getName());
			new UI("ComboShed, a Sports Scheduling Solution", teamNames);
		}
}