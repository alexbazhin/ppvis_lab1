package ppvis_lab_1;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame simpleWindow = new SimpleWindow().createFrame("PPVIS-1");
        simpleWindow.setSize(850, 180);
        simpleWindow.setVisible(true);
        simpleWindow.setLocationRelativeTo(null);
    }
}
