package graphics;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Ball {

	public Ball(int startX, int startY) {
		this.x = startX;
		this.y = startY;
		ImageIcon ic = new ImageIcon("images/ball.png");
		imgBall = ic.getImage();
		visible = true;
	}

	//public void move(Board board, Player player, Block block) {
	public void move(Board board) {
		x += dx;
		y += dy;

		// Frame bounds

		if (x < board.getBounds().getMinX()) {
			x = (int) board.getBounds().getMinX();
			dx = -dx;
			// System.out.println("MinX: " + board.getBounds().getMinX());
			// System.out.println("Player minX: " + player.getBounds().getX());
		}
		if (x + imgBall.getWidth(null) >= board.getBounds().getMaxX()) {
			x = (int) (board.getBounds().getMaxX() - imgBall.getWidth(null));
			dx = -dx;
			// System.out.println("MaxX: " + board.getBounds().getMaxX());
		}
		if (y < board.getBounds().getMinY()) {
			y = (int) board.getBounds().getMinY();
			dy = -dy;
			// System.out.println("MinY: " + board.getBounds().getMinY());
		}
		if (y + imgBall.getHeight(null) >= board.getBounds().getMaxY()) {
			y = (int) (board.getBounds().getMaxY() - imgBall.getHeight(null));
			dy = -dy;
			// System.out.println("MaxY: " + board.getBounds().getMaxY());
		}
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, imgBall.getWidth(null),
				imgBall.getHeight(null));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getDy() {
		return dy;
	}

	public void setDy(int dy) {
		this.dy = dy;
	}

	public Image getImgBall() {
		return imgBall;
	}

	public boolean isVisible() {
		return visible;
	}

	private int x, y;
	private int dx = 2, dy = 2; // 1,2,5
	private Image imgBall;
	boolean visible;
}
