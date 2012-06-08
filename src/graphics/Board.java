package graphics;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import listeners.BoardListener;

public class Board extends JPanel {

	public Board() {

		player = new Player();
		block = new Block();
		ball = new Ball(player.getX() + 80, player.getY() - 20);
		setFocusable(true);
		// addKeyListener(new AL());
		boardListener = new BoardListener(this, ball, player);
		addKeyListener(boardListener);
		addMouseMotionListener(boardListener);
		ImageIcon ic = new ImageIcon("images/background.jpg");
		imgBackground = ic.getImage();
		blocks = new ArrayList<Block>();
		balls = new ArrayList<Ball>();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.drawImage(imgBackground, 0, 0, null);

		g2d.drawImage(player.getImgPlayer(), player.getX(), player.getY(), null);

		paintLevel(g2d);

		g2d.drawImage(ball.getImgBall(), ball.getX(), ball.getY(), null);

		g2d.setFont(new Font("Serif", Font.HANGING_BASELINE, 20));
		g2d.drawString("Punktacja: " + score, 670, 20);

		g2d.drawString("Poziom: " + level, 20, 20);

		g2d.drawString("Życie: " + player.getLife(), 400, 20);

		balls = Player.getBalls();
		for (int i = 0; i < balls.size(); i++) {
			ball = balls.get(i);
			if (!ball.isVisible()) {
				g2d.drawImage(ball.getImgBall(), ball.getX(), ball.getY(), null);
			}
		}
	}

	private void paintLevel(Graphics2D g2d) {

		for (int i = 0; i < blocks.size(); i++) {
			Block tmpBlock = blocks.get(i);
			if (tmpBlock.isVisible())
				g2d.drawImage(tmpBlock.getImgBlock1(), tmpBlock.getX(),
						tmpBlock.getY(), null);
			if (level == 1) {
				g2d.drawImage(tmpBlock.getImgBlock1(), tmpBlock.getX(),
						tmpBlock.getY(), null);
			}
			if (level == 2) {
				g2d.drawImage(tmpBlock.getImgBlock2(), tmpBlock.getX(),
						tmpBlock.getY(), null);
			}
			if (level == 3) {
				g2d.drawImage(tmpBlock.getImgBlock3(), tmpBlock.getX(),
						tmpBlock.getY(), null);
			}
		}
	}

	public void initBlocks(Block[] b) {
		for (int i = 0; i < b.length; i++) {
			blocks.add(b[i]);
			if (!blockIsVisible(i)) {
				blockSetVisible(i);
			}
		}
	}

	private void blockSetVisible(int i) {
		blocks.get(i).setVisible(true);
	}

	private boolean blockIsVisible(int i) {
		return blocks.get(i).isVisible();
	}

	public void collision() {

		ballBounds = ball.getBounds();
		playerBounds = player.getBounds();

		collisionBallAndPlayer();

		for (int i = 0; i < blocks.size(); i++) {
			block = blocks.get(i);
			blockBounds = block.getBounds();
			if (block.isVisible()) {

				collisionBallAndBlock();

			} else {
				blocks.remove(i);
				if (blocks.size() == 0) {
					level++;
					if (level == 2) {
						JOptionPane
								.showMessageDialog(this, "Skończyłeś poziom");
						BoardListener.getTimer().setDelay(6);
						initBlocks(blocksOfLevelTwo);
						logger.info("Zmiana poziomu: LEVEL 2");
					}
					if (level == 3) {
						JOptionPane
								.showMessageDialog(this, "Skończyłeś poziom");
						BoardListener.getTimer().setDelay(4);
						initBlocks(blocksOfLevelThree);
						logger.info("Zmiana poziomu: LEVEL 3");
					}
					// blocks.get(i).setVisible(true);
					ball.setX(player.getX() + 80);
					ball.setY(player.getY() - 20);
				}
			}
		}
	}

	private void collisionBallAndPlayer() {
		if (intersectBallAndPlayer()
				&& (playerBounds.getMinX() - (ball.getWidth() - ball.getDx())) == ballBounds
						.getX()) {
			setBallDx();
		}
		if (intersectBallAndPlayer()
				&& (playerBounds.getMaxX() - (ball.getWidth() + ball.getDx())) == ballBounds
						.getX()) {
			setBallDx();
		}
		if (intersectBallAndPlayer()
				&& (playerBounds.getY() - (ball.getHeight() - ball.getDy())) == ballBounds
						.getY()) {
			setBallDy();
		}
	}

	private boolean intersectBallAndPlayer() {
		return ballBounds.intersects(playerBounds);
	}

	// poprawić zmienną getX() oraz getY()
	private void collisionBallAndBlock() {
		if (intersectBallAndBlock()
				&& (blockBounds.getMinX() - (ball.getWidth() - ball.getDx())) == ballBounds
						.getX()) {
			setBallDx();
			block.setVisible(false);
			logger.info("LEWA");
			score++;
			System.out.println("score: " + score);
		}
		if (intersectBallAndBlock()
				&& (blockBounds.getMaxX() - (ball.getWidth() + ball.getDx())) == ballBounds
						.getX()) {
			setBallDx();
			block.setVisible(false);
			logger.info("PRAWA");
			score++;
			System.out.println("score: " + score);
		}
		if (intersectBallAndBlock()
				&& (blockBounds.getMinY() - (ball.getHeight() - ball.getDy())) == ballBounds
						.getY()) {
			setBallDy();
			block.setVisible(false);
			score++;
			System.out.println("score: " + score);
		}
		if (intersectBallAndBlock()
				&& (blockBounds.getMaxY() - (ball.getHeight() + ball.getDy())) == ballBounds
						.getY()) {
			setBallDy();
			block.setVisible(false);
			score++;
			System.out.println("score: " + score);
		}
	}

	private boolean intersectBallAndBlock() {
		return ballBounds.intersects(blockBounds);
	}

	private void setBallDx() {
		ball.setDx(-ball.getDx());
	}

	private void setBallDy() {
		ball.setDy(-ball.getDy());
	}

	public int getLevel() {
		return level;
	}

	public Block[] getBlocksOfLevelOne() {
		return blocksOfLevelOne;
	}

	Logger logger = Logger.getLogger("MyLog");

	private Block[] blocksOfLevelOne = { new Block(115, 50),
			new Block(213, 50), new Block(311, 50), new Block(409, 50),
			new Block(507, 50), new Block(605, 50), new Block(115, 100),
			new Block(213, 100), new Block(311, 100), new Block(409, 100),
			new Block(507, 100), new Block(605, 100), new Block(115, 150),
			new Block(213, 150), new Block(311, 150), new Block(409, 150),
			new Block(507, 150), new Block(605, 150) };

	private Block[] blocksOfLevelTwo = { new Block(90, 50), new Block(198, 50),
			new Block(306, 50), new Block(414, 50), new Block(522, 50),
			new Block(630, 50), new Block(90, 120), new Block(198, 120),
			new Block(306, 120), new Block(414, 120), new Block(522, 120),
			new Block(630, 120), new Block(90, 190), new Block(198, 190),
			new Block(306, 190), new Block(414, 190), new Block(522, 190),
			new Block(630, 190) };

	private Block[] blocksOfLevelThree = { new Block(90, 70),
			new Block(198, 70), new Block(306, 70), new Block(414, 70),
			new Block(522, 70), new Block(630, 70), new Block(90, 170),
			new Block(198, 170), new Block(306, 170), new Block(414, 170),
			new Block(522, 170), new Block(630, 170), new Block(90, 270),
			new Block(198, 270), new Block(306, 270), new Block(414, 270),
			new Block(522, 270), new Block(630, 270) };

	Image img;
	private Player player;
	private Block block;
	private BoardListener boardListener;
	private Image imgBackground;
	// private final Timer timer;
	private Rectangle playerBounds, ballBounds, blockBounds;
	private List<Block> blocks;
	private List<Ball> balls;
	private Ball ball;
	private static int score = 0;
	private int level = 1;
	private static final long serialVersionUID = 1L;
}
