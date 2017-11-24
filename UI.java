package comboshed;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class UI extends WindowAdapter implements ActionListener {
    private static JFrame frame;
    private static JList<Object> list;
    private static UI current;
    private static JTextPane text;

    UI(String title, ArrayList array) {
        current = this;
        frame = prepareFrame(title);
        JScrollPane listPanel = prepareList(array.toArray());
        Label label = new Label("Select your teams", 2);
        label.setForeground(Color.RED);
        label.setSize(200, 100);
        label.setFont(new Font("Bold", Font.BOLD, 19));
        JPanel panel = prepareContainer();
        Button submitButton = prepareButton("generateSchedule");
        panel.add(label);
        panel.add(listPanel);
        panel.add(submitButton);
        frame.add("Center", panel);
        frame.setVisible(true);
    }

    private static JFrame prepareFrame(String title) {
        frame = new JFrame(title);
        frame.setSize(600, 200);
        frame.setLayout(new BorderLayout());
        frame.setExtendedState(0);
        frame.addWindowListener(current);
        frame.setDefaultCloseOperation(2);
        return frame;
    }

    private static JScrollPane prepareList(Object[] teamArray) {
        list = new JList<>(teamArray);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setVisibleRowCount(-1);
        JScrollPane listScroll = new JScrollPane(list);
        listScroll.setPreferredSize(new Dimension(150, 150));
        return listScroll;
    }

    private static Button prepareButton(String actionCommand) {
        Button submitButton = new Button("Generate Schedule");
        submitButton.setBackground(Color.RED);
        submitButton.setActionCommand(actionCommand);
        submitButton.addActionListener(current);
        return submitButton;
    }

    private static JPanel prepareContainer() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.setBounds(10, 10, 2000, 1500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = Math.max(screenSize.width / 2 - frame.getSize().width / 2, 0);
        int y = Math.max(screenSize.height / 2 - frame.getSize().height / 2, 0);
        panel.setLocation(x, y);
        return panel;
    }

    private static JFrame prepareFrame() {
        frame = new JFrame("ComboShed");
        frame.setSize(1500, 2000);
        frame.setLayout(new BorderLayout());
        frame.setExtendedState(0);
        frame.addWindowListener(current);
        frame.setDefaultCloseOperation(2);
        return frame;
    }

    static void makeSchedule(ArrayList<Game> e) throws BadLocationException {
        frame.setVisible(false);
        frame.dispose();
        frame = prepareFrame();
        text = prepareTextPane(e);
        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(500, 320));
        scrollPane.setMinimumSize(new Dimension(10, 10));
        Label label = new Label("Your combined schedule:");
        label.setForeground(Color.RED);
        label.setSize(200, 100);
        label.setFont(new Font("Something", 1, 19));
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(scrollPane);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.pack();
        frame.setVisible(true);
    }

    private static JTextPane prepareTextPane(ArrayList<Game> e) throws BadLocationException {
        text = new JTextPane();
        DefaultCaret caret = (DefaultCaret) text.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        StyledDocument doc = text.getStyledDocument();
        Style regular = doc.addStyle("regular", StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE));
        StyleConstants.setFontFamily(StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE), "SansSerif");
        Style s = doc.addStyle("large", regular);
        StyleConstants.setFontSize(s, 28);
        StyleConstants.setFontSize(regular, 16);
        Game temp = e.get(0);
        doc.insertString(doc.getLength(), temp.getMonth() + "/" + temp.getDay() + "/" + temp.getYear() + "\n",
                doc.getStyle("large"));
        doc.insertString(doc.getLength(), temp.getName() + " vs. " + temp.getOpponent() + " at " + temp.getTime() + "\n",
                doc.getStyle("regular"));
        int year = temp.getYear();
        int month = temp.getMonth();
        int day = temp.getDay();
        for (int i = 1; i < e.size(); i++) {
            temp = e.get(i);
            if (year != temp.getYear() || month != temp.getMonth() || day != temp.getDay()) {
                doc.insertString(doc.getLength(), "\n" + temp.getMonth() + "/" + temp.getDay() + "/" + temp.getYear() + "\n",
                        doc.getStyle("large"));
                doc.insertString(doc.getLength(), temp.getName() + " vs. " + temp.getOpponent() + " at " + temp.getTime() + "\n",
                        doc.getStyle("regular"));
                year = temp.getYear();
                month = temp.getMonth();
                day = temp.getDay();
            } else {
                doc.insertString(doc.getLength(), temp.getName() + " vs. " + temp.getOpponent() + " at " + temp.getTime() + "\n",
                        doc.getStyle("regular"));
            }
            text.setEditable(false);
        }
        return text;
    }

    static void emptyError() {
        frame.setTitle("ComboShed - Please select at least one team");
        frame.setVisible(false);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Controller.generateSchedule(list.getSelectedValuesList());
        } catch (BadLocationException e1) {
            System.out.println("Bad Location Exception thrown");
        }
    }

    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
    }

}