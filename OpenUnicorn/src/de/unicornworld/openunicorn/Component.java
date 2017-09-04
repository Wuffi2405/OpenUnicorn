package de.unicornworld.openunicorn;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;

import de.unicornworld.openunicorn.entity.Player;
import de.unicornworld.openunicorn.world.Tile;
import de.unicornworld.openunicorn.world.World;

public class Component extends Canvas {

	private static final long serialVersionUID = 1L;

	public static double dirVert = 0;
	public static double dirHor = 0;
	public static double sx = 0;
	public static double sy = 0;

	private boolean readyForLoop = false;

	public static Dimension realsize;

	public static Dimension size = new Dimension(1300, 700);

	public static boolean isRunning = false;
	public static boolean isMovingVert = false;
	public static boolean isMovingHor = false;
	public static boolean isJumping = false;
	public static boolean isMouseLeft = false;
	public static boolean isMouseRight = false;

	public static Player player;
	public static World world;

	public static int pixelsize = 1;
	public static Dimension pixel = new Dimension(size.width / pixelsize, size.height / pixelsize);

	public static Point mse = new Point(0, 0);

	public Component() {

		System.out.println("[OpenUnicorn] [Initialisation] [Initialisation] called");

		world = new World();
		player = new Player(Tile.tileSize, Tile.tileSize);

		readyForLoop = true;
		System.out.println("[OpenUnicorn] [GameCanvas] [GameCanvas] called");

		setBounds(0, 0, 1000, 600); // test

		addKeyListener(new KeyInput());

	}

	public void update() {
		if (readyForLoop) {


			world.tick((int) sx, (int) sy, (int) (pixel.width / Tile.tileSize + 2), (int) (pixel.height / Tile.tileSize + 2));
			player.tick();
			
			
		}

	}

	public void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		// Background
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, 800, 600);
		
		
		world.render(g, (int) sx, (int) sy, (int) (pixel.width / Tile.tileSize + 2), (int) (pixel.height / Tile.tileSize + 2));
		player.render(g);

		
		// ---------

		g.setColor(new Color(100, 50, 150));
		g.drawRect(0, 0, 1000, 1000);
		if (readyForLoop) {

		}

		g.dispose();
		bs.show();
	}

}
