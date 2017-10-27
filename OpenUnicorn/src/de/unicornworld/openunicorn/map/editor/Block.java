package de.unicornworld.openunicorn.map.editor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

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
	}
	
	public void update() {
	}
	
	public void render(Graphics g) {
		g.drawImage(getTexture(), x, y, width, height, null);
	}
	
	public BufferedImage getTexture() {
		switch(material) {
		case DIRT: return Graphic.imageDirt;
		case STONE_WAY:	return Graphic.imageStone;
		case STONE_WAY_OLD: return Graphic.imageStone2;
		case GRASS: return Graphic.imageGrass;
		default: return image;
		}
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
	
	public void setMaterial(Material m) {
		this.material = m;
	}
	
	public Material getMaterial() {
		return material;
	}
	
}
