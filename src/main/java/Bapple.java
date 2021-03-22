package main.java;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class Bapple extends Board {
	private int bapple_x;
    private int bapple_y;
    private Image bapple;
    
    protected void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();
        
        ImageIcon iib = new ImageIcon("src/resources/badApple_sm.png"); 
        bapple = iib.getImage();
    }
    
    protected void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        
        locateApple();
        locateBapple();

        timer = new Timer(DELAY, this);
        timer.start();
    }
    
	protected void doDrawing(Graphics g) {
	        
	        if (inGame) {
	
	            g.drawImage(apple, apple_x, apple_y, this);
	            g.drawImage(bapple, bapple_x, bapple_y, this);
	
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
	
	protected void checkCollision() {

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
            }

        }

	        if (y[0] >= B_HEIGHT) {
	            inGame = false;
	        }
	        if ((x[0] == bapple_x) && (y[0] == bapple_y)) {
	
	            inGame = false;
	        }
	
	        if (y[0] < 0) {
	            inGame = false;
	        }
	
	        if (x[0] >= B_WIDTH) {
	            inGame = false;
	        }
	
	        if (x[0] < 0) {
	            inGame = false;
	        }
	        
	        if (!inGame) {
	            timer.stop();
	        }
	    }
		
		protected void locateBapple() {
	
	        int r = (int) (Math.random() * RAND_POS);
	        bapple_x = ((r * DOT_SIZE));
	
	        r = (int) (Math.random() * RAND_POS);
	        bapple_y = ((r * DOT_SIZE));
	    }
		
	   protected void checkBapple() {
	
	        if ((x[0] == apple_x) && (y[0] == apple_y)) {
	
	            timer.stop();
	        }
	    }
	}
