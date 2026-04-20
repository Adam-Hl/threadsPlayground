package pro1.example2b;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

class MyWorker extends SwingWorker<String, String> {
    JPanel centerPanel;
    String room;
    String term;

    public MyWorker(JPanel centerPanel, String room, String term) {
        this.centerPanel = centerPanel;
        this.room = room;
        this.term = term;
    }

    @Override
    public String doInBackground() {

        // TODO

        return "";
    }

    @Override protected void process(List<String> chunks) {
        // define what the event dispatch thread
        // will do with the intermediate results
        // received while the thread is executing

        for (var message : chunks) {
            JLabel label = new JLabel("");
            label.setText(message);
            label.setBorder(new CompoundBorder(
                    BorderFactory.createLineBorder(Color.black),
                    new EmptyBorder(10, 10, 10, 10)
            ));
            centerPanel.add(label);
            centerPanel.validate();
            centerPanel.repaint();
        }
    }
}