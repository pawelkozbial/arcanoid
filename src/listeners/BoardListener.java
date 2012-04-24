package listeners;

import graphics.Board;
import graphics.Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class BoardListener extends KeyAdapter implements ActionListener {

	public BoardListener(Board b, Player p) {
		this.b = b;
		this.p=p;
		time = new Timer(5, this);
		time.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		p.move();
		b.repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		p.keyPressed(e);
		super.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		p.keyReleased(e);
		super.keyReleased(e);
	}

	private Board b;
	private Player p;
	private Timer time;
}
