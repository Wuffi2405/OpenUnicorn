package de.unicornworld.openunicorn;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Component extends Applet implements Runnable {

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

	public static Character character;
	public static Level level;
	public static Inventory inventory;
	public static Sky sky;

	private Image screen;
	private static final long serialVersionUID = 1L;

	public Component() {
		setPreferredSize(size);
		addKeyListener(new Listening());
		addMouseListener(new Listening());
		addMouseMotionListener(new Listening());
		addMouseWheelListener(new Listening());
	}

	public void start() {

		new Tile();

		level = new Level();
		character = new Character(Tile.tileSize, Tile.tileSize * 2);
		inventory = new Inventory();
		sky = new Sky();

		isRunning = true;
		new Thread(this).start();
	}

	public void stop() {
		isRunning = false;
	}

	private static JFrame frame;

	public static void main(String args[]) {
		Component component = new Component();

		frame = new JFrame();
		frame.add(component);
		frame.pack();

		realsize = new Dimension(frame.getWidth(), frame.getHeight());

		frame.setTitle(name);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		component.start();
	}

	public void tick() {

		if (frame.getWidth() != realsize.width || frame.getHeight() != realsize.height) {
			frame.pack();
		}

		level.tick((int) sx, (int) sy, (int) (pixel.width / Tile.tileSize + 2), (int) (pixel.height / Tile.tileSize + 2));
		character.tick();
		sky.tick();
	}

	public void render() {
		Graphics g = screen.getGraphics();
		g.setColor(new Color(100, 100, 255));
		g.fillRect(0, 0, pixel.width, pixel.height);

		sky.render(g);
		level.render(g, (int) sx, (int) sy, (int) (pixel.width / Tile.tileSize + 2), (int) (pixel.height / Tile.tileSize + 2));
		character.render(g);
		inventory.render(g);

		g = getGraphics();
		g.drawImage(screen, 0, 0, size.width, size.height, 0, 0, pixel.width, pixel.height, null);

		g.dispose();
	}

	public void run() {

		screen = createVolatileImage(pixel.width, pixel.height);
		while (isRunning == true) {
			tick();
			render();

			try {
				Thread.sleep(5);
			} catch (Exception e) {

			}
		}
	}
}
