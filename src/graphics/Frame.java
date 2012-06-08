package graphics;

import javax.swing.JFrame;

public class Frame extends JFrame {

	public Frame() {
		setTitle("ARCANOID");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setResizable(false);
		add(board);
		// setAlwaysOnTop(true);
		setLocationRelativeTo(null);
	}

	public void initLevelOne() {
		board.initBlocks(board.getBlocksOfLevelOne());
	}

	private static final int DEFAULT_WIDTH = 812;
	private static final int DEFAULT_HEIGHT = 630;
	private final Board board = new Board();

	private static final long serialVersionUID = 1L;

}
