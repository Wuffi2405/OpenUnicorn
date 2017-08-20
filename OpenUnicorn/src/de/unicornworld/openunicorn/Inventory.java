package de.unicornworld.openunicorn;

import java.awt.Graphics;
import java.awt.Rectangle;

import de.unicornworld.openunicorn.world.Tile;

public class Inventory {

	public Cell[] inv_bar = new Cell[Tile.invLenght];

	public static int selected = 0;

	public Inventory() {
		for (int i = 0; i < inv_bar.length; i++) {
			inv_bar[i] = new Cell(new Rectangle((Component.pixel.width / 2) - ((Tile.invLenght * (Tile.invCellSize + Tile.invCellSpace)) / 2) + (i * (Tile.invCellSize + Tile.invCellSpace)),
					Component.pixel.height - (Tile.invCellSize + Tile.invBorderSpace), Tile.invCellSize, Tile.invCellSize), Tile.air);
		}

		inv_bar[0].id = Tile.earth;
		inv_bar[1].id = Tile.stone;
		inv_bar[2].id = Tile.sand;

	}

	public void render(Graphics g) {
		for (int i = 0; i < inv_bar.length; i++) {
			if (i == selected) {
				inv_bar[i].render(g, true);
			} else {
				inv_bar[i].render(g, false);

			}
		}
	}

}
