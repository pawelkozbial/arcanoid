package listeners;

import graphics.NotHelloWorldPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class NotHelloWorldListener implements ActionListener {

	NotHelloWorldPanel p;
	Timer time;

	public NotHelloWorldListener(NotHelloWorldPanel p) {
		this.p = p;
		time = new Timer(5, this);
		time.start();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (p.x >= 50)
			p.setVisible(true);
		else
			p.setVisible(false);
		p.checkCollision();
		p.repaint();
	}

	public class Al extends KeyAdapter {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_RIGHT && p.x < 200) {
				p.x += 5;
			}
			if (key == KeyEvent.VK_LEFT && p.x > 20) {
				p.x -= 5;
			}
			System.out.println("Pressed " + e.getKeyCode() + " " + p.x);

			// moveSquare(p.x, 20);
			// validate();
			// repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();

			if (key == KeyEvent.VK_RIGHT) {
				p.x += 0;
			}
			if (key == KeyEvent.VK_LEFT) {
				p.x += 0;
			}
		}
	}
}