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

		/*
		 * Rectangle rectPlayer = player.getBounds(); Rectangle rectBall =
		 * this.getBounds(); Rectangle rectBlock = block.getBounds();
		 * 
		 * // Player bounds
		 * 
		 * if (rectBall.intersects(rectPlayer) && (rectPlayer.getMinX() -
		 * (imgBall.getWidth(null) - dx)) == rectBall .getX()) { dx = -dx;
		 * block.setVisible(true); // System.out.println("MinX player " +
		 * rectPlayer.getMinX()); } if (rectBall.intersects(rectPlayer) &&
		 * (rectPlayer.getMaxX() - (imgBall.getWidth(null) + dx)) == rectBall
		 * .getX()) { dx = -dx; block.setVisible(true);
		 * System.out.println("MaxX player " + rectPlayer.getMaxX()); } if
		 * (rectBall.intersects(rectPlayer) && (rectPlayer.getY() -
		 * (imgBall.getHeight(null) - dy)) == rectBall .getY()) { dy = -dy;
		 * block.setVisible(true); System.out.println("MIN: " +
		 * rectBall.getMinY() + " MAX " + rectBall.getMaxY()); }
		 * 
		 * // Block bounds if (block.isVisible() == true) {
		 * 
		 * if (rectBall.intersects(rectBlock) && (rectBlock.getMinX() -
		 * (imgBall.getWidth(null) - dx)) == rectBall .getX()) { dx = -dx;
		 * block.setVisible(false); System.out.println("MinX " +
		 * rectBall.getMinX()); } if (rectBall.intersects(rectBlock) &&
		 * (rectBlock.getMaxX() - (imgBall.getWidth(null) + dx)) == rectBall
		 * .getX()) { dx = -dx; block.setVisible(false);
		 * System.out.println("MaxX " + rectBall.getMinX()); } if
		 * (rectBall.intersects(rectBlock) && (rectBlock.getMinY() -
		 * (imgBall.getHeight(null) - dy)) == rectBall .getY()) { dy = -dy;
		 * block.setVisible(false); // System.exit(0);
		 * System.out.println("MinY " + rectBall.getY()); } if
		 * (rectBall.intersects(rectBlock) && (rectBlock.getMaxY() -
		 * (imgBall.getHeight(null) + dy)) == rectBall .getY()) {
		 * System.out.println("MaxY " + rectBall.getY()); dy = -dy;
		 * block.setVisible(false); } }
		 */
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
