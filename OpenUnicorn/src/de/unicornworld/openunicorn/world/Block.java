package de.unicornworld.openunicorn.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Block extends Rectangle {

	public static BufferedImage grass;

	public static BufferedImage earth;
	public static BufferedImage steinWeg_1;

	private static final long serialVersionUID = 1L;

	public int[] id = { -1, -1 };

	public Block(Rectangle size, int[] id) {
		setBounds(size);

		this.id = id;
	}

	public void render(Graphics g) {

		if (id == Tile.stone) {
			g.drawImage(steinWeg_1, x + World.sumx, y + World.sumy, Tile.tileSize, Tile.tileSize, null);

		}

		if (id == Tile.grass) {
			g.drawImage(grass, x + World.sumx, y + World.sumy, Tile.tileSize, Tile.tileSize, null);

		}

		if (id == Tile.earth) {
			g.drawImage(earth, x + World.sumx, y + World.sumy, Tile.tileSize, Tile.tileSize, null);

		}

	}

}
