package de.unicornworld.openunicorn.world;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class World {
	public static int worldW = 30, worldH = 30;
	public Block[][] block = new Block[worldW][worldH];
	private static BufferedReader reader;

	public static int sumx;
	public static int sumy;

	public World() {
		for (int x = 0; x < block.length; x++) {
			for (int y = 0; y < block[0].length; y++) {
				block[x][y] = new Block(
						new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.air);
			}
		}

		generateLevel();
	}

	public void generateLevel() {

		try {
			reader = new BufferedReader(new FileReader(new File("OpenUnicorn/src/assets/files/world.uwwf")));

			for (int y = 0; y < worldH; y++) {
				try {

					String[] numbers = reader.readLine().split("");

					for (int x = 0; x < worldW; x++) {

						if (Integer.parseInt(numbers[x]) == 1) {
							block[x][y] = new Block(
									new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize),
									Tile.stone);

						} else if (Integer.parseInt(numbers[x]) == 2) {
							block[x][y] = new Block(
									new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize),
									Tile.earth);
						} else {
							block[x][y] = new Block(
									new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize),
									Tile.grass);

						}
					}
				} catch (Exception e) {

				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void tick(int camX, int camY, int renW, int renH) {
		
	}

	public void render(Graphics g, int camX, int camY, int renW, int renH) {

		// cam has to be used against lags coming soon!

		for (int x = 0; x < worldW; x++) {
			for (int y = 0; y < worldH + renH; y++) {

				if (x >= 0 && y >= 0 && x < worldW && y < worldH) {
					block[x][y].render(g);

				}
			}
		}
	}

}
