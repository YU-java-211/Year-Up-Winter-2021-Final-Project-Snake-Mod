import java.awt.EventQueue;
import javax.swing.JFrame;

public class Launcher extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1503268438955605275L;


	public Launcher() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new SnakeTimedStage());
               
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