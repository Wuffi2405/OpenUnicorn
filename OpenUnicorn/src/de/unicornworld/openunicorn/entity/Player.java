package de.unicornworld.openunicorn.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import de.unicornworld.openunicorn.Component;
import de.unicornworld.openunicorn.frame.Window;
import de.unicornworld.openunicorn.world.Tile;
import de.unicornworld.openunicorn.world.World;

public class Player extends Rectangle {

	private static final long serialVersionUID = 1L;
	public static float speed = 2;
	protected float dx;
	protected float dy;
	protected boolean falling = true;
	protected boolean jumping;

	protected boolean jumpPerformed;

	public static BufferedImage player;
	public static BufferedImage player_left;

	protected boolean top;
	protected boolean left;
	protected boolean right;
	protected boolean bottom;

	public int animation = 0;
	public int animationFrame = 0, animationTime = 40;

	public Player(int width, int height) {
		setBounds(Tile.tileSize, Tile.tileSize, width, height);
	}

	public void tick() {

		// if (Component.player.x > Window.getJFrame().getWidth() / 2) {
		//
		// Component.sx = Component.player.x - Window.getJFrame().getWidth() / 2;
		// }
		//
		// if (Component.player.y > Window.getJFrame().getHeight() / 2) {
		//
		// Component.sy = Component.player.y - Window.getJFrame().getHeight() / 2;
		//
		// }

		calculateCollisions();

		if (Component.isMovingVert == true) {

			if (Component.dirVert == Player.speed && right != true) {

				if (Component.player.x < Window.getJFrame().getWidth() / 2) {

					x += Player.speed;

				} else {
					World.sumx -= Player.speed;
				}
			}
			if (Component.dirVert == -Player.speed && left != true) {

				if (World.sumx >= 0) {

					x -= Player.speed;

				} else {
					World.sumx += Player.speed;
				}
			}

		}

		if (Component.isMovingHor == true) {

			if (Component.dirHor == Player.speed && bottom != true) {

				if (Component.player.y < Window.getJFrame().getHeight() / 2) {

					y += Player.speed;

				} else {
					World.sumy -= Player.speed;
				}
			}
			if (Component.dirHor == -Player.speed && top != true) {

				if (World.sumy >= 0) {

					y -= Player.speed;

				} else {
					World.sumy += Player.speed;
				}
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
		//
		// if (Component.world.block[(int) ((Component.player.x - 1) /
		// Tile.tileSize)][(int) (((Component.player.y)
		// / Tile.tileSize))].id == Tile.stone
		// || Component.world.block[(int) ((Component.player.x - 1)
		// / Tile.tileSize)][(int) (((Component.player.y - 1) / Tile.tileSize) + 1)].id
		// == Tile.stone) {
		// left = true;
		// } else {
		// left = false;
		// }
		//
		// if (Component.world.block[(int) ((Component.player.x) / Tile.tileSize)
		// + 1][(int) (((Component.player.y) / Tile.tileSize))].id == Tile.stone
		// || Component.world.block[(int) ((Component.player.x) / Tile.tileSize)
		// + 1][(int) (((Component.player.y - 1) / Tile.tileSize) + 1)].id ==
		// Tile.stone) {
		// right = true;
		// } else {
		// right = false;
		// }
		//
		// if (Component.world.block[(int) (Component.player.x / Tile.tileSize)][(int)
		// (((Component.player.y - 1)
		// / Tile.tileSize))].id == Tile.stone
		// || Component.world.block[(int) ((Component.player.x - 1) / Tile.tileSize)
		// + 1][(int) (((Component.player.y - 1) / Tile.tileSize))].id == Tile.stone) {
		// top = true;
		// } else {
		// top = false;
		// }
		//
		// if (Component.world.block[(int) (Component.player.x
		// / Tile.tileSize)][(int) (((Component.player.y) / Tile.tileSize) + 1)].id ==
		// Tile.stone
		// || Component.world.block[(int) ((Component.player.x - 1) / Tile.tileSize)
		// + 1][(int) (((Component.player.y) / Tile.tileSize) + 1)].id == Tile.stone) {
		// bottom = true;
		// } else {
		// bottom = false;
		// }

	}

	public void render(Graphics g) {

		if (Component.dirVert == speed) {

			g.drawImage(player, x, y, 40, 40, null);

		} else {

			g.drawImage(player_left, x, y, 40, 40, null);
		}
	}

}
