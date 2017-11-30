package comboshed;

import javax.swing.text.BadLocationException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

class Controller {
    static void generateSchedule(List y) throws BadLocationException {
        if(y.size()==0)
        {
            UI.emptyError();
            return;
        }
        ArrayList<Game> games = new ArrayList<Game>();
        for(Team t : ComboShed.getTeamsSelected(y)) {
            games.addAll(t.getSchedule());
        }

        Collections.sort(games, new Comparator<Game>() {
            public int compare(Game g1, Game g2) {
                if(g1.getYear() != g2.getYear()) {
                    return Integer.compare(g1.getYear(), g2.getYear());
                }

                if(g1.getMonth() != g2.getMonth()) {
                    return Integer.compare(g1.getMonth(), g2.getMonth());
                }

                if(g1.getDay() != g2.getDay()) {
                    return Integer.compare(g1.getDay(), g2.getDay());
                }

                if(g1.getTimeH() != g2.getTimeH()) {
                    return Integer.compare(g1.getTimeH(), g2.getTimeH());
                }

                if(g1.getTimeM() != g2.getTimeM()) {
                    return Integer.compare(g1.getTimeM(), g2.getTimeM());
                }

                return 0;
            }
        });
        UI.makeSchedule(games);
    }
}
