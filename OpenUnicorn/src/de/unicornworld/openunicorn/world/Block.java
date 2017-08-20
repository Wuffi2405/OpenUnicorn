package de.unicornworld.openunicorn.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import de.unicornworld.openunicorn.Component;

public class Block extends Rectangle {

	private static final long serialVersionUID = 1L;

	public int[] id = { -1, -1 };

	public Block(Rectangle size, int[] id) {
		setBounds(size);
		this.id = id;
	}

	public void render(Graphics g) {

		if (id != Tile.air) {
			g.drawImage(Tile.tileset_terrain, x - (int) Component.sx, y - (int) Component.sy,
					x + width - (int) Component.sx, y + height - (int) Component.sy, id[0] * Tile.tileSize,
					id[1] * Tile.tileSize, id[0] * Tile.tileSize + Tile.tileSize, id[1] * Tile.tileSize + Tile.tileSize,
					null);

		}
	}

}
