package graphics;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Player {

	public Player() {
		ImageIcon ic = new ImageIcon("images/base.png");
		imgPlayer = ic.getImage();
		x = 400;
		y = 560;
		balls = new ArrayList<Ball>();
	}

	public void fire() {
		Ball b = new Ball(200, 200);
		balls.add(b);
		//System.out.println("Utworzono");
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = -5;
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = 5;
		}
		if (key == KeyEvent.VK_UP) {
			dy = -5;
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = 5;
		}
		//System.out.println("Player: " + x);
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}
		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}
		if (key == KeyEvent.VK_UP) {
			dy = 0;
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
	}

	public void move() {
		x += dx;
		y += dy;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Image getImgPlayer() {
		return imgPlayer;
	}
	
	public static List<Ball> getBalls() {
		return balls;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, imgPlayer.getWidth(null),
				imgPlayer.getHeight(null));
	}

	private int x, dx, y, dy;
	private Image imgPlayer;
	private static List<Ball> balls;
}
