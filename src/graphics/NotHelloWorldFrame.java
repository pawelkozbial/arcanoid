package graphics;

import javax.swing.JFrame;

public class NotHelloWorldFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public NotHelloWorldFrame() {
		setTitle("NotHelloWorld");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// add panel to frame

		NotHelloWorldPanel panel = new NotHelloWorldPanel();
		add(panel);
	}

	public static final int DEFAULT_WIDTH = 900;
	public static final int DEFAULT_HEIGHT = 600;
}