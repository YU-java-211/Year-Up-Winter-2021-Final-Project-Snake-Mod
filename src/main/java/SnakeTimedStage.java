package main.java;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;


public class SnakeTimedStage extends Board {
	Timer timer;
	int second;
	JFrame window;
	JLabel counterLabel;
	Font font1 = new Font("Arial", Font.PLAIN, 70);
	
	public static void main(String[] args) {
		new Board();
	}
	public void Board() {
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		
		counterLabel = new JLabel("");
		counterLabel.setBounds(300,230,200,100);;
		counterLabel.setHorizontalAlignment(JLabel.CENTER);
		counterLabel.setFont(font1);
		
		window.add(counterLabel);
		window.setVisible(true);
		
		counterLabel.setText("45");
		second = 45;
		simpleTimer();
		timer.start();
	}
	
	
	public void simpleTimer() {
		timer = new Timer (1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				second--;
				counterLabel.setText(""+second);
				
				if(second==0) {
					timer.stop();
				}
			}
		}); 
	}
}

	
	

