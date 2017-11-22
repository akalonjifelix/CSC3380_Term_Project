package comboshed;

import javax.swing.text.BadLocationException;
import java.util.List;

class Controller {
    static void generateSchedule(List y) throws BadLocationException {
        System.out.println(ComboShed.getTeamsSelected(y).get(0).getName());
        UI.makeSchedule(ComboShed.getTeamsSelected(y).get(0).getSchedule());
    }
}
