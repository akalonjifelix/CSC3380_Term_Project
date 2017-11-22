//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package testing;

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
import java.util.List;
import java.util.ListIterator;

public class UI extends WindowAdapter implements ActionListener {
    private static JFrame frame;
    private static Button submitButton;
    private static JList list;
    private static UI current;
    private static JTextPane text;


    UI(String title, Object[] array) {
        current = this;
        frame = prepareFrame(title);
        JScrollPane listb = prepareList(array);
        Label loginLabel = new Label("Select your teams", 2);
        loginLabel.setForeground(Color.RED);
        loginLabel.setSize(200, 100);
        loginLabel.setFont(new Font("Something", 1, 19));
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
        list = new JList(teamArray);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL_WRAP);
        list.setVisibleRowCount(-1);
        JScrollPane listScroller = new JScrollPane(list);
        listScroller.setPreferredSize(new Dimension(150, 150));
        return listScroller;
    }
    private static Button prepareButton(String actionCommand) {
        Button submitButton = new Button("Generate");
        submitButton.setBackground(Color.RED);
        submitButton.setActionCommand(actionCommand);
        submitButton.addActionListener(current);
        return submitButton;
    }

    public void actionPerformed(ActionEvent e) {
        Controller.generateSchedule(list.getSelectedValuesList());
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
        frame = new JFrame("ComboSchedge");
        frame.setSize(1500, 2000);
        frame.setLayout(new BorderLayout());
        frame.setExtendedState(0);
        frame.addWindowListener(current);
        frame.setDefaultCloseOperation(2);
        return frame;
    }

    private static void makeSchedule(List<Object> e){
        frame.removeAll();
        frame = prepareFrame();
        text = prepareTextPane(e);
        Label label = new Label("You have successfully logged in!");
        label.setBackground(Color.CYAN);
        label.setSize(200, 100);
        label.setFont(new Font("Something", 1, 19));
        frame.add("Center", label);
        frame.add("Bottom", text);
    }

    private static JTextPane prepareTextPane(List<Object> e)
    {
        int year = 0, month = 0, day = 0;
        text = new JTextPane();
        StyledDocument doc = text.getStyledDocument();
        ListIterator iterator = e.listIterator();
        while(iterator.hasNext())
        {
            Game temp = iterator.next();
            if(year != temp.getYear() && month != temp.getMonth() && day != temp.getDay())
            {
                doc.insertString(doc.getLength(), temp.getMonth().toString() + "/"
                        + temp.getDay().toString() + "/" + temp.getYear().toString,
                        doc.getStyle("large"));
                doc.insertString(doc.getLength(), temp.getName() + " vs. " + temp.getOpp() + ": " + temp.getTime,
                        doc.getStyle("regular"));
            }
            else
            {
                doc.insertString(doc.getLength(), temp.getName() + " vs. " + temp.getOpp() + ": " + temp.getTime,
                        doc.getStyle("regular"));
            }
        }
        return text;
    }

}
