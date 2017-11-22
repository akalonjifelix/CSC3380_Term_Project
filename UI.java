package comboshed;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.text.html.HTMLDocument;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class UI extends WindowAdapter implements ActionListener {
    private static JFrame frame;
    private static Button submitButton;
    private static JList<Object> list;
    private static UI current;
    private static JTextPane text;


    UI(String title, ArrayList array) {
        current = this;
        frame = prepareFrame(title);
        JScrollPane listb = prepareList(array.toArray());
        Label loginLabel = new Label("Select your teams", 2);
        loginLabel.setForeground(Color.RED);
        loginLabel.setSize(200, 100);
        loginLabel.setFont(new Font("Bold", Font.BOLD, 19));
        JPanel panel = prepareContainer();
        submitButton = prepareButton("generateSchedule");
        panel.add(loginLabel);
        panel.add(listb);
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

    private static JScrollPane prepareList(Object[] teamArray)
    {
        list = new JList<>(teamArray);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(150, 150));
        return listScroller;
    }
    private static Button prepareButton(String actionCommand) {
        Button submitButton = new Button("Generate Schedule");
        submitButton.setBackground(Color.RED);
        submitButton.setActionCommand(actionCommand);
        submitButton.addActionListener(current);
        return submitButton;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            List selected = list.getSelectedValuesList();
            System.out.println(selected.get(0));
            Controller.generateSchedule(selected);
        } catch (BadLocationException e1) {
            System.out.println("Bad Location Exception thrown");
        }
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

    public void windowClosing(WindowEvent e) {
        super.windowClosing(e);
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
        Label label = new Label("wowee!");
        label.setForeground(Color.CYAN);
        label.setSize(200, 100);
        label.setFont(new Font("Something", 1, 19));
        JPanel panel = new JPanel();
        panel.add("Center", label);
        panel.add(text);
        frame.add(panel);
        frame.setVisible(true);
    }

    private static JTextPane prepareTextPane(ArrayList<Game> e) throws BadLocationException {
        int year = 0, month = 0, day = 0;
        text = new JTextPane();
        StyledDocument doc = text.getStyledDocument();
        for(int i =0; i < e.size(); i++)
        {
            Game temp = e.get(i);
            if(year != temp.getYear() || month != temp.getMonth() || day != temp.getDay())
            {
                doc.insertString(doc.getLength(), "\n" + temp.getMonth() + "/"
                                + temp.getDay() + "/" + temp.getYear() + "\n",
                        doc.getStyle("large"));
                doc.insertString(doc.getLength(), temp.getName() + " vs. " + temp.getOpponent() + " at " + temp.getTime() +"\n",
                        doc.getStyle("regular"));
                year = temp.getYear();
                month = temp.getMonth();
                day = temp.getDay();
            }
            else
            {
                doc.insertString(doc.getLength(), temp.getName() + " vs. " + temp.getOpponent() + " at " + temp.getTime() + "\n",
                        doc.getStyle("regular"));
            }
            System.out.println(temp.getName());
            text.setStyledDocument(doc);
            text.setEditable(false);
        }
        return text;
    }

}