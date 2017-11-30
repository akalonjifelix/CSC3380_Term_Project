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
            Game saintsGame1 = new Game(saints.getName(), 17, 12, 2017, 12, 00, "Jets");
            Game saintsGame2 = new Game(saints.getName(), 24, 12, 2017, 12, 00, "Falcons");
            Game saintsGame3 = new Game(saints.getName(), 7, 12, 2017, 7, 25, "Falcons");
            Game saintsGame4 = new Game(saints.getName(), 31, 12, 2017, 12, 00, "Buccaneers");
            Game saintsGame5 = new Game(saints.getName(), 3, 12, 2017, 3, 25, "Panthers");
            saints.addGame(saintsGame1);
            saints.addGame(saintsGame2);
            saints.addGame(saintsGame3);
            saints.addGame(saintsGame4);
            saints.addGame(saintsGame5);
            Team redWings = new Team();
            redWings.setName("Detroit Red Wings");
            Game redWingsGame1 = new Game(redWings.getName(), 15, 12, 2017, 7, 30, "Toronto Maple Leafs");
            Game redWingsGame2 = new Game(redWings.getName(), 17, 12, 2017, 7, 00, "New York Rangers");
            Game redWingsGame3 = new Game(redWings.getName(), 2, 12, 2017, 7, 00, "Montreal Canadiens");
            Game redWingsGame4 = new Game(redWings.getName(), 11, 12, 2017, 7, 30, "Florida Panthers");
            Game redWingsGame5 = new Game(redWings.getName(), 23, 12, 2017, 1, 00, "Boston Bruins");
            Game redWingsGame6 = new Game(redWings.getName(), 31, 12, 2017, 7, 00, "Pittsburgh Penguins");
            Game redWingsGame7 = new Game(redWings.getName(), 25, 1, 2018, 7, 30, "Florida Panthers");
            redWings.addGame(redWingsGame1);
            redWings.addGame(redWingsGame2);
            redWings.addGame(redWingsGame3);
            redWings.addGame(redWingsGame4);
            redWings.addGame(redWingsGame5);
            redWings.addGame(redWingsGame6);
            redWings.addGame(redWingsGame7);
            Team pelicans = new Team();
            pelicans.setName("New Orleans Pelicans");
            Game pelicansGame1 = new Game(pelicans.getName(), 1, 12, 2017, 7, 00, "Portland Trail Blazers");
            Game pelicansGame2 = new Game(pelicans.getName(), 6, 12, 2017, 8, 00, "Denver Nuggets");
            Game pelicansGame3 = new Game(pelicans.getName(), 22, 12, 2017, 7, 00, "Orlando Magic");
            Game pelicansGame4 = new Game(pelicans.getName(), 29, 12, 2017, 8, 00, "Dallas Mavericks");
            Game pelicansGame5 = new Game(pelicans.getName(), 03, 1, 2018, 9, 00, "Utah Jazz");
            Game pelicansGame6 = new Game(pelicans.getName(), 10, 1, 2018, 8, 00, "Memphis Grizzlies");
            Game pelicansGame7 = new Game(pelicans.getName(), 23, 2, 2018, 8, 00, "Miami Heat");
            pelicans.addGame(pelicansGame1);
            pelicans.addGame(pelicansGame2);
            pelicans.addGame(pelicansGame3);
            pelicans.addGame(pelicansGame4);
            pelicans.addGame(pelicansGame5);
            pelicans.addGame(pelicansGame6);
            pelicans.addGame(pelicansGame7);
            Team grizzlies = new Team();
            grizzlies.setName("Memphis Grizzlies");
            Game grizzliesGame1 = new Game(grizzlies.getName(), 2, 12, 2017, 7, 30, "Cleveland Cavaliers");
            Game grizzliesGame2 = new Game(grizzlies.getName(), 13, 12, 2017, 7, 00, "Washington Wizards");
            Game grizzliesGame3 = new Game(grizzlies.getName(), 12, 12, 2017, 9, 00, "Phoenix Suns");
            Game grizzliesGame4 = new Game(grizzlies.getName(), 31, 12, 2017, 7, 00, "Sacramento Kings");
            Game grizzliesGame5 = new Game(grizzlies.getName(), 5, 1, 2018, 9, 30, "Washington Wizards");
            Game grizzliesGame6 = new Game(grizzlies.getName(), 22, 1, 2018, 8, 00, "Philadelphia 76ers");
            Game grizzliesGame7 = new Game(grizzlies.getName(), 1, 2, 2018, 7, 00, "Detroit Pistons");
            Game grizzliesGame8 = new Game(grizzlies.getName(), 6, 2, 2018, 7, 30, "Atlanta Hawks");
            grizzlies.addGame(grizzliesGame1);
            grizzlies.addGame(grizzliesGame2);
            grizzlies.addGame(grizzliesGame3);
            grizzlies.addGame(grizzliesGame4);
            grizzlies.addGame(grizzliesGame5);
            grizzlies.addGame(grizzliesGame6);
            grizzlies.addGame(grizzliesGame7);
            grizzlies.addGame(grizzliesGame8);

            teams.add(redWings);
            teamNames.add(redWings.getName());
            teams.add(grizzlies);
            teamNames.add(grizzlies.getName());
            teams.add(pelicans);
            teamNames.add(pelicans.getName());
            teams.add(saints);
            teamNames.add(saints.getName());


			new UI("ComboShed, a Sports Scheduling Solution", teamNames);
		}
}