package de.unicornworld.openunicorn;

import java.awt.Graphics;

import de.wuffitv.openunicorn.util.SourceLoader;

public class Player extends DoubleRectangle {

	protected float speed = 1;
	protected float dx;
	protected float dy;
	protected boolean left;
	protected boolean right;
	protected boolean falling = true;
	protected boolean jumping;

	protected boolean jumpPerformed;

	protected boolean topleft;
	protected boolean topright;
	protected boolean midleft;
	protected boolean midright;
	protected boolean bottomleft;
	protected boolean bottomright;

	public int animation = 0;
	public int animationFrame = 0, animationTime = 40;

	public Player(int width, int height) {
		setBounds((Component.pixel.width / 2) - (width / 2), Component.pixel.height / 2 - (height / 2), width, height);
	}

	public void tick() {

		Component.sy = Component.player.y - Component.pixel.height / 2 - (height / 2);
		Component.sx = Component.player.x - Component.pixel.width / 2 - (width / 2);

		if (Component.isMoving == true) {
			x += Component.dir;
		}

		if (Component.isUp == true) {
			y -= 1;
		}

		if (Component.isDown == true) {
			y += 1;
		}

	}

	public void render(Graphics g) {

		g.drawRect((int) x, (int) y, (int) width, (int) height);
		g.drawImage(SourceLoader.loadImage("/assets/player.png"), (int) x, (int) y, 64, 128, null);
	}

}
