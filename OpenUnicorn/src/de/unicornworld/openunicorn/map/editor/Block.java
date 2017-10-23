package de.unicornworld.openunicorn.map.editor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import de.unicornworld.openunicorn.util.SourceLoader;

public class Block {
	
	private int x;
	private int y;
	private int width;
	private int height;
	static int sizeX = 64;
	static int sizeY = 64;
	private Material material;
	private static BufferedImage image;
	
	public Block(int p_x, int p_y, int p_width, int p_height, Material p_material) {
		this.x = p_x;
		this.y = p_y;
		this.width = p_width;
		this.height = p_height;
		this.material = p_material;
		if(material == Material.AIR) {
			image = SourceLoader.loadImage("/assets/texture/block/Erde1.png");
		}
	}
	
	public void update() {
		if(material == Material.AIR) {
			image = SourceLoader.loadImage("/assets/texture/block/Erde1.png");
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(image, x, y, width, height, null);
	}
	
	public BufferedImage getTexture() {
		return image;
	}
	
	public int getPosX() {
		return x;
	}
	
	public int getPosY() {
		return y;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
}
