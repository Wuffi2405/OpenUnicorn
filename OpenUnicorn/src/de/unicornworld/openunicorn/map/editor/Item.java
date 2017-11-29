package de.unicornworld.openunicorn.map.editor;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Item extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	Material material;

	public Item(Material material){
		setLayout(null);
		this.material = material;
		addMouseListener(this);
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("clicked: " + material);
		World.materialChange = material;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
