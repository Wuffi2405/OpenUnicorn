package de.unicornworld.openunicorn.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.unicornworld.openunicorn.frame.Window;
import de.unicornworld.openunicorn.util.Path;
import de.unicornworld.openunicorn.world.World;

public class NPC extends Entity {

	public static BufferedImage markens_img;

	public String name;
	public Path path;
	public boolean ableToMove;
	public int selectedDirection;
	public int step;
	
	public NPC(int x, int y, int width, int height, double speed, String name, Path path, boolean ableToMove, int selectedDirection, int step) {
		super(x, y, width, height, speed);

		this.name = name;
		this.path = path;
		this.ableToMove = ableToMove;
		this.selectedDirection = selectedDirection;
		this.step = step;
	}

	public void update() {

	}

	public void render(Graphics g) {

		if (Window.containsRectangle(x, y, width, height)) {
			g.drawImage(markens_img, x + World.difx, y + World.dify, width, height, null);
		}

	}

}
