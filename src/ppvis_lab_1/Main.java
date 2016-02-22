package ppvis_lab_1;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SimpleWindow window = new SimpleWindow("PPVIS-1");
        window.setSize(850, 180);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // window.setResizable(false);
        window.setLocationRelativeTo(null);
    }
}
