package de.unicornworld.openunicorn;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import de.unicornworld.openunicorn.world.World;

public class MouseLocation implements MouseMotionListener {

	@Override
	public void mouseDragged(MouseEvent e) {

	}

	@Override
	public void mouseMoved(MouseEvent e) {

		Component.mouseX = e.getX();
		Component.mouseY = e.getY();

		for (int i = 0; i < World.npcamount; i++) {

			if (Component.mouseX + World.difx > World.npcs[i].x
					&& Component.mouseX + World.difx < World.npcs[i].x + World.npcs[i].width
					&& Component.mouseY - World.dify > World.npcs[i].y
					&& Component.mouseY - World.dify < World.npcs[i].y + World.npcs[i].height) {
				World.npcs[i].ableToMove = false;

			} else {
				World.npcs[i].ableToMove = true;
				if (MouseInput.npcWithSpeechBubble[0] == World.npcs[i]) {

					Component.speechBubble = null;

				}
			}

		}

	}

}
