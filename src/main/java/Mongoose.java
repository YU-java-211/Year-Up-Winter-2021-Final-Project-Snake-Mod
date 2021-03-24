package main.java;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Mongoose extends JFrame {

    public Mongoose() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Mongoose_lvl());
               
        setResizable(false);
        pack();
        
        setTitle("Mongoose");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new Mongoose();
            ex.setVisible(true);
        });
    }
}
