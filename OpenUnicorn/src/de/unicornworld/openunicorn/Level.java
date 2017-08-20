package de.unicornworld.openunicorn;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Random;

public class Level {
	public static int worldW = 70, worldH = 70;
	public Block[][] block = new Block[worldW][worldH];

	public Level() {
		for (int x = 0; x < block.length; x++) {
			for (int y = 0; y < block[0].length; y++) {
				block[x][y] = new Block(new Rectangle(x * Tile.tileSize, y * Tile.tileSize, Tile.tileSize, Tile.tileSize), Tile.air);
			}
		}

		generateLevel();
	}

	public void generateLevel() {
		for (int y = 0; y < block.length; y++) {
			for (int x = 0; x < block[0].length; x++) {

				if (y > worldH / 4) {

					if (new Random().nextInt(100) > 10) {
						try {
							if (block[x - 1][y - 1].id == Tile.stone) {
								block[x][y].id = Tile.stone;
							}
						} catch (Exception e) {

						}
					}

					if (new Random().nextInt(100) > 20) {

						try {
							if (block[x + 1][y - 1].id == Tile.stone) {
								block[x][y].id = Tile.stone;
							}

						} catch (Exception e) {

						}
					}

					if (new Random().nextInt(100) > 10) {

						try {
							if (block[x][y - 1].id == Tile.stone) {
								block[x][y].id = Tile.stone;
							}

						} catch (Exception e) {

						}
					}

					if (new Random().nextInt(100) < 5) {
						block[x][y].id = Tile.stone;
					}
				}
			}
		}

		for (int y = 0; y < block.length; y++) {
			for (int x = 0; x < block[0].length; x++) {

				if (block[x][y].id == Tile.stone && block[x][y - 1].id == Tile.air) {
					block[x][y].id = Tile.earth;
				}

			}
		}

	}

	public void building(int camX, int camY, int renW, int renH) {

		if (Component.isMouseLeft || Component.isMouseRight) {

			for (int x = (camX / Tile.tileSize); x < (camX / Tile.tileSize) + renW; x++) {
				for (int y = (camY / Tile.tileSize); y < (camY / Tile.tileSize) + renH; y++) {

					if (x >= 0 && y >= 0 && x < worldW && y < worldH) {

						if (block[x][y].contains(new Point(Component.mse.x / Component.pixelsize + (int) Component.sx, Component.mse.y / Component.pixelsize + (int) Component.sy))) {

							int sid[] = Component.inventory.inv_bar[Inventory.selected].id;

							if (Component.isMouseRight) {

								if (sid != Tile.air) {
									if (block[x][y].id == Tile.air) {
										block[x][y].id = sid;

									}

								}

							} else {
								block[x][y].id = Tile.air;

							}

							break;
						}

					}
				}
			}
		}
	}

	public void tick(int camX, int camY, int renW, int renH) {

		building(camX, camY, renW, renH);
	}

	public void render(Graphics g, int camX, int camY, int renW, int renH) {
		for (int x = (camX / Tile.tileSize); x < (camX / Tile.tileSize) + renW; x++) {
			for (int y = (camY / Tile.tileSize); y < (camY / Tile.tileSize) + renH; y++) {

				if (x >= 0 && y >= 0 && x < worldW && y < worldH) {
					block[x][y].render(g);

					if (block[x][y].contains(new Point(Component.mse.x / Component.pixelsize + (int) Component.sx, Component.mse.y / Component.pixelsize + (int) Component.sy))) {

						if (block[x][y].id != Tile.air) {

							g.setColor(Color.BLACK);
							g.drawRect(block[x][y].x - (int) Component.sx, block[x][y].y - (int) Component.sy, block[x][y].width - 1, block[x][y].height - 1);

						}
					}
				}
			}
		}
	}

}
