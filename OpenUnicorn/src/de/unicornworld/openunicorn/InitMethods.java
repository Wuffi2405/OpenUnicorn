package de.unicornworld.openunicorn;

import java.awt.Graphics;

import de.wuffitv.openunicorn.entity.Player;
import de.wuffitv.openunicorn.world.Block;

public class InitMethods {


	private boolean readyForLoop = false;

	private Player player;

	public InitMethods() {
		System.out.println("[OpenUnicorn] [Initialisation] [Initialisation] called");

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
			player.render(g);
		}
	}

}
