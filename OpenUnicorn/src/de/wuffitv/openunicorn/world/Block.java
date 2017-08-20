package de.wuffitv.openunicorn.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;


public class Block extends Rectangle {

	private static final long serialVersionUID = 1L;

	
	public static final int BLOCKSIZE = 50;
	
	public int x, y, width, height;

	public Block(Rectangle rec, BufferedImage image) {
	
	}

	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.drawRect(x, y, BLOCKSIZE, BLOCKSIZE);
	}

}
