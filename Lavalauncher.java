import java.awt.EventQueue;
import javax.swing.JFrame;

public class Lavalauncher extends JFrame {

    public Lavalauncher() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Lavalevel());
               
        setResizable(false);
        pack();
        
        setTitle("Lavalauncher");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            JFrame ex = new Lavalauncher();
            ex.setVisible(true);
        });
    }
}
