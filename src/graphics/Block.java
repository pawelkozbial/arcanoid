package graphics;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Block {

	public Block() {
		ImageIcon ic = new ImageIcon("images/block-1.png");
		imgBlock = ic.getImage();
		x = 0;
		y = 0;
		visible = true;
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, imgBlock.getWidth(null),
				imgBlock.getHeight(null));
	}

	public Image getImgBlock() {
		return imgBlock;
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
	private Image imgBlock;
	private boolean visible;

}
