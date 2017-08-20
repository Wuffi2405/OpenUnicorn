package de.unicornworld.openunicorn;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;

import de.wuffitv.openunicorn.Initialisation;

public class Component extends Canvas {

	private static final long serialVersionUID = 1L;
	public static double dir = 0;
	public static double sx = 0;
	public static double sy = 0;

	public static Dimension realsize;

	public static Dimension size = new Dimension(1300, 700);

	public static int pixelsize = 2;
	public static Dimension pixel = new Dimension(size.width / pixelsize, size.height / pixelsize);

	public static Point mse = new Point(0, 0);

	public static JButton save;

	public static String name = "Endless";
	public static boolean isRunning = false;
	public static boolean isMoving = false;
	public static boolean isJumping = false;
	public static boolean isMouseLeft = false;
	public static boolean isMouseRight = false;

	public static Player character;
	public static World world;
	public static Inventory inventory;
	public static Sky sky;

	public static Initialisation init;
	
	
	public Component() {

	}

	public void start() {

		new Tile();
		init = new Initialisation();
		world = new World();
		character = new Player(Tile.tileSize, Tile.tileSize * 2);
		inventory = new Inventory();
		sky = new Sky();

		isRunning = true;
	}

	public void stop() {
		isRunning = false;
	}

	private static JFrame frame;

	public void tick() {

		if (frame.getWidth() != realsize.width || frame.getHeight() != realsize.height) {
			frame.pack();
		}

		world.tick((int) sx, (int) sy, (int) (pixel.width / Tile.tileSize + 2),
				(int) (pixel.height / Tile.tileSize + 2));
		character.tick();
		sky.tick();
	}

	public void render() {
		
	}

	public void run() {

	}

}
