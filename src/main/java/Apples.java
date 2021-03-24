package main.java;

public class Apples extends Board {
  //initialize apple count
	int appleCount = 0;
  //use parent constructor 
	public Apples(){
		super();
	}
// conditional statement for eating 10 apples 
	public boolean win() {
	if (appleCount == 10) {
		return true;
    // if snake hasn't eaten ten apples player may not move to next level. 
	} else {
		return false;
	}
	} 
	// code for increasing dot everytime snake eats apple
	protected void checkApple() {

        if ((x[0] == apple_x) && (y[0] == apple_y)) {
//dots increase
            dots++;
            locateApple();
        }
    }
	
}
