import javax.swing.Timer;
public class Speed {
	public int setDelay(Timer timer, int DELAY) {
		DELAY = DELAY-2;
		timer.setInitialDelay(DELAY);
		return DELAY;
	}
	public void updateTimer(Timer timer, int DELAY) {
		timer.setDelay(DELAY);
         timer.start();
	}
}
