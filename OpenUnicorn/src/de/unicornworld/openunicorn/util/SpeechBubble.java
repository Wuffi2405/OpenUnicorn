package de.unicornworld.openunicorn.util;

import java.awt.Color;
import java.awt.Graphics;

import de.unicornworld.openunicorn.world.World;

public class SpeechBubble {

	public int x, y, width, height;
	public Color color;
	public String text;

	public SpeechBubble(int x, int y, int width, int height, Color color, String text) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.text = text;
	}

	public void update() {

	}

	public void render(Graphics g) {

		g.setColor(color);
		g.fillOval(x + World.difx, y + World.dify, width, height);
		g.setColor(Color.BLACK);
		g.drawString(text, x + 10 + World.difx, y + height / 2 + 3 + World.dify);
	}

}
