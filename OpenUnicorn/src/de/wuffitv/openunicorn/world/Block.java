package de.wuffitv.openunicorn.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sun.javafx.geom.Rectangle;

public class Block extends Rectangle {

	public static final int BLOCKSIZE = 50;
	
	public int x, y, width, height;

	public Block(int x, int y, int width, int height, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.drawRect(x, y, BLOCKSIZE, BLOCKSIZE);
	}

}
