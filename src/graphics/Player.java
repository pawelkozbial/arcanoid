package graphics;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import listeners.BoardListener;

public class Player {

	public Player() {
		ImageIcon ic = new ImageIcon("images/player.png");
		imgPlayer = ic.getImage();
		x = 350;
		y = 530;
		balls = new ArrayList<Ball>();
	}

	public void fire() {
		ball = new Ball(x + 80, y - 20);
		balls.add(ball);
		// System.out.println("Utworzono: " + balls.size());
		System.out.println("Size: " + balls.size());
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_SPACE) {
			if (life > 0) {
				if (balls.size() != 1) {
					life--;
					fire();
				}
			}
			if (balls.size() == 0 && ball.isVisible() == false) {
				BoardListener.getTimer().stop();
				JOptionPane.showMessageDialog(null, "KONIEC GRY");
				System.exit(0);
			}
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
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

	public int getLife() {
		return life;
	}

	private int x, y;
	// private int dx, dy;
	private int life = 3;
	private Ball ball;
	private Image imgPlayer;
	private static List<Ball> balls;
}
