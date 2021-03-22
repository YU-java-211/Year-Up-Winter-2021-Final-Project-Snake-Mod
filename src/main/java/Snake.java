package main.java;

import java.util.Scanner;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.io.File;
import java.io.FileNotFoundException;

public class Snake extends JFrame {

    public Snake() {
        
    	firstLevelUI();
    }
    
    
    
    private void firstLevelUI() {
    	String points = "";
    	try {
    	File file = new File("pointsLivesDate.txt");
    
	    Scanner scanner = new Scanner(file);
    	

	    while(scanner.hasNextLine()) {
	    	points = scanner.nextLine();
	    }

	    } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.File not found.");
	        e.printStackTrace();
	        points = "";
	        
	        add(new Board());
            
	        setResizable(false);
	        pack();
	        
	        setTitle("Snake");
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      }
    	
    	String[] parsePoints = points.split("|");
    	int previousPoints = Integer.parseInt(parsePoints[0]);
    	int previousLives = Integer.parseInt(parsePoints[1]);
	    
        add(new NewLevel( previousPoints, previousLives));
               
        setResizable(false);
        pack();
        
        setTitle("Snake");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new Snake();
            ex.setVisible(true);
        });
    }
}
