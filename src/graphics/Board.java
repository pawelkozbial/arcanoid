package graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

	public Board() {
		player = new Player();
		block = new Block();
		ball = new Ball(200, 200);
		setFocusable(true);
		addKeyListener(new AL());
		// addKeyListener(new BoardListener(this, p));
		ImageIcon ic = new ImageIcon("images/background.jpg");
		imgBackground = ic.getImage();
		ic = new ImageIcon("images/block-1.png");
		img = ic.getImage();
		time = new Timer(5, this);
		time.start();
		blocks = new ArrayList<Block>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 3; j++) {

				blocks.add(new Block());
				blocks.get(ktory).setX(
						30 + (block.getImgBlock().getWidth(null) + 28) * i);
				blocks.get(ktory).setY(
						30 + (block.getImgBlock().getHeight(null) + 20) * j);

				System.out.println("Block: " + (ktory) + " "
						+ blocks.get(ktory).getX() + " "
						+ blocks.get(ktory).getY());
				ktory++;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * for (int i = 0; i < balls.size(); i++) { ball = balls.get(i); if
		 * (ball.getVisible() == true) { ball.move(); } else balls.remove(i); }
		 */
		player.move();
		ball.move(this);
		collision();
		validate();
		repaint();
	}

	public void collision() {
		Rectangle rectPlayer = player.getBounds();
		Rectangle rectBall = ball.getBounds();
		// Rectangle rectBlock = block.getBounds();

		// Player bounds

		if (rectBall.intersects(rectPlayer)
				&& (rectPlayer.getMinX() - (ball.getImgBall().getWidth(null) - ball
						.getDx())) == rectBall.getX()) {
			ball.setDx(-ball.getDx());
			// block.setVisible(true);
			// System.out.println("MinX player " + rectPlayer.getMinX());
		}
		if (rectBall.intersects(rectPlayer)
				&& (rectPlayer.getMaxX() - (ball.getImgBall().getWidth(null) + ball
						.getDx())) == rectBall.getX()) {
			ball.setDx(-ball.getDx());
			block.setVisible(true);
			/* System.out.println("MaxX player " + rectPlayer.getMaxX()); */
		}
		if (rectBall.intersects(rectPlayer)
				&& (rectPlayer.getY() - (ball.getImgBall().getHeight(null) - ball
						.getDy())) == rectBall.getY()) {
			ball.setDy(-ball.getDy());
			block.setVisible(true);
			/*
			 * System.out.println("MIN: " + rectBall.getMinY() + " MAX " +
			 * rectBall.getMaxY());
			 */
		}

		// Block bounds
		for (int i = 0; i < blocks.size(); i++) {
			block = blocks.get(i);
			Rectangle rectBlock = block.getBounds();
			if (block.isVisible() == true) {

				if (rectBall.intersects(rectBlock)
						&& (rectBlock.getMinX() - (ball.getImgBall().getWidth(
								null) - ball.getDx())) == rectBall.getX()) {
					ball.setDx(-ball.getDx());
					block.setVisible(false);
					ile++;
					System.out.println("ILE: " + ile);
					System.out.println("Block " + block.getX());
				}
				if (rectBall.intersects(rectBlock)
						&& (rectBlock.getMaxX() - (ball.getImgBall().getWidth(
								null) + ball.getDx())) == rectBall.getX()) {
					ball.setDx(-ball.getDx());
					block.setVisible(false);
					ile++;
					System.out.println("ILE: " + ile);
					System.out.println("Block " + block.getX());
				}
				if (rectBall.intersects(rectBlock)
						&& (rectBlock.getMinY() - (ball.getImgBall().getHeight(
								null) - ball.getDy())) == rectBall.getY()) {
					ball.setDy(-ball.getDy());
					block.setVisible(false);
					ile++;
					System.out.println("ILE: " + ile);
					System.out.println("Block " + block.getX());
				}
				if (rectBall.intersects(rectBlock)
						&& (rectBlock.getMaxY() - (ball.getImgBall().getHeight(
								null) + ball.getDy())) == rectBall.getY()) {
					ball.setDy(-ball.getDy());
					block.setVisible(false);
					ile++;
					System.out.println("ILE: " + ile);
					System.out.println("Block " + block.getX());
				}
			} else {
				blocks.remove(i);
				if(blocks.size()==0){
				System.out.println("KONIEC");
				System.exit(0);
				}
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(imgBackground, 0, 0, null);
		// if (block.isVisible() == true) {
		// g2d.drawImage(block.getImgBlock(), block.getX(), block.getY(), null);
		// }
		g2d.drawImage(player.getImgPlayer(), player.getX(), player.getY(), null);

		/*
		 * for (int i = 0; i < 8; i++) { for (int j = 0; j < 3; j++) {
		 * g.drawImage(block.getImgBlock(), 30 +
		 * ((block.getImgBlock().getWidth(null) + 28) * i), 30 +
		 * (block.getImgBlock().getHeight(null) + 20) * j, null); } }
		 */

		// for (int i = 0; i < 8; i++) {
		// for (int j = 0; j < 3; j++) {
		// if (blocks.get(i * j).isVisible() == true)
		// g2d.drawImage(block.getImgBlock(),
		// blocks.get(i * j).getX(), blocks.get(i * j).getY(),
		// null);
		// }
		// }

		g2d.drawImage(ball.getImgBall(), ball.getX(), ball.getY(), null);

		/*
		 * List<Ball> balls = Player.getBalls(); for (int i = 0; i <
		 * balls.size(); i++) { Ball ball = balls.get(i);
		 * g2d.drawImage(ball.getImgBall(), ball.getX(), ball.getY(), null); }
		 */
	}

	private class AL extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			player.keyPressed(e);
			super.keyPressed(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			player.keyReleased(e);
			super.keyReleased(e);
		}
	}

	private Player player;
	private Block block;
	private Image imgBackground, img;
	private Timer time;
	private List<Block> blocks;
	private Ball ball;
	private static int ile = 0;
	private int ktory = 0;
	private static final long serialVersionUID = 1L;
}
