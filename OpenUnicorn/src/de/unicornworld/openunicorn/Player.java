package de.unicornworld.openunicorn;

import java.awt.Graphics;

import de.unicornworld.openunicorn.world.Tile;
import de.unicornworld.openunicorn.world.World;

public class Player extends DoubleRectangle {

	private final float gravity = 1.01F;
	private float fallinspeed = 1;
	private final float maxfallingspeed = 10F;

	protected float speed = 1;
	protected float dx;
	protected float dy;
	protected boolean left;
	protected boolean right;
	protected boolean falling = true;
	protected boolean jumping;

	protected boolean jumpPerformed;

	protected boolean topleft;
	protected boolean topright;
	protected boolean midleft;
	protected boolean midright;
	protected boolean bottomleft;
	protected boolean bottomright;

	public int animation = 0;
	public int animationFrame = 0, animationTime = 40;

	public Player(int width, int height) {
		setBounds((Component.pixel.width / 2) - (width / 2), Component.pixel.height / 2 - (height / 2), width, height);
	}

	public void tick() {

		claculateCollisions();

		if (!jumping && falling) {

			if (gravity * fallinspeed < maxfallingspeed) {

				y += gravity * fallinspeed;
				fallinspeed = fallinspeed + (gravity - 1);

			}
		}

		if (Component.isMoving == true) {

			if (Component.dir == Component.character.speed && bottomright != true && topright != true) {
				x += 1;
			}
			if (Component.dir == -Component.character.speed && bottomleft != true && topleft != true) {
				x -= 1;
			}

		}

		if (Component.isJumping == true && falling == false) {

			falling = true;
			jumpPerformed = true;
		}

		if (jumpPerformed == true) {
			y -= 2;
		}

		Component.sy = Component.character.y - Component.pixel.height / 2 - (height / 2);
		Component.sx = Component.character.x - Component.pixel.width / 2 - (width / 2);

	}

	public void claculateCollisions() {

		if (Component.character.y > 0 && Component.character.y < World.worldH * Tile.tileSize - 2 * Tile.tileSize && Component.character.x > 0
				&& Component.character.x < World.worldW * Tile.tileSize - 2 * Tile.tileSize) {

			if (Component.world.block[(int) ((Component.character.x) / Tile.tileSize)][(int) (Component.character.y / Tile.tileSize) + 2].id != Tile.air
					|| Component.world.block[(int) ((Component.character.x - 1) / Tile.tileSize) + 1][(int) (Component.character.y / Tile.tileSize) + 2].id != Tile.air) {
				falling = false;
				fallinspeed = 1;
				jumpPerformed = false;

			} else {
				falling = true;
			}

			if (Component.world.block[(int) (Component.character.x / Tile.tileSize)][(int) (Component.character.y / Tile.tileSize)].id != Tile.air
					|| Component.world.block[(int) ((Component.character.x - 1) / Tile.tileSize) + 1][(int) (Component.character.y / Tile.tileSize)].id != Tile.air) {
				fallinspeed = (float) 0.4;
				jumpPerformed = false;

			} else {
			}

			if (Component.world.block[(int) (Component.character.x / Tile.tileSize) + 1][(int) ((Component.character.y - 1) / Tile.tileSize) + 2].id != Tile.air
					|| Component.world.block[(int) (Component.character.x / Tile.tileSize) + 1][(int) ((Component.character.y) / Tile.tileSize) + 1].id != Tile.air) {
				bottomright = true;

			} else {
				bottomright = false;
			}

			if (Component.world.block[(int) (Component.character.x / Tile.tileSize) + 1][(int) (Component.character.y / Tile.tileSize)].id != Tile.air) {
				topright = true;

			} else {
				topright = false;
			}

			if (Component.world.block[(int) ((Component.character.x - 1) / Tile.tileSize)][(int) ((Component.character.y - 1) / Tile.tileSize) + 2].id != Tile.air
					|| Component.world.block[(int) ((Component.character.x - 1) / Tile.tileSize)][(int) ((Component.character.y) / Tile.tileSize) + 1].id != Tile.air) {
				bottomleft = true;

			} else {
				bottomleft = false;
			}

			if (Component.world.block[(int) ((Component.character.x - 1) / Tile.tileSize)][(int) (Component.character.y / Tile.tileSize)].id != Tile.air) {
				topleft = true;

			} else {
				topleft = false;
			}

		}

	}

	public void render(Graphics g) {

		if (Component.dir == speed) {
			g.drawImage(Tile.tileset_terrain, (int) (x - Component.sx), (int) (y - Component.sy), (int) ((x + width) - Component.sx), (int) ((y + height) - Component.sy),
					(Tile.character[0] * Tile.tileSize) + (Tile.tileSize * animation), Tile.character[1] * Tile.tileSize,
					(Tile.character[0] * Tile.tileSize) + (Tile.tileSize * animation) + (int) width, Tile.character[1] * Tile.tileSize + (int) height, null);
		} else {
			g.drawImage(Tile.tileset_terrain, (int) (x - Component.sx), (int) (y - Component.sy), (int) ((x + width) - Component.sx), (int) ((y + height) - Component.sy),
					(Tile.character[0] * Tile.tileSize) + (Tile.tileSize * animation) + (int) width, Tile.character[1] * Tile.tileSize,
					(Tile.character[0] * Tile.tileSize) + (Tile.tileSize * animation), Tile.character[1] * Tile.tileSize + (int) height, null);

		}

	}

}
