package de.unicornworld.openunicorn.map.editor;

import java.awt.Graphics;

public class World {

	private int sizeMapX = 16; // Fields
	private int sizeMapY = 16; // Fields
	Block[][] blocks = new Block[sizeMapX][sizeMapY];

	
	int camX = 0;
	int camY = 0;
	
	
	public World() {
		System.out.println("lengh: " + blocks.length);
		for (int x = 0; x < sizeMapX; x++) {
			for (int y = 0; y < sizeMapY; y++) {
				blocks[x][y] = new Block(x * Block.sizeX, y * Block.sizeY, 64, 64, Material.AIR);
				System.out.println("x: " + x * Block.sizeX + " x-end: " + ((x * Block.sizeX) + Block.sizeX));
			}
		}
	}

	public void generateDefaultMap() {

	}

	public void update() {

	}

	public void render(Graphics g) {
		for (int x = 0; x < sizeMapX; x++) {
			for (int y = 0; y < sizeMapY; y++) {
				blocks[x][y].render(g);
				System.out.println("x: " + x * Block.sizeX + " x-end: " + ((x * Block.sizeX) + Block.sizeX));
				System.out.println(blocks[x][y].getTexture());
			}

		}
	}

}
