package main.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner; // Import the Scanner class to read text files

public class ScoreBoard extends Board {

    private File scoreFile = new File("tempScoreFile");
    private int score = 0; //import anisahs variable when available
    private String name;
    private boolean applesEaten = true;
    

    public ScoreBoard() {
        
        initBoard();
    }
    protected void doDrawing(Graphics g) {
    	
        int lowest = 0;
        String lowName;
        
        if (inGame) {

            g.drawImage(apple, apple_x, apple_y, this);

            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else if (applesEaten){
         
        	try {
        	Scanner myReader = new Scanner(scoreFile);
        	
        	
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();//make while loop that reads through file and displays as string
              String [] highScore = data.split("|");
              int tempScore = Integer.parseInt(highScore[0]);
              System.out.println(data);
              
              if (tempScore < score) {
            	  lowest = tempScore;
            	  lowName = highScore[1];
              }
              
            }
            myReader.close();
            
          
            
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        	
        	
        	
			String oldContent = lowest + "|" + lowName;
        	BufferedReader reader = new BufferedReader(new FileReader(scoreFile));
        	String line = reader.readLine();
        	
        	try {
        	
        	while (line != null) {
        		oldContent = oldContent + line + System.lineSeparator();
        		line = reader.readLine();
        	}
        	
        	String newContent = oldContent.replaceAll(oldString, newString);
        	FileWriter writer = new FileWriter(scoreFile);
        	writer.write(newContent);
        	writer.close();
        	} catch (IOException e){
        		e.printStackTrace();
        		
        	} finally {
        		try {
        			reader.close();
        			
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        	}
        	
        	
        	
        } else {

            gameOver(g);
        }        
    }

    protected void lastLevel(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    
}
