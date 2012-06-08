package listeners;

import graphics.Ball;
import graphics.Board;
import graphics.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.List;

import javax.swing.Timer;

public class BoardListener extends KeyAdapter implements ActionListener,
		MouseMotionListener {

	public BoardListener(Board board, Ball ball, Player player) {
		this.board = board;
		this.ball = ball;
		this.player = player;
		BoardListener.timer = new Timer(8, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		List<Ball> balls = Player.getBalls();
		for (int i = 0; i < balls.size(); i++) {
			Ball ball = balls.get(i);
			if (ball.isVisible()) {
				ball.move(board);
			} else
				balls.remove(i);
		}

		// player.move();
		// ball.move(board);
		board.collision();
		board.validate();
		board.repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		player.keyPressed(e);
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_SPACE) {
			timer.start();
		}
		if (key == KeyEvent.VK_P) {
			if (timer.isRunning()) {
				timer.stop();
			} else
				timer.start();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println(e.getClickCount());
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		ball.setX(e.getX());
		player.setX(e.getX() - 60);
		board.repaint();
	}

	public static Timer getTimer() {
		return timer;
	}

	private final Board board;
	private final Ball ball;
	private final Player player;
	private static Timer timer = null;
}
