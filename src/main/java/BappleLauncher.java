package main.java;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class BappleLauncher extends JFrame {

    public BappleLauncher() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Bapple());
               
        setResizable(false);
        pack();
        
        setTitle("BappleLauncher");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new BappleLauncher();
            ex.setVisible(true);
        });
    }
}
