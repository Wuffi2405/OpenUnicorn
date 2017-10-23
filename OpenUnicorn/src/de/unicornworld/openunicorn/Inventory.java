package de.unicornworld.openunicorn;

import java.awt.Color;
import java.awt.Graphics;

import de.unicornworld.openunicorn.frame.Window;

public class Inventory {

	public void update() {

	}

	public void render(Graphics g) {

		g.setColor(Color.GRAY);
		g.fillRect(20, 20, Window.getJFrame().getWidth() - 80, Window.getJFrame().getHeight() - 80);

	}

}
