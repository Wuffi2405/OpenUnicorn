package de.unicornworld.openunicorn.map.editor;

import java.awt.event.KeyEvent;

public class KeyListener implements java.awt.event.KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_Q) 
			World.materialChange = Material.DIRT;
		if(e.getKeyCode() == KeyEvent.VK_W) 
			World.materialChange = Material.STONE_WAY;
		if(e.getKeyCode() == KeyEvent.VK_E) 
			World.materialChange = Material.STONE_WAY_OLD;
		if(e.getKeyCode() == KeyEvent.VK_R) 
			World.materialChange = Material.GRASS;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
