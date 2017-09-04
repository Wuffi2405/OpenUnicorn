package de.unicornworld.openunicorn;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import de.unicornworld.openunicorn.entity.Player;

public class KeyInput implements KeyListener {

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_D:

			Component.isMovingVert = true;
			Component.dirVert = Player.speed;
			break;

		case KeyEvent.VK_A:

			Component.isMovingVert = true;
			Component.dirVert = -Player.speed;
			break;

		case KeyEvent.VK_S:

			Component.isMovingHor = true;
			Component.dirHor = Player.speed;
			break;

		case KeyEvent.VK_W:

			Component.dirHor = -Player.speed;
			Component.isMovingHor = true;
			break;

		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_D:
			if (Component.dirVert == Player.speed) {
				Component.isMovingVert = false;
			}
			break;

		case KeyEvent.VK_A:
			if (Component.dirVert == -Player.speed) {
				Component.isMovingVert = false;
			}
			break;

		case KeyEvent.VK_W:
			if (Component.dirHor == -Player.speed) {
				Component.isMovingHor = false;
			}

			break;

		case KeyEvent.VK_S:
			if (Component.dirHor == Player.speed) {
				Component.isMovingHor = false;
			}
			break;

		}

	}

	public void keyTyped(KeyEvent e) {

	}


}
