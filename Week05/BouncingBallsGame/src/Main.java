import java.util.Random;

public class Main {

	public static void main(String[] args) {
		TheGame newGame = new TheGame(1300, 600);
	/*	Ball myBall = new Ball(50, 60, 60, Color.ORANGE, 1);
		Ball myBall2 = new Ball(40, 40, 180, Color.RED, 2);
		
		myBall.setMoveX(1);
		myBall.setMoveY(3);
		myBall2.setMoveX(1);
		myBall2.setMoveY(1);
		
		
		newGame.addBall(myBall);
		newGame.addBall(myBall2);*/
		newGame.startGame();
	}

	

}
