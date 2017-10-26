package de.unicornworld.openunicorn.map.editor;

import java.awt.Color;
import java.awt.Graphics;

public class World {

	private static int sizeMapX = 16; // Fields
	private static int sizeMapY = 16; // Fields
	static Block[][] blocks = new Block[sizeMapX][sizeMapY];

	int camX = 0;
	int camY = 0;
	int camW;
	int camH;
	static int mouseX;
	static int mouseY;
	static boolean mouseMoving;
	static int mx = 0;
	static int my = 0;

	public World() {
		generateDefaultMap();

	}

	public void generateDefaultMap() {
		for (int x = 0; x < sizeMapX; x++) {
			for (int y = 0; y < sizeMapY; y++) {
				blocks[x][y] = new Block(x * Block.sizeX, y * Block.sizeY, Block.sizeX, Block.sizeY, Material.AIR);
				// System.out.println("x: " + x * Block.sizeX + " x-end: " + ((x * Block.sizeX)
				// + Block.sizeX));
			}
		}
	}

	public void update() {
		/**
		 * update renderable Area
		 */
		camX = 0;
		camY = 0;
		camW = MapEditor.getJFrame().getWidth() / Block.sizeX;
		camH = MapEditor.getJFrame().getHeight() / Block.sizeY;
		/**
		 * update active Block
		 */
		for(int x = 0; x < mouseX/64+1; x++) {
			mx = x;
		}
		for(int y = 0; y < mouseY/64+1; y++) {
			my = y;
		}
	}

	public void render(Graphics g) {
		for (int x = 0; x < sizeMapX; x++) {
			for (int y = 0; y < sizeMapY; y++) {
				if (camX <= x && (camX + camW) >= x && camY <= y && (camY + camH) >= y) {
					blocks[x][y].render(g);
					// System.out.println("x: " + x * Block.sizeX + " x-end: " + ((x * Block.sizeX)
					// + Block.sizeX));
					// System.out.println(blocks[x][y].getTexture());
				}

			}
		}
				
		g.setColor(Color.RED);
		g.drawRect(mx*64, my*64, Block.sizeX, Block.sizeY);
		
	}
	
	static void setBlockMaterial() {
		blocks[mx][my] = new Block(blocks[mx][my].getPosX(), blocks[mx][my].getPosY(), blocks[mx][my].getWidth(), blocks[mx][my].getHeight(), Material.STONE);
 		System.out.println("mx: "+ mx + " my: " + my);
	}
	
}
