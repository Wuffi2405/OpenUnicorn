package de.unicornworld.openunicorn;

import java.awt.Graphics;
import java.awt.Rectangle;

import de.unicornworld.openunicorn.world.Tile;

public class Cell extends Rectangle {

	private static final long serialVersionUID = 1L;

	public int[] id = { 0, 0 };

	public Cell(Rectangle size, int[] id) {
		setBounds(size);
		this.id = id;
	}

	public void render(Graphics g, boolean isSelcted) {
		g.drawImage(Tile.tile_cell, x, y, width, height, null);

		if (id != Tile.air) {
			g.drawImage(Tile.tileset_terrain, x + Tile.invItemBorder, y +Tile.invItemBorder , x + width - Tile.invItemBorder, y + height - Tile.invItemBorder, id[0] * Tile.tileSize, id[1] * Tile.tileSize, id[0] * Tile.tileSize + Tile.tileSize, id[1] * Tile.tileSize + Tile.tileSize,
					null);
		}

		if (isSelcted) {
			g.drawImage(Tile.tile_select, x - 1, y - 1, width + 2, height + 2, null);
		} else {
		}

	}

}
