package de.unicornworld.openunicorn;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.unicornworld.openunicorn.entity.NPC;
import de.unicornworld.openunicorn.entity.Player;
import de.unicornworld.openunicorn.frame.Window;
import de.unicornworld.openunicorn.util.SourceLoader;
import de.unicornworld.openunicorn.util.SpeechBubble;
import de.unicornworld.openunicorn.util.TextureReload;
import de.unicornworld.openunicorn.world.Tile;
import de.unicornworld.openunicorn.world.World;
import de.unicornworld.openunicorn.world.overwrite.Console;
import de.unicornworld.openunicorn.world.overwrite.Inventory;
import de.unicornworld.openunicorn.world.overwrite.OverWritable;

public class Component extends Canvas {
	// pointless
	private static final long serialVersionUID = 1L;
	// player direction
	public static double dirVert = 0;
	public static double dirHor = 0;
	public static double sx = 0;
	public static double sy = 0;

	public static int state = 0;

	private boolean readyForLoop = false;

	public static Dimension realsize;

	public static Dimension size = new Dimension(1300, 700);

	public static int mouseX;
	public static int mouseY;

	public static boolean isRunning = false;
	public static boolean isMovingVert = false;
	public static boolean isMovingHor = false;
	public static boolean isJumping = false;
	public static boolean isMouseLeft = false;
	public static boolean isMouseRight = false;

	public static Player player;
	public static World world;
	public static Console console;
	public static SpeechBubble speechBubble;
	public static Inventory inventory;
	public static TextureReload texturereload;

	public static BufferedReader logdatainput;

	public static Point location = new Point(0, 0);

	public static String worldName = "world";
	public static OverWritable layer2 = null;

	public static int pixelsize = 1;
	public static Dimension pixel = new Dimension(size.width / pixelsize, size.height / pixelsize);

	public static Point mse = new Point(0, 0);

	public Component() {

		System.out.println("[OpenUnicorn] [Initialisation] [Initialisation] called");

		try {
			logdatainput = new BufferedReader(new FileReader(new File("src/assets/files/log.uwuf")));
			worldName = logdatainput.readLine().trim();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try {

			Player.player = ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/player.png"));
			Player.player_left = ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/player_left.png"));
			NPC.markens_img = ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/NPC1.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		texturereload = new TextureReload();
		inventory = new Inventory();
		world = new World(worldName);
		speechBubble = null;
		player = new Player(Tile.tileSize, Tile.tileSize, Tile.tileSize, Tile.tileSize, 2);
		console = new Console();

		try {
			player.x = Integer.parseInt(logdatainput.readLine().trim());
			player.y = Integer.parseInt(logdatainput.readLine().trim());
			World.difx = Integer.parseInt(logdatainput.readLine().trim());
			World.dify = Integer.parseInt(logdatainput.readLine().trim());
		} catch (Exception e) {
		}

		readyForLoop = true;
		System.out.println("[OpenUnicorn] [GameCanvas] [GameCanvas] called");

		setBounds(0, 0, 1000, 600); // test

		addKeyListener(new KeyInput());
		addKeyListener(new ConsoleListener());
		addMouseListener(new MouseInput());
		addMouseMotionListener(new MouseLocation());

	}

	public void update() {
		if (readyForLoop) {

			if (state == 0) {

				world.tick((int) sx, (int) sy, (int) (pixel.width / Tile.tileSize + 2),
						(int) (pixel.height / Tile.tileSize + 2));
				player.tick();

				location = new Point(player.x - World.difx, player.y - World.dify);

				if (layer2 != null) {
					layer2.update();
				}

			}

			if (speechBubble != null) {
				speechBubble.update();
			}

		}

	}

	public void render() {

		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		if (state == 0) {
			g.setColor(Color.LIGHT_GRAY);
			g.fillRect(0, 0, 800, 600);

			world.render(g, (int) sx, (int) sy, (int) (Window.getJFrame().getWidth() / Tile.tileSize + 2),
					(int) (Window.getJFrame().getHeight() / Tile.tileSize + 2));
			player.render(g);

			g.setColor(new Color(100, 50, 150));
			g.drawRect(0, 0, 1000, 1000);

			if (layer2 != null) {
				layer2.render(g);
			}

		}

		if (readyForLoop) {

		}
		if (speechBubble != null) {

			speechBubble.render(g);
		}

		g.dispose();
		bs.show();
	}

	public static void switchWorld(String worldName) {

		Component.speechBubble = null;
		Component.worldName = worldName;
		Component.world = new World(worldName);
		Component.player.x = Tile.tileSize;
		Component.player.y = Tile.tileSize;
		World.difx = 0;
		World.dify = 0;

	}

}
