package de.unicornworld.openunicorn.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.unicornworld.openunicorn.Component;
import de.unicornworld.openunicorn.frame.Window;
import de.unicornworld.openunicorn.world.Tile;
import de.unicornworld.openunicorn.world.World;

public class Player extends Entity {

	public Player(int x, int y, int width, int height, double speed) {
		super(x, y, width, height, speed);
	}

	public static float speed = 2;
	protected float dx;
	protected float dy;

	protected boolean jumpPerformed;

	public static BufferedImage player;
	public static BufferedImage player_left;

	public int animation = 0;
	public int animationFrame = 0, animationTime = 40;

	public void tick() {

		calculateCollisions();

		if (Component.isMovingVert == true) {

			if (Component.player.x - World.difx < 19) {

				System.out.println(Component.player.x - World.difx);

			}

			if (Component.dirVert == Player.speed && right != true) {

				if ((Component.player.x - World.difx) < ((Window.getJFrame().getWidth() - Component.player.width) / 2)
						|| Window.getJFrame().getWidth() - World.difx - 14 > World.worldW * Tile.tileSize) {

					x += Player.speed;

				} else {
					World.difx -= Player.speed;

				}
			}
			if (Component.dirVert == -Player.speed && left != true) {

				if (World.difx >= 0 || Component.player.x - World.difx - 14 > World.worldW * Tile.tileSize
						- (Window.getJFrame().getWidth() / 2)) {

					x -= Player.speed;

				} else {
					World.difx += Player.speed;
				}
			}

		}

		if (Component.isMovingHor == true) {

			if (Component.dirHor == Player.speed && bottom != true) {
 
				if ((Component.player.y - World.dify) < ((Window.getJFrame().getHeight() - Component.player.height) / 2)
						|| Window.getJFrame().getHeight() - World.dify - 35 > World.worldH * Tile.tileSize) {

					y += Player.speed;

				} else {
					World.dify -= Player.speed;
				}
			}
			if (Component.dirHor == -Player.speed && top != true) {

				if (World.dify >= 0 || Component.player.y - World.dify - 14 > World.worldH * Tile.tileSize
						- (Window.getJFrame().getHeight() / 2)) {

					y -= Player.speed;

				} else {
					World.dify += Player.speed;
				}
			}

		}

	}

	public void render(Graphics g) {

		if (Component.dirVert == speed) {

			g.drawImage(player, x, y, width, height, null);

		} else {

			g.drawImage(player_left, x, y, width, height, null);
		}
	}

}
