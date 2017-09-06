package de.unicornworld.openunicorn.entity;

import java.awt.Color;
import java.awt.Graphics;

import de.unicornworld.openunicorn.util.Path;
import de.unicornworld.openunicorn.world.Tile;

public class NPC {

	private int x, y;
	private int checkpointx = 0;
	private int checkpointy = 0;
	private Path path;
	private String NPCName;

	public NPC(Path path, String nPCName) {
		this.path = path;
		NPCName = nPCName;

	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public String getNPCName() {
		return NPCName;
	}

	public void setNPCName(String nPCName) {
		NPCName = nPCName;

	}

	public void update() {

		x = path.getX().get(checkpointx);

		path.getX().remove(checkpointx);
		path.getX().add(checkpointx, x + 1);

		y = path.getY().get(checkpointy);

	}

	public void render(Graphics g) {

		g.setColor(Color.CYAN);
		g.fillRect(x, y, Tile.tileSize, Tile.tileSize);

	}

}
