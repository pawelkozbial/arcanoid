package graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import listeners.TestListener;

public class NotHelloWorldPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public NotHelloWorldPanel() {
		ImageIcon icTlo = new ImageIcon("images/background.jpg");
		tlo = icTlo.getImage();
		ImageIcon ic = new ImageIcon("images/block-1.png");
		img = ic.getImage();
		// addKeyListener(new Al());
		deskaRect = new Rectangle2D.Double(70, 25.0, 120, 30.0);
		doubleRect = new Rectangle2D.Double(200.0, 25.0, 32.5, 30.0);
		addKeyListener(new TestListener(this));
		// addKeyListener(new NotHelloWorldListener(this).new Al());
		setFocusable(true);
		// time = new Timer(5, this);
		// time.start();
		visible = false;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g); // wyczyszczenie tła
		Graphics2D g2 = (Graphics2D) g;
		g.drawImage(tlo, 0, 0, null);
		g2.draw(doubleRect);
		g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
		g2.setColor(Color.RED);
		if (visible == true)
			g2.draw(deskaRect);

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 3; j++)
				g.drawImage(img, 30 + ((img.getWidth(null) + 25) * i), 30
						+ (img.getHeight(null) + 20) * j, null);
		}

		/*
		 * g.setColor(Color.RED); g.fillRect(squareX,squareY,squareW,squareH);
		 * g.setColor(Color.BLACK); g.drawRect(squareX,squareY,squareW,squareH);
		 */
	}

	public void move() {
		x = x + dx;
	}

	/*
	 * @Override public void actionPerformed(ActionEvent e) {
	 * 
	 * if (x >= 50) visible = true; else visible = false; checkCollision();
	 * repaint(); }
	 */

	public void checkCollision() {
		if (deskaRect.getBounds2D().intersects(doubleRect.getBounds2D())) {
			System.out.println("Kolizja");
		}
	}

	/*
	 * @Override public void paint(Graphics g) { super.paint(g);
	 * g.setColor(Color.RED); g.fillRect(squareX, squareY, squareW, squareH);
	 * g.setColor(Color.BLACK); g.drawRect(squareX, squareY, squareW, squareH);
	 * }
	 */

	/*
	 * private class Al extends KeyAdapter {
	 * 
	 * @Override public void keyTyped(KeyEvent e) { }
	 * 
	 * @Override public void keyPressed(KeyEvent e) { int key = e.getKeyCode();
	 * 
	 * if (key == KeyEvent.VK_RIGHT && x < 200) { x += 5; } if (key ==
	 * KeyEvent.VK_LEFT && x > 20) { x -= 5; } System.out.println("Pressed " +
	 * e.getKeyCode() + " " + x);
	 * 
	 * moveSquare(x, 20); // validate(); // repaint(); }
	 * 
	 * @Override public void keyReleased(KeyEvent e) { int key = e.getKeyCode();
	 * 
	 * if (key == KeyEvent.VK_RIGHT) { x += 0; } if (key == KeyEvent.VK_LEFT) {
	 * x += 0; } } }
	 */

	private void moveSquare(int x, int y) {
		int OFFSET = 1;
		if ((squareX != x) || (squareY != y)) {
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
			squareX = x;
			squareY = y;
			repaint(squareX, squareY, squareW + OFFSET, squareH + OFFSET);
		}
	}

	public boolean getVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	private Timer time;
	private Image tlo, img;

	private int squareX = 50;
	private int squareY = 50;
	private int squareW = 20;
	private int squareH = 20;

	public int x = 20;
	public int dx = 0;

	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;
	public Rectangle2D doubleRect;
	public Rectangle2D deskaRect;

	boolean visible;
}