
import java.util.ArrayList;
import java.util.List;


public class GameRectangle { 
	
	private int width;
	private int height;

	private List<Ball> balls;
	private Player hero;
	private LaserBeam laser;
	private static final int defaultWidth = 1000;
	private static final int defaultHeight = 500;
	
	
	public GameRectangle() {
		this(defaultWidth, defaultHeight);
	}
	
	public GameRectangle(int width, int height) {
		this.width = width;
		this.height = height;
		balls = new ArrayList<>();
		hero = new Player(width / 2);
		hero.setyAxis(height - hero.getHeight());

	}
	
	public GameRectangle(int width, int height, List<Ball> ls) {
		this.width = width;
		this.height = height;
		balls = new ArrayList<>(ls);
		hero = new Player(width / 2);
		hero.setyAxis(height - hero.getHeight());
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public List<Ball> getBalls() {
		return balls;
	}

	public void add(Ball b) {
		balls.add(b);
	}
	
	public Player getPlayer() {
		return hero;
	}
	
	public LaserBeam getLaser() {
		return laser;
	}
	public void setNewBalls(List<Ball> newBalls) {
		balls = new ArrayList<Ball> (newBalls);
	}
	
	public void constructLaserBeam() {
		double heroMiddlePoint = hero.getxAxis() + hero.getWidth() / 2;
		laser = new LaserBeam(heroMiddlePoint, hero.getyAxis());
	}
	
	public void setLaserNULL() {
		laser = null;
	}
	
	public void moveAll(){
		
		for(Ball ball: balls) {
			if(ball.getLeftmostX() + ball.getMoveX() < 0) {
				int newMove = ball.getMoveX() * (-1);
				ball.setMoveX(newMove);
			}
			if(ball.getRightmostX() + ball.getMoveX() > width) {
				int newMove = ball.getMoveX() * (-1);
				ball.setMoveX(newMove);
			}
			if(ball.getLowestY() + ball.getMoveY() > height) {
				int newMove = ball.getMoveY() * (-1);
				ball.setMoveY(newMove);
			}
			if(ball.getHighestY() + ball.getMoveY() < 0) {
				int newMove = ball.getMoveY() * (-1);
				ball.setMoveY(newMove);
			}
			ball.move();
		}
		if(laser != null) {
			System.out.println(laser.getyAxis());
			laser.incrementyAxis(-3.5);
			if(laser.getyAxis() <= 0 ) {
				laser = null;
			}
		}
		
	}

	

	
	
	

}
