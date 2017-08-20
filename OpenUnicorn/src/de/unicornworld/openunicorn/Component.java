package de.unicornworld.openunicorn;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import de.unicornworld.openunicorn.world.Sky;
import de.unicornworld.openunicorn.world.World;
import de.wuffitv.openunicorn.entity.Player;

public class Component extends Canvas {

	private static final long serialVersionUID = 1L;
	public static double dir = 0;
	public static double sx = 0;
	public static double sy = 0;
	private boolean readyForLoop = false;
	
	public static Dimension realsize;

	public static Player character;

	public static Dimension size = new Dimension(1300, 700);
	private Player player;

	public static int pixelsize = 2;
	public static Dimension pixel = new Dimension(size.width / pixelsize, size.height / pixelsize);

	public static Point mse = new Point(0, 0);

	public static boolean isMoving = false;
	public static boolean isJumping = false;
	public static boolean isMouseLeft = false;
	public static boolean isMouseRight = false;

	public static World world;
	public static Sky sky;


	public Component() {
		
		System.out.println("[OpenUnicorn] [Initialisation] [Initialisation] called");

		player = new Player();
		readyForLoop = true;
		System.out.println("[OpenUnicorn] [GameCanvas] [GameCanvas] called");

		setBounds(0, 0, 800, 600); // test

		addKeyListener(new KeyInput());

	}

	public void update() {
		if (readyForLoop) {
			player.update();
		}
	}

	public void render() {

		this.setBackground(new Color(100, 50, 150));
		if (readyForLoop) {
			player.render(getGraphics());
		}
	}

}
