package main.java;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Timer;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
public class MazeLevelOne extends Board {
	  protected int brickLocationY;
      protected int brickLocationX;
      protected Image brick;
	    protected void loadImages() {
	        ImageIcon iid = new ImageIcon("src/resources/dot.png");
	        ball = iid.getImage();
	        ImageIcon iia = new ImageIcon("src/resources/apple.png");
	        apple = iia.getImage();
	        ImageIcon iih = new ImageIcon("src/resources/head.png");
	        head = iih.getImage();
	        ImageIcon iiw = new ImageIcon("src/resources/brick.png");
	        brick = iiw.getImage();
	        // input wall image here //
	    }
	    protected void initGame() {
	        dots = 3;
	        for (int z = 0; z < dots; z++) {
	            x[z] = 50 - z * 10;
	            y[z] = 50;
	        }
	        locateApple();
	        brickLocationY = 200;
	        brickLocationX = 200;
	        timer = new Timer(DELAY, this);
	        timer.start();
	    }
       protected void doDrawing(Graphics g) {
	        if (inGame) {
	            g.drawImage(apple, apple_x, apple_y, this);
	            g.drawImage(brick, brickLocationX, brickLocationY, this);
	            //checkMaze();
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
       
       protected void move() {
    	   
    	   if  ((((x[0] - 10) < brickLocationX) && ((x[0] + 10) > brickLocationX))
    				 && (((y[0] - 10) < brickLocationY) && ((y[0] + 10) > brickLocationY))) {
    	   
    	   // ((x[0] == brickLocationX) && (y[0] == brickLocationY)) {
		    	System.out.println("brickLocationX " + brickLocationX + " brickLocationY " + brickLocationY + " x[0] " + x[0] + " y[0] " + y[0]);

		        if (leftDirection) {
		          if  ((x[0] + 5) > brickLocationX && (x[0] - 5) < brickLocationX)  {
		            x[0] = x[0];
		            System.out.println("hit");
		          } else { 
		        	  for (int z = dots; z > 0; z--) {
		                  x[z] = x[(z - 1)];
		                  y[z] = y[(z - 1)];
		              }
   		        	x[0] -= DOT_SIZE;
   		          }
		        }
		        

		        if (rightDirection) {
		        	if  ((x[0] + 5) > brickLocationX && (x[0] - 5) < brickLocationX) {
   		            x[0] = x[0];
   		          } else {
   		        	for (int z = dots; z > 0; z--) {
   		               x[z] = x[(z - 1)];
   		               y[z] = y[(z - 1)];
   		           }
   		        	x[0] += DOT_SIZE;
   		          }
		        }
		        

		        if (upDirection) {
		        	if  ((y[0] + 5) > brickLocationY && (y[0] - 5) < brickLocationY) {
   		            y[0] = y[0];
   		          } else {
   		        	for (int z = dots; z > 0; z--) {
   		               x[z] = x[(z - 1)];
   		               y[z] = y[(z - 1)];
   		           }
   		        	y[0] -= DOT_SIZE;
   		          }
		        }
		        

		        if (downDirection) {
		        	if  ((y[0] + DOT_SIZE) == brickLocationY) {
   		            y[0] = y[0];
   		          } else {
   		        	for (int z = dots; z > 0; z--) {
   		               x[z] = x[(z - 1)];
   		               y[z] = y[(z - 1)];
   		           }
   		        	y[0] += DOT_SIZE;
   		          }
		        	
		        }
		    } else { 
    	   
           for (int z = dots; z > 0; z--) {
               x[z] = x[(z - 1)];
               y[z] = y[(z - 1)];
           }

           if (leftDirection) {
               x[0] -= DOT_SIZE;
           }

           if (rightDirection) {
               x[0] += DOT_SIZE;
           }

           if (upDirection) {
               y[0] -= DOT_SIZE;
           }

           if (downDirection) {
               y[0] += DOT_SIZE;
           }
		 }
       }
       
       
       
       protected void checkMaze() {

    	   for (int z = dots; z > 0; z--) {

    		    if (((x[0] -1) == brickLocationX) || ((x[0] +1) == brickLocationX) || (x[0] == brickLocationX) 
    		    		&& (((y[0] -1) == brickLocationY) || ((y[0] +1) == brickLocationY) || (y[0] == brickLocationY)) ) {
    		    	

    		        if (leftDirection) {
    		          if  ((x[0] += DOT_SIZE) == brickLocationX) {
    		            x[0] = x[0];
    		          }
    		        }

    		        if (rightDirection) {
    		        	if  ((x[0] -= DOT_SIZE) == brickLocationX) {
        		            x[0] = x[0];
        		          }
    		        }

    		        if (upDirection) {
    		        	if  ((y[0] += DOT_SIZE) == brickLocationY) {
        		            y[0] = y[0];
        		          }
    		        }

    		        if (downDirection) {
    		        	if  ((y[0] -= DOT_SIZE) == brickLocationY) {
        		            y[0] = y[0];
        		          }
    		        }
    		    }
    		}
       }
}









// (((x[0] -1) == brickLocationX) || ((x[0] +1) == brickLocationX) || (x[0] == brickLocationX) 
		// && (((y[0] -1) == brickLocationY) || ((y[0] +1) == brickLocationY) || (y[0] == brickLocationY)) )