package de.unicornworld.openunicorn.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import de.unicornworld.openunicorn.Component;
import de.unicornworld.openunicorn.world.Tile;

public class Player extends Rectangle {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static float speed = 1;
	protected float dx;
	protected float dy;
	protected boolean falling = true;
	protected boolean jumping;

	protected boolean jumpPerformed;

	protected boolean top;
	protected boolean left;
	protected boolean right;
	protected boolean bottom;

	public int animation = 0;
	public int animationFrame = 0, animationTime = 40;

	public Player(int width, int height) {
		setBounds(Tile.tileSize, 0, width, height);
	}

	public void tick() {

		if (Component.player.x > Component.pixel.getWidth() / 2) {

			Component.sx = Component.player.x - Component.pixel.getWidth() / 2;

		}

		if (Component.player.y > Component.pixel.getHeight() / 2) {

			Component.sy = Component.player.y - Component.pixel.getHeight() / 2;

		}

		calculateCollisions();

		if (Component.isMovingVert == true) {

			if (Component.dirVert == Player.speed && right != true) {
				x += 1;
			}
			if (Component.dirVert == -Player.speed && left != true) {
				x -= 1;
			}

		}

		if (Component.isMovingHor == true) {

			if (Component.dirHor == Player.speed && bottom != true) {
				y += 1;
			}
			if (Component.dirHor == -Player.speed && top != true) {
				y -= 1;
			}

		}

	}

	public void calculateCollisions() {

		if (Component.player.x == 0) {
			left = true;
		} else {
			left = false;
		}

		if (Component.player.y == 0) {
			top = true;
		} else {
			top = false;
		}

		if (Component.world.block[(int) ((Component.player.x - 1) / Tile.tileSize)][(int) (((Component.player.y)
				/ Tile.tileSize))].id == Tile.stone
				|| Component.world.block[(int) ((Component.player.x - 1)
						/ Tile.tileSize)][(int) (((Component.player.y - 1) / Tile.tileSize) + 1)].id == Tile.stone) {
			left = true;
		} else {
			left = false;
		}

		if (Component.world.block[(int) ((Component.player.x) / Tile.tileSize)
				+ 1][(int) (((Component.player.y) / Tile.tileSize))].id == Tile.stone
				|| Component.world.block[(int) ((Component.player.x) / Tile.tileSize)
						+ 1][(int) (((Component.player.y - 1) / Tile.tileSize) + 1)].id == Tile.stone) {
			right = true;
		} else {
			right = false;
		}

		if (Component.world.block[(int) (Component.player.x / Tile.tileSize)][(int) (((Component.player.y - 1)
				/ Tile.tileSize))].id == Tile.stone
				|| Component.world.block[(int) ((Component.player.x - 1) / Tile.tileSize)
						+ 1][(int) (((Component.player.y - 1) / Tile.tileSize))].id == Tile.stone) {
			top = true;
		} else {
			top = false;
		}

		if (Component.world.block[(int) (Component.player.x
				/ Tile.tileSize)][(int) (((Component.player.y) / Tile.tileSize) + 1)].id == Tile.stone
				|| Component.world.block[(int) ((Component.player.x - 1) / Tile.tileSize)
						+ 1][(int) (((Component.player.y) / Tile.tileSize) + 1)].id == Tile.stone) {
			bottom = true;
		} else {
			bottom = false;
		}

	}

	public void render(Graphics g) {

		if (Component.dirVert == speed) {

			g.setColor(Color.green);
			g.fillRect(x, y, width, height);

		} else {
			g.setColor(Color.cyan);
			g.fillRect(x, y, width, height);

		}
	}

}
