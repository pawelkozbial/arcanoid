package graphics;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Block {

	public Block() {
		ImageIcon ic1 = new ImageIcon("images/block-1.png");
		imgBlock1 = ic1.getImage();
		ImageIcon ic2 = new ImageIcon("images/block-2.png");
		imgBlock2 = ic2.getImage();
		ImageIcon ic3 = new ImageIcon("images/block-3.png");
		imgBlock3 = ic3.getImage();
		x = 0;
		y = 0;
		visible = true;
	}

	public Block(int x, int y) {
		ImageIcon ic1 = new ImageIcon("images/block-1.png");
		imgBlock1 = ic1.getImage();
		ImageIcon ic2 = new ImageIcon("images/block-2.png");
		imgBlock2 = ic2.getImage();
		ImageIcon ic3 = new ImageIcon("images/block-3.png");
		imgBlock3 = ic3.getImage();
		this.x = x;
		this.y = y;
		visible = true;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, imgBlock1.getWidth(null),
				imgBlock1.getHeight(null));
	}

	public Image getImgBlock1() {
		return imgBlock1;
	}

	public Image getImgBlock2() {
		return imgBlock2;
	}

	public Image getImgBlock3() {
		return imgBlock3;
	}

	public int getWidth() {
		return imgBlock1.getWidth(null);
	}

	public int getHeight() {
		return imgBlock1.getHeight(null);
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public boolean isVisible() {
		return visible;
	}

	private int x, y;
	private final Image imgBlock1, imgBlock2, imgBlock3;
	private boolean visible;

}
