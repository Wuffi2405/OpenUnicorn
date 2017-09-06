package de.unicornworld.openunicorn.entity;

import java.awt.Color;
import java.awt.Graphics;

import de.unicornworld.openunicorn.util.Path;
import de.unicornworld.openunicorn.world.Tile;

public class NPC {

	private int x, y;
	private int checkpointx = 1;
	private int checkpointy = 1;
	private int speed;
	private Path path;
	private String NPCName;

	public NPC(Path path, String nPCName, int speed) {
		this.path = path;
		this.speed = speed;
		NPCName = nPCName;

		x = path.getX().get(checkpointx - 1);
		y = path.getY().get(checkpointy - 1);

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

		try {

			if (path.getX().get(checkpointx) == x) {
				checkpointx += 1;
				System.out.println("hier!");

			}

			if (path.getX().get(checkpointx) > x) {
				x += speed;
			}

		} catch (Exception e) {

		}

		try {
			
		} catch (Exception e) {
			
		}

	}

	public void render(Graphics g) {

		g.setColor(Color.CYAN);
		g.fillRect(x, y, Tile.tileSize, Tile.tileSize);

	}

}
