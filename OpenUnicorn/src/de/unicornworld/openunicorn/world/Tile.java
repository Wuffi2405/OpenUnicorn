package de.unicornworld.openunicorn.world;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Tile {

	public static int tileSize = 40;

	public static int[] air = { -1, -1 };
	public static int[] stone = { 0, 0 };
	public static int[] earth = { 1, 0 };
	public static int[] sand = { 2, 0 };
	public static int[] wood = { 3, 0 };
	public static int[] grass = { 5, 0 };

	
	
	public static int invItemBorder = 3;
	public static int invLenght = 8;
	public static int invCellSize = 25;
	public static int invCellSpace = 4;
	public static int invBorderSpace = 4;

	public static int[] character = { 0, 18 };
	public static int[] healthbar = { 0, 17 };

	public static BufferedImage tileset_terrain;
	public static BufferedImage tile_cell;
	public static BufferedImage tile_select;

	public Tile() {

		try {
			Tile.tileset_terrain = ImageIO.read(new File("/assets/texture/block/grass.png"));
			Tile.tile_cell = ImageIO.read(new File("/assets/texture/block/grass.png"));
			Tile.tile_select = ImageIO.read(new File("/assets/texture/block/grass.png"));

		} catch (Exception e) {

		}

	}

}
