package main.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Board extends JPanel implements ActionListener {
	
	protected static final long serialVersionUID = 1L;
    protected final int B_WIDTH = 600;
    protected final int B_HEIGHT = 600;
    protected final int DOT_SIZE = 10;
    protected final int ALL_DOTS = (B_WIDTH * B_HEIGHT)/DOT_SIZE;
    protected int DELAY = 140;

    protected final int x[] = new int[ALL_DOTS];
    protected final int y[] = new int[ALL_DOTS];

    protected int dots;
    protected int apple_x;
    protected int apple_y;

    protected boolean leftDirection = false;
    protected boolean rightDirection = true;
    protected boolean upDirection = false;
    protected boolean downDirection = false;
    protected boolean inGame = true;

    protected Timer timer;
    protected Image ball;
    protected Image apple;
    protected Image head;
    
    protected Random random = new Random();
    protected String score;
    protected String speed;
    protected String highscore = "";
    protected int highScoreCheck, scoreCheck;
    protected Speed timerSpeed = new Speed();
    
    

    public Board() {
        
        initBoard();
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        JTextField field = new JTextField(4);
        add(field, gbc);

        JButton btn = new JButton("Start");
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (timer.isRunning()) {
                    timer.stop();
                    btn.setText("Start");
                } else {
                    int counter = 0;
                    timer.start();
                    field.setText(Integer.toString(counter));
                    btn.setText("Stop");
                }
            }
        });
        add(btn, gbc);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int counter = 0;
                counter++;
                if (counter >= 60) {
                    timer.stop();
                    btn.setText("Start");
                }
                field.setText(Integer.toString(counter));
            }
        });
    }
    
    protected void initBoard() {

        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        loadImages();
        initGame();
    }

    protected void loadImages() {

        ImageIcon iid = new ImageIcon("src/resources/dot.png");
        ball = iid.getImage();

        ImageIcon iia = new ImageIcon("src/resources/apple.png");
        apple = iia.getImage();

        ImageIcon iih = new ImageIcon("src/resources/head.png");
        head = iih.getImage();
    }

    protected void initGame() {

        dots = 3;

        for (int z = 0; z < dots; z++) {
            x[z] = 50 - z * 10;
            y[z] = 50;
        }
        
        locateApple();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    protected void doDrawing(Graphics g) {
    	
    	if(highscore.equalsIgnoreCase("")) {
        	highscore = Score.getHighScore();
    	}
        
        if (inGame) {
        	
        	Font small = new Font("Helvetica", Font.BOLD, 14);

            g.setColor(Color.white);
            g.setFont(small);
        	score = String.valueOf((dots-3)*10);
        	//speed = String.valueOf(140 - timer.getDelay());
        	g.drawString("Current score : " + score, 0, 20);
        	//g.drawString("Current speed : " + speed, 140, 20);
        	g.drawString("Highscore : " + highscore, 280, 20);

            g.drawImage(apple, apple_x, apple_y, this);

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

    protected void gameOver(Graphics g) {
        
        String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - metr.stringWidth(msg)) / 2, B_HEIGHT / 2);
    }

    protected void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {
        	
        	DELAY = timerSpeed.setDelay(timer, DELAY, 2);
        	timerSpeed.updateTimer(timer, DELAY);

            dots++;
            locateApple();
        }
    }

    protected void move() {

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

    protected void checkCollision() {
    	
    	highScoreCheck = Integer.parseInt((highscore.split(":")[1]));
    	scoreCheck = Integer.parseInt(score);

        for (int z = dots; z > 0; z--) {

            if ((z > 4) && (x[0] == x[z]) && (y[0] == y[z])) {
                inGame = false;
                
                Score.checkScore(scoreCheck, highScoreCheck);
            }
        }

        if (y[0] >= B_HEIGHT) {
            inGame = false;
            Score.checkScore(scoreCheck, highScoreCheck);
        }

        if (y[0] < 0) {
            inGame = false;
            Score.checkScore(scoreCheck, highScoreCheck);
        }

        if (x[0] >= B_WIDTH) {
            inGame = false;
            Score.checkScore(scoreCheck, highScoreCheck);
        }

        if (x[0] < 0) {
            inGame = false;
            Score.checkScore(scoreCheck, highScoreCheck);
        }
        
        if (!inGame) {
            timer.stop();
        }
    }

    protected void locateApple() {

        
        apple_x = random.nextInt((int)(B_WIDTH/DOT_SIZE))*DOT_SIZE;

       
        apple_x = random.nextInt((int)(B_WIDTH/DOT_SIZE))*DOT_SIZE;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (inGame) {

            checkApple();
            checkCollision();
            move();
        }

        repaint();
    }

    protected class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}
