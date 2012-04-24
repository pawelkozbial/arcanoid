package main;

import graphics.Frame;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Arcanoid {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				// NotHelloWorldFrame frame = new NotHelloWorldFrame();
				Frame frame = new Frame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
		System.out.println(Arcanoid.class.getResource(""));
	}

}
