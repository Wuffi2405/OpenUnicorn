package de.unicornworld.openunicorn;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import de.unicornworld.openunicorn.entity.NPC;
import de.unicornworld.openunicorn.util.SpeechBubble;
import de.unicornworld.openunicorn.world.World;

public class MouseInput implements MouseListener {

	public static NPC npcWithSpeechBubble[] = new NPC[1];

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getButton() == MouseEvent.BUTTON1) {

			for (int i = 0; i < World.npcamount; i++) {

				if (Component.mouseX + World.difx > World.npcs[i].x && Component.mouseX + World.difx < World.npcs[i].x + World.npcs[i].width && Component.mouseY + World.dify > World.npcs[i].y
						&& Component.mouseY + World.dify < World.npcs[i].y + World.npcs[i].height) {
					System.out.println("ja bei npc " + World.npcs[i].name);

					Component.speechBubble = new SpeechBubble(World.npcs[i].x + World.npcs[i].width, World.npcs[i].y, 200, 30, Color.WHITE, "hallo i bims 1 " + World.npcs[i].name + " vong heute!");

					npcWithSpeechBubble[0] = World.npcs[i];

				}

			}
		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

}
