package de.unicornworld.openunicorn;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import de.unicornworld.openunicorn.world.Tile;

public class KeyInput implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_D:

			Component.isMoving = true;
			Component.dir = Component.character.speed;
			break;

		case KeyEvent.VK_A:

			Component.isMoving = true;
			Component.dir = -Component.character.speed;
			break;

		case KeyEvent.VK_SPACE:

			Component.isJumping = true;
			break;

		}

	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
		case KeyEvent.VK_D:
			if (Component.dir == Component.character.speed) {
				Component.isMoving = false;
			}
			break;

		case KeyEvent.VK_A:
			if (Component.dir == -Component.character.speed) {
				Component.isMoving = false;
			}
			break;

		case KeyEvent.VK_SPACE:

			Component.isJumping = false;
			break;

		}

	}

	public void keyTyped(KeyEvent e) {

	}

	public void mouseDragged(MouseEvent e) {
		Component.mse.setLocation(new Point(e.getX(), e.getY()));
	}

	public void mouseMoved(MouseEvent e) {
		Component.mse.setLocation(new Point(e.getX(), e.getY()));
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			Component.isMouseLeft = true;
		} else if (e.getButton() == MouseEvent.BUTTON3) {

			Component.isMouseRight = true;
		}
	}

	public void mouseReleased(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			Component.isMouseLeft = false;
		} else if (e.getButton() == MouseEvent.BUTTON3) {

			Component.isMouseRight = false;
		}
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() > 0) {
			if (Inventory.selected < Tile.invLenght - 1) {

				Inventory.selected += 1;

			}else {
				Inventory.selected = 0; 
			}
		} else if (e.getWheelRotation() < 0) {
			if (Inventory.selected > 0) {

				Inventory.selected -= 1;

			}else {
				Inventory.selected = Tile.invLenght-1; 
			}
		}
	}

}
