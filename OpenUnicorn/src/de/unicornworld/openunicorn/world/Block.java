package de.unicornworld.openunicorn.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Block extends Rectangle {

	public static BufferedImage grass;
	public static BufferedImage steinWeg_1;

	private static final long serialVersionUID = 1L;

	public int[] id = { -1, -1 };

	public Block(Rectangle size, int[] id) {
		setBounds(size);

		this.id = id;
	}

	public void render(Graphics g) {

		if (id != Tile.air) {

			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);

		}

		if (id == Tile.stone) {
			g.drawImage(steinWeg_1, x, y, 40, 40, null);

		}

		if (id == Tile.earth) {
			g.drawImage(grass, x, y, 40, 40, null);

		}

	}

}
