package graphics;

import javax.swing.JFrame;

public class Frame extends JFrame {
	
	public Frame(){
		setTitle("ARCANOID");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		//setResizable(false);
		
		add(new Board());
		setLocationRelativeTo(null);
	}

	private static final int DEFAULT_WIDTH = 912;
	private static final int DEFAULT_HEIGHT = 630;
	
	private static final long serialVersionUID = 1L;

}
