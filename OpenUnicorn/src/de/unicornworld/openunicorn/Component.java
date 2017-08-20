package de.unicornworld.openunicorn;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;

import javax.swing.JButton;
import javax.swing.JFrame;

import de.wuffitv.openunicorn.Initialisation;
import de.wuffitv.openunicorn.KeyInput;
import de.wuffitv.openunicorn.frame.LayeredPaneLauncher;
import de.wuffitv.openunicorn.frame.Window;

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
		System.out.println("[OpenUnicorn] [GameCanvas] [GameCanvas] called");

		setBounds(0, 0, 800, 600); // test

		Initialisation.setFrame_widthWithoutInsets(Window.getJFrame().getWidth()
				- (Window.getJFrame().getInsets().left + Window.getJFrame().getInsets().right));
		Initialisation.setFrame_heightWithoutInsets(Window.getJFrame().getHeight()
				- (Window.getJFrame().getInsets().top + Window.getJFrame().getInsets().bottom));

		addKeyListener(new KeyInput());
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

	public void run() {

	}

	public void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		/**
		 * set bg, against a bug xD
		 */
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 20000, 20000);

		// OpenUnicorn.getOpenUnicorn().getInitialisation().render(g);
		LayeredPaneLauncher.initialisation.render(g);

		g.dispose();
		bs.show();
	}

}
