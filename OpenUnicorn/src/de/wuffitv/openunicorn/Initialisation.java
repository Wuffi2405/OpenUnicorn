package de.wuffitv.openunicorn;

import java.awt.Graphics;

public class Initialisation {
	
	private static int frame_width = 0;
	private static int frame_height = 0;
	private static int frame_widthWithoutInsets = 0;
	private static int frame_heightWithoutInsets = 0;
	
	public Initialisation(){
		System.out.println("[OpenUnicorn] [Initialisation] [Initialisation] called");
		
		/**
		 * init KeyListener
		 * Updater
		 * Renderer
		 * 
		 * load World		
		 */
		
	}
	
	public void update(){
		frame_width = OpenUnicorn.getOpenUnicorn().getPreInitialisation().getWindow().getJFrame().getWidth();
		frame_height = OpenUnicorn.getOpenUnicorn().getPreInitialisation().getWindow().getJFrame().getHeight();
	}
	
	public void render(Graphics g){
		
	}

	public static int getFrame_width() {
		return frame_width;
	}

	public static int getFrame_height() {
		return frame_height;
	}
	
}
