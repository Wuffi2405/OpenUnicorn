package de.unicornworld.openunicorn.map.editor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseListener implements java.awt.event.MouseListener, MouseMotionListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// World.setBlockMaterial();
		World.getMaterial();
		World.setBlockMaterial();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	// ----------------
	@Override
	public void mouseDragged(MouseEvent e) {
		// System.out.println(1);
		World.mouseX = e.getX();
		World.mouseY = e.getY();
		World.mouseMoving = true;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// System.out.println(5);
		World.mouseX = e.getX();
		World.mouseY = e.getY();
		World.mouseMoving = true;
	}

}
