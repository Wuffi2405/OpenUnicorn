package de.unicornworld.openunicorn.map.editor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Item extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Material material;

	public Item(Material material){
		setLayout(null);
		this.material = material;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(getTexture(), 5, 5, 40, 40, null);
	}
	
	public BufferedImage getTexture() {
		switch(material) {
		case DIRT: return Graphic.imageDirt;
		case STONE_WAY:	return Graphic.imageStone;
		case STONE_WAY_OLD: return Graphic.imageStone2;
		case GRASS: return Graphic.imageGrass;
		default: return Graphic.imagePlaceholder;
		}
	}
	
}
