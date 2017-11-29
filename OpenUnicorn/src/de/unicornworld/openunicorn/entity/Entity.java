package de.unicornworld.openunicorn.entity;

import de.unicornworld.openunicorn.Component;
import de.unicornworld.openunicorn.world.Tile;
import de.unicornworld.openunicorn.world.World;

public class Entity {

	public int x, y, width, height;
	public double speed;

	protected boolean top;
	protected boolean left;
	protected boolean right;
	protected boolean bottom;

	public Entity(int x, int y, int width, int height, double speed) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}

	public void calculateCollisions() {

		if ((Component.player.x - World.difx) <= 0) {
			left = true;
		} else {
			left = false;
		}

		if ((Component.player.y - World.dify) <= 0) {
			top = true;
		} else {
			top = false;
		}

		if (Component.world.block[(int) (((Component.player.x - World.difx) - 1) / Tile.tileSize)][(int) ((((Component.player.y - World.dify)) / Tile.tileSize))].id == 1
				|| Component.world.block[(int) (((Component.player.x - World.difx) - 1) / Tile.tileSize)][(int) ((((Component.player.y - World.dify) - 1) / Tile.tileSize) + 1)].id == 1) {
			left = true;
		} else {
			left = false;
		}

		if (Component.world.block[(int) (((Component.player.x - World.difx)) / Tile.tileSize) + 1][(int) ((((Component.player.y - World.dify)) / Tile.tileSize))].id == 1
				|| Component.world.block[(int) (((Component.player.x - World.difx)) / Tile.tileSize) + 1][(int) ((((Component.player.y - World.dify) - 1) / Tile.tileSize) + 1)].id == 1) {
			right = true;
		} else {
			right = false;
		}

		if (Component.world.block[(int) ((Component.player.x - World.difx) / Tile.tileSize)][(int) ((((Component.player.y - World.dify) - 1) / Tile.tileSize))].id == 1
				|| Component.world.block[(int) (((Component.player.x - World.difx) - 1) / Tile.tileSize) + 1][(int) ((((Component.player.y - World.dify) - 1) / Tile.tileSize))].id == 1) {
			top = true;
		} else {
			top = false;
		}

		if (Component.world.block[(int) ((Component.player.x - World.difx) / Tile.tileSize)][(int) ((((Component.player.y - World.dify)) / Tile.tileSize) + 1)].id == 1
				|| Component.world.block[(int) (((Component.player.x - World.difx) - 1) / Tile.tileSize) + 1][(int) ((((Component.player.y - World.dify)) / Tile.tileSize) + 1)].id == 1) {
			bottom = true;
		} else {
			bottom = false;
		}

	}

}
