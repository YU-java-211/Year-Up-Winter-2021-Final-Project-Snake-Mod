package main.java;

import java.io.FileWriter;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;



public class NewLevel  extends Board {

    protected int appleCount = 0;
    protected int lives;
    protected int points;
    
    
	public NewLevel(int lives, int points) {
        
	    initBoard();
	}
	    
	
protected void doDrawing(Graphics g) {
        
        if (inGame) {
        	// GRAB AND WRITE OUT TO FILE TO SET DIRECTORY
        	try {
        	FileWriter writer = new FileWriter("pointsLivesDate.txt", false);
        	
            g.drawImage(apple, apple_x, apple_y, this);
        	}catch (Exception e) {}
        	finally {
            	if(appleCount > 9) {
            		//Write out variables to text file (points, lives, date/time)
            		writer.write(points + "|" + lives);
            		//Show YAY! screen
            		yayNextLevel(g);
            	}//return file name
            	try {
            		writer.close();
            	}catch (IOException e) {
					e.printStackTrace();
            	}
        	}
        
            for (int z = 0; z < dots; z++) {
                if (z == 0) {
                    g.drawImage(head, x[z], y[z], this);
                } else {
                    g.drawImage(ball, x[z], y[z], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {
        	
            gameOver(g);
        }        
    }

	protected void yayNextLevel(Graphics g) {
	    
	    String msg = "Yay!";
	    Font small = new Font("Helvetica", Font.BOLD, 14);
	    FontMetrics metr = getFontMetrics(small);
	
	    g.setColor(Color.white);
	    g.setFont(small);
	    g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
	}

    protected void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {

            dots++;
            appleCount++;
            locateApple();
        }
    }
	
	
}
    

