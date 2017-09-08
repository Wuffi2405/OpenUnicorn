package de.unicornworld.openunicorn;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.imageio.ImageIO;

import de.unicornworld.openunicorn.entity.NPC;
import de.unicornworld.openunicorn.entity.Player;
import de.unicornworld.openunicorn.util.SourceLoader;
import de.unicornworld.openunicorn.world.Block;
import de.unicornworld.openunicorn.world.Tile;
import de.unicornworld.openunicorn.world.World;

public class Component extends Canvas {

	private static final long serialVersionUID = 1L;

	public static double dirVert = 0;
	public static double dirHor = 0;
	public static double sx = 0;
	public static double sy = 0;

	public static int state = 0;

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
	public static Console console;

	public static String worldName = "world";

	public static int pixelsize = 1;
	public static Dimension pixel = new Dimension(size.width / pixelsize, size.height / pixelsize);

	public static Point mse = new Point(0, 0);

	public Component() {

		System.out.println("[OpenUnicorn] [Initialisation] [Initialisation] called");

		
		world = new World(worldName);
		
		player = new Player(Tile.tileSize, Tile.tileSize, Tile.tileSize, Tile.tileSize, 2);
		console = new Console();

		try {

			Block.earth = ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/Erde1.png"));
			Block.grass = ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/grass.png"));
			Block.steinWeg_1 = ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/Steinweg1.png"));
			Player.player = ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/player.png"));
			Player.player_left = ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/player_left.png"));
			NPC.markens_img = ImageIO.read(SourceLoader.class.getResourceAsStream("/assets/texture/block/NPC1.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}

		readyForLoop = true;
		System.out.println("[OpenUnicorn] [GameCanvas] [GameCanvas] called");

		setBounds(0, 0, 1000, 600); // test

		addKeyListener(new KeyInput());
		addKeyListener(new ConsoleListener());

	}

	public void update() {
		if (readyForLoop) {

			if (state == 0) {

				world.tick((int) sx, (int) sy, (int) (pixel.width / Tile.tileSize + 2), (int) (pixel.height / Tile.tileSize + 2));
				player.tick();

			} else if (state == 1) {

				console.update();

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

			world.render(g, (int) sx, (int) sy, (int) (pixel.width / Tile.tileSize + 2), (int) (pixel.height / Tile.tileSize + 2));
			player.render(g);

			g.setColor(new Color(100, 50, 150));
			g.drawRect(0, 0, 1000, 1000);

		} else if (state == 1) {

			console.render(g);

		}

		if (readyForLoop) {

		}

		g.dispose();
		bs.show();
	}

	public static void switchWorld(String worldName) {
		Component.world = new World(worldName);
		Component.player.x = Tile.tileSize;
		Component.player.y = Tile.tileSize;
		World.difx = 0;
		World.dify = 0;

	}

}
