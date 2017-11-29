package de.unicornworld.openunicorn.world.overwrite;

import java.awt.Color;
import java.awt.Graphics;

import de.unicornworld.openunicorn.ConsoleListener;
import de.unicornworld.openunicorn.frame.Window;

public class Console extends OverWritable {

	public Console() {

	}

	public void update() {

	}

	public void render(Graphics g) {

		g.setColor(Color.DARK_GRAY);

		g.fillRect(20, 20, Window.getJFrame().getWidth() - 80, Window.getJFrame().getHeight() - 80);

		g.setColor(Color.BLACK);

		if (ConsoleListener.keyChar.startsWith("null")) {
			ConsoleListener.keyChar = ConsoleListener.keyChar.replaceFirst("null", "");
		}

		g.drawString(ConsoleListener.keyChar, 40, 40);

	}
}
