public class ComboShed
{
		public static void main (String[] args)
		{
			Team saints = new Team();
			Game saintsGame1 = new Game("Saints", "24", "12", "2017", "1200", "Jets");
			Game saintsGame2 = new Game("Saints", "17", "12", "2017", "1200", "Falcons");
			saints.addGame(saintsGame1);
			saints.addGame(saintsGame2);
			Team redWings = new Team();
			Game redWingsGame1 = new Game("Red Wings", "15", "12", "2017", "1930", "Toronto");
			Game redWingsGame2 = new Game("Red Wings", "17", "12", "2017", "1900", "New York");
			redWings.addGame(redWingsGame1);
			redWings.addGame(redWingsGame2);
			redWings.setName("Red Wings");
			System.out.println(redWings.getName());
		}
}