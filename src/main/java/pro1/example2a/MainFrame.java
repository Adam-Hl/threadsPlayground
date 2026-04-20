package pro1.example2a;

import com.google.gson.Gson;
import pro1.example2a.api.Api;
import pro1.example2a.api.apiDataModel.ActionsList;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MainFrame extends JFrame {

    JPanel centerPanel;

    public MainFrame() {
        setTitle("PRO1 Graphics");
        setVisible(true);
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setPreferredSize(new Dimension(200, 0));
        add(leftPanel, BorderLayout.WEST);

        centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setBackground(Color.WHITE);

        for(var r : new String[]{"J8","J9","J10"})
            for(var t : new String[]{"ZS","LS"})
            {
                JButton button = new JButton(r+" "+t);
                leftPanel.add(button);
                button.addActionListener((e) -> go(r,t));
            }

        JCheckBox dummyCheckBox = new JCheckBox();
        leftPanel.add(dummyCheckBox);
    }

    private void go(String room, String term) {

        centerPanel.removeAll();
        centerPanel.validate();
        centerPanel.repaint();

        for (int y = 1995; y <= 2030; y++) {
            String json = Api.getActionsByRoom(room, term, y);
            ActionsList actions = new Gson().fromJson(json, ActionsList.class);
            int localY = y;

            // START UPDATING UI
                JLabel label = new JLabel("");
                label.setText(localY + ": " + actions.items.size() + " akcí");
                label.setBorder(new CompoundBorder(
                        BorderFactory.createLineBorder(Color.black),
                        new EmptyBorder(10, 10, 10, 10)
                ));
                centerPanel.add(label);
                centerPanel.validate();
                centerPanel.repaint();
            // END UPDATING UI
        }

    }
}