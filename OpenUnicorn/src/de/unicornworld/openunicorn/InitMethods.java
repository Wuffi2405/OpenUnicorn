package de.unicornworld.openunicorn;

import java.awt.Graphics;

import de.wuffitv.openunicorn.Initialisation;
import de.wuffitv.openunicorn.entity.Player;
import de.wuffitv.openunicorn.world.Block;

public class InitMethods {

	public static Initialisation initialisation;

	private boolean readyForLoop = false;

	private Player player;
	private World world;

	public InitMethods() {
		System.out.println("[OpenUnicorn] [Initialisation] [Initialisation] called");

		world = new World();
		player = new Player();
		readyForLoop = true;

	}

	public void update() {
		if (readyForLoop) {
			player.update();

		}

	}

	public void render(Graphics g) {
		if (readyForLoop) {
			world.render(g, (int) Component.sx, (int) Component.sy, (int) (Component.pixel.width / Block.BLOCKSIZE + 2),
					(int) (Component.pixel.height / Block.BLOCKSIZE + 2));
			player.render(g);
		}
	}

}
