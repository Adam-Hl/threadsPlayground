package pro1.example2a;

import javax.swing.*;

public class Main {

    // TODO: Uprav kód v metodě MainFrame.go tak, aby program "nezamrzal",
    //       v této úloze k tomu využij vlákna

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }
}