


import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Color;
import java.awt.FontMetrics;

public class PauseMenu extends JPanel {

    int B_WIDTH = 0;
    int B_HEIGHT = 0;

    public PauseMenu(int width, int height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(int var) {
        this.B_WIDTH = var;
    }

    public void setHeight(int var) {
        this.B_HEIGHT = var;
    }

    public void gamePause(Graphics g) {

        String msg = "Game Pause";
        Font small = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (this.B_WIDTH - metr.stringWidth(msg)) / 2, this.B_HEIGHT / 2);
    }
}
