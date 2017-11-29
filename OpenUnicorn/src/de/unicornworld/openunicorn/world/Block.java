package de.unicornworld.openunicorn.world;

import java.awt.Graphics;
import java.awt.Rectangle;

import de.unicornworld.openunicorn.util.TextureReload;

public class Block extends Rectangle {

	private static final long serialVersionUID = 1L;

	public int id = -1;

	public Block(Rectangle size, int id) {
		setBounds(size);

		this.id = id;
	}

	public void renderID(Graphics g) {

		g.drawImage(TextureReload.textures.get(id), x + World.difx, y + World.dify, Tile.tileSize, Tile.tileSize, null);

	}

}
