package main.java;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Reverse extends JFrame {

    public Reverse() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Reverse_lvl());
               
        setResizable(false);
        pack();
        
        setTitle("Reverse");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new Reverse();
            ex.setVisible(true);
        });
    }
}
