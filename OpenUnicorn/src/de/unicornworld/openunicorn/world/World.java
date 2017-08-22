package de.unicornworld.openunicorn.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import de.wuffitv.openunicorn.util.SourceLoader;

public class World {
	public static int worldW = 70, worldH = 70;
	public Block[][] block = new Block[worldW][worldH];

	public World() {
		for (int x = 0; x < block.length; x++) {
			for (int y = 0; y < block[0].length; y++) {
				block[x][y] = new Block(
						new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.air);
			}
		}

	}

	public void generateLevel() {

	}

	public void building(int camX, int camY, int renW, int renH) {

	}

	public void tick(int camX, int camY, int renW, int renH) {

		building(camX, camY, renW, renH);
	}

	public void render(Graphics g) {

		g.setColor(Color.BLACK);
		g.drawRect(0, 0, 20, 20);
		g.drawImage(SourceLoader.loadImage(""), 0, 0, 20, 20, 0, 0, 20, 20, null);

	}

}
