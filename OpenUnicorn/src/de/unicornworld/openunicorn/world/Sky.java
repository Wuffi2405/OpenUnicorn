package de.unicornworld.openunicorn.world;

import java.awt.Color;
import java.awt.Graphics;

import de.unicornworld.openunicorn.Component;

public class Sky {

	public int day = 0;
	public int night = 1;
	public int time = night;

	public int changeframe = 0;
	public int changeTime = 3;

	public int r1 = 70, g1 = 120, b1 = 230; // day
	public int r2 = 0, g2 = 0, b2 = 50; // night

	public int alpha = 0;

	public int r = r1, g = g1, b = b1;

	public double sunx = Component.player.x - Component.sx;
	public double suny = Component.player.y - Component.sy;
	public int dayFrame = 750, dayTime = 1000;

	public double sunRotationTime = dayTime * 2;
	public double sunFrame = 0;
	public double sunPosition;

	public Sky() {
		if (time == day) {
			r = r1;
			g = g1;
			b = b1;
		} else if (time == night) {
			r = r2;
			g = g2;
			b = b2;
		}
	}

	public void tick() {

		if (sunFrame >= sunRotationTime) {

			sunPosition = 0;
			sunFrame = 0;
		} else {

			if (sunFrame < sunRotationTime / 1.5) {

			} else {
				if (alpha > 1) {
					alpha -= 1;
				}

			}

			sunPosition += (Math.PI * 2) / sunRotationTime;

			sunx = Math.sin(sunPosition) * 300;
			suny = Math.cos(sunPosition) * 300;
			sunFrame += 1;
		}

		if (dayFrame >= dayTime) {

			if (time == day) {
				time = night;
			} else if (time == night) {
				time = day;
			}

			dayFrame = 0;
		} else {

			dayFrame += 1;
		}

		if (changeframe >= changeTime) {

			if (time == day) {
				if (r < r1) {
					r += 1;
				}
				if (g < g1) {
					g += 1;
				}
				if (b < b1) {
					b += 1;
				}
				if (alpha < 254) {
					alpha += 1;
				}
			} else if (time == night) {
				if (r > r2) {
					r -= 1;
				}
				if (g > g2) {
					g -= 1;
				}
				if (b > b2) {
					b -= 1;
				}

			}

			changeframe = 0;

		} else {
			changeframe += 1;
		}

	}

	public void render(Graphics gr) {
		gr.setColor(new Color(r, g, b));
		gr.fillRect(0, 0, Component.pixel.width, Component.pixel.height);

		gr.setColor(new Color(Color.YELLOW.getRed(), Color.YELLOW.getGreen(), Color.YELLOW.getBlue(), alpha));

		gr.fillRect((int) (Math.round(sunx) + (Component.player.x - Component.sx)),
				(int) (Math.round(suny) / 2 + (Component.player.y - Component.sy)), Tile.tileSize, Tile.tileSize);

	}
}
