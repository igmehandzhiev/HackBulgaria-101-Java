import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TheGame extends JFrame {
	private GameRectangle mGame;
	private MyPanel myPanel;
	StopWatch timer;
	
	
	boolean gameOver = false;
	private int score;
	private int levelNumber;
	
	private static final int MIN_DIAMETER = 20;

	public TheGame(int rectWidth, int rectHeight) {
		super("Buster Bros");
		mGame = new GameRectangle(rectWidth, rectHeight);
		myPanel = new MyPanel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		getContentPane().add(myPanel);
		setSize(mGame.getWidth(), mGame.getHeight() + 100);
		setVisible(true);
		setResizable(true);
		addKeyListener(new MyKeyListener());
	}

	public TheGame(int rectWidth, int rectHeight, List<Ball> balls) {
		super("Buster Bros");
		mGame = new GameRectangle(rectWidth, rectHeight, balls);
		myPanel = new MyPanel();
	}
	
	public void initTimer() {
		timer.initTimer();;
	}
	
	public void startGame() {
		
		levelNumber = 0;
		
		timer = new StopWatch();
		
		while (!gameOver) {
			
			initTimer();

			levelNumber++;
			initBallsForLevel(levelNumber);
			
			boolean levelCompleted = false;
			
			while(!levelCompleted || !gameOver) {
				if(mGame.getBalls().size() == 0) {
					levelCompleted = true;
					break;
				}
				
				
				mGame.moveAll();
				myPanel.repaint();
				
				if(isPlayerHit() || timer.getInterval() == 0) {
					gameOver = true;
				}
				
				if(mGame.getLaser() != null && isBallHit()){
					splitBalls();
				}
				
				try {
					Thread.sleep(5);
				} catch (Exception ex) {

				}
			}
			
		}
	}

	
	private void initBallsForLevel(int levelNumber) {
		for(int i = 0; i < levelNumber; i++) {
			Random rand = new Random();

			double randomDiam = 60 + rand.nextInt(40);
			int randomCenterX = 50 + rand.nextInt(mGame.getWidth() - 50);
			int randomCenterY = 50 + rand.nextInt(50);
			
			float r = rand.nextFloat();
			float g = rand.nextFloat();
			float b = rand.nextFloat();
			
			Color randomColor = new Color(r, g, b);
			
			double speed = 1;
			
			Ball newBall = new Ball(randomDiam, randomCenterX, randomCenterY, randomColor, speed);
			
			int randMoveX = 1 + rand.nextInt(3);
			int randMoveY = 1 + rand.nextInt(3);
			
			System.out.println("RX " + randMoveX);
			System.out.println("RY " + randMoveY);
			
			
			newBall.setMoveX(randMoveX);
			newBall.setMoveY(randMoveY);

			mGame.add(newBall);
		}
	}

	public void addBall(Ball ballToAdd) {
		mGame.add(ballToAdd);
	}

	public JPanel getPanel() {
		return myPanel;
	}


	private boolean isPlayerHit() {
		
		for (Ball ball : mGame.getBalls()) {
			
			double ballLowestPoint = ball.getLowestY();
			double ballLeftmostPoint = ball.getLeftmostX();
			double ballRightmostPoint = ball.getRightmostX();
			
			double playerHighestPoint = mGame.getPlayer().getyAxis();
			double playerRightmostPoint = mGame.getPlayer().getxAxis() + mGame.getPlayer().getWidth();
			double playerLeftmostPoint = mGame.getPlayer().getxAxis();
			
			if(ballLowestPoint >= playerHighestPoint 
					&& ballLeftmostPoint <= playerRightmostPoint
					&& ballRightmostPoint >= playerLeftmostPoint) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isBallHit() {
		
		for (Ball ball : mGame.getBalls()) {
			
			double ballLowestPoint = ball.getLowestY();
			double ballLeftmostPoint = ball.getLeftmostX();
			double ballRightmostPoint = ball.getRightmostX();
			
			
			if(ballLowestPoint >=  mGame.getLaser().getyAxis()
					&& ballLeftmostPoint <= mGame.getLaser().getxAxis()
					&& ballRightmostPoint >= mGame.getLaser().getxAxis()) {
				score += 150;
				return true;
			}
		}
		return false;
	}
	
	private void splitBalls() {
		
		List<Ball> newBalls = new ArrayList<Ball>(mGame.getBalls());
		
		for (Ball ball : mGame.getBalls()) {
			
			double ballLowestPoint = ball.getLowestY();
			double ballLeftmostPoint = ball.getLeftmostX();
			double ballRightmostPoint = ball.getRightmostX();
			
			
			if(ballLowestPoint >=  mGame.getLaser().getyAxis()
					&& ballLeftmostPoint <= mGame.getLaser().getxAxis()
					&& ballRightmostPoint >= mGame.getLaser().getxAxis()) {
				
				newBalls.remove(ball);
				
				if(ball.getDiameter() / 2 >= TheGame.MIN_DIAMETER) {
					
					double newDiam = ball.getDiameter() / 2;
					int newCenterX = ball.getCenterX() + (int)ball.getDiameter() / 2;
					
					Ball ball1 = new Ball(newDiam, newCenterX, ball.getCenterY(), ball.getColor(), ball.getSpeed());
					
					newDiam = ball.getDiameter() / 2;
					newCenterX = ball.getCenterX() - (int)ball.getDiameter() / 2;
					
					Ball ball2 = new Ball(newDiam, newCenterX, ball.getCenterY(), ball.getColor(), ball.getSpeed());
					
					ball1.setMoveX(ball.getMoveX());
					ball1.setMoveY(Math.abs(ball.getMoveY()) * (-1));
					
					ball2.setMoveX(ball.getMoveX() * (-1));
					ball2.setMoveY(Math.abs(ball.getMoveY()) * (-1));
					
					newBalls.add(ball1);
					newBalls.add(ball2);
				}
			}
			
			mGame.setNewBalls(newBalls);
		}
		
		mGame.setLaserNULL();
		
	}
	

	class MyPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			
			if(gameOver) {
				endScreenLoser(g);
				return;
			}
			
			if(mGame.getBalls().size() == 0) {
				endScreenWinner(g);
				return;
			}
			
			drawInfoRect(g);
			
			drawGameRectangle(g);
			drawPlayer(g);
			drawBalls(g);

			LaserBeam laser = mGame.getLaser();
			if(laser != null) {
				drawLaser(g, laser);
			}
			
			g.dispose();
			Toolkit.getDefaultToolkit().sync();
		}

		private void drawInfoRect(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(4));
			g.setColor(Color.GRAY);
			g.fillRect(0, mGame.getHeight(), mGame.getWidth(), 100);
			g.setColor(Color.CYAN);
			g.drawRect(0, mGame.getHeight(), mGame.getWidth(), 100);
			
			drawLevelNumber(g);
			drawScore(g);
			drawTime(g);
			
		}

		private void drawTime(Graphics g) {
			g.setColor(Color.ORANGE);
			g.setFont(new Font("TimesRoman", Font.BOLD, 40));
			g.drawString("Time left: " + timer.getInterval(), mGame.getWidth() - 1250, mGame.getHeight() + 60);
		}

		private void drawScore(Graphics g) {
			g.setColor(Color.ORANGE);
			g.setFont(new Font("TimesRoman", Font.BOLD, 40));
			g.drawString("SCORE: " + score, mGame.getWidth() - 750, mGame.getHeight() + 60);
			
		}

		private void drawLevelNumber(Graphics g) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.BOLD, 40));
			g.drawString("LEVEL " + levelNumber, mGame.getWidth() - 200, mGame.getHeight() + 40);
		}

		private void endScreenWinner(Graphics g) {
			g.setColor(Color.GRAY);
			g.fillRect(70, 70, 740, 240);
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			g.drawString("YOU WON! CONGRATULATIONS", 100, 200);
			g.drawString("Your score: " + score , 300, 250);
			
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(4));
			g.setColor(Color.CYAN);
			g.drawRect(70, 70, 740, 240);
			
		}

		private void drawLaser(Graphics g, LaserBeam laser) {
				Graphics2D g2 = (Graphics2D) g;
				g2.setStroke(new BasicStroke(4));
			
				g.setColor(Color.RED);
				g.drawLine((int)laser.getxAxis(), (int)mGame.getPlayer().getyAxis() - 2, 
						(int)laser.getxAxis(), (int)laser.getyAxis());
			
		}

		private void drawBalls(Graphics g) {
			for (Ball ball : mGame.getBalls()) {
				g.setColor(ball.getColor());
				g.fillOval((int) ball.getLeftmostX(), (int) ball.getHighestY(), (int) ball.getDiameter(),
						(int) ball.getDiameter());
			}
			
		}

		private void drawPlayer(Graphics g) {
			g.setColor(Color.BLUE);
			g.fillRect(mGame.getPlayer().getxAxis(), mGame.getPlayer().getyAxis(), mGame.getPlayer().getWidth(),
					mGame.getPlayer().getHeight());
			
		}

		private void drawGameRectangle(Graphics g) {
			Graphics2D g2 = (Graphics2D) g;
			g2.setStroke(new BasicStroke(4));
			
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, mGame.getWidth(), mGame.getHeight());
			g.setColor(Color.CYAN);
			g.drawRect(0, 0, mGame.getWidth(), mGame.getHeight());

			
		}

		private void endScreenLoser(Graphics g) {
			g.setColor(Color.YELLOW);
			g.fillRect(70, 70, 740, 340);
			g.setColor(Color.BLACK);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
			g.drawString("GAME OVER", 300, 250);
			
		}
	}

	class MyKeyListener implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == KeyEvent.VK_LEFT) {
				mGame.getPlayer().movePlayerLeft();
			}
			if (keyCode == KeyEvent.VK_RIGHT) {
				mGame.getPlayer().movePlayerRight();
			}
			if (keyCode == KeyEvent.VK_SPACE) {
				mGame.constructLaserBeam();
			}

		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub

		}
	}
	
	/*class RemindTask extends TimerTask {
	    public void run() {
	      System.out.println("Time's up!");
	      timer.cancel(); //Not necessary because we call System.exit
	      //System.exit(0); //Stops the AWT thread (and everything else)
	    }
	  }*/
}
