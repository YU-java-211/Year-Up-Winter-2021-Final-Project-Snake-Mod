import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Score {
	Font font;
	protected int points;
	protected int timesIncremented;
	
	public Score () {
		points = 0;
		timesIncremented = 1;
		font = new Font("Arial", Font.PLAIN, 36);
	}
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.setFont(font);
		g.drawString("Score: " + points, 520, 50);
		g.setColor(Color.BLACK);
	}
	public void incrementScore(){
		points += timesIncremented*10;
		timesIncremented++;
	}
	public int getPoints(){
		return points;
	}
}
