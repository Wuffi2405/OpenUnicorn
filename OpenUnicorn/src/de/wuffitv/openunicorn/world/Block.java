package de.wuffitv.openunicorn.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.sun.javafx.geom.Rectangle;

public class Block extends Rectangle {

	public int x, y, width, height;

	public Block(int x, int y, int width, int height, BufferedImage image) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(x, y, width, height);
	}

}
