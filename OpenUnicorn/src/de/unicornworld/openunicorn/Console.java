package de.unicornworld.openunicorn;

import java.awt.Color;
import java.awt.Graphics;

public class Console {

	public Console() {

	}

	public void update() {

	}

	public void render(Graphics g) {

		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 1000, 1000);

		g.setColor(Color.BLACK);

		if (ConsoleListener.keyChar.startsWith("null")) {
			ConsoleListener.keyChar = ConsoleListener.keyChar.replaceFirst("null", "");
		}

		g.drawString(ConsoleListener.keyChar, 20, 20);

	}
}
