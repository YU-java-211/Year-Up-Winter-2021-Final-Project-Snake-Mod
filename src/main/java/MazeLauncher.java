package main.java;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class MazeLauncher extends JFrame {

    public MazeLauncher() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new MazeLevelOne());
               
        setResizable(false);
        pack();
        
        setTitle("Maze Launcher");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new MazeLauncher();
            ex.setVisible(true);
        });
    }
}
