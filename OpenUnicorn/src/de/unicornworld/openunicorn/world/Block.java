package de.unicornworld.openunicorn.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle {

	private static final long serialVersionUID = 1L;

	public int[] id = { -1, -1 };

	public Block(Rectangle size, int[] id) {
		setBounds(size);
		this.id = id;
	}

	public void render(Graphics g) {

		if (id != Tile.air) {

			g.setColor(Color.RED);
			g.fillRect(x, y, width, height);

		}
	}

}
