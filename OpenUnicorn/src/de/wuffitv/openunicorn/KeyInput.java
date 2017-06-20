package de.wuffitv.openunicorn;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
	
	public static boolean W = false;
	public static boolean A = false;
	public static boolean S = false;
	public static boolean D = false;
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) W = true;
		if(e.getKeyCode() == KeyEvent.VK_A) A = true;
		if(e.getKeyCode() == KeyEvent.VK_S) S = true;
		if(e.getKeyCode() == KeyEvent.VK_D) D = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_W) W = false;
		if(e.getKeyCode() == KeyEvent.VK_A) A = false;
		if(e.getKeyCode() == KeyEvent.VK_S) S = false;
		if(e.getKeyCode() == KeyEvent.VK_D) D = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	
	
}
