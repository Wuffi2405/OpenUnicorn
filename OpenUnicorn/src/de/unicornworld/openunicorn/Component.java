package de.unicornworld.openunicorn;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;

import de.unicornworld.openunicorn.entity.Player;
import de.unicornworld.openunicorn.world.Sky;
import de.unicornworld.openunicorn.world.World;

public class Component extends Canvas {

	private static final long serialVersionUID = 1L;
	public static double dir = 0;
	public static double sx = 0;
	public static double sy = 0;
	private boolean readyForLoop = false;

	public static Dimension realsize;

	public static Player player;

	public static Dimension size = new Dimension(1300, 700);

	public static int pixelsize = 2;
	public static Dimension pixel = new Dimension(size.width / pixelsize, size.height / pixelsize);

	public static Point mse = new Point(0, 0);

	public static boolean isMoving = false;
	public static boolean isUp = false;
	public static boolean isDown = false;
	public static boolean isMouseLeft = false;
	public static boolean isMouseRight = false;

	public static World world;
	public static Sky sky;

	public Component() {

		System.out.println("[OpenUnicorn] [Initialisation] [Initialisation] called");

		player = new Player(20, 20);
		world = new World();

		readyForLoop = true;
		System.out.println("[OpenUnicorn] [GameCanvas] [GameCanvas] called");

		setBounds(0, 0, 1000, 600); // test

		addKeyListener(new KeyInput());

	}

	public void update() {
		if (readyForLoop) {
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
		// ---------

		g.setColor(new Color(100, 50, 150));
		g.drawRect(0, 0, 1000, 1000);
		if (readyForLoop) {

			world.render(g);

			player.render(g);

		}

		g.dispose();
		bs.show();
	}

}
